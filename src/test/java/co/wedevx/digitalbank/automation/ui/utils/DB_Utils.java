package co.wedevx.digitalbank.automation.ui.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_Utils {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    //method to establish connection with the db
    public static void establishConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    ConfigReader.getPropertiesValue("digitalbank.db.url"),
                    ConfigReader.getPropertiesValue("digitalbank.db.username"),
                    ConfigReader.getPropertiesValue("digitalbank.db.password"));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //a method that can dynamically send select statements and returns a list of map of all column

    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery) {
        List<Map<String, Object>> dbResultList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            //getMetaData() - returns info about your info.
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            while(resultSet.next()) {
                Map<String, Object> rowMap = new HashMap<>();

                for (int column = 1; column <= columnCount; column++) {
                    rowMap.put(resultSetMetaData.getColumnName(column), resultSet.getObject(column));
                }
                dbResultList.add(rowMap);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return dbResultList;
    }


    //create a method that inserts into db
    //return the number of rows updated or 0 when action is not taken

    //delete or truncate the table

    public static int runSQLUpdateQuery(String sqlQuery) {
        int rowsAffected = 0;

        try {
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rowsAffected;
    }

    //close connection

    public static void closeConnection() {
        try {

            if(resultSet != null) {
                resultSet.close();
            }

            if(statement != null) {
                statement.close();
            }

            if(connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
