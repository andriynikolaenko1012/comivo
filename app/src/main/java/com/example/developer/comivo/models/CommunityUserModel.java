package com.example.developer.comivo.models;

/**
 * Created by Kevin Khanda on 30.09.2016.
 * Class that represents entity CommunityUser
 */

public class CommunityUserModel {

    private int userId;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String companyName;
    private String country;
    private int answers;
    private int questions;
    private int posts;
    private int reviews;
    private boolean isFollow;

    public CommunityUserModel(int userId, String firstName, String lastName, String profileImage,
                              String companyName, String country, int answers, int questions, int posts,
                              int reviews, boolean isFollow) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.companyName = companyName;
        this.country = country;
        this.answers = answers;
        this.questions = questions;
        this.posts = posts;
        this.reviews = reviews;
        this.isFollow = isFollow;
    }

    public int getUserId() {
        return userId;
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

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }

    public int getAnswers() {
        return answers;
    }

    public int getQuestions() {
        return questions;
    }

    public int getPosts() {
        return posts;
    }

    public int getReviews() {
        return reviews;
    }

    public boolean isFollow() {
        return isFollow;
    }
}
