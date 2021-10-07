public class Test {

    public static void main(String[] args) {
        HomeWork3.task3();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        HomeWork3.task8(arr, 3);  // [6, 7, 8, 1, 2, 3, 4, 5] - правый сдвиг на три элемента
        HomeWork3.task8(arr, -3); // [1, 2, 3, 4, 5, 6, 7, 8] - левый сдвиг на три элемента

    }
}
