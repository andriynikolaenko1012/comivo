package com.example.developer.comivo.network;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


public class BackendManager {

    private static final java.lang.String EMAIL = "email";
    private static final java.lang.String PASSWORD = "password";
    private static BackendManager mInstance = null;
    private OkHttpClient client;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final String baseUrl = "http://beta.comivo.com/mobileapi/";
    private String scheme = "http";
    private String host = "beta.comivo.com";

    private BackendManager() {
        this.client = new OkHttpClient();
    }

    public static BackendManager getInstance() {
        if (mInstance == null) {
            mInstance = new BackendManager();
        }
        return mInstance;
    }



    /*request for account registration, api 1*/

    /*"Note For request parameter: AccountType : 1 for Buyer,
    2 for Seller, BusinessTypeId : Business Type Id get from API-8

    Status: 4 for success , 5 for fail
    Data : 0 - email already exists , >0 (return user id) (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getAccountRegistration(String first_name, String last_name, String email, String password, String company, String account_type, String business_type) {
        return this.client.newCall(this.postRequest(first_name, last_name, email, password, company, account_type, business_type));
    }

    private Request postRequest(String first_name, String last_name, String email, String password, String company, String account_type, String business_type) {
        RequestBody body = RequestBody.create(JSON, signUpJson(first_name, last_name, email, password, company, account_type, business_type));
        return new Request.Builder()
                .url(baseUrl + "account/register")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .post(body)
                .build();
    }

    private String signUpJson(String first_name, String last_name, String email, String password, String company, String account_type, String business_type) {
         return "{\"FirstName\":\"" + first_name + " \","
                + "\"LastName\":\"" + last_name + " \","
                + "\"Email\":\"" + email + " \","
                + "\"Password\":\"" + password + " \","
                + "\"Company\":\"" + company + " \","
                + "\"AccountType\":\"" + account_type + " \","
                + "\"BusinessTypeId\":\"" + account_type + "\""
                + "}";

    }

    /*request for businesstype/{accountType}, api 8*/

        /*"Request :
        accountType : 1=Buyer,2=Seller.
        eg: Buyer business Type = businesstype/1
        Seller business Type = businesstype/2

        Status: 4 for success , 5 for fail
        Data : Array of business types (if status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getBusinesstype(){
        return this.client.newCall(this.getBusinesstypeRequest());
    }

    private Request getBusinesstypeRequest(){
        return new Request.Builder()
                .url(this.buildBusinesstype())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildBusinesstype() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("businesstype")
                .addPathSegment("{accountType}")
                .build();
    }

    /*request for cms/cmstype?type=MemberShip, api 9*/

        /*"Status: 4 for success , 5 for fail
        Data : Title = Header title , Content = HTML content (If Status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getMemberShips(){
        return this.client.newCall(this.getMemberShipRequest());
    }

    private Request getMemberShipRequest(){
        return new Request.Builder()
                .url(this.buildMemberShip())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildMemberShip() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("cms")
                .addPathSegment("cmstype?type=MemberShip")
                .build();
    }

    /*request for cms/cmstype?type=Privacy_Policy, api 9*/

        /*"Status: 4 for success , 5 for fail
        Data : Title = Header title , Content = HTML content (If Status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getPrivacy_Policy(){
        return this.client.newCall(this.getPrivacy_PolicyRequest());
    }

    private Request getPrivacy_PolicyRequest(){
        return new Request.Builder()
                .url(this.buildPrivacy_Policy())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildPrivacy_Policy() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("cms")
                .addPathSegment("cmstype?type=Privacy_Policy")
                .build();
    }

    /*request for cms/cmstype?type=Thank_You, api 27*/

        /*"Status: 4 for success , 5 for fail
        Data : Title = Header title , Content = HTML content (If Status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getThank_You(){
        return this.client.newCall(this.getThank_YouRequest());
    }

    private Request getThank_YouRequest(){
        return new Request.Builder()
                .url(this.buildThank_You())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildThank_You() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("cms")
                .addPathSegment("cmstype?type=Thank_You")
                .build();
    }

    /*request for account/forgotpassword, api 27*/

        /*"Status: 4 for success , 5 for fail
        Data : UserId for valid email , 0 for email not exist (If Status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getAccountForgotPass(String email) {
        return this.client.newCall(this.getRequestAccountForgotPass(EMAIL, email));
    }

    private Request getRequestAccountForgotPass(String paramKey1, String paramValue1) {
        return new Request.Builder()
                .url(this.builtUrlAccountForgotPass(paramKey1, paramValue1))
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrlAccountForgotPass(
            String paramKey1, String paramValue1) {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("account")
                .addPathSegment("forgotpassword")
                .addQueryParameter(paramKey1, paramValue1)
                .build();
    }

    /*request for account/forgotpassword/verifycode, api 4*/

        /*"Status: 4 for success , 5 for fail
        Data : 0 for false,1 for true (If Status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call postVerifyCode(String userId, String confirmation_cod) {
        return this.client.newCall(this.postVerifyCodeRequest(userId, confirmation_cod));
    }

    private Request postVerifyCodeRequest(String userId, String confirmation_cod) {
        RequestBody body = RequestBody.create(JSON, postJSONVerifyCode(userId, confirmation_cod));
        return new Request.Builder()
                .url(baseUrl + "account/forgotpassword/verifycode")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .post(body)
                .build();
    }

    private String postJSONVerifyCode(String userId, String confirmation_code) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"confirmationCode\":\"" + confirmation_code + " \""
                + "}";

    }


    /*request for reset password, api 5*/

    /*"Status: 4 for success , 5 for fail
    Data : 0 for valid,1 (Invalid old password) (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getResetPassword(String userId, String oldPassword, String newPassword) {
        return this.client.newCall(this.postResetPassword(userId, oldPassword, newPassword));
    }

    private Request postResetPassword(String userId, String oldPassword, String newPassword) {
        RequestBody body = RequestBody.create(JSON, resetPassword(userId, oldPassword, newPassword));
        return new Request.Builder()
                .url(baseUrl + "account/resetpassword")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String resetPassword(String userId, String oldPassword, String newPassword) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"OldPassword\":\"" + oldPassword + " \","
                + "\"NewPassword\":\"" + newPassword + " \""
                + "}";

    }

    /*request for account/validatelogin, api 10*/

    /*"Status: 4 for success , 5 for fail
    Data : 0 for false,1 for true (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getLoginValidation(String email, String password, String deviceId) {
        return this.client.newCall(this.getRequestValidateLogin(deviceId, EMAIL, email, PASSWORD, password));
    }

    private Request getRequestValidateLogin(String deviceId,
                                            String paramKey1, String paramValue1,
                                            String paramKey2, String paramValue2) {
        return new Request.Builder()
                .url(this.builtUrlValidateLogin("mobileapi/account/validatelogin", paramKey1, paramValue1, paramKey2, paramValue2))
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("deviceId", deviceId)
                .build();
    }

    private HttpUrl builtUrlValidateLogin(String pathSegment,
                                          String paramKey1, String paramValue1,
                                          String paramKey2, String paramValue2) {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("account")
                .addPathSegment("validatelogin")
                .addQueryParameter(paramKey1, paramValue1)
                .addQueryParameter(paramKey2, paramValue2)
                .build();
    }


    /*request for account device saving, api 97*/

   /* Example:
    DeviceModel (iPad2,5 , Moto G (4),iPhone7,2 ,Mi 4i)
    Platform (iOS , Android)
    Unique Device ID
    Version (4.4.2, 9.3.1)
    Manufacturer (Apple, samsung,Sony,Xiaomi)
    AppVersion (Current APP version installed)

    UserId : If logged once and stored in the local.

    Status: 4 for success , 5 for fail
    Data : 0 false , 1 true (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getDeviceSave(String userId, String device_model, String platform, String device_id, String version, String manufacturer, String app_version) {
        return this.client.newCall(this.postDeviceSaveRequest(userId,device_model, platform, device_id, version, manufacturer, app_version));
    }

    private Request postDeviceSaveRequest(String userId, String device_model, String platform, String device_id, String version, String manufacturer, String app_version) {
        RequestBody body = RequestBody.create(JSON, saveDeviceJson(device_model, platform, device_id, version, manufacturer, app_version));
        return new Request.Builder()
                .url(baseUrl + "device/save")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String saveDeviceJson(String device_model, String platform, String device_id, String version, String manufacturer, String app_version) {
        return "{\"DeviceModel\":\"" + device_model + " \","
                + "\"Platform\":\"" + platform + " \","
                + "\"DeviceId\":\"" + device_id + " \","
                + "\"Version\":\"" + version + " \","
                + "\"Manufacturer\":\"" + manufacturer + " \","
                + "\"AppVersion\":\"" + app_version + " \""
                + "}";

    }

    /*request for change password*/
    public Call getChangePassword(String userId, String oldPassword, String newPassword) {
        return this.client.newCall(this.postChangePassword(userId, oldPassword, newPassword));
    }

    private Request postChangePassword(String userId, String oldPassword, String newPassword) {
        RequestBody body = RequestBody.create(JSON, changePassword(userId, oldPassword, newPassword));
        return new Request.Builder()
                .url(baseUrl + "account/resetpassword")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String changePassword(String userId, String oldPassword, String newPassword) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"OldPassword\":\"" + oldPassword + " \","
                + "\"NewPassword\":\"" + newPassword + " \""
                + "}";

    }


    /*request for company info, api 38*/

    /*"Status: 4 for success , 5 for fail
    Data : return company model (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getCompanyInfo(int userId){
        return this.client.newCall(this.getCompanyInfoRequest(userId));
    }

    private Request getCompanyInfoRequest(int userId){
        return new Request.Builder()
                .url(this.buildCompanyInfo())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildCompanyInfo() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("userprofile")
                .addPathSegment("company")
                .build();
    }


    /*request for change company info, api 40*/

    /*"Status: 4 for success , 5 for fail
    Data : 4 for success"*/

    public Call getEditCompanyInfo(String userId, String imageUrl, String company_name, String website, String description) {
        return this.client.newCall(this.postEditCompanyInfo(userId, imageUrl, company_name, website, description));
    }

    private Request postEditCompanyInfo(String userId, String imageUrl, String company_name, String website, String description) {
        RequestBody body = RequestBody.create(JSON, editCompanyInfo(userId, imageUrl, company_name, website, description));
        return new Request.Builder()
                .url(baseUrl + "userprofile/company")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String editCompanyInfo(String userId, String imageUrl, String company_name, String website, String description) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"ImageUrl\":\"" + imageUrl + " \","
                + "\"CompanyName\":\"" + company_name + " \","
                + "\"Website\":\"" + website + " \","
                + "\"Description\":\"" + description + " \""
                + "}";
    }

    /*request for upload company image/*

    /*"Status: 4 for success , 5 for fail
    Data : 1 (if data insert success), 0 (If data insert fail)"*/

    public Call getUploadCompanyImage(String userId, String company_id, String company_image_name,
                                      String image_size, String image_type, String data) {
        return this.client.newCall(this.postCompanyImage(userId, company_id, company_image_name, image_size, image_type, data));
    }

    private Request postCompanyImage(String userId, String company_id, String company_image_name,
                                     String image_size, String image_type, String data) {
        RequestBody body = RequestBody.create(JSON, uploadCompanyImage(userId, company_id, company_image_name, image_size, image_type, data));
        return new Request.Builder()
                .url(baseUrl + "account/resetpassword")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String uploadCompanyImage(String userId, String company_id, String company_image_name,
                                      String image_size, String image_type, String data) {
        return "{\"UserId\":\"" + userId + " \","
        + "\"CompanyId\":\"" + company_id + " \","
        + "\"Files\":\"["
        + "{\"Name\":\"" + company_image_name + " \","
        + "\"Size\":\"" + image_size + " \","
        + "\"Extension\":\"" + image_type + " \","           /*  "image/png"  */
        + "\"Data\":\"" + data + " \"]}"
        + "\"DeleteFileId\":\"["
        + "]}";

  }



    // Request for faq/list, api 47

    /*"Status: 4 for success , 5 for fail
    Data : Array of FAQ Section model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getFAQList() {
        return this.client.newCall(this.getFAQListRequest());
    }

    private Request getFAQListRequest() {
        return new Request.Builder()
                .url(this.buildFAQList())
                .get()
                .addHeader("platform", "Android")       /*for all request need two parameters*/
                .addHeader("version", "1.0.0")          /*device platform and apk version*/
                .build();
    }

    private HttpUrl buildFAQList() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("faq")
                .addPathSegment("list")
                .build();
    }


    //request for notification/settings, api 37

    /*"Status: 4 for success , 5 for fail
    Data: Array of notification setting model
    Message : Exception message (If Status = 5)"*/

    public Call getNotificationSettings(int userId){
        return this.client.newCall(this.getNotificationSettingsRequest(userId));
    }

    private Request getNotificationSettingsRequest(int userId){
        return new Request.Builder()
                .url(this.buildUrlForNotificationSettings())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUrlForNotificationSettings() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("notification")
                .addPathSegment("settings")
                .build();
    }


    //request for userprofile/notification, api 37

    /*"Status: 4 for success , 5 for fail
    Data: user notification setting Id (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getUserProfileNotification(String userId, int notification_setting_id, boolean isEnable) {
        return this.client.newCall(this.postUserProfileNotification(userId, notification_setting_id, isEnable));
    }

    private Request postUserProfileNotification(String userId, int notification_setting_id, boolean isEnable) {
        RequestBody body = RequestBody.create(JSON, userProfileNotification(userId, notification_setting_id, isEnable));
        return new Request.Builder()
                .url(baseUrl + "notification/settings")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String userProfileNotification(String userId, int notification_setting_id, boolean isEnable) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"notificationSettingId\":\"" + notification_setting_id + " \","
                + "\"isEnable\":\"" + isEnable + " \""
                + "}";
    }


    //request for cms/cmstype?type=Privacy_Policy, api 9

    /*"Status: 4 for success , 5 for fail
    Data : Title = Header title , Content = HTML content (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getPrivacyPolicy2(){
        return this.client.newCall(this.getPrivacyPolicyRequest());
    }

    private Request getPrivacyPolicyRequest(){
        return new Request.Builder()
                .url(this.buildUrlPrivacyPolicy())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildUrlPrivacyPolicy() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("cms")
                .addPathSegment("cmstype?type=Privacy_Policy")
                .build();
    }


    //request for account/social, api 106

    /*"Status: 4 for success , 5 for fail
    Data : return Social Media model (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getAccountSocial(int userId){
        return this.client.newCall(this.getAccountSocialRequest(userId));
    }

    private Request getAccountSocialRequest(int userId){
        return new Request.Builder()
                .url(this.buildUrlAccountSocial())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUrlAccountSocial() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("account")
                .addPathSegment("social")
                .build();
    }


    //request for account/social/connect, api 106

    /*"Status: 4 for success , 5 for fail
    Data : return true (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getSocialConnect(String userId, String social_media_id, String access_token, String social_user_id) {
        return this.client.newCall(this.postSocialConnectRequest(userId, social_media_id, access_token, social_user_id));
    }

    private Request postSocialConnectRequest(String userId, String social_media_id, String access_token, String social_user_id) {
        RequestBody body = RequestBody.create(JSON, socialConnect(userId, social_media_id, access_token, social_user_id));
        return new Request.Builder()
                .url(baseUrl + "account/social/connect")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String socialConnect(String userId, String social_media_id, String access_token, String social_user_id) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"SocialMediaId\":\"" + social_media_id + " \","
                + "\"AccessToken\":\"" + access_token + " \","
                + "\"SocialUserId\":\"" + social_user_id + " \""
                + "}";
    }


    //request for account/social/disconnect, api 106

   /* "Status: 4 for success , 5 for fail
    Data : return true (If Status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getAccountSocialDisconnect(int user_social_account_id){
        return this.client.newCall(this.getAccountSocialRequestDisconnect(user_social_account_id));
    }

    private Request getAccountSocialRequestDisconnect(int user_social_account_id){
        return new Request.Builder()
                .url(this.buildUrlAccountSocialDisconnect())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(user_social_account_id))
                .build();
    }

    private HttpUrl buildUrlAccountSocialDisconnect() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("account")
                .addPathSegment("social")
                .build();
    }


    //request for userfeedback, api 32

   /* "Status: 4 for success , 5 for fail
    Data : 4 for success, 5 for null"*/

    public Call postFeedback(String userId, String feedback) {
        return this.client.newCall(this.postFeedbackRequest(userId, feedback));
    }

    private Request postFeedbackRequest(String userId, String feedback) {
        RequestBody body = RequestBody.create(JSON, postJSONFeedback(userId, feedback));
        return new Request.Builder()
                .url(baseUrl + "account/social/connect")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String postJSONFeedback(String userId, String feedback) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"feedBack\":\"" + feedback + " \""
                + "}";
    }


    /*request for user profile, api 33*/

    /*"Status: 4 for success , 5 for fail
    Data : Array of user detail model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getUserProfile(int userId){
        return this.client.newCall(this.getUserProfileRequest(userId));
    }

    private Request getUserProfileRequest(int userId){
        return new Request.Builder()
                .url(this.buildUserProfile())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUserProfile() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("userprofile")
                .addPathSegment("detail")
                .build();
    }

    /*request for user profile, api 34*/

    /*"Status: 4 for success , 5 for fail
    Data : Array of user detail model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getUserContact(int userId){
        return this.client.newCall(this.getUserContactRequest(userId));
    }

    private Request getUserContactRequest(int userId){
        return new Request.Builder()
                .url(this.buildUserContact())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUserContact() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("userprofile")
                .addPathSegment("contact")
                .build();
    }


    //request for userprofile/contact, api 35

    /*"Status: 4 for success , 5 for fail
    Data : Success (if status = 4), Fail (If status = 5)
    Message : Exception message (If Status = 5)"*/

    public Call postEditUserContact(String userId, String email, String company_name, String website,
                                    String address, String city, String country_id, String state,
                                    String zip_code, String area_code, String country_code, String extension,
                                    String number, String cell_country_code, String cell_number) {
        return this.client.newCall(this.postEditUserContactRequest(userId, email, company_name, website,
                                    address, city, country_id, state, zip_code, area_code, country_code,
                                    extension, number, cell_country_code, cell_number));
    }

    private Request postEditUserContactRequest(String userId, String email, String company_name, String website,
                                               String address, String city, String country_id, String state,
                                               String zip_code, String area_code, String country_code, String extension,
                                               String number, String cell_country_code, String cell_number) {
        RequestBody body = RequestBody.create(JSON, postJSONEditUserContact(userId, email, company_name, website,
                                                address, city, country_id, state, zip_code, area_code, country_code,
                                                extension, number, cell_country_code, cell_number));
        return new Request.Builder()
                .url(baseUrl + "account/social/connect")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String postJSONEditUserContact(String userId, String email, String company_name, String website,
                                           String address, String city, String country_id, String state,
                                           String zip_code, String area_code, String country_code, String extension,
                                           String number, String cell_country_code, String cell_number) {

        return "{\"UserId\":\"" + userId + " \","
                + "\"Email\":\"" + email + " \","
                + "\"CompanyName\":\"" + company_name + " \","
                + "\"Website\":\"" + website + " \","
                + "\"Address\":\"["
                + "{\"Address\":\"" + address + " \","
                + "\"City\":\"" + city + " \","
                + "\"CountryId\":\"" + country_id + " \","
                + "\"State\":\"" + state + " \","
                + "\"ZipCode\":\"" + zip_code + " \"]}"
                + "\"Mobile\":\"["
                + "\"AreaCode\":\"" + area_code + " \","
                + "\"CountryCode\":\"" + country_code + " \","
                + "\"Extension\":\"" + extension + " \","
                + "\"Number\":\"" + number + " \"]}"
                + "\"Telephone\":\"["
                + "\"CountryCode\":\"" + cell_country_code + " \","
                + "\"Number\":\"" + cell_number + " \"]}"
                + "}";
    }


    //request for userprofile/upload/profileimage, api 36

   /* """Status: 4 for success , 5 for fail
    Data : Success (if status = 4), null (If status = 5)
    Message : Exception message (If Status = 5)"""*/

    public Call postUploadProfileImage(String userId, String image_name) {
        return this.client.newCall(this.postUploadProfileImageRequest(userId, image_name));
    }

    private Request postUploadProfileImageRequest(String userId, String image_name) {
        RequestBody body = RequestBody.create(JSON, postJSONUploadProfileImage(userId, image_name));
        return new Request.Builder()
                .url(baseUrl + "userprofile/upload/profileimage")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String postJSONUploadProfileImage(String userId, String image_name) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"imageName\":\"" + image_name + " \""
                + "}";
    }



    /*request for  userprofile/experience, api 43*/

    /*"Status: 4 for success , 5 for fail
    Data : Array of user experience model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getUserExperience(int userId){
        return this.client.newCall(this.getUserExperienceRequest(userId));
    }

    private Request getUserExperienceRequest(int userId){
        return new Request.Builder()
                .url(this.buildUserExperience())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUserExperience() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("userprofile")
                .addPathSegment("experience")
                .build();
    }


    //request for userprofile/experience, api 43

   /* "Status: 4 for success , 5 for fail
    Data : user experience Id for success, 5 for null"*/

    public Call postUserExperience(String userId, String city, String company_name,
                                   String country_id, String country_name, String from_month,
                                   String from_year, String position, String state,
                                   String to_month, String to_year) {
        return this.client.newCall(this.postUserExperienceRequest(userId, city, company_name,
                country_id, country_name, from_month, from_year, position, state, to_month, to_year));
    }

    private Request postUserExperienceRequest(String userId, String city, String company_name,
                                              String country_id, String country_name, String from_month,
                                              String from_year, String position, String state,
                                              String to_month, String to_year) {
        RequestBody body = RequestBody.create(JSON, postJSONUserExperience(userId, city, company_name,
                country_id, country_name, from_month, from_year, position, state, to_month, to_year));
        return new Request.Builder()
                .url(baseUrl + "userprofile/experience")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String postJSONUserExperience(String userId, String city, String company_name,
                                          String country_id, String country_name, String from_month,
                                          String from_year, String position, String state,
                                          String to_month, String to_year) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"City\":\"" + city + " \","
                + "\"Company\":\"" + company_name + " \","
                + "\"CountryId\":\"" + country_id + " \","
                + "\"CountryName\":\"" + country_name + " \","
                + "\"FromMonth\":\"" + from_month + " \","
                + "\"FromYear\":\"" + from_year + " \","
                + "\"Position\":\"" + position + " \","
                + "\"State\":\"" + state + " \","
                + "\"ToMonth\":\"" + to_month + " \","
                + "\"ToYear\":\"" + to_year + " \""
                + "}";
    }



    /*request for  userprofile/experience, api 43*/

    /*"Status: 4 for success , 5 for fail
    Data : true (if status = 4), null (If status = 5)
    Message : Exception message (If Status = 5)"*/

    public Call deleteUserExperience(String userId, String userExperienceId) {
        return this.client.newCall(this.deleteUserExperienceRequest(userId, userExperienceId));
    }

    private Request deleteUserExperienceRequest(String userId, String userExperienceId) {
        RequestBody body = RequestBody.create(JSON, deleteJSONUserExperience(userId, userExperienceId));
        return new Request.Builder()
                .url(baseUrl + "userprofile/experience")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String deleteJSONUserExperience(String userId, String userExperienceId) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"UserExperienceId\":\"" + userExperienceId + " \""
                + "}";
    }


    /*request for  userprofile/education, api 42*/

   /* "Status: 4 for success , 5 for fail
    Data : Array of user education model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getUserEducation(int userId){
        return this.client.newCall(this.getUserEducationRequest(userId));
    }

    private Request getUserEducationRequest(int userId){
        return new Request.Builder()
                .url(this.buildUserEducation())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUserEducation() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("userprofile")
                .addPathSegment("education")
                .build();
    }


    //request for userprofile/education, api 42

    /* "Status: 4 for success , 5 for fail
        Data : user education Id for success, 5 for null"*/

    public Call postUserEducation(String userId, String degree, String field_of_study,
                                  String from_month, String from_year, String school,
                                  String to_month, String to_year, String updated) {
        return this.client.newCall(this.postUserEducationRequest(userId, degree, field_of_study,
                from_month, from_year, school, to_month, to_year, updated));
    }

    private Request postUserEducationRequest(String userId, String degree, String field_of_study,
                                             String from_month, String from_year, String school,
                                             String to_month, String to_year, String updated) {
        RequestBody body = RequestBody.create(JSON, postJSONUserEducation(userId, degree, field_of_study,
                from_month, from_year, school, to_month, to_year, updated));
        return new Request.Builder()
                .url(baseUrl + "userprofile/education")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String postJSONUserEducation(String userId, String degree, String field_of_study,
                                          String from_month, String from_year, String school,
                                          String to_month, String to_year, String updated) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"Degree\":\"" + degree + " \","
                + "\"FieldOfStudy\":\"" + field_of_study + " \","
                + "\"FromMonth\":\"" + from_month + " \","
                + "\"FromYear\":\"" + from_year + " \","
                + "\"School\":\"" + school + " \","
                + "\"ToMonth\":\"" + to_month + " \","
                + "\"ToYear\":\"" + to_year + " \","
                + "\"Updated\":\"" + updated + " \""
                + "}";
    }



    //request for userprofile/education, api 42

    /* """Status: 4 for success , 5 for fail
    Data : true (if status = 4), null (If status = 5)
    Message : Exception message (If Status = 5)"""*/

    public Call deleteUserEducation(String userId, String userEducationId) {
        return this.client.newCall(this.deleteUserExperienceRequest(userId, userEducationId));
    }

    private Request deleteUserEducationRequest(String userId, String userEducationId) {
        RequestBody body = RequestBody.create(JSON, deleteJSONUserExperience(userId, userEducationId));
        return new Request.Builder()
                .url(baseUrl + "userprofile/education")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String deleteJSONUserEducation(String userId, String userEducationId) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"UserEducationId\":\"" + userEducationId + " \""
                + "}";
    }



    /*request for  userprofile/language, api 45*/

    /* "Status: 4 for success , 5 for fail
        Data : Array of user User Language model (if status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getUserLanguage(int userId){
        return this.client.newCall(this.getUserLanguageRequest(userId));
    }

    private Request getUserLanguageRequest(int userId){
        return new Request.Builder()
                .url(this.buildUserLanguage())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildUserLanguage() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("userprofile")
                .addPathSegment("language")
                .build();
    }

    //request for userprofile/language, api 45

        /* "Status: 4 for success , 5 for fail
         Data : Array of user User Language model (if status = 4)
         Message : Exception message (If Status = 5)"*/

    public Call postUserLanguage(String userId, String language_id, String lang_id, String lev_id) {
        return this.client.newCall(this.postUserLanguageRequest(userId, language_id, lang_id, lev_id));
    }

    private Request postUserLanguageRequest(String userId, String language_id, String lang_id, String lev_id) {
        RequestBody body = RequestBody.create(JSON, postJSONUUserLanguage(userId, language_id, lang_id, lev_id));
        return new Request.Builder()
                .url(baseUrl + "userprofile/language")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String postJSONUUserLanguage(String userId, String language_id, String lang_id, String lev_id) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"UserLanguageId\":\"" + language_id + " \","
                + "\"Language\":\"{"
                + "\"Id\":\"" + lang_id + " \"}"
                + "\"LanguageLevel\":\"{"
                + "\"Id\":\"" + lev_id + " \"}"
                + "}";
    }




    //request for userprofile/language, api 45

    /* "Status: 4 for success , 5 for fail
    Data : true (if status = 4), User language detail is not found.(If status = 5)
    Message : Exception message (If Status = 5)"*/

    public Call deleteUserLanguage(String userId, String userLanguageId) {
        return this.client.newCall(this.deleteUserLanguageRequest(userId, userLanguageId));
    }

    private Request deleteUserLanguageRequest(String userId, String userLanguageId) {
        RequestBody body = RequestBody.create(JSON, deleteJSONUserLanguage(userId, userLanguageId));
        return new Request.Builder()
                .url(baseUrl + "userprofile/language")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", userId)
                .post(body)
                .build();
    }

    private String deleteJSONUserLanguage(String userId, String userLanguageId) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"UserLanguageId\":\"" + userLanguageId + " \""
                + "}";
    }


    /*request for  languages, api 45*/

    /* "Status: 4 for success , 5 for fail
        Data : Array of user Language model (if status = 4)
        Message : Exception message (If Status = 5)"*/

    public Call getLanguages(){
        return this.client.newCall(this.getLanguagesRequest());
    }

    private Request getLanguagesRequest(){
        return new Request.Builder()
                .url(this.buildLanguages())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildLanguages() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("languages")
                .build();
    }

    /*request for  languages/levels, api 45*/

    /*"Status: 4 for success , 5 for fail
    Data : Array of user Language level model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getLevels(){
        return this.client.newCall(this.getLevelsRequest());
    }

    private Request getLevelsRequest(){
        return new Request.Builder()
                .url(this.buildLevels())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildLevels() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("languages")
                .addPathSegment("levels")
                .build();
    }


    /*REQUESTS FOR COMMON ITEMS*/


    /*request for countries, api 44*/

    /*"Status: 4 for success , 5 for fail
    Data : Array of country model (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getCountries(){
        return this.client.newCall(this.getCountriesRequest());
    }

    private Request getCountriesRequest() {
        return new Request.Builder()
                .url(this.builtUrlCountries())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrlCountries() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("countries")
                .build();
    }

    /*request for paymentterm, api 130*/

        /*"""Status: 4 for success , 5 for fail
        Data : KeyValueModel List(if status = 4)
        Message : Exception message (If Status = 5)"""*/

    public Call getPaymentterm(){
        return this.client.newCall(this.getPaymenttermRequest());
    }

    private Request getPaymenttermRequest() {
        return new Request.Builder()
                .url(this.builtUrlPaymentterm())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrlPaymentterm() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("paymentterm")
                .build();
    }


    /*request for currency, api 131*/

    /*"Status: 4 for success , 5 for fail
    Data : KeyValueModel LIst (if status = 4)
    Message : Exception message (If Status = 5)"*/

    public Call getCurrency(){
        return this.client.newCall(this.getCurrencyRequest());
    }

    private Request getCurrencyRequest() {
        return new Request.Builder()
                .url(this.builtUrlCurrency())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrlCurrency() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("currency")
                .build();
    }


    /*request for box, api 72*/

    /*"""Status: 4 for success , 5 for fail
    Data : KeyValueModel List(if status = 4)
    Message : Exception message (If Status = 5)"""*/

    public Call getBox(){
        return this.client.newCall(this.getBoxRequest());
    }

    private Request getBoxRequest() {
        return new Request.Builder()
                .url(this.builtUrlBox())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrlBox() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("box")
                .build();
    }


    /*request for unit, api 129*/

    /*"""Status: 4 for success , 5 for fail
    Data : KeyValueModel List(if status = 4)
    Message : Exception message (If Status = 5)"""*/

    public Call getUnit(){
        return this.client.newCall(this.getUnitRequest());
    }

    private Request getUnitRequest() {
        return new Request.Builder()
                .url(this.builtUrlUnit())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrlUnit() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("unit")
                .build();
    }


    /*REQUESTS FOR COMMUNITY*/





    // Request for community/timeline/list, api 13

    /*"Request :
    lastCommunityId : last community id loaded.load more will return data from that id

    Status: 4 for success , 5 for fail
    Data : Array of community model (Post and answers) (if status = 4)
    Message : Exception message (If Status = 5)

    Response : PostType = 1(post) , 3(answer)
    Response : ParentFirstName, ParentLastName, ParentTitle,ParentId (info of who asked Que.)"
    */

    public Call getTimelineList(int userId) {
        return this.client.newCall(this.getTimelineListRequest(userId));
    }

    private Request getTimelineListRequest(int userId) {
        return new Request.Builder()
                .url(this.buildTimelineList())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .addHeader("userId", String.valueOf(userId))
                .build();
    }

    private HttpUrl buildTimelineList() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("community")
                .addPathSegment("timeline")
                .addPathSegment("list")
                .build();
    }

}
