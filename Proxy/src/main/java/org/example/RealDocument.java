package org.example;


public class RealDocument implements Document {
    private static int counter = 0;
    private String identifier;
    private String content;
    private long createDate;

    public RealDocument(String identifier, String content) {
        this.identifier = identifier + " - " + counter;
        this.content = content;
        this.createDate = System.currentTimeMillis();
        counter++;
    }

    @Override
    public long getCreateDate() {
        return this.createDate;
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public String getContent(User user)  throws AccessDeniedException {
        return this.content;
    }


}
