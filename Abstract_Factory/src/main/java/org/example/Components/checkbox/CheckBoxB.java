package org.example.Components.checkbox;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CheckBoxB  extends AbstractCheckbox{
    public CheckBoxB(HBox hBox, String text) {
        super(hBox, text);
    }
    @Override
    public void display() {
        CheckBox checkBox = new CheckBox(super.getText());
        Font font = Font.font("Dialog", FontWeight.BOLD, 12);

        checkBox.setFont(font);
        checkBox.setPrefSize(400, 200);
        checkBox.setStyle("-fx-background-color:grey;-fx-text-fill:white;");
        super.getHBox().getChildren().add(checkBox);
        super.setCheckBox(checkBox);

    }

}
