# Домашняя работа № 9 «StreamAPI»
от 29.12.2021

### Задание
Имеется следующая структура:
```java
    interface Student {
        String getName();
        List<Course> getAllCourses();
        }
    interface Course {}
```
1. Написать функцию, принимающую список Student и возвращающую список уникальных
курсов, на которые подписаны студенты.
2. Написать функцию, принимающую на вход список Student и возвращающую список из трех
самых любознательных (любознательность определяется количеством курсов).
3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую
список студентов, которые посещают этот курс.

### Решение
Возьму данную структуру, имплементирую ее в классы, воссоздам необходимую вложенность. В точке входа помещу проверку 
на тестовых данных. Комментарии в коде. 

### Вывод программы
```
    -- Все студенты -------------------------------
    Студент 'Вася', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ]
    Студент 'Петя', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС)]
    Студент 'Федя', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ, ПДО]
    Студент 'Маша', записан на курсы = [ДД, ПДД, СОП(КС), СОП(ДС), НБ]
    Студент 'Глаша', записан на курсы = [ДД, ПДД, СОП(КС), СОП(ДС)]
    Студент 'Люся', записан на курсы = [ПДД, СОП(КС), СОП(ДС)]
    Студент 'Дуся', записан на курсы = [ПДД, СОП(КС), СОП(ДС), КСП, ОСП, Кройка и Шитье, Первая помощь, я ХЗ…]
    -- Задание №1 ---------------------------------
    [ДД, ПДД, Кройка и Шитье, ОСП, НБ, СОП(ДС), ПДО, я ХЗ…, КСП, Первая помощь, СОП(Арт), СОП(КС)]
    [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ, ПДО, КСП, ОСП, Кройка и Шитье, Первая помощь, я ХЗ…]
    -- Задание №2 ---------------------------------
    Студент 'Дуся', записан на курсы = [ПДД, СОП(КС), СОП(ДС), КСП, ОСП, Кройка и Шитье, Первая помощь, я ХЗ…]
    Студент 'Федя', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ, ПДО]
    Студент 'Вася', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ]
    -- Задание №3 ---------------------------------
    Студент 'Вася', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ]
    Студент 'Федя', записан на курсы = [ДД, ПДД, СОП(КС), СОП(Арт), СОП(ДС), НБ, ПДО]
    Студент 'Маша', записан на курсы = [ДД, ПДД, СОП(КС), СОП(ДС), НБ]
```
