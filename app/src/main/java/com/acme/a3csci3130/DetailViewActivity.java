package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/*
* Edit and Delete Contact User Interface Class
* @author Mihyar Al Masalma
* */
public class DetailViewActivity extends Activity {

    private EditText nameField, addressField, numberField, businessField, provinceField;
    private MyApplicationData appState;
    Contact receivedPersonInfo;
/*
* Create User Interface for DetailViewActivity
* @param savedInstanceState Get the info from the interface
* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField     = (EditText) findViewById(R.id.name);
        addressField  = (EditText) findViewById(R.id.address);
        numberField   = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        provinceField = (EditText) findViewById(R.id.province);
/*
* Make sure that the fields are filled with info
* */
        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            addressField.setText(receivedPersonInfo.address);
            numberField.setText(receivedPersonInfo.number);
            businessField.setText(receivedPersonInfo.business);
            provinceField.setText(receivedPersonInfo.province);
        }
    }
/*
* Update an existing Record based on the ID
 * @param V The View where the info is coming from
* */
    public void updateContact(View v){
        //TODO: Update contact funcionality
        receivedPersonInfo.name     = nameField.getText().toString();
        receivedPersonInfo.address  = addressField.getText().toString();
        receivedPersonInfo.number   = numberField.getText().toString();
        receivedPersonInfo.business = businessField.getText().toString();
        receivedPersonInfo.province = provinceField.getText().toString();
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);
        finish();
    }
/*
* Delete an existing Record based on the ID
* @param V The View where the info is coming from
* */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
    }
}
