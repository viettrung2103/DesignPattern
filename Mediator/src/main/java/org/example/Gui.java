package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {
    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoomMediator();

        new ChatClientWindow("Alice", mediator);
        new ChatClientWindow("Bob", mediator);
        new ChatClientWindow("Charlie", mediator);
    }
}
