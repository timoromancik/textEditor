package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;

public class TextEditorController {

    @FXML
    TextArea myTextFile;

    @FXML
    public void save() {

        String strWriter;
        try {
            BufferedWriter bufferedWriter02 = new BufferedWriter(new FileWriter("dokument", true));
            strWriter = myTextFile.getText();
              System.out.println(strWriter);
            bufferedWriter02.write(strWriter);
            bufferedWriter02.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){

        String strBuffer;
        String vystup = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dokument"));
            while ((strBuffer = bufferedReader.readLine()) != null)
            {
                // System.out.println(strBuffer);
                // myTextFile.setText(strBuffer);
                vystup = vystup + strBuffer + "\n";
            }
            myTextFile.setText(vystup);
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}