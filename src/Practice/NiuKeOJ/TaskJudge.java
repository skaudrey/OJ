package Practice.NiuKeOJ;

import java.util.Scanner;

/**
 * TaskJudge
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *
 * ��Ϸ�����кܶ��ʽ����������������һ���������ֻ����һ�Σ���������һ����1024��������ID��Χ[1,1024]��
 * ����32��unsigned int��������¼��1024�������Ƿ��Ѿ���ɡ���ʼ״̬����δ��ɡ�
 * ����������������������ID����Ҫ���õ�һ��ID������Ϊ�Ѿ���ɣ������ڶ���ID�������Ƿ��Ѿ���ɡ�
 * ���һ������������ڶ���ID�������Ѿ�������1�����δ������0�������һ��ڶ���ID����[1,1024]��Χ�������-1��
 *
 */
public class TaskJudge {

    private static int[] flags = new int[32];

    public TaskJudge(){
        for(int i=0; i<32; i++){
            flags[i] = 0;
        }
    }

    public void setTaskDone(int nTask){
        flags[nTask%32] = 1;
    }

    public int isDone(int nTask){

        if(nTask<1 || nTask >1024)
            return -1;

        else if(flags[nTask%32]==1)
            return 1;

        return 0;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nTaskDone = sc.nextInt();
        int nTaskJudge = sc.nextInt();

        TaskJudge solver = new TaskJudge();

        solver.setTaskDone(nTaskDone);

        System.out.println(solver.isDone(nTaskDone));
    }

}
