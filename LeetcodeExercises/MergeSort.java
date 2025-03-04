package LeetcodeExercises;

public class MergeSort {
    public static int[] mergeSort (int[] arr, int left, int right){
        if (left == right) {
            int[] baseCase = {arr[left]};
            return baseCase;
        }
        int mid = (left+right)/2;
        int[] firstHalf = mergeSort(arr, left, mid);
        int[] secondHalf = mergeSort(arr, mid+1, right);
        return merge(firstHalf, secondHalf);

    }

    public static int[] merge (int[] firstHalf, int[] secondHalf){
        int[] results = new int[firstHalf.length + secondHalf.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int resultsPointer = 0;

        while (firstPointer < firstHalf.length && secondPointer < secondHalf.length){
            if (firstHalf[firstPointer] <= secondHalf[secondPointer]){
                results[resultsPointer++] = firstHalf[firstPointer++];
            }
            else {
                results[resultsPointer++] = secondHalf[secondPointer++];
            }
        }

        while (firstPointer < firstHalf.length){
            results[resultsPointer++] = firstHalf[firstPointer++];
        }

        while (secondPointer < secondHalf.length) {
            results[resultsPointer++] = secondHalf[secondPointer++];
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