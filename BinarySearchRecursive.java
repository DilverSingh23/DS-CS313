// Leetcode | 704. Binary Search
public class BinarySearchRecursive {
    public static int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length-1);
    }

    public static int searchHelper(int[] nums, int target, int l, int r) {
        int m = (l+r)/2;
        if (l > r) {
            return -1;
        }
        if (nums[m] == target) {
            return m;
        }
        else if (nums[m] < target) {
            l = m + 1;
            return searchHelper(nums, target, l, r);
        }
        else {
            r = m - 1;
            return searchHelper(nums, target, l, r);
        }
    }

    public static void main (String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 2));
    }
}
