package org.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Component {
    private String name;
//    private List<String> propertiesKeys;
//    private List<String> propertiesValues;

    public Component(String name){
        this.name = name;
//        createPropertiesKeys();
//        createPropertiesValues();

//        properties.add("name");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> createPropertiesKeys(){
//        if (this.propertiesKeys == null){
//            this.propertiesKeys = new ArrayList<>();
//        }
        List<String> propertiesKeys = new ArrayList<>();
        Field[] allFields = this.getClass().getDeclaredFields();
        Field[] allFieldsSuper = this.getClass().getSuperclass().getDeclaredFields();
        for (Field field : allFieldsSuper){
            field.setAccessible(true);
            String fieldName = field.getName();
            if (!fieldName.contains("properties")){
                propertiesKeys.add(fieldName);
            }
        }
        for (Field field: allFields) {
            field.setAccessible(true);
            String fieldName = field.getName();

            if (!fieldName.contains("properties")){
                propertiesKeys.add(fieldName);
            }
        }
        return propertiesKeys;
    }
    public List<String> createPropertiesValues(){
//        if (this.propertiesValues == null){
//            this.propertiesValues = new ArrayList<>();
//        }
        List<String> propertiesValues = new ArrayList<>();
        Field[] allFieldValues = this.getClass().getDeclaredFields();
        Field[] allFieldValueSuper = this.getClass().getSuperclass().getDeclaredFields();
        for (Field field: allFieldValueSuper){
            try{
                field.setAccessible(true);
                String valueStr = field.get(this).toString();
//                if (this.isPropertiesValues(valueStr)){
//                }
                propertiesValues.add(valueStr);
            } catch ( Exception e ){
                e.printStackTrace();
            }
        }
        for (Field field: allFieldValues) {
            try{
                field.setAccessible(true);
                String valueStr = field.get(this).toString();
//                if (this.isPropertiesValues(valueStr)){
//                }
                propertiesValues.add(valueStr);

            } catch ( Exception e ){
                e.printStackTrace();
            }
        }
        return propertiesValues;
    }

//    public void clearPropertiesKeysAndValue(){
//        this.propertiesKeys.clear();
//        this.propertiesValues.clear();
//    }

//    public abstract void printData();
    public abstract int totalSalary();
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract Component getChild(int index);

    @Override
    public String toString(){
        String componentName = this.getClass().getSimpleName();
        String componentData = "";
        List<String> propertiesKeys = createPropertiesKeys();
        List<String> propertiesValues = createPropertiesValues();
        for ( int i = 0; i < propertiesKeys.size(); i++){
            String newString = "<"+propertiesKeys.get(i)+">"+propertiesValues.get(i)+"</"+propertiesKeys.get(i)+">\n";
            componentData+= newString;
        }
        String startString = "<"+componentName+">\n";
        String endString = "</"+componentName+">\n";

        componentData= startString+componentData+endString ;
        return componentData;
    }

}
