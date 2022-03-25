package days;

import java.util.Stack;

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


    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * @param root
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /**
         * 从根节点向下搜索
         *    两种情况：
         *             1. p q节点在当前root节点同侧 --->  继续向下搜索
         *             2. 两个节点在两侧  ----> 搜索结束，此时达到最近公共节点
         */
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ||  root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
    public void find(Stack<TreeNode> stack,TreeNode root,TreeNode target){
        if (target.val == root.val) return;
        stack.add(root);
        if (target.val < root.val) find(stack,root.left,target);
        if (target.val > root.val) find(stack,root.right,target);
    }
    public static void main(String[] args) {
        Day19 day19 = new Day19();
        System.out.println(day19.sumNums2(24));

        class A {
            private int a = 10;
        }
    }
}
