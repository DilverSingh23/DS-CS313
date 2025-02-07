package LeetcodeExercises;

public class MergeSort {
    public static int[] mergeSort(int[] arr, int left, int right){
        if (left == right) {
            int[] baseCase = {arr[left]};
            return baseCase;
        }
        int mid = (left+right)/2;
        int[] firstHalf = mergeSort(arr, left, mid);
        int[] secondHalf = mergeSort(arr, mid+1, right);
        return merge(firstHalf, secondHalf);
    }

    public static int[] merge (int[] firstHalf, int[] secondHalf) {
        int[] results = new int[firstHalf.length + secondHalf.length];

        int firstPtr = 0;
        int secondPtr = 0;
        int resultsPtr = 0;

        while (firstPtr < firstHalf.length && secondPtr < secondHalf.length) {
            if (firstHalf[firstPtr] < secondHalf[secondPtr]) {
                results[resultsPtr] = firstHalf[firstPtr];
                firstPtr++;
            }
            else {
                results[resultsPtr] = secondHalf[secondPtr];
                secondPtr++;
            }
            resultsPtr++;
        }

        while (firstPtr < firstHalf.length) {
            results[resultsPtr] = firstHalf[firstPtr];
            firstPtr++;
            resultsPtr++;
        }

        while (secondPtr < secondHalf.length) {
            results[resultsPtr] = secondHalf[secondPtr];
            secondPtr++;
            resultsPtr++;
        }

        return results;
    }


	public static void main(String[] args) {
		int[] arr = {9, 0, -3, 21, 5, 9, 1, -15};
		arr = mergeSort(arr, 0, arr.length-1);
        for (int a: arr) {
            System.out.print(a + " ");
        }
	}

}