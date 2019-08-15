package offer66;

/**
 * 二叉树中序遍历的下一个值
 */
public class A57 {

    static TreeLinkNode GetNext(TreeLinkNode node)
    {
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //初始化二叉树
    public static TreeLinkNode initTreeNode(int[] array){
        return createBinaryTreeByArray(array, 0);
    }
    private static TreeLinkNode createBinaryTreeByArray(int[] array, int index) {
        TreeLinkNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeLinkNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        TreeLinkNode root = initTreeNode(array);
        TreeLinkNode next = GetNext(root.left);//任意给定一个数值
        System.out.println(next.val);
    }
}
