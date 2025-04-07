package org.example;

public class CompensationClaimHandler extends Handler {
    private final FeedbackType feedbackType = FeedbackType.COMPENSATION_CLAIM;
//    public DevelopSuggestionHandler() {}

    @Override
    public void process(Message message) {
        System.out.println("Handler "+feedbackType.name());
        System.out.println("Handling "+ message);

        if (feedbackType == message.getFeedbackType()) {
            System.out.println("Receiving a compensation claim message...");
            System.out.println("Reviewing a compensation claim...");
            System.out.println("Approved a compensation claim");
            System.out.println("Finished Handling a message.");
        } else {
            System.out.println("Cannot handle the message. Transfer to next handler");
            super.process(message);
        }
    }
}
