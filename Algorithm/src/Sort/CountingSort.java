package Sort;

import java.util.Arrays;
/*
两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在arr1中。

对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。

 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
//        relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] nums = new int[1001];
        int[] res = new int[arr1.length];

        //遍历arr1,统计每个元素的数量
        for(int i : arr1){
            nums[i]++;
//            System.out.println(Arrays.toString(nums));
        }

        //遍历arr2，处理arr2中的元素
        int index = 0;
        for (int i : arr2){
            while (nums[i] > 0){
                res[index] = i;
                index++;
                nums[i]--;
            }
        }

        //遍历nums，处理剩下arr2中未出现的元素
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0){
                res[index] = i;
                index++;
                nums[i]--;
            }
        }

        return res;
    }
}
