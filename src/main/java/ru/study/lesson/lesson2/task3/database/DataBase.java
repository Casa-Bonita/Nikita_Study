package ru.study.lesson.lesson2.task3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private DataBase(){

    }

    private static Connection connection = null;

    public static Connection initConnection(){
        if(connection == null){
            try{
                String url = "jdbc:sqlite:C:/sqlite/BotDataBase.db";
                connection = DriverManager.getConnection(url);
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

}
