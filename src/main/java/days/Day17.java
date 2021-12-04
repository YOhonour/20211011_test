package days;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] arr = {2,4,63,1,7,3,34,2,23,14};
        Day17 day17 = new Day17();
        day17.fastSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
