# files

от 10.12.2021

работа с фалами, их чтение и запись

### С чего все начинается
А начинается все с байтовых потоков. Это потоки в которых передаются байты информации на самом примитивном ее уровне.
#### FileInputStream и FileOutputStream
Начинается все с побайтного чтения и побайтной записи, тоесть с прямой работы с фалом. Такая работа реализуется в 
классах FileInputStream и FileOutputStream. Эти классы позволяют как напрямую писать байты в файл (побайтную запись 
я даже не пробовал, ввиду ее ненужности, но чтение есть) так и используя буфер произвольной длины. При этом если 
длина буфера больше чем нужно он заполняется неполностью. Под длиной буфера понимается именно кусок информации (ее 
объем в байтах) который читается за раз.  
пример в коде - класс FileInputOutputStream

#### Буферизированные потоки
Поскольку нецелесообразно читать и писать побайтово не используя буфер, были введены классы BufferedInputStream и 
BufferedOutputStream. Они уже содержат в себе нужный буффер. Однако при создании (конструировании) в них на вход 
подается FileInputStream и FileOutputStream соответсвенно, а они в свою очередь просят либо файл (класс File), либо 
строку с именем файла.
**Несколько особенен вывод**. При использовании объекта класса BufferedOutputStream запись производится без обращения к
устройству вывода при записи каждого байта. Сначала данные записываются во внутренний буфер.Непосредственное обращение к
устройству вывода и запись происходит только тогда, когда буфер будет полностью заполнен. Принудительное освобождение
буфера с последующей записью можно вызвать методом flush() или закрытием потока записи методом close().
а так все тоже самое и работает с теми же скоростями.
пример в коде - класс BufferedInputOutputStream
```
JAVA1
--------------------------------------------------------
JAVA1               (на самом деле тут пустые символы до общей длины 20 - как указана для буфера)
--------------------------------------------------------
```
другой вопрос что в примере приведено посимвольное чтение таким способом, но и через буфер работает, однако хреново. 
мало того что нет возможности конролировать что происходит с бфером (а может и есть) так еще и полностью идентичный 
предыдущему побитовому чтнию код получается… а если невидно разницы… 
**Вывод - херня, или я просто не умею ей пользоваться**

#### Что тут есть еще
Есть такие классы как **DataInputStream и DataOutputStream**, предназначенные для работы с примитивами. При записи 
происходит конвертация любых примитивных типов в байты, а при чтении – наоборот.    
Есть **ObjectInputStream и ObjectOutputStream** предназначенные для сериализации и десериализации **объектов** при 
записи в файлы. (Сериализация - это преобразование примитива в набор байтов), но тут есть хреновинка: чтобы экземпляр 
класса мог быть сериализован, класс должен реализовать маркерный интерфейс Serializable.  
**(примера не будет… хотя в домашке походу именно это и нужно будет сделать, возможно позже…)**  
Объекты классов **PipedInputStream и PipedOutputStream** всегда используются в паре. Данные, записанные в объект 
PipedOutputStream, могут быть считаны в соединенном объекте PipedInputStream. Соединение обеспечивается за счет указания
парного объекта в качестве аргумента конструктора или метода connect(). Данная пара классов используется очень редко 
и примера **точно не будет**
И еще есть **SequenceInputStream** — класс SequenceInputStream последовательно считывает данные из нескольких входных 
потоков, как будто мы работаем с одним потоком. Конец потока SequenceInputStream будет достигнут только тогда,
когда подойдет к окончанию последний в списке поток. 

### Сериализация
В произвольный формат невозможна. тоесть сохранить в формат scv, или json не получится - это служебный формат 
сохранения объектов. Дял того, чтобы объект можно было сереализовать через класс ObjectOutputStream в класс должен 
быть имплементирован интерфейс Serializable. Правда для этого достаточно дописать что это так и не переопределять 
никаких методов. После этого его можно будет сохранить на диск как объект.  
пример - класс Serialization.

#### Ограничения байтовых потоков
Байтовые потоки ограничены передачей информации только в рамках таблицы ASCII, причем без национальных ее кодировок. 
Так как bute это число 0 до 255 - оно кодирует символ только в этой таблице. При работе с текстом возникают 
сложности и передавать текст (за исключением аглицкого) не получится. Поэтому появились текстовые потоки, изначально 
заточенные на работу с текстом.

### Текстовые потоки
Все описанное выше - это наследники абстрактных классов InputStream и OutputStream. Они работают с байтовыми 
потоками. С сивольными - их аналоги Reader и Writer. Соответсвенно при их конструировании используются объекты 
FileReader и FileWriter (вместо FileInputStream и FileOutputStream), которые в свою очередь на вход (как параметр 
при конструировании) требуют файл или его полный путь.    
И вот они уже нормально, как настоящие, пишут текст в файл.

#### BufferedReader и BufferedWriter
Классы прямые наследники Reader и Writer…
если 
```java
    final static String FILE = "/home/alex/DeskTop/file";
    final static String WORD = "JAVA";
```
то запись текста в файл:
```java
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
        writer.write(myText);
    } catch (Exception e) {
        System.out.println(e);
    }
```
а его чтение:
```java
    String res = "";    //  результат
    String line= "";    //  считанная строка
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
        // чтение возможно только построчно
        while ((line=reader.readLine())!=null) {
            res+=line+'\n';
        }
    } catch (Exception e) {
        System.out.println(e);
    }
```
дальше полученный текст можно сплитнуть, а можно и не сплитать а сразу вносить в коллекцию, и вообще делать с ним все 
что хошь, но это тема другого разговора.

в общем : как-то так...

### Другие файлы
1. в классе TextFile находится пример чтения и записи в текстовый файл - он несколько другой, без использования 
буферизации…
2. В классе CSVFile - решение следующей задачи:
```
1. Реализовать сохранение данных в csv файл;
2. Реализовать загрузку данных из csv файла. Файл читается целиком.

Структура csv файла:
    | Строка заголовок с набором столбцов |
    | Набор строк с целочисленными значениями |
    | * Разделитель между столбцами - символ точка с запятой (;) |

Пример:
    Value 1;Value 2;Value 3
    100;200;123
    300;400;500
Для хранения данных использовать класс вида:
    public class AppData {
      private String[] header;
      private int[][] data;
    
     // ...
    }
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
```