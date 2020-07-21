package com.example.task11;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    Context ct;
    List<Contact> contactList;
    public ContactAdapter(MainActivity mainActivity, List<Contact> contacts) {
        ct = mainActivity;
        contactList = contacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.contact_card,parent,false);
        return new ContactHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        final Contact contact = contactList.get(position);
        holder.name.setText(contact.getName());
        holder.mail.setText(contact.getEmailId());
        holder.phone.setText(contact.getPhoneNumber());
        holder.address.setText(contact.getAddress());
        holder.gender.setText(contact.getGender());
        holder.language.setText(contact.getLanguages());
        holder.department.setText(contact.getDepartment());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.viewModel.delete(contact);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView mail;
        private TextView phone;
        private TextView address;
        private TextView gender;
        private TextView language;
        private TextView department;
        private Button update, delete;

        public ContactHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cardDetailsName);
            mail = itemView.findViewById(R.id.cardDetailsMailId);
            phone = itemView.findViewById(R.id.cardDetailsPhoneNumber);
            address = itemView.findViewById(R.id.cardDetailsAddress);
            gender = itemView.findViewById(R.id.cardDetailsGender);
            language = itemView.findViewById(R.id.cardDetailsLanguages);
            department = itemView.findViewById(R.id.cardDetailsDepartment);
            update = itemView.findViewById(R.id.cardDetailsUpdate);
            delete = itemView.findViewById(R.id.cardDetailsDelete);

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ct, AddModify.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    intent.putExtra("language", language.getText().toString());
                    intent.putExtra("mail", mail.getText().toString());
                    intent.putExtra("address", address.getText().toString());
                    intent.putExtra("gender", gender.getText().toString());
                    intent.putExtra("department", department.getText().toString());
                    intent.setAction("update");
                    ct.startActivity(intent);

                }
            });
        }
    }
}
