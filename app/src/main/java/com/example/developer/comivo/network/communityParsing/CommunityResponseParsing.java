package com.example.developer.comivo.network.communityParsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Kevin Khanda on 29.09.2016.
 * Class for parsing Community.
 */

/*
Reusable template

public void parseCommunityComments(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
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
    private String socialMediaId;
    private String socialMediaName;
    private String clientId;
    private String clientSecret;
    private String communityCommentId;
    private String comment;
    private String isFollow;
    private String follows;
    private String answers;
    private String firstDataId;
    private String firstDataValue;
    private String secondDataId;
    private String secondDataValue;
    ArrayList<JSONObject> chemicals;
    private String followCount;
    private String hasUserFollow;
    private String answersCount;
    private String questionsCount;
    private String postsCount;
    private String productId;
    private String chemicalName;
    private String synonyms;
    private String molecularFormula;
    private String molecularWeight;
    private String imageUrl;

    /**
     * Method for parsing JSON for Community Timeline List.
     * @param response JSON that is received from route "community/timeline/list".
     */
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
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON from Community Share.
     * @param response JSON that is returned from route "community/share".
     */
    public void parseCommunityShare(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                socialMediaId = jsonData.getString("SocialMediaId");
                socialMediaName = jsonData.getString("Name");
                clientId = jsonData.getString("ClientId");
                clientSecret = jsonData.getString("ClientSecret");
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON from comments. Pay attention that here I have field comment, not comments like in first method.
     * @param response JSON that is returned from route "community/{communityId}/comments.
     */
    public void parseCommunityComments(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                communityCommentId = jsonData.getString("CommunityCommentId");
                communityId = jsonData.getString("CommunityId");
                comment = jsonData.getString("Comment");
                created = jsonData.getString("Created");
                isUserLike = jsonData.getString("IsUserLike");
                likes = jsonData.getString("Likes");
                JSONObject jsonCommunityUser = jsonData.getJSONObject("CommunityUser");
                // CommunityUser fields
                userId = jsonCommunityUser.getString("UserId");
                userFirstName = jsonCommunityUser.getString("FirstName");
                userLastName = jsonCommunityUser.getString("LastName");
                profileImage = jsonCommunityUser.getString("ProfileImage");
                companyName = jsonCommunityUser.getString("CompanyName");
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is similar to parseCommunityTimelineList. The only difference is route.
     * @param response JSON that is returned by the route "community/posts/list"
     */
    public void parseCommunityPostsList(String response) {
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
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing JSON from Post with CommunityId as parameter.
     * Request:
     * communityId: community id loaded.load more will return data from that id
     * (Customers comment)
     * @param response JSON that is returned by route "community/post/{{communityId}}
     */
    public void parseCommunityPostCommunityId(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonData = jsonArray.getJSONObject(0);
                communityId = jsonData.getString("CommunityId"); // Maybe here can be a mistake. My thoughts is that Customer forgot to add this field in JSON
                title = jsonData.getString("Title");
                post = jsonData.getString("Post");
                postType = jsonData.getString("PostType");
                created = jsonData.getString("Created");
                likes = jsonData.getString("Likes");
                isUserLike = jsonData.getString("IsUserLike");
                comments = jsonData.getString("Comments");
                JSONObject jsonCommunityUser = jsonData.getJSONObject("CommunityUser");
                // CommunityUser fields
                userId = jsonCommunityUser.getString("UserId");
                userFirstName = jsonCommunityUser.getString("FirstName");
                userLastName = jsonCommunityUser.getString("LastName");
                profileImage = jsonCommunityUser.getString("ProfileImage");
                companyName = jsonCommunityUser.getString("CompanyName");
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is similar to parseCommunityTimelineList. The only difference is route.
     * @param response JSON that is returned by the route "community/answers/list"
     */
    public void parseCommunityAnswersList(String response) {
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
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for Answer that send as parameters CommunityId.
     * @param response JSON from route "community/answer/{{communityId}}".
     */
    public void parseCommunityAnswerCommunityId(String response) {
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
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing list of Questions. THere are two responses for that method.
     * One of them takes also search as a parameter.
     * @param response JSON returned from "community/questions/list".
     */
    public void parseCommunityQuestionsList(String response) {
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
                isFollow = jsonData.getString("IsFollow");
                follows = jsonData.getString("Follow");
                answers = jsonData.getString("Answers");
                comments = jsonData.getString("Comments");
                JSONObject jsonCommunityUser = jsonData.getJSONObject("CommunityUser");
                // CommunityUser fields
                userId = jsonCommunityUser.getString("UserId");
                userFirstName = jsonCommunityUser.getString("FirstName");
                userLastName = jsonCommunityUser.getString("LastName");
                profileImage = jsonCommunityUser.getString("ProfileImage");
                companyName = jsonCommunityUser.getString("CompanyName");
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing Search
     * @param response JSON returned from "community/question/search".
     */
    public void parseCommunityQuestionSearch(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                JSONObject jsonDataFirst = jsonArray.getJSONObject(0);
                firstDataId = jsonDataFirst.getString("Id");
                firstDataValue = jsonDataFirst.getString("Value");
                JSONObject jsonDataSecond = jsonArray.getJSONObject(1);
                secondDataId = jsonDataSecond.getString("Id");
                secondDataValue = jsonDataSecond.getString("Value");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing Answers for Questions
     * @param response JSON returned from "community/question/{questionId}/answers
     */
    public void parseCommunityQuestionAnswers(String response) {
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
                userCountry = jsonCommunityUser.getString("Country");
                userAnswers = jsonCommunityUser.getString("Answers");
                userQuestions = jsonCommunityUser.getString("Questions");
                userPosts = jsonCommunityUser.getString("Posts");
                userReviews = jsonCommunityUser.getString("Reviews");
                userIsFollow = jsonCommunityUser.getString("IsFollow");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing chemicals. I decided to store objects in array here. Read comments.
     * @param response JSON from "community/chemicals"
     */
    public void parseCommunityChemicals(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonArray = jsonObject.getJSONArray(DATA);
                chemicals = new ArrayList<>();
                // It is better to store JSONObject in array. Then you can access fields by chemicals.get(1).getString("Id");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonChemicals = jsonArray.getJSONObject(i);
                    chemicals.add(jsonChemicals);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    public String getCommunityId() {
        return communityId;
    }

    public String getTitle() {
        return title;
    }

    public String getPost() {
        return post;
    }

    public String getPostType() {
        return postType;
    }

    public String getCreated() {
        return created;
    }

    public String getParentId() {
        return parentId;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public String getIsUserLike() {
        return isUserLike;
    }

    public String getComments() {
        return comments;
    }

    public String getLikes() {
        return likes;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public String getQuestionCreated() {
        return questionCreated;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserAnswers() {
        return userAnswers;
    }

    public String getUserQuestions() {
        return userQuestions;
    }

    public String getUserPosts() {
        return userPosts;
    }

    public String getUserReviews() {
        return userReviews;
    }

    public String getUserIsFollow() {
        return userIsFollow;
    }

    public String getSocialMediaId() {
        return socialMediaId;
    }

    public String getSocialMediaName() {
        return socialMediaName;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getComment() {
        return comment;
    }

    public String getCommunityCommentId() {
        return communityCommentId;
    }

    public String getIsFollow() {
        return isFollow;
    }

    public String getFollows() {
        return follows;
    }

    public String getAnswers() {
        return answers;
    }

    public String getFirstDataId() {
        return firstDataId;
    }

    public String getFirstDataValue() {
        return firstDataValue;
    }

    public String getSecondDataId() {
        return secondDataId;
    }

    public String getSecondDataValue() {
        return secondDataValue;
    }

    public ArrayList<JSONObject> getChemicals() {
        return chemicals;
    }

    public String getFollowCount() {
        return followCount;
    }

    public String getHasUserFollow() {
        return hasUserFollow;
    }

    public String getAnswersCount() {
        return answersCount;
    }

    public String getQuestionsCount() {
        return questionsCount;
    }

    public String getPostsCount() {
        return postsCount;
    }

    public String getProductId() {
        return productId;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public String getMolecularWeight() {
        return molecularWeight;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
