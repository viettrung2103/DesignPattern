package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class ChatClientWindow implements ChatClient {
    private final String username;
    private final ChatMediator mediator;
    private final TextArea messageArea = new TextArea();
    private final TextField messageField = new TextField();
    private final ComboBox<String> recipientDropdown = new ComboBox<>();

    public ChatClientWindow(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
        createWindow();
    }

    private void createWindow() {
        Stage stage = new Stage();
        stage.setTitle(username);

        messageArea.setEditable(false);
        messageArea.setPrefHeight(200);

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String message = messageField.getText();
            String recipient = recipientDropdown.getValue();
            if (!message.isEmpty() && recipient != null) {
                mediator.sendMessage(message, username, recipient);
                messageArea.appendText("Me to " + recipient + ": " + message + "\n");
                messageField.clear();
            }
        });

        VBox layout = new VBox(5,
                new Label("Chat:"),
                messageArea,
                new Label("Message:"),
                messageField,
                new Label("Recipient:"),
                recipientDropdown,
                sendButton
        );

        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void receiveMessage(String message) {
        messageArea.appendText(message + "\n");
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setAvailableRecipients(List<String> allUsernames) {
        List<String> otherUsers = allUsernames.stream()
                .filter(name -> !name.equals(username))
                .collect(Collectors.toList());

        recipientDropdown.getItems().setAll(otherUsers);
        if (!otherUsers.isEmpty()) {
            recipientDropdown.setValue(otherUsers.get(0)); // select default
        }
    }
}
