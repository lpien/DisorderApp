package ur.disorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ur.disorderapp.model.Collection;

public class LoginActivity extends AppCompatActivity
{
    private Button mLoginBtn, mRegisterBtn;
    private EditText mUsername, mPassword;

    private Collection sCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sCollection = Collection.get(this.getApplicationContext());

        mLoginBtn       = (Button) findViewById(R.id.login_btn);
        mRegisterBtn    = (Button) findViewById(R.id.login_btn_register);
        mUsername       = (EditText) findViewById(R.id.login_username_hint);
        mPassword       = (EditText) findViewById(R.id.login_password_hint);

        mLoginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //check username and password from database
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                boolean check = sCollection.login(username,password);

                if(check)
                {
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Incorrect username or password", Toast.LENGTH_SHORT)
                            .show();
                    mUsername.setText("");
                    mPassword.setText("");
                }

            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //add new account to the local database
                //lead to a register screen
            }
        });



    }
}