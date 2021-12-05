package days;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Day17 {
    public void fastSort(int[] arr){
        fastRecur(arr,0,arr.length-1);
    }

    /**
     *
     * @param arr
     * @param n
     * @param m
     */
    private void fastRecur(int[] arr,int n,int m){
        if (m<=n) return;
        int i = n;
        int j = m;
        int temp = arr[i];
        while (i<j){
            while (arr[j] >= temp && j>i) j--;
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j&& arr[i] < temp) i++;
            //将比基准数 大的往后移
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        fastRecur(arr,n,i-1);
        fastRecur(arr,i+1,m);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        fastSort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        long between = 0;
        Day17 day17 = new Day17();
        //自定义的排序算法
        int[][] ints1 = day17.generate(10000, 5000);
        Date bg1 = new Date();
        for (int i = 0; i < ints1.length; i++) {
            day17.fastSort(ints1[i]);
        }
        Date end1 = new Date();
        between = end1.getTime()-bg1.getTime();
        System.out.println(between);//输出时间差

        int[][] ints2 = day17.generate(10000, 5000);
        bg1 = new Date();
        for (int i = 0; i < ints1.length; i++) {
            Arrays.sort(ints2[i]);
        }
        end1 = new Date();
        between = end1.getTime()-bg1.getTime();
        System.out.println(between);//输出时间差

        int[][] ints3 = day17.generate(10000, 5000);
        bg1 = new Date();
        for (int i = 0; i < ints1.length; i++) {
            day17.quickSort(ints3[i],0,ints3[i].length-1);
        }
        end1 = new Date();
        between = end1.getTime()-bg1.getTime();
        System.out.println(between);//输出时间差
    }
    public int[][] generate(int row,int cl){
        int[][] arr2 = new int[row][cl];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cl; j++) {

                arr2[i][j] = random.nextInt(500);
            }
        }
        return arr2;
    }
    public void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+": "+Arrays.toString(arr[i]));
        }
    }
}
