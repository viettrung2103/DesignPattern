package org.example;

public class ContactRequestHandler extends Handler {
    private final FeedbackType feedbackType= FeedbackType.CONTACT_REQUEST;
//    public DevelopSuggestionHandler() {}

    @Override
    public void process(Message message) {
        System.out.println("Handler "+feedbackType.name());
        System.out.println("Handling "+ message);

        if (feedbackType == message.getFeedbackType()) {
            System.out.println("Receiving a contact request...");
            System.out.println("Forwarding to appropriate department...");
            System.out.println("Finished Handling a message.");
        }
        else {
            System.out.println("Cannot handle the message. Transfer to next handler");
            super.process(message);
        }
    }
}
