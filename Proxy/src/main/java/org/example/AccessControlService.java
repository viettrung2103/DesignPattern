package org.example;

import java.util.*;

public class AccessControlService {
    private static AccessControlService accessControlService;
    Map<String,List<User>> userDocumentMap;

    private AccessControlService() {
        this.userDocumentMap = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (accessControlService == null){
            accessControlService = new AccessControlService();
        }

        return accessControlService;
    }

//    public Set<User> getUsers() {
//        return this.users;
//    }
    public void addUserAndDocument(String identifier, User user) {
//        List<User> users = userDocumentMap.get(identifier);
//        if (users == null){
//            users = new ArrayList<>();
//        }
//        users.add(user);

        userDocumentMap.computeIfAbsent(identifier, k -> new ArrayList<>());
        userDocumentMap.get(identifier).add(user);
//        this.userDocumentMap.put(identifier, user);
    }



    public boolean isAllowed(User checkingUser, Document document) {
        List<User> users = userDocumentMap.get(document.getIdentifier());
        for (User user : users) {
            if (user.isSameUser(checkingUser)) {
                return true;
            }
        }
        return false;
//        for (Map.Entry<String,List<User>> entry: this.userDocumentMap.entrySet()){
//            List<User> users = entry.getValue();
//            String identifier = entry.getKey();
//            for (User user: users){
//                if ()
//            }
//        }
    }
}
