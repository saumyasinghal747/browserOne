package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.web.WebView;
//import javafx.scene.web.WebViewBuilder;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    int counter = 5;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        TabPane tabpane = new TabPane();

        // create multiple tabs
        for (int i = 0; i < 5; i++) {

            // create Tab
            Tab tab = new Tab("Tab_" + (i + 1));

            // create a label
            Button button = new Button("Search");
            TextField sbar = new TextField();
            ToolBar  toolBar = new ToolBar(sbar,button);
            toolBar.setStyle("-fx-pref-width: 1600.0");
            HBox hbox = new HBox(toolBar);

            // add label to the tab
            tab.setContent(hbox);

            // add tab
            tabpane.getTabs().add(tab);
        }

        // create a tab which
        // when pressed creates a new tab
        Tab newtab = new Tab("+");
        newtab.getStyleClass().clear();
        newtab.getStyleClass().add("new-tab-button");
        // action event
        EventHandler<Event> event =
                e -> {
                    if (newtab.isSelected())
                    {

                        // create Tab
                        Tab tab = new Tab("Tab_" + (counter + 1));

                        // create a label
                        Label label = new Label("This is Tab: "
                                + (counter + 1));

                        counter++;

                        // add label to the tab
                        tab.setContent(label);

                        // add tab
                        tabpane.getTabs().add(
                                tabpane.getTabs().size() - 1, tab);

                        // select the last tab
                        tabpane.getSelectionModel().select(
                                tabpane.getTabs().size() - 2);
                    }
                };

        // set event handler to the tab
        newtab.setOnSelectionChanged(event);

        // add newtab
        tabpane.getTabs().add(newtab);

        primaryStage.setTitle("Browser One");
        Scene scene = new Scene(tabpane, 1600, 900);
        scene.getStylesheets().add("/sample/tabs.css");
        scene.getStylesheets().add("/sample/toolbar.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
