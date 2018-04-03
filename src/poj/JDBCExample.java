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
	 * java 原生JDBC操作数据库
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
            //1、加载数据库驱动，包名一般为域名反写  
            Class.forName("com.mysql.jdbc.Driver");  
            Properties info = new Properties();  
            info.put("user", "root");  
            info.put("password", "root");  
            info.put("useUnicode","true");  
            info.put("charactorEncoding","utf8");  
            /* 
             * 2、获取数据连接对象，DriverManager.getConnection方法有3个重载方法 
             */  
//          Connection conn1 = DriverManager.getConnection(url3, user, password);//将连接的用户名、密码放到方法参数中  
//          Connection conn2 = DriverManager.getConnection(url2,info);//将连接的属性键值对放在Properties对象中  
            conn3 = DriverManager.getConnection(url1);//将所有连接信息都放在URL中  
            /* 
             * 3、根据SQL获取sql会话对象，有2种方式 Statement、PreparedStatement 
             *      1、 PreparedStatement接口继承Statement， PreparedStatement 实例包含已编译的 SQL 语句，所以其执行速度要快于 Statement 对象。 
             *      2、作为 Statement 的子类，PreparedStatement 继承了 Statement 的所有功能。三种方法  execute、 executeQuery 和 executeUpdate 已被更改以使之不再需要参数 
             *      3、在JDBC应用中,如果你已经是稍有水平开发者,你就应该始终以PreparedStatement代替 Statement.也就是说,在任何时候都不要使用Statement. 
             *          一.代码的可读性和可维护性.Statement需要不断地拼接，而PreparedStatement不会。 
             *          二.PreparedStatement尽最大可能提高性能.DB有缓存机制，相同的预编译语句再次被调用不会再次需要编译。 
             *          三.最重要的一点是极大地提高了安全性.Statement容易被SQL注入，而PreparedStatementc传入的内容不会和sql语句发生任何匹配关系。 
             * 最常用的api 
             * addBatch()/addBatch(String sql) 预编译SQL语句,只编译一回哦,效率高啊。剥瓜子，一个一个剥，最后一口吃。 
             * setXXX(parameterIndex,value) 设置指定参数的值。 
             * execute()  执行 SQL 语句，该语句可以是任何种类的 SQL 语句。 
             * executeQuery() 执行查询语句返回ResultSet 
             * executeUpdate() 执行增删改，返回影响的行数。 
             *  
             */  
            String sql_other = "TRUNCATE TABLE t_user_info";  
            String sql_insert = "insert into t_user_info(id,user,sex,age) value(null,?,?,?)";  
            String sql_query = "select * from t_user_info where id < ?";  
            conn3.setAutoCommit(false);//关闭自动提交  
            PreparedStatement preparedStatement_other = conn3.prepareStatement(sql_other);  
            PreparedStatement preparedStatement_insert = conn3.prepareStatement(sql_insert);  
            PreparedStatement preparedStatement_query = conn3.prepareStatement(sql_query);  
            preparedStatement_other.execute();  
              
              
            for(int i=0;i<100;i++){  
                preparedStatement_insert.setString(1, "user_"+i);  
                preparedStatement_insert.setString(2, "n");  
                preparedStatement_insert.setInt(3, i);  
                if(i>50){  
//                  preparedStatement_insert.setString(3, "我是错误的尝试");  
                }  
                preparedStatement_insert.addBatch();  
            }  
            //一次性插入100条记录，如果中间有出错，那么这一次性的插入都不会成功  
            int[] updateInt = preparedStatement_insert.executeBatch();  
            conn3.commit();  
            point1 = conn3.setSavepoint("point1");  
            System.out.println(updateInt.length);  
              
            preparedStatement_query.setInt(1, 50);  
            //4、执行SQL语句，查询语句就获取结果集  
            ResultSet result = preparedStatement_query.executeQuery();  
            while(result.next()){  
                int a = result.getInt("id");  
                int b = result.getInt(1);  
                System.out.println("第一列值，通过列名:"+a+",通过下标："+b);  
                  
            }  
            /* 
             * 5、关闭结果集、关闭会话、关闭连接 
             */  
            result.close();  
            preparedStatement_other.close();  
            preparedStatement_insert.close();  
            preparedStatement_query.close();  
            conn3.close();  
              
        } catch (ClassNotFoundException e) {  
            System.out.println("驱动没有加载到。。。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            System.out.println("出现sql异常。。。");  
            try {  
                conn3.rollback(point1);;  
            } catch (SQLException e1) {  
                  
                e1.printStackTrace();  
            }  
            e.printStackTrace();  
        }  
	}
	
	
}
