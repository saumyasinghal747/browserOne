package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SampleController {
    public Label helloWorld;
    public TabPane topTabs;


    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }


    public void addTabs(ActionEvent actionEvent){

    }
}


