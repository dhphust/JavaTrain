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
        //中序中划分左右子树范围，前序的开始结束索引通过计算中序中左右子树的大小来计算
        head.left = preIn(pre, preIndex + 1, preIndex + (index - inIndex), in, inIndex, index - 1, map);
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

    //后序遍历
    private static List<TreeNode> lastIterator(TreeNode node) {

        List<TreeNode> list = new ArrayList<TreeNode>();
        // 递归处理左子树
        if (node.left != null) {
            list.addAll(lastIterator(node.left));
        }
        // 递归处理右子树
        if (node.right != null) {
            list.addAll(lastIterator(node.right));
        }
        // 处理根节点
        list.add(node);

        return list;
    }

    //中序后序确定二叉树
    public static TreeNode reConstructBinaryTree2(int[] in,int[] last){
        if (last == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree2(in,0,in.length-1,last,0,last.length-1,map);
    }

    public static TreeNode reConstructBinaryTree2(int[] in,int inStart,int inEnd,int[] last,int lastStart,int lastEnd,HashMap<Integer, Integer> map){

        if (inStart > inEnd || lastStart > lastEnd) {
            return null;
        }
        TreeNode head = new TreeNode(last[lastEnd]);
        int index = map.get(last[lastEnd]);
        head.left = reConstructBinaryTree2(in,  inStart, index-1, last, lastStart, lastStart+index-inStart-1, map);
        head.right = reConstructBinaryTree2(in, index+1, inEnd, last, lastStart+index-inStart, lastEnd-1, map);
        return head;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] last = {7,4,2,5,8,6,3,1};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        List<TreeNode> list = lastIterator(treeNode);
        //打印先序遍历结果
        for (int i = 0; i < list.size(); i++) {
            TreeNode node =  list.get(i);
            System.out.println(node.value);
        }

        System.out.println("验证中序后序->先序");
     //   验证中序后序->先序
        TreeNode root = reConstructBinaryTree2(in,last);
        List<TreeNode> list1 = preIterator(root);
        for(TreeNode node : list1){
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
