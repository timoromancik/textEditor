package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MojaDb {


    public static void main(String[] args) {

        try {
            String url = "jdbc:h2:tcp://localhost/C:\\Program Files\\skola\\H2";
            String meno = "dtb";
            String heslo = "123";
            Connection spojenie = DriverManager.getConnection(url, meno, heslo);

            Statement statement = spojenie.createStatement();

            /* String sql = "CREATE TABLE  POKUS " +
                    " (id INTEGER not NULL, " +
                    " meno VARCHAR(255), " +
                    " priezvisko VARCHAR(255), " +
                    " vek INTEGER, " +
                    " PRIMARY KEY ( id ))";

            statement.execute(sql);
            System.out.println("tabulka vytvorena"); */

            String sqlinsert = "INSERT INTO POKUS VALUES (150, 'Timo', 'Romancik', 18)";
            statement.execute(sqlinsert);
            System.out.println("data vlozene");
            spojenie.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}