package com.example.recyclerviewtugas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rvContact);
        contacts = Contact.createContactsList(30);
        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setAdapter(contactsAdapter);
        rv.setLayoutManager(layoutManager);
    }
}