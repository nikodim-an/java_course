# Решения заданий курса
https://stepik.org/course/90684  
Записываю сюда не все решения а только те которые не показались совсем элементарными.

## Модуль «Базовые понятия»
### 2.4 «Ввод данных»
2.4.2
```java
import java.util.Scanner;

class Test {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String st = sc.nextLine();
       System.out.print(st);
   }
}
```
2.4.3
```java
import java.util.Scanner;

class MySolution {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);       
       String name_user = s.next(); 
       // Хотя имя может быть и английским типа «хер, херович, третий, младший»
       s.close();
       System.out.print("Привет, "+name_user);
    }
}
```
2.4.4
```java
import java.util.Scanner;

class MySolution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String v = s.nextLine();
        s.close();
        System.out.println(v);
        System.out.println(v);
        System.out.println(v);
    }
}
```
2.4.6
```java
import java.util.Scanner;

class MySolution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        s.close();
        System.out.println("Температура воздуха сегодня: "+v+" градусов.");
    }
}
```
2.4.7
```java
import java.util.Scanner;

class MySolution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String y = s.next();
        String m = s.next();
        String d = s.next();
        s.close();
        System.out.println(d+":"+m+":"+y);
    }
}
```
как вариант
```java
import java.util.Scanner;
class MyClassStudyJava {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    int m = sc.nextInt();
    int d = sc.nextInt();
    String str = String.format("%2d:%02d:%4d",d,m,y);
    System.out.print(str);
```
2.4.8
```java
import java.util.Scanner;

class MySolution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String y = s.nextLine();
        String m = s.nextLine();
        Long d = s.nextLong();
        s.close();
        System.out.println("Привет, "+y+", это твой помощник "+m+".\nУ тебя "+d+" новых писем.");
    }
}
```

### 2.5 «Операторы»
2.5.5
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        s.close();
        int myVar = a+b;
        System.out.print(myVar);
   }
}
```
2.5.9 Почему-то все ругались на эту задачу... непонятно
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       double x = s.nextDouble();
       double y = 5*x*x+2*x+11;
       System.out.print(y);
   }
}
```
2.5.10
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       s.close();
       System.out.println(n+" "+n*n+" "+n*n*n);
   }
}
```
2.5.11
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       double a = s.nextDouble();
       double b = s.nextDouble();
       double c = s.nextDouble();
       s.close(); 
       double res = (a+b+c)/3;
       System.out.print(res);
   }
}
```
2.5.14
```java
import java.util.Scanner;
import  java.lang.Math;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       long a = Math.abs(s.nextLong());
       System.out.print((int)a%10);
   }
}
```
2.5.15
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       double x = s.nextDouble();
       double y = s.nextDouble();
       System.out.print((int)(x/y));System.out.print(" ");System.out.print((int)(x%y));
   }
}
```
2.5.16
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner c = new Scanner(System.in);
       Long x = c.nextLong();
       int h = (int)(x/3600);
       h=h%24; // убрал все что больше суток...
       int m = (int)((x%3600)/60);
       int s = (int)((x%3600)%60);
       c.close();
       System.out.print(String.format("%02d:%02d:%02d",h,m,s));
   }
}
```
### 2.6 «Инкремент и декремент»
2.6.8
```java
class MyNumber {
   public static void main(String[] args) {
       int x = 10;
       System.out.println(++x);
       System.out.println(++x);
       System.out.println(++x);
   }
}
```
2.6.11
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       s.close();
       String myVar = (--n)+" "+(++n)+" "+(++n);
       System.out.print(myVar);
   }
}
```
2.6.12 - инкремент и декремент тут не нужен!!!
```java
import java.util.Scanner;
class MyNumber {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int x = s.nextInt(); int y = s.nextInt();
       s.close();
       int z = (x+1)/(y-1)+(y+1)/(x-1);
       System.out.print(z);
   }
}
```
### 2.7 «Строки и их методы»
2.7.7
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       String str1 = s.nextLine();
       s.close();
       System.out.print(str1.charAt(0)+" "+str1.charAt(str1.length()-1));
   }
}
```
2.7.8
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       String str1 = s.nextLine();
       String str2 = s.nextLine();
       s.close();
       System.out.print(str1.contains(str2));
   }
}
```
2.7.9
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       String str1 = s.nextLine();
       s.close();
       System.out.println(str1.toLowerCase());
       System.out.println(str1.toUpperCase());
   }
}
```
2.7.11 - совпадение строк
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       String str1 = s.nextLine();
       String str2 = s.nextLine();
       s.close();
       System.out.print(str1.equals(str2));
   }
}
```
2.7.12 - конкатенация и длина строки
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       String str1 = s.nextLine();
       String str2 = s.nextLine();
       s.close();
       String res = str1+" "+str2;
       System.out.println(res);
       System.out.println(res.length());
   }
}
```
2.7.15 - сравненеи строк по первым символам (дял упорядочивания по возрастанию, например)
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in); 
       String str1 = s.next();
       String str2 = s.next();
       s.close();
       boolean res = str1.charAt(0) < str2.charAt(0);
       System.out.println(res);
   }
}
```
### 2.8 «Общий тест по базовым вопросам»
2.8.4
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in); 
       // делаю наоборот - обрабатываю строки а потом числа - так рациональнее
       int sec = s.nextInt();
       s.close();
       long res = sec*60*60*24;
       System.out.println(res);
   }
}
```
2.8.7 - решение на основе теоремы Виета
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in); 
       double a = s.nextDouble(); double b = s.nextDouble(); double c = s.nextDouble();
       s.close();
       double res1 = (-1)*b/a; double res2 = c/a;
       System.out.println(res1+" "+res2);
   }
}
```
2.8.8
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in); 
       double n = s.nextDouble();
       s.close();
       System.out.println((int)((n/4+n/400)-n/100));
   }
}
```
2.8.9
```java
import java.util.Scanner;
class MyProgram {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in); 
       int x = s.nextInt(); int y = s.nextInt();
       s.close();
       System.out.println("Сложение: "+x+" + "+y+" = "+(x+y));
       System.out.println("Вычитание: "+x+" - "+y+" = "+(x-y));
   }
}
```

задачи дял которых тут нет решения - элементарны…
хотя и эти - элементарны…
