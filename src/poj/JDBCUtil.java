package poj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��װ��JDBCUtil�У�ԭ��������JDBCExample���е�jdbcRawJava����
 * **/
public class JDBCUtil {  
    /** 
     * jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ 
     * String url = "jdbc:mysql://localhost:3306/JAVA?user=root&password=root&useUnicode=true&characterEncoding=UTF8"; 
     * Ҳ���ڻ�ȡ���ӵ�ʱ��ʹ���û��������� 
     * ������������Ҫָ��useUnicode��characterEncoding, ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ����� 
     */  
    private static final String url="jdbc:mysql://localhost:3306/JAVA";  
    private static final String user="root";  
    private static final String password="root";  
    private static Connection conn;  
    //��̬����飬�����ʱ�ͼ�������  
    static {  
        //1����������  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {  
            System.out.println("Exception: com.mysql.jdbc.driver not found Exception");  
            e.printStackTrace();  
        }  
    }  
    private JDBCUtil(){  
          
    }  
    //2��ȡ���ӵķ�����ֻ����һ������  
    public static Connection getConnection(){  
        try {  
            if(conn==null){  
                synchronized (JDBCUtil.class) {  
                    if(conn==null){  
                        conn = DriverManager.getConnection(url, user, password);  
                    }  
                }  
            }  
        } catch (SQLException e) {  
            System.out.println("Exception: get mysql connection Exception");  
            e.printStackTrace();  
        }  
        return conn;  
    }  
    //����ͷ���Դ���м������preparedStatement ȥ���������  
    public static void free(ResultSet result,Statement statement,Connection connection){  
        try {  
            if(result!=null){//�رս����  
                result.close();  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                if(statement!=null){//�ر�statement�Ự  
                    statement.close();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }finally{  
                try {  
                    if(connection!=null){  
                        connection.close();//�ر�����  
                    }  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
              
        }  
          
    }  
    
    public static void main(String[] args) {  
        //1��������������ȡ����  
        Connection connection = JDBCUtil.getConnection();  
        String sql_init ="TRUNCATE TABLE t_user_info";  
        String sql_insert = "insert into t_user_info(id,user,sex,age) value(null,?,?,?)";  
        String sql_query = "select * from t_user_info where id < ?";  
        PreparedStatement ps_init;  
        PreparedStatement ps_insert;  
        PreparedStatement ps_query;  
        try {  
            connection.setAutoCommit(false);  
            //2������sql����ȡ ��ȡԤ����������  
            ps_init = connection.prepareStatement(sql_init);  
            ps_insert = connection.prepareStatement(sql_insert);  
            ps_query = connection.prepareStatement(sql_query);  
              
            ps_init.execute();//����ִ���κ������SQL���  
            //3���в���ֵ�������ò���ֵ��Ȼ��ִ��Ԥ������䣬��ȡ�����  
            for(int i=0;i<100;i++){  
                ps_insert.setString(1, "user_"+i);  
                ps_insert.setString(2, "n");  
                ps_insert.setInt(3, i);  
                ps_insert.addBatch();//���ӵ������������  
            }  
            ps_insert.executeBatch();//һ����ִ��  
              
            ps_query.setInt(1, 50);  
            //��ѯ��¼����ȡ�����  
            ResultSet result = ps_query.executeQuery();  
            while(result.next()){  
                int a = result.getInt("id");  
                int b = result.getInt(1);  
                System.out.println("��һ��ͨ������:"+a+",��һ��ͨ��index:"+b);  
            }  
            connection.commit();  
            //5���ͷ���Դ  
            JDBCUtil.free(result, ps_query, connection);  
            JDBCUtil.free(result, ps_init, connection);  
            JDBCUtil.free(result, ps_insert, connection);  
        } catch (SQLException e) {  
            try {  
                connection.rollback();  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }  
            e.printStackTrace();  
        }  
          
    }  
}  
