package com.krish.Krishnan;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity {

    Button b1, b2, b3;
    EditText e1, e2;
    String name, college;
    SQLiteDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR,college VARCHAR);");


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name = e1.getText().toString();
                college = e2.getText().toString();
                db.execSQL("INSERT INTO student VALUES('" + name + "','" + college + "');");
                Toast.makeText(getApplicationContext(),"ROW INSERTED",Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(getApplicationContext(),My2Activity.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.exit(0);
            }
        });

    }
}