package org.example;

public abstract class Handler {
    private Handler nextApprover;

    public void process(Message message) {
        if (nextApprover != null) {
            nextApprover.process(message);
        }
    }
    public void setNextApprover(Handler nextApprover) {
        this.nextApprover = nextApprover;
    }
}
