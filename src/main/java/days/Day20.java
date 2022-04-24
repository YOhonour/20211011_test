package days;

import java.util.*;

public class Day20 {
    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
     * 中序遍历性质： 节点按照 [ 左子树 | 点 | 右子树 ] 排序。
     */
    int[] myPreorder;
    HashMap<Integer,Integer> dit = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        myPreorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            dit.put(inorder[i],i);//将元素下标存入字典
        }
        return buildTreeRecur(0, 0, inorder.length - 1);
    }

    /**
     * @param pre_root 根节点在前序遍历的索引
     * @param in_left 子树在中序遍历的左边界
     * @param in_right 子树在中序遍历的右边界
     * @return
     */
    private TreeNode buildTreeRecur(int pre_root,int in_left, int in_right){
        if (in_left>in_right) return null;
        TreeNode corRoot = new TreeNode(myPreorder[pre_root]);
        int i = dit.get(myPreorder[pre_root]);//获取在中序遍历中根节点所在索引，以方便获取左子树的数量
        corRoot.left = buildTreeRecur(pre_root+1,in_left,i-1);
        corRoot.right = buildTreeRecur(pre_root+(i-in_left)+1,i+1,in_right);
        return corRoot;
    }
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
    static int N_ONE = -1;
    public static double myPow2(double x, int n) {
        if (x == 1) return x;
        else if (x == -1) return ((n & 1) ==0) ? -x : x;
        else if (n==1) return x;
        else if (n < 0) {
            n = n*N_ONE;
            x = 1/x;
        }
        double ans = x;
        for (int i = 1; i < n; i++) {
            ans*=x;
        }
        return ans;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,postorder.length-1,0);
    }

    /**
     *
     * @param postorder int序列
     * @param headIndex 头节点下标
     * @param limitIndexOfLeft 左边界下标
     * @return 是否为后序遍历
     */
    private boolean recur(int[] postorder,int headIndex,int limitIndexOfLeft){
        if (headIndex <= limitIndexOfLeft) return true;
        int leftSubTreeIndex = limitIndexOfLeft;//左子树头节点下标，左子树一定是小于根节点的，所以在后续判断中，需要判断左子树中是否有大于根节点的
        //从尾部向前遍历，寻找左子树的下标，也即为第一个小于头节点的下标值
        for (int i = headIndex; i >= limitIndexOfLeft; i--) {
            if (postorder[i] < postorder[headIndex] ){
                leftSubTreeIndex = i;
                break;
            }
        }
        if (leftSubTreeIndex != limitIndexOfLeft){
            //左子树下标与左边界相同则说明没有左子树，就不进行左子树判断了
            for (int i = leftSubTreeIndex; i >= limitIndexOfLeft; i--) {
                if (postorder[i] >= postorder[headIndex]) return false;
            }
        }
        return recur(postorder,headIndex-1,leftSubTreeIndex+1) &&
                recur(postorder,leftSubTreeIndex,limitIndexOfLeft);
    }
    boolean recur1(int[] postorder, int headIndex, int limitIndexOfRight) {
        if(limitIndexOfRight >= headIndex) return true;
        int p = limitIndexOfRight;
        while(postorder[p] < postorder[headIndex]) p++;
        int m = p;
        while(postorder[p] > postorder[headIndex]) p++;
        return p == headIndex
                && recur1(postorder, limitIndexOfRight, m - 1)
                && recur1(postorder, m, headIndex - 1);
    }
    public static String get(String a){
        return a.substring(1,-1);
    }

    public static void main(String[] args) {
        //int[] aaa = new int[]{5,10,6,9,4};//[5, 4, 3, 2, 1]
        int[] aaa = new int[]{5, 4, 3, 2, 1};//[5, 4, 3, 2, 1]

        //String s1 = s.replaceAll("\n", "").replaceAll(" ", "");
//        System.out.println(s1);
        Random random = new Random();
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
        for (int i = 0; i < 2000000; i++) {
            searchTree.insert(((random.nextInt()%2000000)+2000000)%2000000);
        }
        Date d0 = new Date();
        System.out.println(new Day20().verifyPostorder(aaa));//searchTree.nodeList.stream().mapToInt(Integer::intValue).toArray()
        Date d1 = new Date();
        System.out.println(d1.getTime()-d0.getTime());

        System.out.println(new Day20().verifyPostorder(searchTree.nodeList.stream().mapToInt(Integer::intValue).toArray()));//
        Date d2 = new Date();
        System.out.println(d2.getTime()-d1.getTime());
        //System.out.println(searchTree.toString());
    }

}

