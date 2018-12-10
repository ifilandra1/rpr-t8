package ba.unsa.etf.rpr.tutorijal08;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;



public class Controller {

public TextField unosField;
public SimpleStringProperty unos;


    public Controller() {

    unosField= new TextField();
    unos=new SimpleStringProperty("");
}


public void initialize() {
unosField.textProperty().bindBidirectional(unos);

}


}
