package DB;

import java.sql.*;

public class DB {

    private static String url = "jdbc:mysql://127.0.0.1:3306/fingerprint";
    private static String user = "root";
    private static String password= "147896";

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //连接数据库
    public static Connection getConnectDB(){
        Connection connection=null;
        try{
            connection=DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

    //关闭数据库
    public static void CloseDB(ResultSet rs,PreparedStatement stm,Connection connection){
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        if(stm!=null){
            try{
                stm.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try{
                stm.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


}

