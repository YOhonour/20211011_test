package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day07 {
    /*
    二叉树A是否包含二叉树B
    递归搜索每一个节点是否与B数有相同结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null ) return false;
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
    //先序遍历
    public void rootFirst(TreeNode treeNode, List list){
        if (treeNode.left != null) rootFirst(treeNode.left,list);
        list.add(treeNode.val);
        if (treeNode.right != null) rootFirst(treeNode.right,list);
    }

    public TreeNode mirrorTree(TreeNode root) {
        switchMap(root);
        return root;
    }
    public void switchMap(TreeNode A){
        if (A != null){
            TreeNode temp = A.left;
            A.left = A.right;
            A.right = temp;
            switchMap(A.right);
            switchMap(A.left);
        }
    }
    /*
    对称的二叉树
     */
    public boolean recurBody(TreeNode A,TreeNode B){
        //当A、B只有一个为null时说明不对称
        if ((A == null && B!=null) || (B == null && A!=null) ) return false;
        //同时为null说明递归到了二叉树底部，此时应该为对称
        else if (A == null && B == null) return true;
        //当A、B节点的值相等时应该进行下层判断
        else if (A.val == B.val) return recurBody(A.left,B.right) && recurBody(A.right, B.left);
        else return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recurBody(root.left,root.right);
    }
    //生成一个二叉树
    public TreeNode generation(){
        TreeNode a1_1 = new TreeNode(1);
        TreeNode a2_1 = new TreeNode(2);
        TreeNode a2_2 = new TreeNode(2);
        TreeNode a3_1 = new TreeNode(3);
        TreeNode a3_2 = new TreeNode(4);
        TreeNode a3_3 = new TreeNode(4);
        TreeNode a3_4 = new TreeNode(3);
        a2_1.left = a3_1;
        a2_1.right = a3_2;
        a2_2.left = a3_3;
        a2_2.right = a3_4;
        a1_1.left = a2_1;
        a1_1.right = a2_2;
        return a1_1;
    }
    public static void main(String[] args) {
        Day07 day07 = new Day07();
        day07.isSymmetric(day07.generation());
    }
}
