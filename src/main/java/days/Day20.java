package days;

import java.util.HashMap;

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
}
