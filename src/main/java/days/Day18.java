package days;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day18 {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    int max = 0;
    public void recur(TreeNode root,int last){
        map.put(root,last+1);
        if(max < last+1) max = last+1;
        if (root.left != null) recur(root.left,last+1);
        if (root.right!= null) recur(root.right,last+1);
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        recur(root,0);
        return max;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth3(root.left),maxDepth3(root.right))+1;
    }

    //广度优先
    int re = 0;
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        if (root==null) return 0;
        list.add(root);
        recur2(list);
        return re;
    }
    public void recur2(Queue<TreeNode> workList){
        if (workList.isEmpty()) return;
        Queue<TreeNode> temp = new LinkedList<>();
        for (TreeNode poll : workList) {
            if (poll.left!=null) temp.add(poll.left);
            if (poll.right!=null) temp.add(poll.right);
        }
        re++;
        recur2(temp);
    }
}
