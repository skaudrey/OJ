package poj;

/**
 * Runnable ʵ���߳�
 * **/
class Runnable1  implements Runnable {  
	  
    public void run() {  
        // TODO Auto-generated method stub  
        for (int i = 1; i <= 5; i++) {  
            System.out.println("ʵ��Runnable�ӿڵ��߳�----->"+i);  
        }  
    }  
   }
/**
 * extends Threadʵ���߳�
 * **/
class Thread2 extends Thread{  
    public void run() {  
        for (int i = 0; i < 100; i++) {  
            System.out.println("Thread-----:"+i);  
        }  
    } 
 } 


/**
 * * �߳�ͬ�����⣺ʹ��synchronized�ؼ���
 * * **/
class ThreadA extends Thread{  
    @Override  
    public void run(){  
        for(int i=0;i<100;i++){  
            account.add();  
            try {  
                sleep(10);//ģ������ϵͳ����ʱ��  
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
                sleep(10);//ģ������ϵͳ����ʱ��
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class account {  
    public static int count=1000;  
      
    //��ȥ100Ԫ  
    public static synchronized void remove(){  
        count=count-100;  
        System.out.println("��ȥ100Ԫ,�������"+count);  
    }  
      
    //����100Ԫ  
    public static synchronized void add(){  
        count=count+100;  
        System.out.println("����100Ԫ,�������"+count);  
    }  
}  


/**
 * �߳���صĴ���
 * **/
public class MyThread  {
	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * �̳���Thread���߳�ʵ��
		 * **/
//		Thread2 t = new Thread2();
//		//t.run(); //����Ҳ����ֱ�ӵ��÷���
//		t.start(); //startΪ׼���̣߳�run��ʼִ�У���ֱ�ӵ���run�޷� ����µ��̵߳Ľ�����ֻ�������ڶ�������˷���
//		for (int i = 0; i < 100; i++) {
//			System.out.println("main:"+i);
//			}
//		
//		/**
//		 * �̳���Runnable���߳�ʵ��
//		 * **/
//		
//		 Runnable1 r =new Runnable1();  
//	     Thread t1=new Thread(r);  
//	     t1.start();
	     
	     /**
	      * * �߳�ͬ�����⣺ʹ��synchronized�ؼ���
	      * * **/
	     ThreadA  t2=new ThreadA();  
	        t2.start();  
	        ThreadB t3 = new ThreadB();
	        t3.start();  
		}


	}
