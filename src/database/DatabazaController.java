package database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.Random;

public class DatabazaController {
    @FXML
    TextField meno;
    @FXML
    TextField priezvisko;
    @FXML
    TextField vek;
    @FXML
    TextArea vysledok;
    private String url = " jdbc:h2:tcp://localhost/C:\\Program Files\\skola\\H2";
    private String name = "dtb";
    private String heslo = "123";


    @FXML
    public void save() {
        System.out.println("save ");

        String meno = this.meno.getText();
        String priezvisko = this.priezvisko.getText();
        String vek = this.vek.getText();
        Integer cislo = Integer.parseInt(vek);
        try {
            Connection pripojenie = DriverManager.getConnection(url, name, heslo);

            Statement spojenie = pripojenie.createStatement();

            String sqlinsert = "INSERT INTO POKUS VALUES (" + generator() + ", '" + meno + "','" + priezvisko + "'," + vek + ");";

            boolean test = spojenie.execute(sqlinsert);

            System.out.println(sqlinsert);
            vysledok.setText(sqlinsert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private int generator() {
        Random random = new Random();
        return (random.nextInt(500));
    }


    public void load() {
        try {
            String select="SELECT * FROM POKUS";

            Connection pripojenie = DriverManager.getConnection(url, name, heslo);

            Statement spojenie = pripojenie.createStatement();
            ResultSet odpoved = spojenie.executeQuery(select);
            while (odpoved.next()){
                String meno =odpoved.getString("meno");
                System.out.println(meno);
                vysledok.setText(meno);
                String priezvisko = odpoved.getString("priezvisko");
                System.out.println(priezvisko);
                vysledok.setText(priezvisko);
                int vek = odpoved.getInt("vek");
                System.out.println(vek);
                vysledok.setText(String.valueOf(vek));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}