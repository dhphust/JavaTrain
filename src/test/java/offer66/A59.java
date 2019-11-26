package offer66;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 之字形打印二叉树
 */
public class A59 {

    public static ArrayList<ArrayList<Integer>> print(TreeNode root){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;

        Stack<TreeNode> stack1 = new Stack<>();//stack1保存奇数层节点
        stack1.push(root);//将跟节点存入stsck1
        Stack<TreeNode> stack2 = new Stack<>(); //stack2保存偶数层节点
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()){
                    TreeNode temp = stack1.pop();
                    list.add(temp.val);
                    if(temp.left != null)//偶数层存入stack2
                        stack2.push(temp.left);
                    if(temp.right != null)
                        stack2.push(temp.right);
                }
                lists.add(list);//保存本层节点
            }
            else { //打印偶数层节点
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()){
                    TreeNode temp = stack2.pop();
                    list.add(temp.val);
                    if(temp.right != null)
                        stack1.push(temp.right);
                    if(temp.left != null)
                        stack1.push(temp.left);
                }
                lists.add(list);
            }
        }
        return lists;
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
        int[] array = {1,2,3,4,5,6};
        TreeNode root = initTreeNode(array);
        ArrayList<ArrayList<Integer>> result = print(root);
        System.out.println(result);
    }
}
