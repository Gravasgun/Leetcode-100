import java.util.ArrayList;
import java.util.List;

/**
 *  给你二叉树的根节点 root ，返回它节点值的后序遍历。
 *  示例:
 *  输入：root = [1,null,2,3]
 *  输出：[3，2，1]
 */
public class postOrderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        postorder(root.left, res);
        postorder(root.right, res);
    }
}
