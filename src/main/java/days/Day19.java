package days;

public class Day19
{
    /*
    求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    n(1+n)
    示例 1：
        输入: n = 3
        输出: 6

    示例 2：
        输入: n = 9
        输出: 45
     */

    /*
    5  0101
    8  1000
    9  1001
    72 0100 1000
    128 64 32 16 8 4 2 1
     */
    public int sumNums(int n) {
        /*
        使用移位操作
         */
        if(n==2) return 3;
        int result = 0;
        int n1 = n+1;
        //如果对奇数做整数除法会产生误差
        if (n % 2 == 0 ) {
            n=n>>1;
        }else {
            n1=n1>>1;
        }
        int flag = 1;
        for (int i = 0; i < Integer.SIZE; i++) {
            int j = (n & (flag << i));
            if ( j != 0){
                result = result + (n1 << i);
            }
        }
        return result;
    }
    public int recur(int n,int m,int i,int result){
        if (i >= Integer.SIZE) return result;
        int j = (n & (1 << i));
        if ( j != 0){
            result = result + (m << i);
        }
        i++;
        return recur(n,m,i,result);
    }
    public int sumNums2(int n){
        int m = n+1;
        if (n % 2 == 0 ) {
            n=n>>1;
        }else {
            m=m>>1;
        }
        int result = recur(n,m,0,0);;

        return result;
    }
    int res = 0;
    public int sumNums3(int n){
        //向下递归，&&为阻断式判断，首先判断此时的n>1,如果等于1说明已经到了递归的底部，
        boolean a = n > 1 && sumNums3(n-1) > 0;
        res+=n;
        return res;
    }
    public static void main(String[] args) {
        Day19 day19 = new Day19();
        System.out.println(day19.sumNums2(24));

        class A {
            private int a = 10;
        }
    }
}
