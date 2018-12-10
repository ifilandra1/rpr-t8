package ba.unsa.etf.rpr.tutorijal08;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;


public class Controller {

public TextField unosField;
public SimpleStringProperty unos;
public Button trazi;
public ListView<String> lista;

    public ObservableList<String> datoteke = FXCollections.observableArrayList();

    public Controller() {

    unosField= new TextField();
    unos=new SimpleStringProperty("");

}

    public void initialize() {
unosField.textProperty().bindBidirectional(unos);

}


    public void traziAction(ActionEvent actionEvent) {
    }

}
