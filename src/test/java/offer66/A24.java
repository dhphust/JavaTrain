package offer66;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 */
public class A24 {

    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));//不重新new的话从始至终listAll中所有引用都指向了同一个list
        if(root.left!=null)
            FindPath(root.left, target);
        if(root.right!=null)
            FindPath(root.right, target);
        //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        list.remove(list.size()-1);//移除最后一个元素，深度遍历完一条路径后要回退
        return listAll;
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
        int[] input = {2,3,4,6,7,5};
        TreeNode root = initTreeNode(input);
        ArrayList<ArrayList<Integer>> result = FindPath(root,11);
        for (ArrayList<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
