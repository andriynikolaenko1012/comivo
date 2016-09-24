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

    public Call getAccountRegistration(String first_name, String last_name, String password, String email, String company, String accountType) {
        return this.client.newCall(this.postRequest(first_name, last_name, password, email, company, accountType));
    }

    private Request postRequest(String firstName, String last_name, String password, String email, String company, String accountType) {
        RequestBody body = RequestBody.create(JSON, bowlingJson(firstName,last_name, password, email, company, accountType ));
        return new Request.Builder()
                .url(baseUrl + "account/register")
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .post(body)
                .build();
    }



    private String bowlingJson(String firstName, String last_name, String password, String email, String first_name, String accountType) {
        return "{\"FirstName\":\"" + first_name + " \","
                + "\"LastName\":\"xyz\","
                + "\"Email\":\"abc.xyz@gmail.com\","
                + "\"Password\":\"Comivo123\","
                + "\"Company\":\"abcCtpl\","
                + "\"AccountType\":1,"
                + "\"BusinessTypeId\":1"
                + "}";
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
