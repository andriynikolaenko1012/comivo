package com.example.developer.comivo.network;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonResponseParsing {

    private CommonResponseParsing() { }
    private static CommonResponseParsing commonResponseParsingInstance;

    public static CommonResponseParsing getInstance() {
        if (commonResponseParsingInstance == null) {
            commonResponseParsingInstance = new CommonResponseParsing();
        }
        return commonResponseParsingInstance;
    }

    private static final String STATUS = "Status";
    private static final String DATA = "Data";
    private static final String MESSAGE = "Message";

    private String status;
    private String message;
    private String data;

    private String countryId;
    private String countryName;
    private String countryPhoneCode;
    private String IsRequired;

    private String paymentTermId;
    private String paymentTermValue;

    private String currencyId;
    private String currencyValue;

    private String boxId;
    private String boxValue;

    private String unitId;
    private String unitValue;

    /**
     * Method for parsing list of countries
     *
     * @param response JSON that will be returned by the server for route "countries"
     */
    public void parseCountriesList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                for (int i = 0; i < jsonDataArray.length(); i++) {
                    JSONObject jsonCountries = jsonDataArray.getJSONObject(i);
                    countryId = jsonCountries.getString("Id");
                    countryName = jsonCountries.getString("Name");
                    countryPhoneCode = jsonCountries.getString("TelephoneCode");
                    IsRequired = jsonCountries.getString("IsRequired");
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }

            Log.d(this.getClass().getName(), status + " status " + countryId + " countryId " +
                    countryName + " countryName " + countryPhoneCode + "countryPhoneCode" +
                    getIsRequired() + " isRequired " + message + " message ");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for parsing list of paymentterm
     *
     * @param response JSON that will be returned by the server for route "paymentterm"
     */
    public void parsePaymentsTermList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                for (int i = 0; i < jsonDataArray.length(); i++) {
                    JSONObject jsonPaymentTerm = jsonDataArray.getJSONObject(i);
                    paymentTermId = jsonPaymentTerm.getString("Id");
                    paymentTermValue = jsonPaymentTerm.getString("Value");
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method for parsing list of currency
     *
     * @param response JSON that will be returned by the server for route "currency"
     */
    public void parseCurrencyList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                for (int i = 0; i < jsonDataArray.length(); i++) {
                    JSONObject jsonCurrency = jsonDataArray.getJSONObject(i);
                    currencyId = jsonCurrency.getString("Id");
                    currencyValue = jsonCurrency.getString("Value");
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method for parsing list of box
     *
     * @param response JSON that will be returned by the server for route "box"
     */
    public void parseBoxList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                for (int i = 0; i < jsonDataArray.length(); i++) {
                    JSONObject jsonBox = jsonDataArray.getJSONObject(i);
                    boxId = jsonBox.getString("Id");
                    boxValue = jsonBox.getString("Value");
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method for parsing list of unit
     *
     * @param response JSON that will be returned by the server for route "unit"
     */
    public void parseUnitList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (!jsonObject.isNull(STATUS)) {
                status = jsonObject.getString(STATUS);
            }
            if (!jsonObject.isNull(DATA)) {
                data = jsonObject.getString(DATA);
                JSONArray jsonDataArray = jsonObject.getJSONArray(DATA);
                for (int i = 0; i < jsonDataArray.length(); i++) {
                    JSONObject jsonUnit = jsonDataArray.getJSONObject(i);
                    unitId = jsonUnit.getString("Id");
                    unitValue = jsonUnit.getString("Value");
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryPhoneCode() {
        return countryPhoneCode;
    }

    public String getIsRequired() {
        return IsRequired;
    }

    public String getPaymentTermId() {
        return paymentTermId;
    }

    public String getPaymentTermValue() {
        return paymentTermValue;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public String getBoxId() {
        return boxId;
    }

    public String getBoxValue() {
        return boxValue;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getUnitValue() {
        return unitValue;
    }
}