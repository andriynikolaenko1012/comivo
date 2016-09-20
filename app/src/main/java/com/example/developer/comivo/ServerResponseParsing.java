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
    private String accountType;
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
    private String id;
    private String value;
    private String userId;
    private String responseStatus;
    private String loginUserModel;
    private String code;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    private ArrayList<String> idList;
    private ArrayList<String> valueList;

    public ArrayList<String> getIdList() {
        return idList;
    }

    public ArrayList<String> getValueList() {
        return valueList;
    }

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
            if (!jsonObject.isNull(STATUS_KEY)) {
                status = jsonObject.getString("Status");
            }
            if (!jsonObject.isNull(DATA_KEY)) {
                data = jsonObject.getString("Data");
            }
            if (!jsonObject.isNull(MESSAGE_KEY)) {
                message = jsonObject.getString("Message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*public void parseBusinessType(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS_KEY)) {
                status = jsonObject.getString("Status");
            }

            JSONArray jsonarray = jsonObject.getJSONArray("Data");
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String id = jsonobject.getString("Id");
                String value = jsonobject.getString("Value");
            }*/




            /*JSONArray jsonArray = jsonObject.getJSONArray("Data");
            idList = new ArrayList<>(jsonArray.length());
            valueList = new ArrayList<>(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject innerObject = jsonArray.getJSONObject(i);
                idList.add(innerObject.getString("Id"));
                valueList.add(innerObject.getString("Value"));
            }*/




   /*         if (!jsonObject.isNull(MESSAGE_KEY)) {
                message = jsonObject.getString("Message");
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("aaa", e.getMessage(), e);
        }
    }*/

    public static final String STATUS_KEY = "Status";
    public static final String DATA_KEY = "Data";
    public static final String MESSAGE_KEY = "Message";

    public void parseMembershipAndPrivacy(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);

            if (!jsonObject.isNull(STATUS_KEY)) {
                status = jsonObject.getString("Status");
            }
            JSONObject jsonObject1 = jsonObject.getJSONObject("Data");

            cmsPageTypeId = jsonObject1.getString("CMSPageTypeId");
            title = jsonObject1.getString("Title");
            content = jsonObject1.getString("Content");
            isActive = jsonObject1.getString("IsActive");
            type = jsonObject1.getString("Type");

            if (!jsonObject.isNull(MESSAGE_KEY)) {
                message = jsonObject.getString("Message");
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("aaa", e.getMessage(), e);
        }
    }


//    {"Status":4,"Data":{"UserId":11231,"ResponseStatus":2,"LoginUserModel":null,
// "Code":"a15b7716f678001f5e3a5e0c49251e31"},"Message":null}



    public static final String FIRST_NAME_KEY = "FirstName";
    public static final String LAST_NAME_KEY = "LastName";
    public static final String PROFILE_IMAGE_KEY = "ProfileImage";

    public void parseLoginValidate(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS_KEY)) {
                status = jsonObject.getString("Status");
            }


       /*     JSONObject jsonObject1 = jsonObject.getJSONObject("Data");
            firstName = jsonObject1.getString("FirstName");
            lastName = jsonObject1.getString("LastName");
            profileImage = jsonObject1.getString("ProfileImage");
            profileCoverImage = jsonObject1.getString("ProfileCoverImage");
            accountType = String.valueOf(jsonObject1.getInt("AccountType"));
            newUser = jsonObject1.getString("NewUser");
            companyName = jsonObject1.getString("CompanyName");
            tokenId = jsonObject1.getString("TokenId");
            token = jsonObject1.getString("Token");
            email =jsonObject1.getString("Email");*/

            JSONObject jsonObject1 = jsonObject.optJSONObject("Data");
            userId = jsonObject1.getString("UserId");
            responseStatus = jsonObject1.getString("ResponseStatus");
            /*loginUserModel = jsonObject1.getString("LoginUserModel");*/
            JSONObject jsonObject2 = jsonObject1.optJSONObject("LoginUserModel");

            if (!jsonObject2.isNull(FIRST_NAME_KEY)) {
                firstName = jsonObject2.getString("FirstName");
            }
            if (!jsonObject2.isNull(LAST_NAME_KEY)) {
                lastName = jsonObject2.getString("LastName");
            }
            if (!jsonObject2.isNull(PROFILE_IMAGE_KEY)) {
                profileImage = jsonObject2.getString("ProfileImage");
            }
            profileCoverImage = jsonObject2.getString("ProfileCoverImage");
            accountType = String.valueOf(jsonObject2.getInt("AccountType"));
            newUser = jsonObject2.getString("NewUser");
            companyName = jsonObject2.getString("CompanyName");
            tokenId = jsonObject2.getString("TokenId");
            token = jsonObject2.getString("Token");
            email =jsonObject2.getString("Email");

            code = jsonObject1.getString("Code");
            if (!jsonObject.isNull(MESSAGE_KEY)) {
                message = jsonObject.getString("Message");
            }
            Log.d(this.getClass().getName(),status + " status "
                    /*+ firstName + " first name " + lastName + " last mane " +
                    profileImage + " profile image " + profileCoverImage + " profile image cover " + accountType + " account type " +
                    newUser + " new user " + companyName + "company name" + tokenId + " token id " + token + " token " +
                    email + " email " + message + " message ");*/
                    +userId+ " user Id " +responseStatus+ " response status " +loginUserModel+ " login user model "
                    +code+ " code " +message + " message ");
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        try{
//            JSONObject jsonObject = new JSONObject(response);
//            if (!jsonObject.isNull(STATUS_KEY)) {
//                status = jsonObject.getString("Status");
//            }
//            JSONObject jsonObject1 = jsonObject.getJSONObject("Data");
//            firstName = jsonObject1.getString("FirstName");
//            lastName = jsonObject1.getString("LastName");
//            profileImage = jsonObject1.getString("ProfileImage");
//            profileCoverImage = jsonObject1.getString("ProfileCoverImage");
//            accountType = jsonObject1.getString("AccountType");
//            newUser = jsonObject1.getString("NewUser");
//            companyName = jsonObject1.getString("CompanyName");
//            tokenId = jsonObject1.getString("TokenId");
//            token = jsonObject1.getString("Token");
//            email =jsonObject1.getString("Email");
//            if (!jsonObject.isNull(MESSAGE_KEY)) {
//                message = jsonObject.getString("Message");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//            Log.e("aaa", e.getMessage(), e);
//        }
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

    public String getAccountType() {
        return accountType;
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

    public String getUserId() {
        return userId;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public String getLoginUserModel() {
        return loginUserModel;
    }

    public String getCode() {
        return code;
    }
}
