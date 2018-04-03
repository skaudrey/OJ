package poj;

/**
 * 一般的try-catch-finally流程
 * **/
public class TryCatchBlock {
	private static int getInt() {  
	    // TODO Auto-generated method stub  
	    try {  
	        return 0;  
	    } catch (Exception e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }finally{  
	        System.out.println("I'm the final block ");
	        
	    }
	    return 0;  
	 }
	
	public static void main(String[] args) {  
	    int i=getInt();  
	    System.out.println(i);  
	}  
}
