package org.example.Components.checkbox;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import org.example.Components.AbstractControl;
import org.example.Components.button.AbstractButton;

public abstract class AbstractCheckbox implements AbstractControl {
    private HBox hBox;
    private String text;
    private CheckBox checkbox;

    public AbstractCheckbox(HBox vbox, String text) {
        this.hBox = vbox;
        this.text = text;


    }
    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.checkbox.setText(text);
    }

    public HBox getHBox(){
        return this.hBox;
    }

    public void setHBox(HBox hBox){
        this.hBox = hBox;
    }

    public CheckBox getCheckBox(){
        return this.checkbox;
    }
    public void setCheckBox(CheckBox checkBox){
        this.checkbox = checkBox;
    }

    public void setMyText(String text){
        this.checkbox.setText(text);
    }

    public abstract void display();
//    public abstract void setText(String text);

}
