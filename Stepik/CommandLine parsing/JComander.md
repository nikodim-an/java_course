# JCommander

*"Потому что жизнь слишком коротка, чтобы анализировать параметры командной строки"*

[TOC]



## 1. Обзор

JCommander-это очень маленькая Java-платформа, которая делает тривиальным анализ параметров командной строки. Вы аннотируете поля описаниями своих опций:

```java
import com.beust.jcommander.Parameter;

public class Args {
  @Parameter
  private List<String> parameters = new ArrayList<>();

  @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
  private Integer verbose = 1;

  @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
  private String groups;

  @Parameter(names = "-debug", description = "Debug mode")
  private boolean debug = false;
}
```

а затем вы просто просите JCommander проанализировать:

```java
Args args = new Args();
String[] argv = { "-log", "2", "-groups", "unit" };
JCommander.newBuilder()
  .addObject(args)
  .build()
  .parse(argv);

Assert.assertEquals(jct.verbose.intValue(), 2);
```

Вот еще один пример:

```java
class Main {
    @Parameter(names={"--length", "-l"})
    int length;
    @Parameter(names={"--pattern", "-p"})
    int pattern;

    public static void main(String ... argv) {
        Main main = new Main();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(argv);
        main.run();
    }

    public void run() {
        System.out.printf("%d %d", length, pattern);
    }
}
$ java Main -l 512 --pattern 2
512 2
```

## 2. Типы опций

Поля, представляющие ваши параметры, могут быть любого типа. Базовые типы (`Integer`, `Boolean`, и т.д....) Поддерживаются по умолчанию, и вы можете написать преобразователи типов для поддержки любого другого типа (`File`, и т.д....).

### 2.1. Логическое

Когда аннотация параметра найдена в поле типа `boolean`или `Boolean`, JCommander интерпретирует ее как параметр с коэффициентом 0:

```java
@Parameter(names = "-debug", description = "Debug mode")
private boolean debug = false;
```

Такой параметр не требует какого-либо дополнительного параметра в командной строке, и если он обнаружен во время синтаксического анализа, соответствующее поле будет установлено в значение true. Если вы хотите определить логический параметр, который по умолчанию является истинным, вы можете объявить его как имеющий значение 1. Затем пользователям придется явно указать нужное значение:

```java
@Parameter(names = "-debug", description = "Debug mode", arity = 1)
private boolean debug = true;
```

Вызывайте с помощью любого из:

```bash
program -debug true
program -debug false
```

Когда аннотация параметра найдена в поле типа `String`, `Integer`, `int`, `Long`или `long`, JCommander проанализирует следующий параметр и попытается привести его к нужному типу:

```java
@Parameter(names = "-log", description = "Level of verbosity")
private Integer verbose = 1;
java Main -log 3
```

приведет к тому, что поле verbose получит значение 3. Однако:

```bash
$ java Main -log test
```

приведет к возникновению исключения.

### 2.2. Списки

Когда в поле типа найдена аннотация параметра `List`, JCommander интерпретирует ее как параметр, который может встречаться несколько раз:

```java
@Parameter(names = "-host", description = "The host")
private List<String> hosts = new ArrayList<>();
```

позволит вам проанализировать следующую командную строку:

```bash
$ java Main -host host1 -verbose -host host2
```

Когда JCommander закончит разбор строки выше, поле хосты будет содержать строки `"host1"`и `"host2"`.

### 2.3. Пароль

Если одним из ваших параметров является пароль или какое-либо другое значение, которое вы не хотите отображать в своей истории или в поле очистить, вы можете объявить его типом пароль, и JCommander попросит вас ввести его в консоль:

```java
public class ArgsPassword {
  @Parameter(names = "-password", description = "Connection password", password = true)
  private String password;
}
```

Когда вы запустите свою программу, вы получите следующее приглашение:

```bash
Value for -password (Connection password):
```

Вам нужно будет ввести значение на этом этапе, прежде чем JCommander возобновит работу.

### 2.4. Эхо-вход

В Java 6 по умолчанию вы не сможете видеть, что вы вводите для паролей, введенных в приглашении (в Java 5 и ниже всегда будет отображаться пароль). Однако вы можете переопределить это, установив значение echoInput `true`(по умолчанию`false`, и этот параметр действует только при наличии пароля`true`).:

```java
public class ArgsPassword {
  @Parameter(names = "-password", description = "Connection password", password = true, echoInput = true)
  private String password;
}
```

## 3. Пользовательские типы (преобразователи и разветвители)

Для привязки параметров к пользовательским типам или изменения способа разделения параметров JCommander (по умолчанию используется разделение через запятую) JCommander предоставляет два интерфейса `IStringConverter`и `IParameterSplitter`.

### 3.1. Пользовательские типы - Одно значение

Используйте либо `converter=`атрибут реализации `@Parameter`или `IStringConverterFactory`.

#### 3.1.1. По аннотации

По умолчанию JCommander анализирует командную строку только на базовые типы (строки, логические значения, целые числа и длинные строки). Очень часто вашему приложению на самом деле требуются более сложные типы (такие как файлы, имена хостов, списки и т.д.). Для достижения этой цели вы можете написать преобразователь типов, реализовав следующий интерфейс:

```java
public interface IStringConverter<T> {
  T convert(String value);
}
```

Например, вот конвертер, который превращает строку в файл:

```java
public class FileConverter implements IStringConverter<File> {
  @Override
  public File convert(String value) {
    return new File(value);
  }
}
```

Затем все, что вам нужно сделать, это объявить свое поле с правильным типом и указать конвертер в качестве атрибута:

```java
@Parameter(names = "-file", converter = FileConverter.class)
File file;
```

JCommander поставляется с несколькими распространенными преобразователями (для получения дополнительной информации, пожалуйста, ознакомьтесь с их реализацией `IStringConverter`).

##### Примечание

Если для `List`поля используется преобразователь:

```java
@Parameter(names = "-files", converter = FileConverter.class)
List<File> files;
```

И приложение называется следующим образом:

```bash
$ java App -files file1,file2,file3
```

JCommander разделит строку `file1,file2,file3`на `file1`, `file2`, `file3`и передаст ее одну за другой в конвертер.

Альтернативное решение для анализа списка значений см. [в разделе Пользовательские типы - Значение списка](https://jcommander.org/#list-value).

#### 3.1.2. По заводу

Если пользовательские типы, которые вы используете, появляются в приложении несколько раз, необходимость указывать конвертер в каждой аннотации может стать утомительной. Чтобы решить эту проблему, вы можете использовать`IStringConverterFactory`:

```java
public interface IStringConverterFactory {
  <T> Class<? extends IStringConverter<T>> getConverter(Class<T> forType);
}
```

Например, предположим, что вам нужно проанализировать строку, представляющую хост и порт:

```bash
$ java App -target example.com:8080
```

Вы определяете класс держателя :

```java
public class HostPort {
  public HostPort(String host, String port) {
     this.host = host;
     this.port = port;
  }

  final String host;
  final Integer port;
}
```

и преобразователь строк для создания экземпляров этого класса:

```java
class HostPortConverter implements IStringConverter<HostPort> {
  @Override
  public HostPort convert(String value) {
    String[] s = value.split(":");
    return new HostPort(s[0], Integer.parseInt(s[1]));
  }
}
```

На заводе все просто:

```java
public class Factory implements IStringConverterFactory {
  public Class<? extends IStringConverter<?>> getConverter(Class forType) {
    if (forType.equals(HostPort.class)) return HostPortConverter.class;
    else return null;
  }
```

Теперь вы можете использовать тип `HostPort`в качестве параметра без какого-либо атрибута converterClass:

```java
public class ArgsConverterFactory {
  @Parameter(names = "-hostport")
  private HostPort hostPort;
}
```

Все, что вам нужно сделать, это добавить фабрику в свой объект JCommander:

```java
ArgsConverterFactory a = new ArgsConverterFactory();
JCommander jc = JCommander.newBuilder()
    .addObject(a)
    .addConverterFactory(new Factory())
    .build()
    .parse("-hostport", "example.com:8080");

Assert.assertEquals(a.hostPort.host, "example.com");
Assert.assertEquals(a.hostPort.port.intValue(), 8080);
```

Еще одно преимущество использования фабрик преобразователей строк заключается в том, что ваши фабрики могут создаваться на основе внедрения зависимостей.

### 3.2. Пользовательские типы - Значение списка

Используйте `listConverter=`атрибут `@Parameter`аннотации и назначьте пользовательскую `IStringConverter`реализацию для преобразования a `String`в a `List`значений.

#### 3.2.1. По аннотации

Если вашему приложению требуется список сложных типов, напишите конвертер типов списков, реализовав тот же интерфейс, что и раньше:

```java
public interface IStringConverter<T> {
  T convert(String value);
}
```

где `T`находится а`List`.

Например, вот конвертер списков, который превращает строку в`List<File>`:

```java
public class FileListConverter implements IStringConverter<List<File>> {
  @Override
  public List<File> convert(String files) {
    String [] paths = files.split(",");
    List<File> fileList = new ArrayList<>();
    for(String path : paths){
        fileList.add(new File(path));
    }
    return fileList;
  }
}
```

Затем все, что вам нужно сделать, это объявить свое поле с правильным типом и указать конвертер списков в качестве атрибута:

```java
@Parameter(names = "-files", listConverter = FileListConverter.class)
List<File> file;
```

Теперь, если вы подадите заявку, как в следующем примере:

```bash
$ java App -files file1,file2,file3
```

Параметр `file1,file2,file3`задается `listConverter`и будет правильно обработан.

JCommander поставляется с преобразователем `String`значений по умолчанию.

### 3.3. Разделение

Используйте `splitter=`атрибут `@Parameter`аннотации и назначьте пользовательскую `IParameterSplitter`реализацию для обработки разделения параметров на части.

#### 3.3.1. По аннотации

По умолчанию JCommander пытается разделить параметры для `List`типов полей на запятые.

Чтобы разделить параметры на другие символы, вы можете написать пользовательский разделитель, реализовав следующий интерфейс:

```java
public interface IParameterSplitter {
  List<String> split(String value);
}
```

Например, вот разделитель, который разбивает строку на точки с запятой:

```java
public static class SemiColonSplitter implements IParameterSplitter {
    public List<String> split(String value) {
      return Arrays.asList(value.split(";"));
    }
}
```

Затем все, что вам нужно сделать, это объявить свое поле с правильным типом и указать разделитель в качестве атрибута:

```java
@Parameter(names = "-files", converter = FileConverter.class, splitter = SemiColonSplitter.class)
List<File> files;
```

JCommander разделит строку `file1;file2;file3`на `file1`, `file2`, `file3`и передаст ее одну за другой в конвертер.

## 4. Проверка параметров

Проверка параметров может выполняться двумя различными способами: на уровне отдельных параметров или глобально.

### 4.1. Проверка отдельных параметров

Вы можете попросить JCommander выполнить раннюю проверку ваших параметров, предоставив класс, реализующий следующий интерфейс:

```java
public interface IParameterValidator {
 /**
   * Validate the parameter.
   *
   * @param name The name of the parameter (e.g. "-host").
   * @param value The value of the parameter that we need to validate
   *
   * @throws ParameterException Thrown if the value of the parameter is invalid.
   */
  void validate(String name, String value) throws ParameterException;
}
```

Вот пример реализации, которая гарантирует, что параметр является положительным целым числом:

```java
public class PositiveInteger implements IParameterValidator {
 public void validate(String name, String value)
      throws ParameterException {
    int n = Integer.parseInt(value);
    if (n < 0) {
      throw new ParameterException("Parameter " + name + " should be positive (found " + value +")");
    }
  }
}
```

Укажите имя класса, реализующего этот интерфейс, в `validateWith`атрибуте ваших `@Parameter`аннотаций:

```java
@Parameter(names = "-age", validateWith = PositiveInteger.class)
private Integer age;
```

Попытка передать отрицательное целое число в этот параметр приведет к возникновению исключения ParameterException.

Может быть указано несколько валидаторов:

```java
@Parameter(names = "-count", validateWith = { PositiveInteger.class, CustomOddNumberValidator.class })
private Integer value;
```

### 4.2. Глобальная проверка параметров

После анализа параметров с помощью JCommander вам может потребоваться выполнить дополнительную проверку этих параметров, например, убедиться, что оба взаимоисключающих параметра не указаны. Из-за всех возможных комбинаций, связанных с такой проверкой, JCommander не предоставляет никакого решения на основе аннотаций для выполнения этой проверки, поскольку такой подход обязательно был бы очень ограничен самой природой аннотаций Java. Вместо этого вы должны просто выполнить эту проверку на Java для всех аргументов, которые только что проанализировал JCommander.

## 5. Основной параметр

До сих пор все `@Parameter`аннотации, которые мы видели, определяли называемый атрибут `names`. Вы можете определить один (и не более одного) параметр без какого-либо такого атрибута. Этот параметр может быть либо одним`List<String>`, либо одним полем (например`String`, типом или типом, имеющим преобразователь, например`File`), и в этом случае должен быть ровно один основной параметр.

```java
@Parameter(description = "Files")
private List<String> files = new ArrayList<>();

@Parameter(names = "-debug", description = "Debugging level")
private Integer debug = 1;
```

позволит вам разобрать:

```bash
$ java Main -debug file1 file2
```

и файлы полей получат строки `"file1"`и `"file2"`.

## 6. Личные параметры

Параметры могут быть закрытыми:

```java
public class ArgsPrivate {
  @Parameter(names = "-verbose")
  private Integer verbose = 1;

  public Integer getVerbose() {
    return verbose;
  }
}
ArgsPrivate args = new ArgsPrivate();
JCommander.newBuilder()
    .addObject(args)
    .build()
    .parse("-verbose", "3");
Assert.assertEquals(args.getVerbose().intValue(), 3);
```

## 7. Разделители параметров

По умолчанию параметры разделены пробелами, но вы можете изменить этот параметр, чтобы разрешить различные разделители:

```bash
$ java Main -log:3
```

или

```bash
$ java Main -level=42
```

Вы определяете разделитель с помощью аннотации @Parameters:

```java
@Parameters(separators = "=")
public class SeparatorEqual {
  @Parameter(names = "-level")
  private Integer level = 2;
}
```

## 8. Множество описаний

Вы можете распространить описание своих параметров более чем на один класс. Например, вы можете определить следующие два класса:

```java
public class ArgsMaster {
  @Parameter(names = "-master")
  private String master;
}

public class ArgsSlave {
  @Parameter(names = "-slave")
  private String slave;
}
```

и передайте эти два объекта JCommander:

```java
ArgsMaster m = new ArgsMaster();
ArgsSlave s = new ArgsSlave();
String[] argv = { "-master", "master", "-slave", "slave" };
JCommander.newBuilder()
    .addObject(new Object[] { m , s })
    .build()
    .parse(argv);

Assert.assertEquals(m.master, "master");
Assert.assertEquals(s.slave, "slave");
```

## 9. @ синтаксис

JCommander поддерживает синтаксис@, который позволяет вам поместить все ваши параметры в файл и передать этот файл в качестве параметра:

/tmp/параметры

```bash
-verbose
file1
file2
file3
$ java Main @/tmp/parameters
```

## 10. Свойства (несколько значений параметров)

### 10.1. Исправленные ошибки

Если для некоторых из ваших параметров требуется более одного значения, например, в следующем примере, где после пар ожидаются два значения:

```bash
$ java Main -pairs slave master foo.xml
```

затем вам нужно определить свой параметр с помощью атрибута arity и сделать этот параметр`List<String>`:

```java
@Parameter(names = "-pairs", arity = 2, description = "Pairs")
private List<String> pairs;
```

Вам не нужно указывать значение для параметров типа `boolean`или `Boolean`(которые имеют значение по умолчанию 0) и типов `String`, `Integer`, `int`, `Long`и `long`(которые имеют значение по умолчанию 1).

Также обратите внимание, что `List<String>`это разрешено только для параметров, определяющих арность. Вам придется самостоятельно преобразовать эти значения, если нужные вам параметры относятся к типу `Integer`или другому (это ограничение связано с удалением Java).

### 10.2. Переменные значения

Вы можете указать, что параметр может принимать неограниченное количество параметров, вплоть до следующего параметра. Например:

```bash
program -foo a1 a2 a3 -bar
program -foo a1 -bar
```

Такой параметр может быть проанализирован двумя различными способами.

#### 10.2.1. Со списком

Если количество следующих параметров неизвестно, ваш параметр должен иметь тип`List<String>`, и вам необходимо задать логическое `variableArity`значение`true`:

```java
@Parameter(names = "-foo", variableArity = true)
public List<String> foo = new ArrayList<>();
```

#### 10.2.2. С классом

Кроме того, вы можете определить класс, в котором будут храниться следующие параметры, в зависимости от их порядка отображения:

```java
static class MvParameters {
  @SubParameter(order = 0)
  String from;

  @SubParameter(order = 1)
  String to;
}

@Test
public void arity() {
  class Parameters {
    @Parameter(names = {"--mv"}, arity = 2)
    private MvParameters mvParameters;
  }

  Parameters args = new Parameters();
  JCommander.newBuilder()
          .addObject(args)
          .args(new String[]{"--mv", "from", "to"})
          .build();

  Assert.assertNotNull(args.mvParameters);
  Assert.assertEquals(args.mvParameters.from, "from");
  Assert.assertEquals(args.mvParameters.to, "to");
}
```

## 11. Несколько имен опций

Вы можете указать более одного имени параметра:

```java
@Parameter(names = { "-d", "--outputDirectory" }, description = "Directory")
private String outputDirectory;
```

позволит использовать оба следующих синтаксиса:

```bash
$ java Main -d /tmp
$ java Main --outputDirectory /tmp
```

## 12. Другие конфигурации опций

Вы можете настроить способ поиска параметров несколькими различными способами:

- `JCommander#setCaseSensitiveOptions(boolean)`: укажите, учитывают ли параметры регистр. Если вы вызываете этот метод с `false`помощью , то `"-param"`и `"-PARAM"`считаются равными.
- `JCommander#setAllowAbbreviatedOptions(boolean)`: укажите, могут ли пользователи передавать сокращенные параметры. Если вы вызовете этот метод с `true`помощью, пользователи могут перейти`"-par"`, чтобы указать вызываемый параметр `-param`. JCommander выдаст`ParameterException`, если сокращенное имя неоднозначно.

## 13. Необходимые и необязательные параметры

Если некоторые из ваших параметров являются обязательными, вы можете использовать `required`атрибут (значение по умолчанию `false`):

```java
@Parameter(names = "-host", required = true)
private String host;
```

Если этот параметр не указан, JCommander выдаст исключение, сообщающее вам, какие параметры отсутствуют.

## 14. Значения по умолчанию

Наиболее распространенный способ указать значение по умолчанию для ваших параметров-инициализировать поле во время объявления:

```java
private Integer logLevel = 3;
```

В более сложных случаях может потребоваться возможность повторного использования идентичных значений по умолчанию в нескольких основных классах или возможность указывать эти значения по умолчанию в централизованном расположении, например в `.properties`файле XML или файле. В этом случае вы можете использовать`IDefaultProvider`:

```java
public interface IDefaultProvider {
  /**
   * @param optionName The name of the option as specified in the names() attribute
   * of the @Parameter option (e.g. "-file").
   *
   * @return the default value for this option.
   */
  String getDefaultValueFor(String optionName);
}
```

Передав реализацию этого интерфейса объекту JCommander, вы теперь можете контролировать, какое значение по умолчанию будет использоваться для ваших параметров. Обратите внимание, что значение, возвращаемое этим методом, затем будет передано в преобразователь строк, если таковой применим, что позволит вам указать значения по умолчанию для любых типов, которые вам нужны.

Например, вот поставщик по умолчанию, который назначит значение по умолчанию 42 для всех ваших параметров, кроме`"-debug"`:

```java
private static final IDefaultProvider DEFAULT_PROVIDER = new IDefaultProvider() {
  @Override
  public String getDefaultValueFor(String optionName) {
    return "-debug".equals(optionName) ? "false" : "42";
  }
};

// ...

JCommander jc = JCommander.newBuilder()
    .addObject(new Args())
    .defaultProvider(DEFAULT_PROVIDER)
    .build()
```

## 15. Параметр справки

Если один из ваших параметров используется для отображения какой-либо справки или использования, вам необходимо использовать атрибут справки:

```java
@Parameter(names = "--help", help = true)
private boolean help;
```

Если вы опустите это логическое значение, JCommander вместо этого выдаст сообщение об ошибке, когда попытается проверить вашу команду и обнаружит, что вы не указали некоторые из требуемых параметров.

## 16. Более сложные синтаксисы (команды)

Сложные инструменты, такие как `git`или `svn`понимание целого набора команд, каждая из которых имеет свой собственный специфический синтаксис:

```bash
$ git commit --amend -m "Bug fix"
```

Такие слова, как `"commit"`выше, называются "командами" в JCommander, и вы можете указать их, создав один объект arg для каждой команды:

```java
@Parameters(separators = "=", commandDescription = "Record changes to the repository")
private class CommandCommit {

  @Parameter(description = "The list of files to commit")
  private List<String> files;

  @Parameter(names = "--amend", description = "Amend")
  private Boolean amend = false;

  @Parameter(names = "--author")
  private String author;
}

@Parameters(commandDescription = "Add file contents to the index")
public class CommandAdd {

  @Parameter(description = "File patterns to add to the index")
  private List<String> patterns;

  @Parameter(names = "-i")
  private Boolean interactive = false;
}
```

Затем вы регистрируете эти команды в своем объекте JCommander. После этапа синтаксического анализа вы вызываете `getParsedCommand()`объект JCommander и на основе возвращаемой команды знаете, какой объект arg следует проверить (вы все равно можете использовать основной объект arg, если хотите поддерживать параметры до появления первой команды в командной строке).:

```java
CommandMain cm = new CommandMain();
CommandAdd add = new CommandAdd();
CommandCommit commit = new CommandCommit();
JCommander jc = JCommander.newBuilder()
    .addObject(cm)
    .addCommand("add", add);
    .addCommand("commit", commit);
    .build();

jc.parse("-v", "commit", "--amend", "--author=cbeust", "A.java", "B.java");

Assert.assertTrue(cm.verbose);
Assert.assertEquals(jc.getParsedCommand(), "commit");
Assert.assertTrue(commit.amend);
Assert.assertEquals(commit.author, "cbeust");
Assert.assertEquals(commit.files, Arrays.asList("A.java", "B.java"));
```

## 17. Исключение

Всякий раз, когда JCommander обнаруживает ошибку, он выдает сообщение `ParameterException`. Обратите внимание, что это исключение во время выполнения, так как на данный момент ваше приложение, вероятно, инициализировано неправильно. Кроме того, `ParameterException`содержит `JCommander`экземпляр, и вы также можете вызвать `usage()`его, если вам нужно отобразить некоторую справку.

## 18. Использование

Вы можете вызвать `usage()`экземпляр JCommander, который вы использовали для анализа командной строки, чтобы сгенерировать сводку всех параметров, понятных вашей программе:

```bash
Usage: <main class> [options]
  Options:
    -debug          Debug mode (default: false)
    -groups         Comma-separated list of group names to be run
  * -log, -verbose  Level of verbosity (default: 1)
    -long           A long number (default: 0)
```

Вы можете настроить имя своей программы, вызвав `setProgramName()`объект JCommander. Параметры, которым предшествует звездочка, обязательны.

Вы также можете указать порядок, в котором каждый параметр должен отображаться при вызове`usage()`, установив `order`атрибут `@Parameter`аннотации:

```java
class Parameters {
    @Parameter(names = "--importantOption", order = 0)
    private boolean a;

    @Parameter(names = "--lessImportantOption", order = 3)
    private boolean b;
```

## 19. Скрытие параметров

Если вы не хотите, чтобы определенные параметры отображались в использовании, вы можете пометить их как "скрытые".:

```java
@Parameter(names = "-debug", description = "Debug mode", hidden = true)
private boolean debug = false;
```

## 20. Интернационализация

Вы можете интернационализировать описания своих параметров. Сначала вы используете `@Parameters`аннотацию в верхней части класса, чтобы определить имя пакета сообщений, а затем используете `descriptionKey`атрибут вместо описания для всех`@Parameters`, которые требуют перевода. Это `descriptionKey`ключ к строке в вашем пакете сообщений:

```java
@Parameters(resourceBundle = "MessageBundle")
private class ArgsI18N2 {
  @Parameter(names = "-host", description = "Host", descriptionKey = "host")
  String hostName;
}
```

Ваш пакет должен определить этот ключ:

```bash
host: Hôte
```

Затем JCommander будет использовать локаль по умолчанию для разрешения ваших описаний.

## 21. Делегаты параметров

Если вы пишете много разных инструментов в одном проекте, вы, вероятно, обнаружите, что большинство из этих инструментов могут совместно использовать конфигурации. Хотя вы можете использовать наследование со своими объектами, чтобы избежать повторения этого кода, ограничение на одно наследование реализации может ограничить вашу гибкость. Для решения этой проблемы JCommander поддерживает делегаты параметров.

Когда JCommander встречает объект с аннотацией `@ParameterDelegate`в одном из ваших объектов, он действует так, как если бы этот объект был добавлен в качестве самого объекта описания:

```java
class Delegate {
  @Parameter(names = "-port")
  private int port;
}

class MainParams {
  @Parameter(names = "-v")
  private boolean verbose;

  @ParametersDelegate
  private Delegate delegate = new Delegate();
}
```

В приведенном выше примере указывается делегат параметра делегата, на который затем ссылаются в MainParams. Вам нужно только добавить `MainParams`объект в свой Конфигурация JCommander для использования делегата:

```java
MainParams p = new MainParams();
JCommander.newBuilder().addObject(p).build()
    .parse("-v", "-port", "1234");
Assert.assertTrue(p.isVerbose);
Assert.assertEquals(p.delegate.port, 1234);
```

## 22. Динамические параметры

JCommander позволяет указать параметры, которые неизвестны во время компиляции, такие как "-Da=b-Dc=d". Такие параметры указываются в `@DynamicParameter`аннотации и должны иметь тип `Map<String, String>`. Динамические параметры могут появляться в командной строке несколько раз:

```java
@DynamicParameter(names = "-D", description = "Dynamic parameters go here")
private Map<String, String> params = new HashMap<>();
```

Вы можете указать строку назначения, отличную от=, используя назначение атрибута.

## 23. Пользовательские форматы использования

JCommander позволяет настроить вывод `JCommander#usage()`метода. Вы можете сделать это, создав подклассы`IUsageFormatter`, а затем позвонив `JCommander#setUsageFormatter(IUsageFormatter)`.

Пример форматирования использования, который печатает только имена параметров, разделенные новыми строками, показан ниже:

```java
class ParameterNamesUsageFormatter implements IUsageFormatter {

    // Extend other required methods as seen in DefaultUsageFormatter

    // This is the method which does the actual output formatting
    public void usage(StringBuilder out, String indent) {
        if (commander.getDescriptions() == null) {
            commander.createDescriptions();
        }

        // Create a list of the parameters
        List<ParameterDescription> params = Lists.newArrayList();
        params.addAll(commander.getFields().values());

        // Append all the parameter names
        if (params.size() > 0) {
            out.append("Options:\n");

            for (ParameterDescription pd : params) {
                out.append(pd.getNames()).append("\n");
            }
        }
    }
}
```

## 24. JCommander на других языках

### 24.1. Kotlin

```kotlin
class Args {
    @Parameter
    var targets: List<String> = arrayListOf()

    @Parameter(names = arrayOf("-bf", "--buildFile"), description = "The build file")
    var buildFile: String? = null

    @Parameter(names = arrayOf("--checkVersions"),
               description = "Check if there are any newer versions of the dependencies")
    var checkVersions = false
}
```

### 24.2. Groovy

Любезно предоставлено Полом Кингом:

```groovy
import com.beust.jcommander.*

class Args {
  @Parameter(names = ["-f", "--file"], description = "File to load. Can be specified multiple times.")
  List<String> file
}

new Args().with {
  JCommander.newBuilder().addObject(it).build().parse(argv)
  file.each { println "file: ${new File(it).name}" }
}
```

## 25. Дополнительные примеры

Вот файлы описания для нескольких проектов, в которых используется JCommander:

- [Тестирование](https://github.com/cbeust/testng/blob/master/src/main/java/org/testng/CommandLineArgs.java)
- [Kobalt](https://github.com/cbeust/kobalt/blob/master/modules/kobalt-plugin-api/src/main/kotlin/com/beust/kobalt/Args.kt)

## 26. Список рассылки

Присоединяйтесь [к группе Google JCommander](http://groups.google.com/group/jcommander), если вас интересуют обсуждения JCommander.

## 27. Javadocs

Javadocs для JCommander можно найти [здесь](http://jcommander.org/apidocs/).

## 28. Лицензия

JCommander выпущен под [лицензией Apache 2.0](https://github.com/cbeust/jcommander/blob/master/license.txt).

## 29. Скачать

Вы можете скачать JCommander из следующих мест:

- [Источник на github](http://github.com/cbeust/jcommander)
- Kobalt

```groovy
compile("com.beust:jcommander:1.71")
```

- Грейфер

```groovy
compile "com.beust:jcommander:1.71"
```

- Знаток:

```xml
<dependency>
  <groupId>com.beust</groupId>
  <artifactId>jcommander</artifactId>
  <version>1.71</version>
</dependency>
```