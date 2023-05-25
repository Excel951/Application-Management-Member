package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class addMember extends AppCompatActivity {
    private Button btnAddName, btnCancelAddMember;
    private EditText editTextAddName, editTextAddNum;
    ArrayList<Contact> contactArrayList;
    ContactHandler contactHandler;

    Context notif;

//    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

//        context = new MainActivity();
        btnAddName = (Button) findViewById(R.id.btnAddName);
        btnCancelAddMember = (Button) findViewById(R.id.btnCancelAddMember);
        editTextAddName = (EditText) findViewById(R.id.editTextAddName);
        editTextAddNum = (EditText) findViewById(R.id.editTextAddNum);
        notif = getApplicationContext();

        contactHandler = new ContactHandler(addMember.this);
        contactArrayList = contactHandler.getAllContacts();

//        contactArrayList = (ArrayList<Contact>) getIntent().getSerializableExtra("contactArraylist");

//        for (Contact contact : contactArrayList) {
//            String baris = contact.getId() + " - " + contact.getNama() + " - " + contact.getNoHp();
//            Log.d("DATA :   ", baris);
//        }

        setBtnCancelAddMember();
        setBtnAddName();
    }

    public void setBtnAddName() {
        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextAddName.getText().toString();
                String telephoneNum = editTextAddNum.getText().toString();
                if (!name.isEmpty() || !telephoneNum.isEmpty()) {
                    contactHandler.addContact(new Contact(name, telephoneNum));
                } else {
                    String text = "Masih ada kolom yang belum terisi";
                    Toast warning = Toast.makeText(notif, text, Toast.LENGTH_SHORT);
                    warning.show();
                }
//                contactArrayList = contactHandler.getAllContacts();
//                for (Contact contact : contactArrayList) {
//                    String baris = contact.getId() + " - " + contact.getNama() + " - " + contact.getNoHp();
//                    Log.d("DATA :   ", baris);
//                }
                finish();
            }
        });
    }

    public void setBtnCancelAddMember() {
        btnCancelAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}