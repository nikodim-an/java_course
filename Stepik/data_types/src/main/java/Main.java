import ru.khan.dataTypes.Arrays_example;
import ru.khan.dataTypes.Collections_example;
import ru.khan.dataTypes.Enumerators;

public class Main {
    /**
     * отработак использования класов хранения данных
     */
    public static void main(String[] args) {
        // перечисления
        Enumerators.enumerateUse();
        // массивы
        Arrays_example.arrayUse();
        // коллекции
        Collections_example.coollections();
        // справочники

        // массивы, сортировка слиянием
        int[] a1 = {0,4,8};
        int[] a2 = {3,6,10};
        System.out.println(Arrays_example.mergeArrays(a1,a2));
    }
}
