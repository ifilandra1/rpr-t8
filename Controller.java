package ba.unsa.etf.rpr.tutorijal08;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Controller {

    public TextField unosField;
    public SimpleStringProperty unos;
    public Button traziBtn;
    public ListView<String> lista;
    public Button stopBtn;
    public ObservableList<String> datoteke;
    NoviController noviController;

    File file = new File(System.getProperty("user.home"));
    Thread t = new MojThread();

    public Controller() {
        unosField = new TextField();
        unos = new SimpleStringProperty("");

    }

    public void initialize() {
        unosField.textProperty().bindBidirectional(unos);
        stopBtn.setDisable(true);
        datoteke = FXCollections.observableArrayList();
    }


    public void traziAction(ActionEvent actionEvent) {

            stopBtn.setDisable(false);
            traziBtn.setDisable(true);

            t = new MojThread();

            t.start();
            lista.setItems(datoteke);


    }

    public void ClickTabela(MouseEvent mouseEvent) {
     String nazivkliknute=lista.getSelectionModel().getSelectedItem();

        Parent root = null;
        try {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("novi.fxml"));
            loader.load();
            noviController = loader.getController();

            myStage.setTitle("Novi prozor");
            myStage.setScene(new Scene(loader.getRoot(), 300, 275));
            myStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class MojThread extends Thread {
        public void run() {

            try {
                pretraga(file);
            }
            catch (Exception e) {
            }
        }
    }

    void pretraga(File file) {


            if (!t.isInterrupted()) {

                if (file.isFile()) {

                    String s = file.getName();
                    if (s.contains(unos.get())) datoteke.add(s);

                }
                if (file.isDirectory()) {
                    for (File f : file.listFiles()) {
                        pretraga(f);
                    }

                }
            }


    }


    public void StopAction(ActionEvent actionEvent) {
        stopBtn.setDisable(true);
        traziBtn.setDisable(false);

        t.interrupt();

    }



}
