package Dao;

import KNN.KNNnode;
import DB.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Dao {

    public List<KNNnode> getInfo(){
        List<KNNnode> node=new ArrayList<KNNnode>();
        Connection connection= DB.getConnectDB();
        PreparedStatement stm=null;
        String sql="select * from data";
        ResultSet rs=null;
        int i=0;

        try{
            stm=connection.prepareStatement(sql);
            rs=stm.executeQuery();
            while (rs.next()){
                KNNnode nnode=new KNNnode();
                nnode.setX( rs.getFloat("x"));
                nnode.setY(rs.getFloat("y"));
                nnode.setType(rs.getString("type"));
                node.add(nnode);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DB.CloseDB(rs,stm,connection);
        }

        return node;
    }

    public String getRSSI(){
        Connection connection=DB.getConnectDB();
        PreparedStatement stm=null;
        String sql="select * from paste where num=1";
        ResultSet rs=null;
        String result=null;

        try {
            stm=connection.prepareStatement(sql);
            rs=stm.executeQuery();
            while (rs.next()){

                result=rs.getString("type");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}
