package Sort;

/*
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */

import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3};
        int k = 4;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));

    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        //Method 1
//        int[] newArr = new int[k];
//        Arrays.sort(arr);
//        for (int i = 0; i < k; i++) {
//            newArr[i] = arr[i];
//            System.out.println(newArr[i]);
//        }
//        return newArr;
        quickSort(arr,0, arr.length-1);
        return  Arrays.copyOf(arr, k);
    }

    private static void quickSort(int[] arr, int l , int r){
        //子数组长度为一时终止递归
        if (l >= r) return;
        //哨兵划分操作，以arr[l]为基准数
        int i = l, j = r;
        //两哨兵相遇即退出循环
        while (i < j){
            //从右向左查找首个小于基准数的元素
            while (i < j && arr[j] >= arr[l]){
                j--;
            }
            //从左向右查找首个大于基准数的元素
            while (i < j && arr[i] <= arr[l]){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,i,l);
        //递归左右子数组执行哨兵划分
        quickSort(arr,l,i-1);;
        quickSort(arr,i+1,r);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
