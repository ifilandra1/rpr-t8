package ba.unsa.etf.rpr.tutorijal08;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;


public class Controller {

public TextField unosField;
public SimpleStringProperty unos;
public Button traziBtn;
public ListView<String> lista;
public Button stopBtn;

    public ObservableList<String> datoteke;

    public Controller() {
    unosField= new TextField();
    unos=new SimpleStringProperty("");
    datoteke= FXCollections.observableArrayList();
}

    public void initialize() {
unosField.textProperty().bindBidirectional(unos);
stopBtn.setDisable(true);

}


    public void traziAction(ActionEvent actionEvent) {
        stopBtn.setDisable(false);
        traziBtn.setDisable(true);
    File file = new File("C:\\Users\\User\\");

        new Thread(() -> {
            try {
                pretraga(file);
            }
            catch(Exception e){

            }

        }).start();



    lista.setItems(datoteke);
    }
    void pretraga(File file) {


        if(file.isFile()) {

            String s = file.getName();
           if(s.contains(unos.get() ) )datoteke.add(s);

        }
        if(file.isDirectory()){
            for(File f: file.listFiles()) {
                pretraga(f);
            }

        }

    }


    public void StopAction(ActionEvent actionEvent) {
//potrebno dodati prekidanje pretrage
    }
}
