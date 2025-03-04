package Midterm1;
import java.util.ArrayList;
import java.util.Arrays;
// Implement binary search recursively
// Time Complexity: O(log n)
public class M1Question2 {
    public static int binarySearch (ArrayList<Integer> arr, int x) {
        return helper(arr, x, 0, arr.size()-1);
    }

    public static int helper (ArrayList<Integer> arr, int target, int left, int right){
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if (arr.get(mid) == target) {
            return mid;
        }
        else if (arr.get(mid) < target){
            return helper(arr, target, mid+1, right);
        }
        else{
            return helper(arr, target, left, mid-1);
        }
    }
        

    public static void main (String[] args) {
        ArrayList<Integer> arr = new ArrayList<>((Arrays.asList(0,1,2,3,4,5,6,7)));
        System.out.println(binarySearch(arr, 5));
    }

}