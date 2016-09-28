package com.example.developer.comivo.models;

    public class MessagesModel {

    String userName;
    String companyName;
    String time;
    String messageText;
    int profileCoverImage;
    int statusImg;

        public MessagesModel(String userName, String companyName, String time, String messageText, int profileCoverImage, int statusImg) {
            this.userName = userName;
            this.companyName = companyName;
            this.time = time;
            this.messageText = messageText;
            this.profileCoverImage = profileCoverImage;
            this.statusImg = statusImg;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMessageText() {
            return messageText;
        }

        public void setMessageText(String messageText) {
            this.messageText = messageText;
        }

        public int getProfileCoverImage() {
            return profileCoverImage;
        }

        public void setProfileCoverImage(int profileCoverImage) {
            this.profileCoverImage = profileCoverImage;
        }

        public int getStatusImg() {
            return statusImg;
        }

        public void setStatusImg(int statusImg) {
            this.statusImg = statusImg;
        }
    }
