/**
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 * <p>
 * 示例:
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */


import java.util.ArrayList;
import java.util.List;

public class preOrderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
