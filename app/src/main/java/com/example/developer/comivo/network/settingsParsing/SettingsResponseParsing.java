package com.example.developer.comivo.network.settingsParsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kevin Khanda on 28.09.2016.
 * This is a class to parse mobileapi/settings
 */

public class SettingsResponseParsing {

    // Parsing "settings API"
    private static final String USR_COMPANY_STATUS = "Status";
    private static final String USR_COMPANY_DATA = "Data";
    private static final String USR_COMPANY_MESSAGE = "Message";

    private String status;
    private String message;
    private String data;
    private String companyId;
    private String companyName;
    private String website;
    private String description;
    private String imageURL;
    private String photos1;
    private String photos2;

    /**
     * This method is parsing JSON that was received from route "userprofile/company"
     *
     * @param response JSON that is received from a server
     */
    public void parseUserprofileCompany(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has(USR_COMPANY_STATUS)) {
                status = jsonObject.getString(USR_COMPANY_STATUS);
            }
            if (jsonObject.has(USR_COMPANY_DATA)) {
                data = jsonObject.getString(USR_COMPANY_DATA);
                JSONObject jsonData = jsonObject.getJSONObject(USR_COMPANY_DATA);

                // Parsing jsonData
                companyId = jsonData.getString("CompanyId");
                companyName = jsonData.getString("CompanyName");
                website = jsonData.getString("Website");
                description = jsonData.getString("Description");
                imageURL = jsonData.getString("ImageUrl");

                JSONArray photos = jsonData.getJSONArray("Photoes");
                photos1 = photos.getString(0);
                photos2 = photos.getString(1);
            }
            if (jsonObject.has(USR_COMPANY_MESSAGE)) {
                message = jsonObject.getString(USR_COMPANY_MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String getUsrCompanyStatus() {
        return USR_COMPANY_STATUS;
    }

    public static String getUsrCompanyData() {
        return USR_COMPANY_DATA;
    }

    public static String getUsrCompanyMessage() {
        return USR_COMPANY_MESSAGE;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebsite() {
        return website;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotos1() {
        return photos1;
    }

    public String getPhotos2() {
        return photos2;
    }
}
