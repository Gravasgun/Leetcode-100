/**
 * 94.给定一个二叉树的根节点 root ，返回它的中序遍历 。
 * <p>
 * 示例:
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class inorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        //res用来保存结果
        List<Integer> res = new ArrayList<>();
        //中序遍历函数
        inorder(root, res);
        //返回res
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        //递归终止条件
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}


