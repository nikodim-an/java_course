# Домашнее задание №4

## Задание
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
3. \* Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4\. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
4. \*** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

## Комментарии к выполнению
 - Первое задание не рассматриваю (названия методов и перменных беру из материала приведенного на уроке).
 - Задания 2 и 3 объединяю, полностью перерабатывая логику анализа победы
 - Задание 4 необязательное - пропускаю.

в результате должен получиться универсальный алгоритм для анализа победы на **любом** по размеру поле и для **любого** размера выигрышной серии.

### Для решения указанных задач нужно:
 - добавить две нефинализированных переменных, которые будут определять сложность игры (размер поля (MAP_SIZE) и длину выигрышной серии (WIN_SERIES))
 - сложность игры устанавливать входящими параметрами, где первый — размерность карты, второй — длина выигрышной серии. 
 - сделать обработку входящих параметров при запуске программы, при отсутствии параметров работать с картой 3×3 и выигрышной комбинацией длиной в 3 последовательно занятых поля
 - сделать генерацию карты размерностью MAP_SIZE
 - добавить в отрисовку карты координатные оси
 - добавить конструктор карт «повышенной» сложности
 - переработать анализ победы игрока (см. далее)

### Логика анализа победы игрока
Анализ буду проводить в строках. Для этого из карты с размерностью MAP_SIZE нужно подобрать строковый список значений (массив тут изначально не подходит) из всех строк, всех столбцов и наклонных линий
(частным случаем которых явлются диагонали). В алгоритме можно учитывать только часть последних, длина которых равна 
или превышает длину выигрышной серии. Если сделать это математически - то алгоритм приобретает черты чрезмерно сложного, а если логически (отбросив все строки эквивалентные диагоналям длинной менее WIN_SERIES), то с этим алгоритмом еще можно мириться...  
Полученный строковый список нужно проверить перебором на предмет наличия в содержащихся в нем строках выигрышной серии. 
Если таковое будет установлено, то прекращать игру, присудив победу тому или иному игроку.
> возможно есть и другой способ выборки, основанный например на матрицах, но он мне на текущем этапе неизвестен. Кроме того, выбранный мной алгоритм изначально не оптимален, задача о его оптимизации при текущих размерностях карты бессмысленна.

### Как вижу выполнение 4-го задания…
Анализ карты у меня сделан, поэтому можно вывести подготовку списка строк в отдельный метод и анализировать не окончание игры, а приближение комбинаций к выигрышной серии по размерности начиная с 2, и при появлении таких комбинаций - блокировать. Данный алгоритм станет чрезмерно сложным уже на поле 6×6 при размерности выигрышной серии 4-5.
Другие способы блокировки ходов противника со стороны компьютера почему-тов  голову не приходят… 