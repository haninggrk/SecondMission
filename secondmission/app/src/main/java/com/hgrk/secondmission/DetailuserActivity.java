package com.hgrk.secondmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailuserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailuser);

        ImageView btn_delete = findViewById(R.id.img_trash);
        ImageView btn_edit = findViewById(R.id.img_edit);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.userlist.remove(getIntent().getIntExtra("pos",0));
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(),AddEdit.class);
                intent.putExtra("code",AddEdit.editcode);
                intent.putExtra("pos",getIntent().getIntExtra("pos",0));
                startActivity(intent);
            }
        });
           }
}