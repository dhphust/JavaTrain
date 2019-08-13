package offer66;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 **/

public class A4 {
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private static TreeNode preIn(int[] pre, int preIndex, int preLength, int[] in, int inIndex, int inLength, HashMap<Integer, Integer> map) {
        if (preIndex > preLength) {
            return null;
        }
        TreeNode head = new TreeNode(pre[preIndex]);
        int index = map.get(pre[preIndex]);
        head.left = preIn(pre, preIndex + 1, preIndex + index - inIndex, in, inIndex, index - 1, map);
        head.right = preIn(pre, preIndex + index - inIndex + 1, preLength, in, index + 1, inLength, map);
        return head;
    }

    //先序遍历
    private static List<TreeNode> preIterator(TreeNode node) {

        List<TreeNode> list = new ArrayList<TreeNode>();
        // 处理根节点
        list.add(node);
        // 递归处理左子树
        if (node.left != null) {
            list.addAll(preIterator(node.left));
        }
        // 递归处理右子树
        if (node.right != null) {
            list.addAll(preIterator(node.right));
        }

        return list;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        List<TreeNode> list = preIterator(treeNode);
        //打印先序遍历结果
        for (int i = 0; i < list.size(); i++) {
            TreeNode node =  list.get(i);
            System.out.println(node.value);
        }

    }

}

//自定义java的链表对象
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        value = x;
    }

}
