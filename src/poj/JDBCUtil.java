package poj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 封装至JDBCUtil中，原生方法见JDBCExample类中的jdbcRawJava方法
 * **/
public class JDBCUtil {  
    /** 
     * jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值 
     * String url = "jdbc:mysql://localhost:3306/JAVA?user=root&password=root&useUnicode=true&characterEncoding=UTF8"; 
     * 也可在获取连接的时候使用用户名和密码 
     * 避免中文乱码要指定useUnicode和characterEncoding, 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定， 
     */  
    private static final String url="jdbc:mysql://localhost:3306/JAVA";  
    private static final String user="root";  
    private static final String password="root";  
    private static Connection conn;  
    //静态代码块，类加载时就加载驱动  
    static {  
        //1、加载驱动  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {  
            System.out.println("Exception: com.mysql.jdbc.driver not found Exception");  
            e.printStackTrace();  
        }  
    }  
    private JDBCUtil(){  
          
    }  
    //2获取连接的方法，只产生一个连接  
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
    //最后释放资源，中间操作由preparedStatement 去操作更灵活  
    public static void free(ResultSet result,Statement statement,Connection connection){  
        try {  
            if(result!=null){//关闭结果集  
                result.close();  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                if(statement!=null){//关闭statement会话  
                    statement.close();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }finally{  
                try {  
                    if(connection!=null){  
                        connection.close();//关闭连接  
                    }  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
              
        }  
          
    }  
    
    public static void main(String[] args) {  
        //1、加载驱动、获取连接  
        Connection connection = JDBCUtil.getConnection();  
        String sql_init ="TRUNCATE TABLE t_user_info";  
        String sql_insert = "insert into t_user_info(id,user,sex,age) value(null,?,?,?)";  
        String sql_query = "select * from t_user_info where id < ?";  
        PreparedStatement ps_init;  
        PreparedStatement ps_insert;  
        PreparedStatement ps_query;  
        try {  
            connection.setAutoCommit(false);  
            //2、根据sql语句获取 获取预编译语句对象  
            ps_init = connection.prepareStatement(sql_init);  
            ps_insert = connection.prepareStatement(sql_insert);  
            ps_query = connection.prepareStatement(sql_query);  
              
            ps_init.execute();//可以执行任何种类的SQL语句  
            //3、有参数值，就设置参数值，然后执行预编译语句，获取结果集  
            for(int i=0;i<100;i++){  
                ps_insert.setString(1, "user_"+i);  
                ps_insert.setString(2, "n");  
                ps_insert.setInt(3, i);  
                ps_insert.addBatch();//增加的批处理队列中  
            }  
            ps_insert.executeBatch();//一次性执行  
              
            ps_query.setInt(1, 50);  
            //查询记录，获取结果集  
            ResultSet result = ps_query.executeQuery();  
            while(result.next()){  
                int a = result.getInt("id");  
                int b = result.getInt(1);  
                System.out.println("第一列通过列明:"+a+",第一列通过index:"+b);  
            }  
            connection.commit();  
            //5、释放资源  
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
