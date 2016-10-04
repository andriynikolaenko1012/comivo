package com.example.developer.comivo.network.commonParsing;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

    private String paymentTermId;
    private String paymentTermValue;

    private String currencyId;
    private String currencyValue;

    private String boxId;
    private String boxValue;

    private String unitId;
    private String unitValue;

    private int countryId;
    private String countryName;
    private int countryPhoneCode;
    private boolean isRequired;

    private ArrayList<String> countriesList;

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
                countriesList = new ArrayList<>();
                for (int i = 0; i < jsonDataArray.length(); i++) {
                    JSONObject jsonCountries = jsonDataArray.getJSONObject(i);
                    countryId = Integer.parseInt(jsonCountries.getString("Id"));
                    countryName = jsonCountries.getString("Name");
                    countryPhoneCode = Integer.parseInt(jsonCountries.getString("TelephoneCode"));
                    isRequired = Boolean.parseBoolean(jsonCountries.getString("IsRequired"));


                   /* countriesList.add(String.valueOf(countryId));
                    countriesList.add(countryName);
                    countriesList.add(String.valueOf(countryPhoneCode));
                    countriesList.add(String.valueOf(isRequired));*/


                    /*JSONObject jsonCountries = jsonDataArray.getJSONObject(i);
                    countriesList.add(jsonCountries.getString("Id"));
                    countriesList.add(jsonCountries.getString("Name"));
                    countriesList.add(jsonCountries.getString("TelephoneCode"));
                    countriesList.add(jsonCountries.getString("IsRequired"));*/
                }
            }
            if (!jsonObject.isNull(MESSAGE)) {
                message = jsonObject.getString(MESSAGE);
            }

            // Here ArrayList data must be printed.
            // It is better to make it in a loop like that for (int i = 0; i < jsonDataArray.length(); i++)
            /*Log.d(this.getClass().getName(), status + " status " +  + " countryId " +
                    countryName + " countryName " + countryPhoneCode + "countryPhoneCode" +
                    getIsRequired() + " isRequired " + message + " message ");*/


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

    public ArrayList<String> getCountriesList() {
        return countriesList;
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

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCountryPhoneCode() {
        return countryPhoneCode;
    }

    public boolean isRequired() {
        return isRequired;
    }
}
