package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String,Document> documentMap;
    private AccessControlService accessControlService;

    public Library () {
        this.accessControlService = AccessControlService.getInstance();
        this.documentMap = new HashMap<>();
    }

    public void addProtectedDocument(User user, String identifier) {
        ProxyDocument proxyDocument = new ProxyDocument(identifier);
        proxyDocument.setAccessControlService(accessControlService);

        accessControlService.addUserAndDocument(identifier,user);

        documentMap.put(identifier, proxyDocument);
//        ProxyDocument proxyDocument = new ProxyDocument()
    }

    public void addUnprotectedDocument(String identifier, String content){
        RealDocument document = new RealDocument(identifier, content);
        documentMap.put(identifier, document);
    }

    public Document getDocument(String identifier) {
        return documentMap.get(identifier);
    }

    public String getContent(String identifier, User user) throws NoDocumentAvailableException, AccessDeniedException {
        // retrieve the document
        Document document = documentMap.get(identifier);
        if (document == null) {
            throw new  NoDocumentAvailableException("No such document exist");
        }
        return document.getContent(user);
    }
}
