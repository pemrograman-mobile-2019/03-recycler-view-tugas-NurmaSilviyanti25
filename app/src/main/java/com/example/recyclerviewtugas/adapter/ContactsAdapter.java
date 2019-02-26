package com.example.recyclerviewtugas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recyclerviewtugas.R;
import com.example.recyclerviewtugas.models.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    //atribut
    private List<Contact> mContact;

    //construktor
    public ContactsAdapter(List<Contact> mContact){
        this.mContact = mContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //menghubungkan  ke adapter
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) { //menghubungkan / mensetting nilai masing2 item
        Contact itemMContact = mContact.get(i);
        TextView textView = viewHolder.nameTextView;
        textView.setText(itemMContact.getName());

        Button buttonContact = viewHolder.messageButton;
        buttonContact.setText(itemMContact.isOnline()? "Message" : "Offline");
        buttonContact.setEnabled(itemMContact.isOnline());

    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private Button messageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            messageButton = itemView.findViewById(R.id.message_button);
        }
    }
}