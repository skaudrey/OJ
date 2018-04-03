package Practice.NiuKeOJ;

/**
 * AdvancedJumpFloor
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��Ŀ����
һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������

 �ţ����װ��ˣ�ȫ��ѹһ��ջ�����᲻���ڴ汬����������һ�°�

 ����Ŷ��ֻ���Ƶ����㹫ʽ��ʱ�򣬲�ֻ��f(n-1) + ... + f(1),���Ҫ����1����ΪҪ���ǵ����ܻ�����ֱ����n��
 */
public class AdvancedJumpFloor {

    public class Solution {
        public int JumpFloorII(int target) {
            if(target <= 0)
                return -1;
            if(target == 1)
                return 1;
            if(target == 2)
                return 2;

            int nResult = 0;

            for(int i = target-1; i>=1; i--){
                nResult += JumpFloorII(i);
            }

            return nResult+1;
        }
    }
}
