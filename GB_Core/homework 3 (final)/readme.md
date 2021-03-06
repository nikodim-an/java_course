# Домашняя работа №3 : «Обобщения»

### Задания 
1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2. Задача:
   Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
   Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
   Для хранения фруктов внутри коробки можно использовать ArrayList;
   Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
   Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
   Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
   Не забываем про метод добавления фрукта в коробку.

### Решение
Разделю 1 и 2 задания по файлам Task1 и Task2
Второе задание можно решить как полностью описав класс и введя в него переменную типа ArrayList, так и напрямую 
унаследовавшись от коллекции. В этом случае снимается необходимость в написании отдельного метода для добавления 
элемента в коробку. Кроме того (теоретически) отпадет необходимость проверки типа фруктов при пересыпании. Поэтому 
реализую оба варианта (Task2v1 и Task2v2 соответственно). Поскольку в одном проекте нельзя иметь два класса с одним 
именем то классы этого модуля приобретут дополнительный индекс «1»: Fruit1, Apple1, Orange1, Box1 …  
При реализации приму как допущения:
 - коробки с фруктами безразмерны;
 - в коробках могут одновременно находиться только фрукты одного вида;
 - учет в коробаках ведется по партиям, признаком партии является ненулевое количество.
 - пересыпать (объединять) можно только непустые коробки.
 - исключительные ситуации не отлавливаю, но в коде делаю пометки в местах где это может быть необходимо.

Вывод тестов каждого класса привожу вконце файла класса в комментарии.

### Вывод в консоль
#### Задача 1
```bash
Содержимое массива {[10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]}
Содержимое массива {[0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10]}
Содержимое массива {[10, 9, 8, 7, 6, слово, 4, 3, 2, 1, 0]}
Содержимое массива {[0, 9, 8, 7, 6, слово, 4, 3, 2, 1, 10]}
```
#### Задача 2
вывод в консоль наиболее удачного варианта решения (того, который с прямым наследованием от класса ArrayList)
```bash
--- Тест создания партий фрутов --------------------
Партия яблок {10 штук, массой 10.0f}
Партия апельсинов {3 штук, массой 4.5f}
--- Тест создания коробок --------------------------
[Партия яблок {10 штук, массой 10.0f}, Партия яблок {6 штук, массой 6.0f}, Партия яблок {3 штук, массой 3.0f}, Партия яблок {8 штук, массой 8.0f}]
Общая масса коробки - 27.0f
[Партия апельсинов {10 штук, массой 15.0f}, Партия апельсинов {6 штук, массой 9.0f}, Партия апельсинов {11 штук, массой 16.5f}]
Общая масса коробки - 40.5f
--- Тест сравнения коробок -------------------------
Коробки не равны
[Партия яблок {3 штук, массой 3.0f}]
[Партия апельсинов {2 штук, массой 3.0f}]
Коробки равны
--- Тест ссыпания коробок в одну -------------------
[Партия яблок {10 штук, массой 10.0f}, Партия яблок {6 штук, массой 6.0f}, Партия яблок {3 штук, массой 3.0f}, Партия яблок {8 штук, массой 8.0f}]
[Партия яблок {3 штук, массой 3.0f}]
[]
[Партия яблок {3 штук, массой 3.0f}, Партия яблок {10 штук, массой 10.0f}, Партия яблок {6 штук, массой 6.0f}, Партия яблок {3 штук, массой 3.0f}, Партия яблок {8 штук, массой 8.0f}]
--- Попытка ссыпать разные фрукты в одну коробку ---
В коробках разные фрукты, объединить их нельзя !!!
[Партия яблок {3 штук, массой 3.0f}, Партия яблок {10 штук, массой 10.0f}, Партия яблок {6 штук, массой 6.0f}, Партия яблок {3 штук, массой 3.0f}, Партия яблок {8 штук, массой 8.0f}]
[Партия апельсинов {10 штук, массой 15.0f}, Партия апельсинов {6 штук, массой 9.0f}, Партия апельсинов {11 штук, массой 16.5f}]
```

