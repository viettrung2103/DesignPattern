package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IOException, IllegalArgumentException {
        String json = fetchJson(urlString);
        return extractAttribute(json, attributeName);
    }

    private String fetchJson(String urlString) throws IOException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder responseBuilder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            return responseBuilder.toString();

        } catch (IOException e) {
            throw new IOException("Failed to fetch JSON from the API: " + e.getMessage());
        } finally {
            if (reader != null) reader.close();
            if (connection != null) connection.disconnect();
        }
    }

    private String extractAttribute(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON.");
            }

            Object value = jsonObject.get(attributeName);
            return value.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing JSON or finding attribute: " + e.getMessage());
        }
    }
}