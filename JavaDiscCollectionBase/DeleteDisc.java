package org.discbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDisc {
    public void DiscDelete() {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер диска, который хотите удалить: ");
        int iddiscs = scanner.nextInt();
        try {
            Connection connection = databaseHandler.getDbConnection();
            String deleteQuery = "DELETE FROM discs WHERE iddiscs = " + iddiscs + "";
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(deleteQuery);

            System.out.println("Строка с диском успешно удалена.");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
