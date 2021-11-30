package days;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day15 {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    /**
     * 递归遍历到叶子结点，当遍历到叶子结点时查看当前目标值是否为0，如果满足条件，将此时的路径加入结果集合中
     * 左右子树递归完成后将当前节点从path中删除，再返回，以此保证在执行时，path始终为从root到当前节点的路径
     * 需要注意的是：
     *      1.每次加入时需要新建链表，原因是在整个伐算运行途中，path指针不变
     *      2.在叶子结点时也需要在path中，移除最后一个节点，保证返回上层时的正确性
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/submissions/
     * @param curNode
     * @param curTarget
     */
    public void recur(TreeNode curNode,int curTarget){
        if (curNode == null) return;
        path.add(curNode.val);
        curTarget = curTarget - curNode.val;
        if (curTarget == 0 && curNode.left==null && curNode.right == null) {
            result.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        recur(curNode.left,curTarget);
        recur(curNode.right,curTarget);
        path.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return result;
    }


    public List<Node> nodeList = new ArrayList<>();
    public void midSearch(Node root){
        if (root == null ) return;
        if (root.left != null) midSearch(root.left);
        nodeList.add(root);
        if (root.right != null) midSearch(root.right);
    }

    /**
     * 第一步中序遍历二叉树，再遍历队列修改左右指针值
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        midSearch(root);
        Node head = nodeList.get(0);
        int size = nodeList.size();
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            node.left = nodeList.get((i+size-1)%size);
            node.right = nodeList.get((i+size+1)%size);
        }
        return head;
    }
}
