/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tauhid
 */
public class koneksi {
    
    static Connection con;
    
    public static Connection connection() {
    
        if (con==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("sistempakar");
            data.setUser("root");
            data.setPort(3306);
            data.setPassword("");
            
            try{
            con = data.getConnection();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    
        return con;
    }
}
