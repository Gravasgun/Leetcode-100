/**
 * 617.合并二叉树
 * 给你两棵二叉树： root1和 root2。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 */
class mergeTreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    mergeTreeNode() {
    }

    mergeTreeNode(int val) {
        this.val = val;
    }

    mergeTreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class mergeTrees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果root1为空，直接返回root2
        if (root1 == null) {
            return root2;
        }
        //如果root2为空，直接返回root1
        if (root2 == null) {
            return root1;
        }
        //都不为空，值相加
        root1.val += root2.val;
        //递归，覆盖root1这棵树
        root1.left = mergeTrees(root1.left, root2.left);
        //递归结束，直接返回root1
        return root1;
    }
}
