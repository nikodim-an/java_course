# Compare

от 08.12.2021  

Это пример сравнения нескольких экземпляров одного класса. Причем класс совершенно нестандартный - определить какое 
значение больше какое меньше можно только согласно человеческому понятию. 

### Задача
Пусть имеется некоторый класс, экземпляры которого нужно сравнить. и пусть будет большим тот у котрого значение 
внутреннего аргумента меньше.

### Решение 
при решении буду пользоваться инетрфейсом Comparable. При этом просто сравню два экземпляра одного класса и загоню 
несколько экземпляров в TreeSet, который их упорядочит по возрастанию.

### Выводы
1. При оценке того, какой из экземпляров больше или меньше не получится использовать знаки <,>,>=,<= - они работают с 
примитивами.
2. Если нужно проверять равенство - то переопределяется метод equals
3. Если нужно просто упорядочить объкты внутри коллекции - нужно использовать интерфейс Comparable.
4. Если нужно сравнивать объекты - то нужно использовать инетрфейс Comparator (Сравниватель)
5. Если при обьявлении класса параметризовать инетрфейс (Example1) то работаь с ним проще.
6. При работе с компараторами вообще нужно стараться избегать упаковок/распаковок

Если нужно сравнивать по многим признакам, то придется, чаще всего, использовать несколько компараторов. 
Переопределенный метод toCompare реально сравнивает или устанавливает равнозначность двух экземпляров. Методы 
compare (инт. Comparator) и toCompare (~ Comparable) **возвращают только число**!!! Если нужно сделать проверку на 
больше и получить true то можно заколхозить метод возвращающий true/false, но проверку вести в методе toCompare 
(Comparable). В этом случае достаточно использовать один нтерфейс в классе, а сам метод проверки на больше/меньше 
назвать ожидаемо compare, а сам интерфейс компаратора не использовать.