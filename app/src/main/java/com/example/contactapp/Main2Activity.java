package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
 MyDatabase myDatabase;
 ImageButton im_b_ex,im_b_add;
 EditText et_kindNum,et_name,et_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDatabase=new MyDatabase(this);
         im_b_ex=findViewById(R.id.im_b_ex);
        im_b_add=findViewById(R.id.im_b_add);
        et_kindNum=findViewById(R.id.et_kindNum);
        et_name=findViewById(R.id.et_name);
        et_number=findViewById(R.id.et_number);

        im_b_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        im_b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kindNum=et_kindNum.getText().toString();
                String name=et_name.getText().toString();
                String number=et_number.getText().toString();
                if (kindNum.length() ==0 ||name.length()==0||number.length()==0) toastMess();
                else if(!kindNum.toLowerCase().equals("vodafone")&&!kindNum.toLowerCase().equals("we")
                && !kindNum.toLowerCase().equals("orange")&& !kindNum.toLowerCase().equals("etislate")
                        || number.length() !=11) {
                    toastMessError();
                } else {
                    myDatabase.insert(new UserData(name,number,kindNum));
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }

            }
        });
    }
    public void toastMess(){
        Toast.makeText(this,"Please Enter All Data ",Toast.LENGTH_LONG).show();
    }
    public void toastMessError(){
        Toast.makeText(this,"Error in data",Toast.LENGTH_LONG).show();
    }
}
