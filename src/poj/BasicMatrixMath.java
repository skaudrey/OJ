package poj;

/**
 * 基本的矩阵运算
 * 判断矩阵能否进行运算
 * 加，减，乘运算
 * **/
public class BasicMatrixMath {
	  public final static int OPERATION_ADD = 1;  
	    public final static int OPERATION_SUB = 2;  
	    public final static int OPERATION_MUL = 4;  
	      
	    /** 
	     * To be able to add two matrices, they must be of the same size 
	     * @param matrixa 
	     * @param matrixb 
	     */  
	    public int[][] add(int[][] matrixa, int[][] matrixb) {  
	        if(legalOperation(matrixa, matrixb, OPERATION_ADD)) {  
	            for(int i=0; i<matrixa.length; i++) {  
	                for(int j=0; j<matrixa[0].length; j++) {  
	                    matrixa[i][j] = matrixa[i][j] + matrixb[i][j];  
	                }  
	            }  
	        }  
	        return matrixa;  
	    }  
	      
	    /** 
	     * To be able to substract two matrices, they must be of the same size 
	     *  
	     * @param matrixa 
	     * @param matrixb 
	     */  
	    public int[][] substract(int[][] matrixa, int[][] matrixb) {  
	        if(legalOperation(matrixa, matrixb, OPERATION_SUB)) {  
	            for(int i=0; i<matrixa.length; i++) {  
	                for(int j=0; j<matrixa[0].length; j++) {  
	                    matrixa[i][j] = matrixa[i][j] - matrixb[i][j];  
	                }  
	            }  
	        }  
	        return matrixa;  
	    }  
	      
	    /** 
	     *  
	     * @param matrixa 
	     * @param matrixb 
	     */  
	    public int[][] multiplication(int[][] matrixa, int[][] matrixb) {  
	        if(legalOperation(matrixa, matrixb, OPERATION_SUB)) {  
	            int[][] result = new int[matrixa.length][matrixb[0].length];  
	            for(int i=0; i<matrixa.length; i++) {  
	                for(int j=0; j<matrixb[0].length; j++) {  
	                    // i will complete this tomorrow @2012/09/17  
	                    result[i][j] = calculateSingleResult(matrixa, matrixb, i, j);   
	                }  
	            }  
	            return result;  
	        }   
	        else  
	        {  
	            return null;  
	        }  
	    }  
	      
	    private int calculateSingleResult(int[][] matrixa, int[][] matrixb, int row, int col) {  
	        int result = 0;  
	        for(int k=0; k<matrixa[0].length; k++) {  
	            result += matrixa[row][k] * matrixb[k][col];  
	        }  
	        return result;  
	    }  
	  
	    /** 
	     *  
	     * @param matrixa 
	     * @param b 
	     */  
	    public int[][] multiplication(int[][] matrixa, int b) {  
	        for(int i=0; i<matrixa.length; i++) {  
	            for(int j=0; j<matrixa[0].length; j++) {  
	                matrixa[i][j] = matrixa[i][j] * b;  
	            }  
	        }  
	        return matrixa;  
	    }  
	      
	    /** 
	     * validate whether the parameters is valid parameters. 
	     *  
	     * @param a 
	     * @param b 
	     * @param type 
	     * @return 
	     */  
	    private boolean legalOperation(int[][] a, int[][] b, int type) {  
	        boolean legal = true;  
	        if(type == OPERATION_ADD || type == OPERATION_SUB)  
	        {  
	            if(a.length != b.length || a[0].length != b[0].length) {  
	                legal = false;  
	            }  
	        }   
	        else if(type == OPERATION_MUL)  
	        {  
	            if(a[0].length != b.length) {  
	                legal = false;  
	            }  
	        }  
	        return legal;  
	    }  
	      
	    /** 
	     *  test code here !!!! 
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	        int[][] a = new int[][]{{1,2},{3,4}};  
	        int[][] b = new int[][]{{7, 8}, {6, 5}};  
	        BasicMatrixMath bmm = new BasicMatrixMath();  
	          
	        System.out.println("addition two matrix");  
	        int[][] result = bmm.add(a, b);  
	        for(int i=0; i<result.length; i++) {  
	            for(int j=0; j<result[0].length; j++) {  
	                System.out.print("\t" + result[i][j]);  
	            }  
	            System.out.println();  
	        }  
	          
	        System.out.println("substract two matrix");  
	        result = bmm.substract(a, b);  
	        for(int i=0; i<result.length; i++) {  
	            for(int j=0; j<result[0].length; j++) {  
	                System.out.print("\t" + result[i][j]);  
	            }  
	            System.out.println();  
	        }  
	          
	        System.out.println("multiplex one matrix");  
	        result = bmm.multiplication(a, 3);  
	        for(int i=0; i<result.length; i++) {  
	            for(int j=0; j<result[0].length; j++) {  
	                System.out.print("\t" + result[i][j]);  
	            }  
	            System.out.println();  
	        }  
	          
	        System.out.println("multiplex two matrix");  
	        result = bmm.multiplication(a, b);  
	        for(int i=0; i<result.length; i++) {  
	            for(int j=0; j<result[0].length; j++) {  
	                System.out.print("\t" + result[i][j]);  
	            }  
	            System.out.println();  
	        }     
	    }  
}
