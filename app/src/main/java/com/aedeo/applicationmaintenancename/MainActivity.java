package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterContact adapterContact;
    private Button btnAddMember;
    private ListView listViewMember;
    private ArrayList<Contact> contactArrayList;

    private ContactHandler contactHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        deklarasi
        btnAddMember = (Button) findViewById(R.id.btnAddMember);
        listViewMember = (ListView) findViewById(R.id.listViewMember);

        contactHandler = new ContactHandler(MainActivity.this);
        Log.d("ADD", "TAMBAH DATA");

//        tambahkan data contact
//        contactHandler.addContact(new Contact("John", "083472385473"));
//        contactHandler.addContact(new Contact("Mawar", "083472236423"));
//        contactHandler.addContact(new Contact("Sekar", "083234312325"));

//        tampilkan data
        Log.d("VIEW", "TAMPILKAN DATA");
        contactArrayList = contactHandler.getAllContacts();

        adapterContact = new AdapterContact(MainActivity.this, contactArrayList);
        listViewMember.setAdapter(adapterContact);

        clickBtnAddMember();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
////        contactArrayList = contactHandler.getAllContacts();
//        String name = String.valueOf(getIntent().getSerializableExtra("nama"));
//        String notelp = String.valueOf(getIntent().getSerializableExtra("noTelp"));
//
//        Log.d("TESSS", name);
//        Log.d("TESSS", notelp);
//        contactHandler.addContact(new Contact(name, notelp));
//        Log.d("TESS", "BERHASIL");
//        contactArrayList = contactHandler.getAllContacts();
//        Log.d("TESS", "BERHASIL");
//        adapterContact.notifyDataSetChanged();
//
//        for (Contact contact : contactArrayList) {
//            String baris = contact.getId() + " - " + contact.getNama() + " - " + contact.getNoHp();
//            Log.d("DATA :   ", baris);
//        }
//    }

    public void clickBtnAddMember() {
        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, addMember.class);
//                intent.putExtra("contactArraylist", contactArrayList);
                startActivity(intent);
                intent.notify();
            }
        });
    }
}