
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Iterate {
    int[] intArray = {1,2,3,4,5,6,7};

    public static void main(String[] args) {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("vfvf0");
        sList.add("vfvf1");
        sList.add("vfvf2");
        sList.add("vfvf3");
        System.out.println(sList);
        Iterator<String> iterator1 = sList.iterator(); // обычный итератор
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
           // можно только получить (а он сейчас получен)
        }
        System.out.println(sList);
        ListIterator<String> iterator2 = sList.listIterator(); // расширенный итератор списка
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
            iterator2.set("!!!!");  // изменение итерируемого объекта
        }
        System.out.println(sList);

        int[] intArray = {1,2,3,4,5,6,7}; // итерация по массиву
        Iterator i = Arrays.stream(intArray).iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        String val = "ldskj fs dflksd jf sdf\nspodf psod if\nsdfsdfsdf";
        Iterator i1 = val.chars().iterator(); // итерация по кодам символов
        while (i1.hasNext()){
            System.out.println(i1.next());
        }
        Iterator i2 = val.lines().iterator(); // итерация по строкам <по \n>
        while (i2.hasNext()){
            System.out.println(i2.next());
        }


    }

}
