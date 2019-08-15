package offer66;

import leetcode.backtrace.PrintAllPermutations;

import java.util.ArrayList;

/**
 * 从上往下打印二叉树
 * //思路：层次遍历，引入队列，从根节点开始，如果存在子节点，将子节点按照左右顺序放到队尾；
 * //接下来从队首取出最早入队的节点，重复以上操作，直到队列中所有节点被打印出来
 */
public class A22 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null)
            return list;
        queue.add(root);
        while(queue.size()!=0){
            TreeNode temp = queue.remove(0);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //初始化二叉树
    public static TreeNode initTreeNode(int[] array){
        return createBinaryTreeByArray(array, 0);
    }
    private static TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length && array[index] != 0) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        TreeNode root = initTreeNode(input);
        ArrayList<Integer> result = PrintFromTopToBottom(root);
        System.out.println(result);
    }
}
