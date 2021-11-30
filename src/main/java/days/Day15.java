package days;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day15 {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

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
}
