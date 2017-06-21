/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.labournet.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PUDING
 */
public class taxDao {

    private Connection connection;
    private Statement statement;

    public void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/telkomdbase", "ThusoPuding", "thusop2121");
        statement = (Statement) connection.createStatement();

    }
    
    

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

}
