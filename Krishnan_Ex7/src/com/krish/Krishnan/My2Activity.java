package com.krish.Krishnan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.krish.Krishnan.R;


public class My2Activity extends Activity {
    Button prev,next,home;
    EditText e3,e4;
    SQLiteDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        prev=(Button)findViewById(R.id.button4);
        next=(Button)findViewById(R.id.button5);
        home=(Button)findViewById(R.id.button6);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);



        db=openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        final Cursor c=db.rawQuery("select * from student",null);
        c.moveToFirst();
        e3.setText(c.getString(c.getColumnIndex("name")));
        e4.setText(c.getString(c.getColumnIndex("college")));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getApplicationContext(),MyActivity.class);
                startActivity(j);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    c.moveToPrevious();
                    e3.setText(c.getString(c.getColumnIndex("name")));
                    e4.setText(c.getString(c.getColumnIndex("college")));
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"First Record",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    c.moveToNext();
                    e3.setText(c.getString(c.getColumnIndex("name")));
                    e4.setText(c.getString(c.getColumnIndex("college")));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Last Record", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });


    }
}