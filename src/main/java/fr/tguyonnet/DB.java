package fr.tguyonnet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public final class DB {
    private static Connection connection;

    static {
        // créer connection
        try {
            // On récup le context.xml
            Context context = new InitialContext();
            // On lit les données
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pokemon");

            connection = DriverManager.getConnection(String.valueOf(ds));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
