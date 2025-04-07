package org.example;

public class Main {
    public static void main(String[] args) {

       Handler primaryHanlder;
       Handler compensationClaimHandler = new CompensationClaimHandler();
       Handler contactRequestHandler = new ContactRequestHandler();
       Handler developSuggestionHandler = new DevelopSuggestionHandler();
       Handler generalFeedbackHandler = new GeneralFeedbackHandler();
       compensationClaimHandler.setNextApprover(contactRequestHandler);
       contactRequestHandler.setNextApprover(developSuggestionHandler);
       developSuggestionHandler.setNextApprover(generalFeedbackHandler);
       primaryHanlder = compensationClaimHandler;


       Message message1 = new Message(FeedbackType.GENERAL_FEEDBACK,"general quesstion","tes@mail.com");
       Message message2 = new Message(FeedbackType.COMPENSATION_CLAIM,"conpensation claim","tes@mail.com");
       Message message3 = new Message(FeedbackType.DEVELOPMENT_SUGGESTION,"development suggestion","tes@mail.com");
       Message message4 = new Message(FeedbackType.CONTACT_REQUEST,"contact request","tes@mail.com");
       primaryHanlder.process(message1);
       System.out.println();
       primaryHanlder.process(message2);
       System.out.println();
       primaryHanlder.process(message3);
       System.out.println();
       primaryHanlder.process(message4);
    }
}