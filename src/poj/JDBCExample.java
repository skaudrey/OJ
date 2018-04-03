package poj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;


public class JDBCExample {
	
	/**
	 * java ԭ��JDBC�������ݿ�
	 * **/
	
	public void jdbcRawJava(){
		String url1="jdbc:mysql://localhost:3306/JAVA?user=root&password=root&useUnicode=true&charactorEncoding=UTF8";  
        String url2="jdbc:mysql://localhost:3306/JAVA?useUnicode=true&charactorEncoding=UTF8";  
        String url3="jdbc:mysql://localhost:3306/JAVA";  
        String user="root";  
        String password="root";  
        Connection conn3 = null;  
        Savepoint point1 = null;  
          
        try {  
            //1���������ݿ�����������һ��Ϊ������д  
            Class.forName("com.mysql.jdbc.Driver");  
            Properties info = new Properties();  
            info.put("user", "root");  
            info.put("password", "root");  
            info.put("useUnicode","true");  
            info.put("charactorEncoding","utf8");  
            /* 
             * 2����ȡ�������Ӷ���DriverManager.getConnection������3�����ط��� 
             */  
//          Connection conn1 = DriverManager.getConnection(url3, user, password);//�����ӵ��û���������ŵ�����������  
//          Connection conn2 = DriverManager.getConnection(url2,info);//�����ӵ����Լ�ֵ�Է���Properties������  
            conn3 = DriverManager.getConnection(url1);//������������Ϣ������URL��  
            /* 
             * 3������SQL��ȡsql�Ự������2�ַ�ʽ Statement��PreparedStatement 
             *      1�� PreparedStatement�ӿڼ̳�Statement�� PreparedStatement ʵ�������ѱ���� SQL ��䣬������ִ���ٶ�Ҫ���� Statement ���� 
             *      2����Ϊ Statement �����࣬PreparedStatement �̳��� Statement �����й��ܡ����ַ���  execute�� executeQuery �� executeUpdate �ѱ�������ʹ֮������Ҫ���� 
             *      3����JDBCӦ����,������Ѿ�������ˮƽ������,���Ӧ��ʼ����PreparedStatement���� Statement.Ҳ����˵,���κ�ʱ�򶼲�Ҫʹ��Statement. 
             *          һ.����Ŀɶ��ԺͿ�ά����.Statement��Ҫ���ϵ�ƴ�ӣ���PreparedStatement���ᡣ 
             *          ��.PreparedStatement���������������.DB�л�����ƣ���ͬ��Ԥ��������ٴα����ò����ٴ���Ҫ���롣 
             *          ��.����Ҫ��һ���Ǽ��������˰�ȫ��.Statement���ױ�SQLע�룬��PreparedStatementc��������ݲ����sql��䷢���κ�ƥ���ϵ�� 
             * ��õ�api 
             * addBatch()/addBatch(String sql) Ԥ����SQL���,ֻ����һ��Ŷ,Ч�ʸ߰��������ӣ�һ��һ���������һ�ڳԡ� 
             * setXXX(parameterIndex,value) ����ָ��������ֵ�� 
             * execute()  ִ�� SQL ��䣬�����������κ������ SQL ��䡣 
             * executeQuery() ִ�в�ѯ��䷵��ResultSet 
             * executeUpdate() ִ����ɾ�ģ�����Ӱ��������� 
             *  
             */  
            String sql_other = "TRUNCATE TABLE t_user_info";  
            String sql_insert = "insert into t_user_info(id,user,sex,age) value(null,?,?,?)";  
            String sql_query = "select * from t_user_info where id < ?";  
            conn3.setAutoCommit(false);//�ر��Զ��ύ  
            PreparedStatement preparedStatement_other = conn3.prepareStatement(sql_other);  
            PreparedStatement preparedStatement_insert = conn3.prepareStatement(sql_insert);  
            PreparedStatement preparedStatement_query = conn3.prepareStatement(sql_query);  
            preparedStatement_other.execute();  
              
              
            for(int i=0;i<100;i++){  
                preparedStatement_insert.setString(1, "user_"+i);  
                preparedStatement_insert.setString(2, "n");  
                preparedStatement_insert.setInt(3, i);  
                if(i>50){  
//                  preparedStatement_insert.setString(3, "���Ǵ���ĳ���");  
                }  
                preparedStatement_insert.addBatch();  
            }  
            //һ���Բ���100����¼������м��г�����ô��һ���ԵĲ��붼����ɹ�  
            int[] updateInt = preparedStatement_insert.executeBatch();  
            conn3.commit();  
            point1 = conn3.setSavepoint("point1");  
            System.out.println(updateInt.length);  
              
            preparedStatement_query.setInt(1, 50);  
            //4��ִ��SQL��䣬��ѯ���ͻ�ȡ�����  
            ResultSet result = preparedStatement_query.executeQuery();  
            while(result.next()){  
                int a = result.getInt("id");  
                int b = result.getInt(1);  
                System.out.println("��һ��ֵ��ͨ������:"+a+",ͨ���±꣺"+b);  
                  
            }  
            /* 
             * 5���رս�������رջỰ���ر����� 
             */  
            result.close();  
            preparedStatement_other.close();  
            preparedStatement_insert.close();  
            preparedStatement_query.close();  
            conn3.close();  
              
        } catch (ClassNotFoundException e) {  
            System.out.println("����û�м��ص�������");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            System.out.println("����sql�쳣������");  
            try {  
                conn3.rollback(point1);;  
            } catch (SQLException e1) {  
                  
                e1.printStackTrace();  
            }  
            e.printStackTrace();  
        }  
	}
	
	
}
