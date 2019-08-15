package offer66;

import java.util.LinkedList;

/**
 * 树的深度
 * 层次遍历
 */
public class A38 {

    public static int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode currentNode;
        int count = 0, depth = 0, nextcount = 1;
        while(!list.isEmpty()){
            currentNode = list.poll();
            count++;
            if(currentNode.left != null)
                list.add(currentNode.left);
            if(currentNode.right != null)
                list.add(currentNode.right);
            if(count == nextcount){
                depth++;
                count = 0;
                nextcount = list.size();
            }
        }
        return depth;
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
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        TreeNode root = initTreeNode(array);
        System.out.println(TreeDepth(root));
    }
}
