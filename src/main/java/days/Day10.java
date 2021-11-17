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
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String temp = s.substring(i-2,i);
            if (temp.compareTo("25") <= 0 && temp.compareTo("10") >= 0){
                dp[i] = dp[i-1]+dp[i-2];
            }else dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int a = 1;
        int b = 1;
        int c = 1;
        for(int i = 2; i <= s.length(); i ++){
            String temp = s.substring(i-2, i);
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
            {
                c = b + a;
                a = b;
                b = c;
            }
            else{
                c = b;
                a = b;
                b = c;
            }

        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Day10().translateNum2(25));
    }
}
