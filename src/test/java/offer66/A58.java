package offer66;

import java.util.Stack;

/**
 * 判断对称二叉树
 */
public class A58 {

    //    public static boolean isSymmetrical(TreeNode pRoot)
//    {
//        if(pRoot == null) return true;
//        return isSymmetrical(pRoot.left, pRoot.right);
//    }
//    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
//        if(left == null && right == null) return true;
//        if(left == null || right == null) return false;
//        return left.val == right.val //为镜像的条件：左右节点值相等
//                && isSymmetrical(left.left, right.right) //2.对称的子树也是镜像
//                && isSymmetrical(left.right, right.left);
//    }
    static boolean isSymmetricalDFS(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.isEmpty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
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
        public static TreeNode initTreeNode ( int[] array){
            return createBinaryTreeByArray(array, 0);
        }
        private static TreeNode createBinaryTreeByArray ( int[] array, int index){
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

        public static void main (String[]args){
            int[] input = {1, 2, 2, 3, 3, 3, 3};
            TreeNode root = initTreeNode(input);
            System.out.println(isSymmetricalDFS(root));
        }
    }
