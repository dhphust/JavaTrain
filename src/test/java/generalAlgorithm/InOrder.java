package generalAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class InOrder {

    public static List<TreeNode> inOrder(TreeNode root){
        if(root == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current);
            current = current.right;
        }
        return list;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode initTreeNode(int[] array){
        return createBinaryTreeByArray(array,0);
    }

    public static TreeNode createBinaryTreeByArray(int[] array,int index){
        TreeNode tn = null;
        if(index < array.length && array[index] != 0){
            tn = new TreeNode(array[index]);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        TreeNode root = initTreeNode(array);
        List<TreeNode> result = inOrder(root);
        for (TreeNode node : result) {
            System.out.print(node.val);
        }
    }
}
