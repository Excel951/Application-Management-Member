package com.aedeo.applicationmaintenancename;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContact extends BaseAdapter {
    Context context;

    ArrayList<Contact> contactArrayList;

    LayoutInflater layoutInflater;

    public AdapterContact() {

    }

    public AdapterContact(Context context, ArrayList<Contact> contactArrayList) {
        this.context = context;
        this.contactArrayList = contactArrayList;
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return contactArrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.layout_adapter_contact, null);

        TextView adapterNameContact = (TextView) view.findViewById(R.id.adapter_contact_name);
        TextView adapterNumContact = (TextView) view.findViewById(R.id.adapter_contact_num);

        adapterNameContact.setText(contactArrayList.get(i).getNama());
        adapterNumContact.setText(contactArrayList.get(i).getNoHp());

        return view;
    }
}