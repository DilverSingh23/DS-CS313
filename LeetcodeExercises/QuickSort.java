package LeetcodeExercises;

public class QuickSort {
    public static void quickSort (int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static int partition (int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main (String[] args) {
        int[] arr = {0,9,1,3,8,4,7,2,5,1,0};
        System.out.println("Original Array: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println("\nSorted Array: ");
        quickSort(arr, 0, arr.length-1);
        for (int a : arr) {
            System.out.print(a + " ");
        }   
    }

}
