package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class SingletonConnection {
 private static Connection connection;
 private static String jdbcDriver;
 private static String urlDataSource;
 private static String user;
 private static String pwd="";

 private static void init ()  {
     try {
         Scanner scanner = new Scanner(new File("config-db.txt"));
         jdbcDriver = scanner.next().split("=")[1];
         urlDataSource = scanner.next().split("=")[1];
         user = scanner.next().split("=")[1];
     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     }

 }
    //private  static Connection connection;
    static {
        //Chargement du driver
        try {
            init();
            Class.forName(jdbcDriver);
            //
            connection = DriverManager.getConnection(urlDataSource,user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    public static void afficher (){
        init();
        System.out.println(jdbcDriver);
        System.out.println(urlDataSource);
        System.out.println(user);
    }

    public static void setConnection(Connection connection) {
        SingletonConnection.connection = connection;
    }
}
