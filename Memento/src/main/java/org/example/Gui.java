package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    ObservableList<IMemento> historyList;
    ListView<IMemento> historyUIList;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label undoLabel = new Label("Press Ctrl-Z to undo the last change.");
        Label redoLabel = new Label ("Press Ctrl-Y to redo the last change.");
        undoLabel.setPadding(insets);
        redoLabel.setPadding(insets);

        // create a listView
        // list view require a observable list, so a list from controller need to be converted
        // to the observable list which will be passed to the listview
        List<IMemento> mementoList = controller.getHistory();

        historyList  = FXCollections.observableArrayList(mementoList);
        historyUIList = new ListView<>(historyList);

//        historyUIList.setItems(historyList);

        // SET UP THE HOW THE CELL IN THE LISTVIEW WILL DISPLAY THE ITEM
        historyUIList.setCellFactory(memento -> new ListCell<IMemento>(){
            @Override
            protected void updateItem(IMemento iMemento, boolean empty) {
                super.updateItem(iMemento, empty);
                if (empty || iMemento == null){
                    setText(null);
                } else {
                    setText(((Memento)iMemento).getName());
                }
            }
        });

        historyUIList.setPrefWidth(100);
        historyUIList.setPrefHeight(200);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, undoLabel, redoLabel, historyUIList);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {

            controller.setIsSelected(checkBox.isSelected());
                }
        );

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        // for undo action
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown()) {
                if (event.getCode() == KeyCode.Z) {
                    // Ctrl-Z: undo
                    System.out.println("Undo key combination pressed");
                    controller.undo();

                }
                // ctrl -y = redo
                if (event.getCode() == KeyCode.Y) {
                    System.out.println("Redo key combination pressed");
                    controller.redo();
                }
            }
        });




        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void updateHistoryList(){
        this.historyList.setAll(controller.getHistory());
    }


}
