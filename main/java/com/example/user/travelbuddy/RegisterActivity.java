package com.example.user.travelbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText uname;
    EditText pswd;
    EditText pswd2;
    Button btn_signup;
    TextView link_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uname = (EditText) findViewById(R.id.input_name);
        pswd = (EditText) findViewById(R.id.input_password);
        pswd2=(EditText) findViewById(R.id.input_password2);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        link_login=(TextView)findViewById(R.id.link_login);

        btn_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pswd.getText().toString();
                String password2 = pswd2.getText().toString();

                if ((password).equals(password2)) {
                    DbHandler db = new DbHandler(getApplicationContext());
                    final List<User> user = db.getAllUsers();

                    User u = new User("username", "password");
                    db.addUser(u);

                    db.close();

                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(RegisterActivity.this);

                    dlgAlert.setMessage("You have successfully created a new account!");
                    dlgAlert.setTitle("Registration");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
                else{
                    pswd.setText("");
                    pswd2.setText("");
                    Toast.makeText(RegisterActivity.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });



    }
}
