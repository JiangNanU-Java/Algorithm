package src.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    public static void main(String[] args) {
        // 创建一个二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 前序遍历二叉树
        System.out.println("前序遍历结果：");
        preOrder(root);

        // 中序遍历二叉树
        System.out.println("\n中序遍历结果：");
        inOrder(root);

        // 后序遍历二叉树
        System.out.println("\n后序遍历结果：");
        postOrder(root);

        // 层级遍历二叉树
        System.out.println("\n层级遍历结果：");
        levelOrder(root);
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);

        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        System.out.println(node.val);

        inOrder(node.right);
    }

    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.println(node.val);
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        System.out.println();
    }
}
