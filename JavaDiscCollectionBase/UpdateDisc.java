package org.discbase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDisc {
    public void DiscUpdate() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id диска, который хотите изменить: ");
        int id = scanner.nextInt();

        System.out.println("Введите имя столбца, который хотите изменить: ");
        String column_name = scanner.next();

        System.out.println("Введите новое значение: ");
        String new_value = scanner.next();

        try {
            Connection connection = databaseHandler.getDbConnection();
            String query = "UPDATE discs SET " + column_name + " = '" + new_value + "' WHERE iddiscs = '" + id + "'";
            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
