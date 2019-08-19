package generalAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历
 */
public class PreOrder {

    public static List<TreeNode> preOrder(TreeNode root){
        if(root == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp);
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
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
    //初始化二叉树
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
        int[] array = {1,2,3,4,5,6};
        TreeNode root = initTreeNode(array);
        List<TreeNode> result = preOrder(root);
        for (TreeNode node : result) {
            System.out.print(node.val);
        }

    }
}
