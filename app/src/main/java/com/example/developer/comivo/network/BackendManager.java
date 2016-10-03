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
    private String memberShipUrl = "cms/cmstype?type=MemberShip";
    private String privacyPolicyUrl = "cms/cmstype?type=Privacy_Policy";
    private String businessTypeUrl = "businesstype/{accountType}";
    private String thanksSendingUrl = "cms/cmstype?type=Thank_You";

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

    public Call getMemberShip() {
        return this.client.newCall(this.getRequest(this.memberShipUrl));
    }

    public Call getPrivacyPolicy() {
        return this.client.newCall(this.getRequest(this.privacyPolicyUrl));
    }

    public Call getBusinessType() {
        return this.client.newCall(this.getRequest(this.businessTypeUrl));
    }

    public Call getLoginValidation(String email, String password, String deviceId) {
        return this.client.newCall(this.getRequestValidateLogin(deviceId, EMAIL, email, PASSWORD, password));
    }

    public Call getThanksSending() {
        return this.client.newCall(this.getRequest(this.thanksSendingUrl));
    }

    public Call getAccountForgotPass(String email) {
        return this.client.newCall(this.getRequestAccountForgotPass(EMAIL, email));
    }

    // Request for Timeline List
    public Call getTimelineList() {
        return this.client.newCall(this.getTimelineListRequest());
    }

    private Request getTimelineListRequest() {
        return new Request.Builder()
                .url(this.buildTimelineList())
                .get()
                .addHeader("platform", "Android")       /*for all request need two parameters*/
                .addHeader("version", "1.0.0")          /*device platform and apk version*/
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

    /*request for user profile, api 33*/
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

    /*request for Q&A*/

    public Call getUserQ_A(){
        return this.client.newCall(this.getUserQ_ARequest());
    }

    private Request getUserQ_ARequest(){
        return new Request.Builder()
                .url(this.buildQ_AUrl())
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl buildQ_AUrl() {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("faq")
                .addPathSegment("list")
                .build();
    }


    /*request for countries*/
    public Call getCountries(){
        return this.client.newCall(this.getCountriesRequest());
    }

    private Request getCountriesRequest() {
        return new Request.Builder()
                .url(this.builtUrlCountries())
                .get()
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


    private Request getRequest(String pathSegment) {
        return new Request.Builder()
                .url(this.builtUrl(pathSegment))
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
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

    private Request getRequestAccountForgotPass(String paramKey1, String paramValue1) {
        return new Request.Builder()
                .url(this.builtUrlAccountForgotPass(paramKey1, paramValue1))
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }


    /*request for account registration*/
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

    /*request for account device saving*/
    public Call getDeviceSave(String userId, String device_model, String platform, String device_id, String version, String manufacturer, String app_version) {
        return this.client.newCall(this.postDeviceSaveRequest(userId,device_model, platform, device_id, version, manufacturer, app_version));
    }

    private Request postDeviceSaveRequest(String userId, String device_model, String platform, String device_id, String version, String manufacturer, String app_version) {
        RequestBody body = RequestBody.create(JSON, saveDeviceJson(device_model, platform, device_id, version, manufacturer, app_version));
        return new Request.Builder()
                .url(baseUrl + "device/save")
                .addHeader("platform", "Android")
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

    /*request for reset password*/
    public Call getResetPassword(String userId, String oldPassword, String newPassword) {
        return this.client.newCall(this.postResetPassword(userId, oldPassword, newPassword));
    }

    private Request postResetPassword(String userId, String oldPassword, String newPassword) {
        RequestBody body = RequestBody.create(JSON, resetPassword(userId, oldPassword, newPassword));
        return new Request.Builder()
                .url(baseUrl + "account/resetpassword")
                .addHeader("platform", "Android")
                .post(body)
                .build();
    }

    private String resetPassword(String userId, String oldPassword, String newPassword) {
        return "{\"UserId\":\"" + userId + " \","
                + "\"OldPassword\":\"" + oldPassword + " \","
                + "\"NewPassword\":\"" + newPassword + " \""
                + "}";

    }

    /*request for company info*/
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


    private Request getRequest(String pathSegment, String paramKey1, String paramValue1) {
        return new Request.Builder()
                .url(this.builtUrl(pathSegment, paramKey1, paramValue1))
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private Request getRequest(String pathSegment,
                               String paramKey1, String paramValue1,
                               String paramKey2, String paramValue2) {
        return new Request.Builder()
                .url(this.builtUrl(pathSegment, paramKey1, paramValue1, paramKey2, paramValue2))
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
    }

    private HttpUrl builtUrl(String pathSegment) {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment(pathSegment)
                .build();
    }

    private HttpUrl builtUrl(String pathSegment,
                             String paramKey1, String paramValue1
    ) {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment(pathSegment)
                .addQueryParameter(paramKey1, paramValue1)
                .build();
    }

    private HttpUrl builtUrl(String pathSegment,
                             String paramKey1, String paramValue1,
                             String paramKey2, String paramValue2) {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment(pathSegment)
                .addQueryParameter(paramKey1, paramValue1)
                .addQueryParameter(paramKey2, paramValue2)
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

    private HttpUrl builtUrlVerifyCode( int userId,
            String paramKey1, String paramValue1) {
        return new HttpUrl.Builder()
                .scheme(this.scheme)
                .host(this.host)
                .addPathSegment("mobileapi")
                .addPathSegment("account")
                .addPathSegment("forgotpassword")
                .addPathSegment("verifycode")
                .addQueryParameter(paramKey1, paramValue1)
                .build();
    }

}
