package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 * @author Mihyar Al Masalma
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String number;
    public  String business;
    public  String address;
    public  String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }
/**
* Constructor for Contact Class
 * @param uid Database User Unique Identifier
 * @param name Name of the Business
 * @param number Business Number
 * @param business The name of the Business
 * @param address  The Address of the Business
 * @param province The Province where the Business is located
* */
    public Contact(String uid, String name, String number, String business, String address, String province){
        this.uid = uid;
        this.name = name;
        this.number = number;
        this.business = business;
        this.address = address;
        this.province = province;
    }
/*
* Business Data object to be stored
 * @return result
* */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("province", province);

        return result;
    }
}
