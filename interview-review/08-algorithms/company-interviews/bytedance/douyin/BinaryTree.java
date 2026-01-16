package bytedance.douyin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树非递归遍历
 * DSF
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.init();
        List<Integer> postList = binaryTree.inOrderStack(root);    //后序遍历  迭代
        System.out.println(postList);        //结果：[4, 5, 2, 6, 7, 3, 1]
    }

    /**
     * <pre>
     *    1
     *  2   3
     * 4 5 6 7
     * </pre>
     */
    public TreeNode init() {            //测试数据
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        return node1;
    }

    public List<Integer> inOrderStack(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                results.add(root.val);
                root = root.right;
            }
        }

        return results;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}