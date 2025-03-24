package org.example.Components.checkbox;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CheckBoxA extends AbstractCheckbox{

    public CheckBoxA(HBox hBox, String text) {
        super(hBox,text);
    }
    @Override
    public void display() {
        CheckBox checkBox = new CheckBox(super.getText());
        Font font = Font.font("Courier New", FontWeight.BOLD, 14);

        checkBox.setFont(font);
        checkBox.setPrefSize(300, 100);
        checkBox.setStyle("-fx-background-color:#ff2143;-fx-text-fill:white;");
        super.getHBox().getChildren().add(checkBox);
        super.setCheckBox(checkBox);

    }


}
