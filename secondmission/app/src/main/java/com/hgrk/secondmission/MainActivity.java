package com.hgrk.secondmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hgrk.secondmission.Model.UserHa;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rUserHa;
    FloatingActionButton fab;
    public static ArrayList<UserHa> userlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.addbutton);
        rUserHa = findViewById(R.id.vUserHa);
        rUserHa.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter adapter = new UserAdapter(userlist, this);
        TextView data =  (TextView) findViewById(R.id.data);
        rUserHa.setAdapter(adapter);
        if(userlist.size()<1){

          data.setVisibility(View.VISIBLE);
        }else{
            data.setVisibility(View.INVISIBLE);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddEdit.class);
                intent.putExtra("code",AddEdit.createcode);
                startActivity(intent);
            }
        });
    }
}