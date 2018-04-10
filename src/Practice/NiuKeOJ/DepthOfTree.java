package Practice.NiuKeOJ;

/**
 * DepthOfTree
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * ��ָoffer
 *
 * ��Ŀ����
����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�

 DFS
 �ݹ飬�˼ҵķ������Ǻ�����ġ����������depth������һ���ڵݹ�ʱ�Ǵ���ȥ��

 */
public class DepthOfTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode root) {
        return depth(root,0);
    }

    public int depth(TreeNode root, int nD){
        if(root == null)
            return nD;
        nD++;

        return Math.max(depth(root.left,nD),depth(root.right,nD));
    }

}
