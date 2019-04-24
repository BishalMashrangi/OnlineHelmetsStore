package com.oninehelmets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView fstText, secText ,tvLogin;
    private EditText edtUserName, edtPassword;
    private Button btnLogin;
    private CheckBox remPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fstText = findViewById(R.id.fstText);
        secText= findViewById(R.id.secText);
        tvLogin= findViewById(R.id.tvLogin);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        remPassword= findViewById(R.id.remPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Login(edtUserName.getText().toString(), edtPassword.getText().toString())==1)
                {
                    Toast.makeText(getApplicationContext(), "Logged In !", Toast.LENGTH_LONG).show();
                    if(! remPassword.isChecked())
                    {
                        edtPassword.setText("");
                    }
                    edtUserName.setText("");

                    //Open dashboard activity
                    startActivity(new Intent(getApplicationContext(), Admin_Dashboard.class));

                }else
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Correct Details !!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private int Login(String name, String password)
    {
        if(name.isEmpty() || password.isEmpty())
        {
            return 0;
        }else if(name.equals("Admin") && password.equals("1234"))
           {
            return 1;
           }
            return 0;

        }


    public void openRegister(View view) {
        startActivity(new Intent(this, Registration.class));
    }
}


