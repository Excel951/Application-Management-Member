package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterContact adapterContact;
    private Button btnAddMember;
    private ListView listViewMember;
    private ArrayList<Contact> contactArrayList;

    private ContactHandler contactHandler;
//    Integer countRowsdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        deklarasi
        btnAddMember = (Button) findViewById(R.id.btnAddMember);
        listViewMember = (ListView) findViewById(R.id.listViewMember);

        contactHandler = new ContactHandler(MainActivity.this);
        Log.d("ADD", "TAMBAH DATA");

//        countRowsdb = contactHandler.getContactsCount();
//        Log.d("DB COUNT", countRowsdb.toString());

//        tambahkan data contact
//        contactHandler.addContact(new Contact("John", "083472385473"));
//        contactHandler.addContact(new Contact("Mawar", "083472236423"));
//        contactHandler.addContact(new Contact("Sekar", "083234312325"));

//        tampilkan data
        Log.d("VIEW", "TAMPILKAN DATA");
        contactArrayList = contactHandler.getAllContacts();

        adapterContact = new AdapterContact(MainActivity.this, contactArrayList);
        listViewMember.setAdapter(adapterContact);

        listViewMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, modifyMember.class);
                intent.putExtra("id", String.valueOf(id));
                startActivity(intent);
            }
        });
        clickBtnAddMember();
    }
    @Override
    protected void onResume() {
        super.onResume();

        contactArrayList = contactHandler.getAllContacts();
        adapterContact = new AdapterContact(MainActivity.this, contactArrayList);
        listViewMember.setAdapter(adapterContact);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        contactHandler.db.close();
    }
    public void clickBtnAddMember() {
        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, addMember.class);
                startActivity(intent);
            }
        });
    }

}