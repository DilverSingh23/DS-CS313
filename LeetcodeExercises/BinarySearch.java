package LeetcodeExercises;
// Leetcode | 704. Binary Search
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;

        while (l <= r) {
            m = (l+r)/2;
            if (nums[m] == target) {
                return m;
            }
            else if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r  = m - 1;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }
}
