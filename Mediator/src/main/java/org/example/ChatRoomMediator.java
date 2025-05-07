package org.example;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChatRoomMediator implements ChatMediator {
    private final Map<String, ChatClientWindow> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        if (client instanceof ChatClientWindow) {
            ChatClientWindow window = (ChatClientWindow) client;
            clients.put(client.getUsername(), window);
            updateAllRecipientLists();
        }
    }

    private void updateAllRecipientLists() {
        List<String> allUsernames = clients.keySet().stream().collect(Collectors.toList());
        for (ChatClientWindow client : clients.values()) {
            client.setAvailableRecipients(allUsernames);
        }
    }

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        ChatClientWindow client = clients.get(recipient);
        if (client != null) {
            client.receiveMessage(sender + ": " + message);
        }
    }
}
