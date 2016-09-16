package com.example.developer.comivo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ServerResponseParsing {

    private static ServerResponseParsing mInstance;
    private String status;
    private String data;
    private String message;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String profileCoverImage;
    private String accountTipe;
    private String newUser;
    private String companyName;
    private String tokenId;
    private String token;
    private String email;
    private String cmsPageTypeId;
    private String title;
    private String content;
    private String isActive;
    private String type;



    private ArrayList<String> idList;
    private ArrayList<String> valueList;

    private ServerResponseParsing() {
    }

    public static ServerResponseParsing getInstance() {
        if (mInstance == null) {
            mInstance = new ServerResponseParsing();
        }
        return mInstance;
    }

    public void parseSimpleResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            status = jsonObject.getString("Status");
            data = jsonObject.getString("Data");
            message = jsonObject.getString("Message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parseBusinessType(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            status = jsonObject.getString("Status");
            JSONArray jsonArray = jsonObject.optJSONArray("Data");
            idList = new ArrayList<>(jsonArray.length());
            valueList = new ArrayList<>(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject innerObject = jsonArray.getJSONObject(i);
                idList.add(innerObject.getString("Id"));
                valueList.add(innerObject.getString("Value"));
            }
            message = jsonObject.getString("Message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parseMembershipAndPrivacy(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            status = jsonObject.getString("Status");
            JSONObject jsonObject1 = jsonObject.optJSONObject("Data");
            cmsPageTypeId = jsonObject1.getString("CMSPageTypeId");
            title = jsonObject1.getString("Title");
            content = jsonObject1.getString("Content");
            isActive = jsonObject1.getString("IsActive");
            type = jsonObject1.getString("Type");
            message = jsonObject.getString("Message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    public void parseLoginValidate(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            status = jsonObject.getString("Status");
            JSONObject jsonObject1 = jsonObject.optJSONObject("Data");
            firstName = jsonObject1.getString("FirstName");
            lastName = jsonObject1.getString("LastName");
            profileImage = jsonObject1.getString("ProfileImage");
            profileCoverImage = jsonObject1.getString("ProfileCoverImage");
            accountTipe = jsonObject1.getString("AccountType");
            newUser = jsonObject1.getString("NewUser");
            companyName = jsonObject1.getString("CompanyName");
            tokenId = jsonObject1.getString("TokenId");
            token = jsonObject1.getString("Token");
            email =jsonObject1.getString("Email");
            message = jsonObject1.getString("Message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getProfileCoverImage() {
        return profileCoverImage;
    }

    public String getAccountTipe() {
        return accountTipe;
    }

    public String getNewUser() {
        return newUser;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTokenId() {
        return tokenId;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getCmsPageTypeId() {
        return cmsPageTypeId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getType() {
        return type;
    }
}
