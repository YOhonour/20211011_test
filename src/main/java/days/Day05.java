package days;

import java.util.HashMap;
import java.util.Scanner;

public class Day05 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /*
        ///牛啊，评论第一个人
        对一个矩阵A(n,m)
        从左上角开始遍历，左上角坐标为(0,m-1)
        假设此时指针坐标为（a,b）
        左移：（a,b-1）
        右移：（a+1,b）
        当触碰到边界时搜索完毕
         */
        if (matrix.length == 0) return false;
        int n = 0;//行
        int m = matrix[0].length-1;//列
        while (n < matrix.length && m >= 0){
            if (matrix[n][m] == target) return true;
            else if (target < matrix[n][m]) m=m-1;
            else if (target > matrix[n][m]) n=n+1;
        }
        return false;
    }

    //遍历法
    public int minArray1(int[] numbers) {
        int ptr = 1;
        while (ptr < numbers.length){
            if (numbers[ptr-1] > numbers[ptr])
                return numbers[ptr];
            else ptr++;
        }
        return numbers[0];
    }

    //二分法
    public int minArray(int[] numbers) {
        int i = 0,j = numbers.length-1;
        int m = 0;
        while (i<j){
            m = (i+j)/2;
            if (numbers[m] > numbers[j]){
                i=m+1;
            }else if (numbers[m]<numbers[j]){
                j=m;//不能写j=m+1是因为有可能漏
            }else {
                j = j-1;
            }
        }
        return numbers[i];
    }

    public static char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        int[] num = new int[26];
        for (int i = 0;i < s.length();i++){
            num[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (1 == num[s.charAt(i)-'a']) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.printf(""+Day05.firstUniqChar(s));
    }
    public static void main2(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        System.out.printf(""+new Day05().minArray(nums));
    }
    public static void main1(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.printf(new Day05().findNumberIn2DArray(matrix,target)+"");;
        int f=0;
        Scanner scan = new Scanner(System.in);
        while (f!=-1){
            f = scan.nextInt();
            System.out.printf(new Day05().findNumberIn2DArray(matrix,f)+"");;
        }
    }
}
