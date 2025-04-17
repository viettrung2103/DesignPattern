package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.util.ArrayList;
import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    private ObservableList<IMemento> finalHistoryList;
    private ListView<IMemento> historyUIList;
    private ChangeListener<IMemento> selectedHistoryListener;

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
        Label tableLabel = new Label ("History :");
        undoLabel.setPadding(insets);
        redoLabel.setPadding(insets);
        tableLabel.setPadding(insets);

        // create a listView
        // list view require a observable list, so a list from controller need to be converted
        // to the observable list which will be passed to the listview
        List<IMemento> mementoList = controller.getHistory();
        List<IMemento> redoMementoList = controller.getRedoHistory();

        finalHistoryList  = FXCollections.observableArrayList(this.combinedHistoryListAndRedoHistoryList(mementoList, redoMementoList));
        historyUIList = new ListView<>(finalHistoryList);

//        historyUIList.setItems(finalHistoryList);

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

        selectedHistoryListener = (observable, oldImemento, newImemento) -> {
            // Your action here
            System.out.println("Selected item: " + newImemento);
            // new Value is the selected item
//                selectedHistory = newValue;
            controller.selectHistory(newImemento);
        };

        historyUIList.getSelectionModel().selectedItemProperty().addListener(selectedHistoryListener);
//        historyUIList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<IMemento>() {
//
//            @Override
//            public void changed(ObservableValue<? extends IMemento> observable, IMemento oldValue, IMemento newValue) {
//                // Your action here
//                System.out.println("Selected item: " + newValue);
//                // new Value is the selected item
////                selectedHistory = newValue;
//                controller.selectHistory(newValue);
//
//
//            }
//        });



        historyUIList.setPrefWidth(100);
        historyUIList.setPrefHeight(200);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, undoLabel, redoLabel,tableLabel, historyUIList);
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
        List<IMemento> historyList = controller.getHistory();
        List<IMemento> redoHistoryList = controller.getRedoHistory();
        // remove the selected history, as it will be remove in the db

        // using the platform run later so we make sure the list is fully retrieved before handle by GUI
        Platform.runLater(() -> {

            // since there is updating inside the listview while listview is affected by the listener, so listening is not connected to the correct selected row
        historyUIList.getSelectionModel().selectedItemProperty().removeListener(selectedHistoryListener);
//        // clear selected row so there is no out of bound
        historyUIList.getSelectionModel().clearSelection();
//        this.finalHistoryList.setAl

        this.finalHistoryList.setAll(combinedHistoryListAndRedoHistoryList(historyList, redoHistoryList));
        // re-add to reactive the selected listern
        historyUIList.getSelectionModel().selectedItemProperty().addListener(selectedHistoryListener);
        });
    }

    public List<IMemento> combinedHistoryListAndRedoHistoryList(List<IMemento> historyList, List<IMemento> redoMementoList) {
        List<IMemento> newHistoryList = new ArrayList<>();
        for (IMemento iMemento : historyList) {
            newHistoryList.add(iMemento);
        }
        for (IMemento iMemento : redoMementoList) {
            newHistoryList.add(iMemento);
        }
        return newHistoryList;
    }


}
