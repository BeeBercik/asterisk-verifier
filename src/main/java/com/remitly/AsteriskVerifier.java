package com.remitly;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class AwsDocumentFileException extends Exception {
    public AwsDocumentFileException(String message) {
        super(message);
    }
}

public class AsteriskVerifier {
    boolean checkAsterisk(String path) throws AwsDocumentFileException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line + "\n");
            }
            br.close();

            JSONObject json = new JSONObject(content.toString());
            JSONObject policyDoc = json.getJSONObject("PolicyDocument");
            JSONArray statement = policyDoc.getJSONArray("Statement");
            JSONObject objInsideStatement = (JSONObject) statement.get(0);

            if (objInsideStatement.get("Resource") instanceof String) {
                String resource = objInsideStatement.getString("Resource");
                return resource.equals("*") ? false : true;
            } else
                return true;
        } catch(IOException e) {
            throw new AwsDocumentFileException("Problem with json file.");
        } catch(JSONException e) {
            throw new AwsDocumentFileException("Incorrect AWS Document Structure.");
        }
    }

    public static void main(String[] args) {
        String path = "src\\main\\java\\com\\remitly\\aws-document.json";

        try {
            boolean result = new AsteriskVerifier().checkAsterisk(path);
            System.out.println(result);
        } catch (AwsDocumentFileException e) {
            System.out.println(e.getMessage());
        }
    }
}