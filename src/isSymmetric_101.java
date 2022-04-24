/**
 * 101.对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
class binaryTreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    binaryTreeNode() {
    }

    binaryTreeNode(int val) {
        this.val = val;
    }

    binaryTreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class isSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 递归函数:
     * 通过「同步移动」两个指针的方法来遍历这棵树，p指针和q指针一开始都指向这棵树的根，
     * 随后 p右移时，q左移，p左移时，q右移。
     * 每次检查当前p和q节点的值是否相等，如果相等再判断左右子树是否对称。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
