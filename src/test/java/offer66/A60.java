package offer66;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树打印出多行
 * 层次遍历
 */
public class A60 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(); //记录每层节点信息
        LinkedList<TreeNode> queue = new LinkedList<>(); //保存左右子节点信息
        if (root == null)
            return lists;
        queue.add(root);
        int curNum = 1;//当前层节点数
        int nextNum = 0; //下一层节点数
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            curNum--;
            list.add(temp.val);//保存当前层元素
            if (temp.left != null) {
                queue.add(temp.left);
                nextNum++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextNum++;
            }
            if (curNum == 0) {//当前层节点已经被全部保存
                //new 一个新的对象，新开辟一块地址空间，不然list.clear()会清空list所有元素
                lists.add(new ArrayList<>(list));
                list.clear();
                curNum = nextNum;//移动到下一层，保存下一层的节点数
                nextNum = 0;//下一层归0
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
    public static TreeNode initTreeNode(int[] array) {
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
        int[] input = {1, 2, 0, 3, 4, 0, 0, 5, 6, 7};
        TreeNode root = initTreeNode(input);
        ArrayList<ArrayList<Integer>> result = Print(root);
        System.out.println(result);
    }
}
