package org.discbase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckDisc {
    public void ViewDisc() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        try {
            Connection connection = databaseHandler.getDbConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM discs";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String Type = resultSet.getString("DiscType");
                String Category = resultSet.getString("DiscCategory");
                String Name = resultSet.getString("DiscName");
                String Desc = resultSet.getString("Description");

                System.out.println("Тип: " + Type + " | Категория: " + Category + " | Название: " + Name + " | Описание: " + Desc);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
