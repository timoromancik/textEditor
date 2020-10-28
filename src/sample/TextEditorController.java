package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextEditorController {

    @FXML
    TextArea myTextFile;

    @FXML
    public void save(){
        String text = myTextFile.getText();
        writer1.write(text);

    }

    public void initialize(){
        String strBuffer;
        String vystup = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dokument"));
            while ((strBuffer= bufferedReader.readLine()) !=null){
                //System.out.println(strBuffer);
                // myTextFile.setText(strBuffer);
                vystup= vystup + strBuffer + "\n";

            }
            bufferedReader.close();
            myTextFile.setText(vystup);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void test(){

    }
}