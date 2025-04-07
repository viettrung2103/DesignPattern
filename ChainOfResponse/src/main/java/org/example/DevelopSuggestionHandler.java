package org.example;

public class DevelopSuggestionHandler extends Handler {
    private final FeedbackType feedbackType= FeedbackType.DEVELOPMENT_SUGGESTION;
//    public DevelopSuggestionHandler() {}

    @Override
    public void process(Message message) {
        System.out.println("Handler "+feedbackType.name());
        System.out.println("Handling "+ message);

        if (feedbackType == message.getFeedbackType()) {
            System.out.println("Logging Handling Development Suggestion...");
            System.out.println("Setting priority for the Development Suggestion...");
            System.out.println("Done Handling Development Suggestion");
        }
        else {
            System.out.println("Cannot handdle the message. Forwarding to next handler");
            super.process(message);
        }
    }
}
