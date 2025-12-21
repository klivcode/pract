public class SelectionSort {

    void swapp(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            swapp(arr, i, min_idx);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 0, 11, 5};
        int n = arr.length;

        SelectionSort s = new SelectionSort();
        s.selectionSort(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

