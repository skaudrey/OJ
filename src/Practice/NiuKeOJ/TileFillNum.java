package Practice.NiuKeOJ;

/**
 * TileFillNum
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��ָoffer
 *
 * ��Ŀ����
���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����

 �ðɣ���Ȼ���ǷƲ���������

 ������㷽�����Ե�

 �������Կ�������

https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6
 */
public class TileFillNum {

    public class Solution {
        public int RectCover(int target) {
            if(target < 1)
                return 0;
            if(target == 1)
                return 1;
            if(target == 2)
                return 2;

            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
