package org.example;


public class ProxyDocument implements Document {
    private String identifier;
//    private String content;
//    private long createDate;
    private RealDocument realDocument;
    private AccessControlService accessControlService;

    public ProxyDocument(String identifier) {
        this.identifier = identifier;
//        this.createDate = createDate;
    }

    @Override
    public long getCreateDate() {
        if (this.realDocument == null){

            System.out.println("Proxy Document is fetching content from real document");
            String defaultContent ="Default";
            realDocument = new RealDocument(this.identifier,defaultContent);
        }
        return realDocument.getCreateDate();
    }

    public void setAccessControlService(AccessControlService accessControlService) {
        this.accessControlService = accessControlService;
//        this.accessControlService.addUser(new User(this.identifier));
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(user, this)) {
            if (this.realDocument == null){

                System.out.println("Proxy Document is fetching content from real document");
                String defaultContent ="Default";
                realDocument = new RealDocument(this.identifier,defaultContent);
            }
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: "+user);
        }
    }

    public RealDocument getRealDocument() {
        return realDocument;
    }
}
