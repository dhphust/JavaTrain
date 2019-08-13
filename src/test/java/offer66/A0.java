package offer66;

import java.util.Scanner;

/**
 * 初始化二叉树
 */
public class A0 {

    public static void solution(TreeNode root){
        preOrderTraver(root);
    }

    //测试：先序遍历
    public static void preOrderTraver(TreeNode node) {
        if (null != node) {
            System.out.println("node:" + node.val);
            preOrderTraver(node.left);
            preOrderTraver(node.right);
        } else {
            return;
        }
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
//        int[] array = {2,3,5,6,7,5,3};
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();//输入N个数
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = input.nextInt();
        }
        TreeNode root = initTreeNode(array);
        solution(root);
    }
}
