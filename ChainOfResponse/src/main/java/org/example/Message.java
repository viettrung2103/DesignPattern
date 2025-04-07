package org.example;

public class Message {

    private FeedbackType feedbackType;
    private String content;
    private String senderEmail;

    public Message(FeedbackType feedbackType, String content, String senderEmail) {
        this.feedbackType = feedbackType;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public FeedbackType getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(FeedbackType feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    @Override
    public String toString() {
        return "Message{" +
                "feedbackType=" + feedbackType +
                ", content='" + content + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                '}';
    }
}
