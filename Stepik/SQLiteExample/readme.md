# SQLite

работа с базой данных SQLite

## Концепция
в java есть контроллер JDBC который работает со всем базами данных, и предоставляет возмоность обращаться к любой из 
них по единному стандарту. 
но дял того чтобы начать работать, например с SQLite нужно поставить внешнюю библиотеку (подключить в мавен или 
скачать и подключить). в случае с последним - это «SQLite JDBC»
```
<!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.36.0.3</version>
</dependency>

```
Далее нужно создать базу данных в «DB Browser SQLite» (при работе с другими бд нужно использовать нативные средства).
После этого базу можно подключить в программу, положив ее в папку resources и выполнять запросы к ней с использованием языка sql.

## Работа с одной таблицей (без связей)
**Реализую это все в виде mvc классами model.Student, OneTableController, GUI.oneTableStend**
для этого создам базу данных students db и буду работать с ней, разместив в папке ./src/main/resources/ при этом поработаю с ее записями и попробую создать еще одну таблицу используя только запрос.   
Тут такое дело: дял работы с БД нужно иметь адекватный (ответный) объект (можно конечно без него, но не нужно) и  
сообветсенно у него должны быть как конструкторы (в том числе и дял создания при наличии ВСЕХ данных) и геттеры с сеттерами. Этот 
объект я назову Student, а таблицу дял этого объекта - person.



