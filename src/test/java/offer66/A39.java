package offer66;

/**
 * 判断平衡二叉树
 * 左右子树的高度差不大于2
 */
public class A39 {

    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        int leftLength = TreeDepth(root.left);
        int rightLength = TreeDepth(root.right);
        if(Math.abs(leftLength - rightLength) >= 2)
            return false;
        else
            return true;
    }
    public static int TreeDepth(TreeNode node){
        if(node == null || node.val == 0)//此处表示了空节点情况
            return 0;
        int left = TreeDepth(node.left);
        int right = TreeDepth(node.right);
        return (left > right ? left+1:right+1);
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
        int[] input = {1,0,3,0,0,4};
        TreeNode root = initTreeNode(input);
        System.out.println(IsBalanced_Solution(root));
    }
}
