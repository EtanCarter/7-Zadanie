package org.discbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+ dbaseHost + ":"
                + dbasePort + "/" + dbaseName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbaseUser, dbasePass);

        return dbConnection;

    }

    public void AddDiscForDb(Disc disc) {
        String insert = "INSERT INTO "+ Constant.DISCS_TABLE + "(" + Constant.DISCS_TYPE + ","
                + Constant.DISCS_CATEGORY+ ","
                + Constant.DISCS_NAME + ","+ Constant.DISCS_DESCRIPTION + ")" + "VALUES (?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, disc.getDiscType());
            prSt.setString(2, disc.getDiscCategory());
            prSt.setString(3, disc.getDiscName());
            prSt.setString(4, disc.getDescription());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
