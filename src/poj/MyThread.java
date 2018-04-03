package poj;

/**
 * Runnable 实现线程
 * **/
class Runnable1  implements Runnable {  
	  
    public void run() {  
        // TODO Auto-generated method stub  
        for (int i = 1; i <= 5; i++) {  
            System.out.println("实现Runnable接口的线程----->"+i);  
        }  
    }  
   }
/**
 * extends Thread实现线程
 * **/
class Thread2 extends Thread{  
    public void run() {  
        for (int i = 0; i < 100; i++) {  
            System.out.println("Thread-----:"+i);  
        }  
    } 
 } 


/**
 * * 线程同步问题：使用synchronized关键字
 * * **/
class ThreadA extends Thread{  
    @Override  
    public void run(){  
        for(int i=0;i<100;i++){  
            account.add();  
            try {  
                sleep(10);//模拟银行系统处理时间  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class ThreadB extends Thread{  
    @Override  
    public void run() {  
        for(int i=0;i<100;i++){  
            account.remove();  
            try {  
                sleep(10);//模拟银行系统处理时间
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class account {  
    public static int count=1000;  
      
    //减去100元  
    public static synchronized void remove(){  
        count=count-100;  
        System.out.println("减去100元,卡内余额"+count);  
    }  
      
    //增加100元  
    public static synchronized void add(){  
        count=count+100;  
        System.out.println("加上100元,卡内余额"+count);  
    }  
}  


/**
 * 线程相关的代码
 * **/
public class MyThread  {
	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * 继承自Thread的线程实现
		 * **/
//		Thread2 t = new Thread2();
//		//t.run(); //这里也不能直接调用方法
//		t.start(); //start为准备线程，run开始执行；若直接调用run无法 完成新的线程的建立，只是类似于对象调用了方法
//		for (int i = 0; i < 100; i++) {
//			System.out.println("main:"+i);
//			}
//		
//		/**
//		 * 继承自Runnable的线程实现
//		 * **/
//		
//		 Runnable1 r =new Runnable1();  
//	     Thread t1=new Thread(r);  
//	     t1.start();
	     
	     /**
	      * * 线程同步问题：使用synchronized关键字
	      * * **/
	     ThreadA  t2=new ThreadA();  
	        t2.start();  
	        ThreadB t3 = new ThreadB();
	        t3.start();  
		}


	}
