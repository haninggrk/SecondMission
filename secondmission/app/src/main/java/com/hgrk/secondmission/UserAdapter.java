package com.hgrk.secondmission;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hgrk.secondmission.Model.UserHa;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    ArrayList<UserHa> userlist;
    private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView age;
        public TextView name;
        public TextView city;
        public CardView carduser;
        public TextView idtext;

        public void removeItem(int pos){
            userlist.remove(pos);
            notifyDataSetChanged();
        }
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            age = itemView.findViewById(R.id.age);
            name = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.city);
            carduser = itemView.findViewById(R.id.carduser);

            carduser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Intent intent = new Intent(context, DetailuserActivity.class);
                intent.putExtra("pos",getAdapterPosition());
                context.startActivity(intent);
                }
            });
        }

    }



    public UserAdapter(ArrayList<UserHa> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user,parent,false);

       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserHa currentuser = userlist.get(position);
        holder.age.setText(userlist.get(position).getAge());
        holder.name.setText(userlist.get(position).getName());
        holder.city.setText(userlist.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }



}
