package org.example;

public class GeneralFeedbackHandler extends Handler {
    private final FeedbackType feedbackType= FeedbackType.GENERAL_FEEDBACK;

    @Override
    public void process(Message message) {
        System.out.println("Handler "+feedbackType.name());
        System.out.println("Handling "+ message);

        if (message.getFeedbackType() == feedbackType) {
        System.out.println("Handling General Feedback Message...");
            System.out.println("Done Handling General Feedback Message");
        } else{
        System.out.println("This Handler cannot process the Message");
    }
    }
}
