package offer66;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树的第K个节点
 * 二叉搜索树中序遍历
 */
public class A62 {

    private static int index = 0;
    //递归中序
//    static TreeNode KthNode(TreeNode root, int k)
//    {
//        if(root != null){
//            TreeNode node = KthNode(root.left,k);
//            if(node != null)
//                return node;
//            index++;
//            if(index == k)
//                return root;
//            node = KthNode(root.right,k);
//            if(node != null)
//                return node;
//        }
//            return null;
//    }

    public static List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
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
        int[] input = {5,3,7,2,4,6,8};
        int k = 3;
        TreeNode root = initTreeNode(input);
        List<Integer> result = inorder(root);
        System.out.println(result.get(k-1));
    }
}
