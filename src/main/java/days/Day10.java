package days;

import java.util.List;

public class Day10 {
    public int recur(int num){
        if (num <= 100)
        {
            if (num < 10 || num > 25) return 1;
            else return 2;
        }
        int temp = num%100;

        if (temp <= 25){
            return recur(num/10)+recur(num/100);
        }
        return recur(num/10);
    }
    public int recur2(List<Integer> list,int startIndex){
        if (list.size() == 1 || (list.size()-startIndex)==1) return 1;
        if ((list.size()-startIndex)==2){
            int num = list.get(startIndex)*10+list.get(startIndex+1);
            if (num < 10 || num > 25) return 1;
            else return 2;
        }
        int num = list.get(startIndex)*10+list.get(startIndex+1);
        int temp = num;

        if (temp <= 25){

            return recur2(list,startIndex+1)+recur2(list,startIndex+2);
        }
        return recur2(list,startIndex+1);
    }
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length(); i++) {
            String temp = s.substring(i-2,i);
            
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(123456).substring(0,2));
    }
}
