package com.example.user.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText uname;
    EditText pswd;
    Button btn_login;
    TextView link_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = (EditText) findViewById(R.id.username);
        pswd = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        link_signup=(TextView)findViewById(R.id.link_signup);

        DbHandler db = new DbHandler(getApplicationContext());
        final List<User> user = db.getAllUsers();

        if (user.size() == 0) {
            User u = new User("admin", "admin");
            db.addUser(u);
        }

        db.close();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uname.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter your username", Toast.LENGTH_LONG).show();
                } else if (pswd.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_LONG).show();
                } else {
                    DbHandler db = new DbHandler(getApplicationContext());

                    final List<User> user = db.getAllUsers();
                    String username = uname.getText().toString().trim();
                    String password = pswd.getText().toString().trim();

                    if (username.equals(user.get(0).getUsername()) && password.equals(user.get(0).getPassword())) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else if (username.equals(user.get(0).getUsername()) && !password.equals(user.get(0).getPassword())) {
                        pswd.setText("");
                        Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    } else if (!username.equals(user.get(0).getUsername())) {
                        Toast.makeText(LoginActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}




