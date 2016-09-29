package com.example.developer.comivo.network.communityParsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kevin Khanda on 29.09.2016.
 * Class for parsing Community.
 */

public class CommunityResponseParsing {

    private CommunityResponseParsing() { }
    private static CommunityResponseParsing communityResponseParsingInstance;

    public static CommunityResponseParsing getInstance() {
        if (communityResponseParsingInstance == null) {
            communityResponseParsingInstance = new CommunityResponseParsing();
        }
        return communityResponseParsingInstance;
    }

    private static final String STATUS = "Status";
    private static final String DATA = "Data";
    private static final String MESSAGE = "Message";

    private String status;
    private String data;
    private String message;
    private String communityId;
    private String title;
    private String post;
    private String postType;
    private String created;
    private String parentId;
    private String parentUserId;
    private String isUserLike;
    private String comments;
    private String likes;
    private String parentTitle;
    private String parentFirstName;
    private String parentLastName;
    private String questionCreated;
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String profileImage;
    private String companyName;
    private String userCountry;
    private String userAnswers;
    private String userQuestions;
    private String userPosts;
    private String userReviews;
    private String userIsFollow;

    public void parseCommunityTimelineList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                communityId = jsonData.getString("CommunityId");
                title = jsonData.getString("Title");
                post = jsonData.getString("Post");
                postType = jsonData.getString("PostType");
                created = jsonData.getString("Created");
                parentId = jsonData.getString("ParentId");
                parentUserId = jsonData.getString("ParentUserId");
                isUserLike = jsonData.getString("IsUserLike");
                comments = jsonData.getString("Comments");
                likes = jsonData.getString("Likes");
                parentTitle = jsonData.getString("ParentTitle");
                parentFirstName = jsonData.getString("ParentFirstName");
                parentLastName = jsonData.getString("ParentLastName");
                questionCreated = jsonData.getString("QuestionCreated");
                JSONObject jsonCommunityUser = jsonData.getJSONObject("CommunityUser");
                // CommunityUser fields
                userId = jsonCommunityUser.getString("UserId");
                userFirstName = jsonCommunityUser.getString("FirstName");
                userLastName = jsonCommunityUser.getString("LastName");
                profileImage = jsonCommunityUser.getString("ProfileImage");
                companyName = jsonCommunityUser.getString("CompanyName");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
