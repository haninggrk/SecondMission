package com.hgrk.secondmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hgrk.secondmission.Model.UserHa;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddEdit extends AppCompatActivity {
    public static final int editcode = 1;
    public static final int createcode = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        TextView heading = findViewById(R.id.heading);
        TextInputLayout ipt_name = findViewById(R.id.ipt_name);
        TextInputLayout ipt_age = findViewById(R.id.ipt_age);
        TextInputLayout ipt_city = findViewById(R.id.ipt_city);
        Button btn_add = findViewById(R.id.btn_add);
        int request = getIntent().getIntExtra("code",0);

        if(request == 0){

        }else if(request == 2){
        heading.setText("Add User");
        btn_add.setText("Add");
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tempName = ipt_name.getEditText().getText().toString().trim();
                String tempAge = ipt_age.getEditText().getText().toString().trim() +" years old";
                String tempCity = ipt_city.getEditText().getText().toString().trim();
                if(!tempName.equals("") && !tempAge.equals("") && !tempCity.equals("")) {
                    UserHa temp = new UserHa(tempName, tempAge, tempCity);
                    MainActivity.userlist.add(temp);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(intent);
                }else{
                    Toast. makeText(getApplicationContext(),"Fill in all data!",Toast. LENGTH_SHORT).show();
                }
            }
        });
        }else if(request == 1){
           heading.setText("Edit User");
           UserHa temp = MainActivity.userlist.get(getIntent().getIntExtra("pos",0));
           ipt_name.getEditText().setText(temp.getName());
           ipt_age.getEditText().setText(temp.getAge());
           ipt_city.getEditText().setText(temp.getCity());

           btn_add.setText("Edit");
           btn_add.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   temp.setAge(ipt_age.getEditText().getText().toString().trim() +" years old");
                   temp.setName(ipt_name.getEditText().getText().toString().trim());
                   temp.setCity(ipt_city.getEditText().getText().toString().trim());
                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                   startActivity(intent);
               }
           });


        }


    }
}