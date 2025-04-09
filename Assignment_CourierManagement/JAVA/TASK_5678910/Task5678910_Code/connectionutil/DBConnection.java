package connectionutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DBConnection {

         private static Connection connection;

    //The constructor is created as private inorder to prevent instantiation
         private DBConnection(){};

        //Static method which returns connection
        //To get connecction properties load from properties file
        public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

            FileInputStream fis=new FileInputStream("C:\\Users\\ramya\\IdeaProjects\\CourierManagement_OOps\\Assignment_OOPs_Exception_JDBC\\connectionutil\\db.properties");
            Properties properties=new Properties();
            properties.load(fis);
            String driver = properties.getProperty("db.driver");
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url, username, password);
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
            return connection;

        }

}
