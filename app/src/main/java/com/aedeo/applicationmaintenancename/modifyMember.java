package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class modifyMember extends AppCompatActivity {
    private EditText editTextUpdateName, editTextUpdateNum;
    private Button btnUpdateMember, btnDeleteMember, btnCancelModify;
    ContactHandler contactHandler;
    Contact item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_member);

        editTextUpdateName = (EditText) findViewById(R.id.editTextUpdateName);
        editTextUpdateNum = (EditText) findViewById(R.id.editTextUpdateNum);
        btnUpdateMember = (Button) findViewById(R.id.btnUpdateMember);
        btnDeleteMember = (Button) findViewById(R.id.btnDeleteMember);
        btnCancelModify = (Button) findViewById(R.id.btnCancelModify);

        contactHandler = new ContactHandler(modifyMember.this);

        Integer position = Integer.parseInt(getIntent().getExtras().getString("id")) - 1;

        Log.d("TAG", String.valueOf(position));
        item = contactHandler.getContact(position);

        editTextUpdateName.setText(item.getNama());
        editTextUpdateNum.setText(item.getNoHp());

        setBtnUpdateMember();
        setBtnDeleteMember();
        setBtnCancelModify();
    }

    public void setBtnUpdateMember() {
        btnUpdateMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setNama(editTextUpdateName.getText().toString());
                item.setNoHp(editTextUpdateNum.getText().toString());
                contactHandler.updateContact(item);
                finish();
            }
        });
    }

    public void setBtnDeleteMember() {
        btnDeleteMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactHandler.deleteContact(item);
                finish();
            }
        });
    }

    public void setBtnCancelModify() {
        btnCancelModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}