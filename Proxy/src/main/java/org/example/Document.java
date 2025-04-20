package org.example;



public interface Document {
//    private long createDate;
//    private String identifier;
//    private String content;

    long getCreateDate();
    String getIdentifier();
    String getContent(User user) throws AccessDeniedException;


}
