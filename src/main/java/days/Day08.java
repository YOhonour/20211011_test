package days;

public class Day08 {
    public int fib(int n) {
        int a0 = 1;
        int a1 = 1;
        if (n == a0) return n;
        int temp_n_2 = 0,temp_n_1 = 1,temp_n = 0;
        for (int i = 2; i <= n ;i++){
            temp_n = (temp_n_1+temp_n_2)%1000000007;
            temp_n_2 = temp_n_1;
            temp_n_1 = temp_n;
        }
        return temp_n;
    }
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
     */
    public int numWays(int n) {
        int temp_n_2 = 0,temp_n_1 = 1,temp_n = 0;
        if (n == temp_n_2 || n == temp_n_1) return n;
        for (int i = 2; i <= n ;i++){
            temp_n = (temp_n_1+temp_n_2)%1000000007;
            temp_n_2 = temp_n_1;
            temp_n_1 = temp_n;
        }
        return temp_n;
    }
    //垃圾双循环
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int temp = 0;
            for (int j = i+1; j < prices.length; j++) {
                int a = (prices[j] - prices[i]);
                if (a > temp){
                    temp = a;
                }
            }
            if (max < temp) max = temp;
        }
        return max;
    }
    //算是动态规划？
    //凭感觉写的
    public int maxProfit2(int[] prices) {
        if (prices.length == 0 ) return 0;
        int max = 0;
        int minPrices = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrices > prices[i]) {
                minPrices=prices[i];

            }else {
                int t = (prices[i] - minPrices);
                if (max < t) max = t;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] v = new int[][]
                {
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                };
    }
}
