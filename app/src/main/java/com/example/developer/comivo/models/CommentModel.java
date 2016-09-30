package com.example.developer.comivo.models;

import java.util.Date;

/**
 * Created by Kevin Khanda on 30.09.2016.
 * Class that represents entity Comment from community
 */

public class CommentModel {

    private int communityId;
    private String title;
    private String post;
    private int postType;
    private Date created;
    private int parentId;
    private int parentUserId;
    private boolean isUserLike;
    private int comments;
    private int likes;
    private String parentTitle;
    private String parentFirstName;
    private String parentLastName;
    private Date questionCreated;
    private CommunityUserModel communityUser;

    public CommentModel(int communityId, String title, String post, int postType, Date created,
                        int parentId, int parentUserId, boolean isUserLike, int comments, int likes,
                        String parentTitle, String parentFirstName, String parentLastName, Date questionCreated,
                        CommunityUserModel communityUser) {
        this.communityId = communityId;
        this.title = title;
        this.post = post;
        this.postType = postType;
        this.created = created;
        this.parentId = parentId;
        this.parentUserId = parentUserId;
        this.isUserLike = isUserLike;
        this.comments = comments;
        this.likes = likes;
        this.parentTitle = parentTitle;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.questionCreated = questionCreated;
        this.communityUser = communityUser;
    }

    public int getCommunityId() {
        return communityId;
    }

    public String getTitle() {
        return title;
    }

    public String getPost() {
        return post;
    }

    public int getPostType() {
        return postType;
    }

    public Date getCreated() {
        return created;
    }

    public int getParentId() {
        return parentId;
    }

    public int getParentUserId() {
        return parentUserId;
    }

    public boolean isUserLike() {
        return isUserLike;
    }

    public int getComments() {
        return comments;
    }

    public int getLikes() {
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

    public Date getQuestionCreated() {
        return questionCreated;
    }

    public CommunityUserModel getCommunityUser() {
        return communityUser;
    }
}
