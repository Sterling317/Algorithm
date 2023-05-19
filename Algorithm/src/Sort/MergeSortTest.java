package Sort;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /*
    从后向前排序
     */
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m - 1;
//        int j = n - 1;
//        for (int k = m + n - 1; k >= 0; k--){
//            if ( (i >= 0 && nums1[i] >= nums2[j]) || j < 0) {
//                nums1[k] = nums1[i];
//                i--;
//            } else {
//                nums1[k] = nums2[j];
//                j--;
//            }
//        }

    /*
    逆向双指针while循环
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        int tempNum = 0;
        while (i >= 0 || j >= 0) {
            if (i == -1){

                tempNum = nums2[j--];
            } else if ( j == -1){

                tempNum = nums1[i--];
            } else if (nums1[i] > nums2[j]){
                tempNum = nums1[i--];
            } else {
                tempNum = nums2[j--];
            }

            nums1[k--] = tempNum;
        }
//        int i = m - 1, j = n - 1;
//        int curIndex = m + n - 1;
//        int cur;
//        while (i >= 0 || j >= 0) {
//            if (i == -1) {
//                j--;
//                cur = nums2[j];
//            } else if (j == -1) {
//                i--;
//                cur = nums1[i];
//            } else if (nums1[i] > nums2[j]) {
//                i--;
//                cur = nums1[i];
//            } else {
//                j--;
//                cur = nums2[j];
//            }
//            nums1[curIndex--] = cur;
//        }
    }

}
