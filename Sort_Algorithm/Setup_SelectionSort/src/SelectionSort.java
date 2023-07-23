public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        selectionSort(list);
    }

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            int min_position = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[min_position] > list[j]) {
                    min_position = j;
                }
            }
            double temp = list[min_position];
            list[min_position] = list[i];
            list[i] = temp;
        }
        for (double ar : list) {
            System.out.print(ar + " ");
        }
    }
}
