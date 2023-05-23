package Search;

import java.util.Arrays;

/*
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回[-1, -1]。

你必须设计并实现时间复杂度为O(log n)的算法解决此问题。

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]

 */
public class BinarySearch_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(Solution_34.searchRange(nums, target)));

    }
}

class Solution_34 {
    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = searchFirst(nums, target-1);
        int rightIdx = searchFirst(nums, target) - 1;
        System.out.println(leftIndex);
        System.out.println(rightIdx);
//        System.out.println("left"+leftIndex +"   " + "right" + rightIdx);
        if (leftIndex <= rightIdx && nums[leftIndex] == target) {
            return new int[]{leftIndex, rightIdx};
        }
        return new int[]{-1, -1};

    }

    private static int searchFirst(int[] nums, int target){
//        int len = nums.length;
//        int left = 0, right = len -1;
//        int res = nums.length;
//        while (left < right){
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < target){
//                left = mid + 1;
//            } else {
//                right = mid;
//                res = mid;
//            }
//        }
//        System.out.println(res);
//        return res;

        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}