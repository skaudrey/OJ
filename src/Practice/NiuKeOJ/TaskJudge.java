package Practice.NiuKeOJ;

import java.util.Scanner;

/**
 * TaskJudge
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *
 * 游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。
 * 请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。
 * 输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。
 * 输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。
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
