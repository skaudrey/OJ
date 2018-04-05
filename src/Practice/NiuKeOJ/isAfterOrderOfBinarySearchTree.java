package Practice.NiuKeOJ;

/**
 * isAfterOrderOfBinarySearchTree
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * 题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

额，才发现二叉搜索树就是二叉排序树就是二叉查找树

链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd
来源：牛客网

BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，
后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。

由于二叉搜索树的性质，根节点的左子树所有值小于根节点的值，右子树大于根节点，那么，
我们只需要将序列分为左子树(leftTree)和右子树(rightTree)，
然后将左子树(leftTree)再分为左子树(left_leftTree)和右子树(left_rightTree)，
右子树(rightTree)分为左子树(left_rightTree)和右子树(right_rightTree)，依次根据二叉搜索树的性质，
进行判断，直到没有节点或者不满足性质则停止。
 */
public class isAfterOrderOfBinarySearchTree {

    public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            int nLen = sequence.length;
            if(nLen==0)
                return false;
            if(nLen == 1)
                return true;
            return judge(sequence, 0 , nLen-1);
        }

        public boolean judge(int[] A, int nLeft, int nRight){
            if(nLeft>=nRight)
                return true;

            int i = nRight-1;
            int nRoot = A[nRight];

            while(i>nLeft && A[i]>nRoot)    //要是写>=会报错
                --i;
            for(int j = i-1; j>=nLeft; j--){    //这里是j=i-1,不然会报错
                if(A[j]>nRoot)
                    return false;
            }

            return judge(A,nLeft,i-1) && judge(A, i+1, nRight-1);//有人的AC用的judge(A, i, nRight-1)，我觉的i+1比较合适

        }
    }

}
