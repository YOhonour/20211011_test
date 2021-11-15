package days;

import java.util.*;

public class Day06 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
        }
        return list.stream().mapToInt(t->t).toArray();
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root== null) return answer;
        Queue<TreeNode> workQ = new LinkedList<>();
        workQ.add(root);
        while (true){
            List<Integer> tempList = new ArrayList<Integer>();
            Queue<TreeNode> nextLevel = new LinkedList<>();

            while (!workQ.isEmpty()){
                TreeNode treeNode = workQ.poll();
                tempList.add(treeNode.val);
                if (treeNode.left!=null) nextLevel.add(treeNode.left);
                if (treeNode.right!=null) nextLevel.add(treeNode.right);
            }
            answer.add(tempList);
            if (nextLevel.isEmpty()) break;
            workQ = nextLevel;
        }
        return answer;
    }
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root== null) return answer;
        Queue<TreeNode> workQ = new LinkedList<>();
        workQ.add(root);
        while (true){
            List<Integer> tempList = new LinkedList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!workQ.isEmpty()){
                TreeNode treeNode = workQ.poll();
                tempList.add(treeNode.val);
                if (treeNode.left!=null) nextLevel.add(treeNode.left);
                if (treeNode.right!=null) nextLevel.add(treeNode.right);
            }
            answer.add(tempList);
            if (nextLevel.isEmpty()) break;
            workQ = nextLevel;
        }
        for(int i=1;i<answer.size();i+=2){
            Collections.reverse(answer.get(i));
        }
//        for (int i = 0; i < answer.size(); i++){
//            if (i % 2==0){
//                List<Integer> old = answer.get(i);
//                LinkedList<Integer> reversedList = new LinkedList<>();
//                for (int j = 0; j < old.size();j++){
//                    reversedList.push(old.get(j));
//                }
//                answer.set(i,reversedList);
//            }
//        }
        return answer;
    }
}
