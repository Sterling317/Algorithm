package Search;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

输入: nums = [1,3,5,6], target = 5
输出: 2

输入: nums = [1,3,5,6], target = 7
输出: 4


 */
public class BinarySearch_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(Solution_35.searchInsert(nums,target));
    }
}

class Solution_35 {
    public static int searchInsert(int[] nums, int target) {
        // int len = nums.length;
        // int left = 0;
        // int right = len;
        // // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        // while (left < right) {
        //     int mid = left + (right - left) / 2;
        //     if (nums[mid] < target){
        //         // 下一轮搜索的区间是 [mid + 1..right]
        //         left = mid + 1;
        //     } else {
        //         // 下一轮搜索的区间是 [left..mid]
        //         right = mid;
        //     }
        // }
        // return left;

        int len = nums.length;

        if (nums[len - 1] < target){
            return len;
        }

        int left = 0;
        int right = len - -1;

        while (left < right){
            int mid = left + (right - left) /2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}