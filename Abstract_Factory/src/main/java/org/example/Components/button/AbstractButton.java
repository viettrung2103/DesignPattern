package org.example.Components.button;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class AbstractButton {

     private HBox hBox;
     private String text;
     private Button button;

     public AbstractButton(HBox hBox, String text) {
          this.hBox = hBox;
          this.text = text;
     }
     public String getText(){
          return this.text;
     }
     public HBox getHBox(){
          return this.hBox;
     }

     public  void setHBox(HBox hBox){
          this.hBox = hBox;
     }
     public Button getButton(){
            return this.button;
     }
     public void setButton(Button button){
            this.button = button;
     }

     public void setText(String text){
          this.button.setText(text);
     }

     public abstract void display();
}
