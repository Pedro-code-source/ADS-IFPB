package br.edu.ifpb.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String url = "jdbc:postgresql://ep-plain-scene-acy2osyk-pooler.sa-east-1.aws.neon.tech/neondb";
    private static final String user = "neondb_owner";
    private static final String password = "npg_sDYE5m8IgwLt";

    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
