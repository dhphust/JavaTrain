package offer66;

/**
 * 二叉树的镜像
 */
public class A18 {


    public static TreeNode Mirror(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return null;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
        return root;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

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
        int[] input = {2,3,4,6,7,3};
        TreeNode root = initTreeNode(input);
        TreeNode result = Mirror(root);
        System.out.println(result.left.val);

    }
}
