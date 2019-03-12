package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_register);
        setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
    }
    public void btnRegister (View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
    public void btnLogin (View view){
        SharedPreferences sharedPreferences = getSharedPreferences("UsersInfo",MODE_PRIVATE);
        String account = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");

        EditText et_email = findViewById(R.id.email);
        EditText et_password = findViewById(R.id.password);

        if(account.equals(et_email.getText().toString()) && password .equals( et_password.getText().toString())){
            Toast showToast=Toast.makeText(this, "success", Toast.LENGTH_SHORT);
            showToast.setGravity(Gravity.BOTTOM, 0, 0);
            showToast.show();

            Intent intent = new Intent();
            intent.setClass(this, Home.class);
            startActivity(intent);
            this.finish();
        }
        else{
            Toast showToast=Toast.makeText(this, "failure", Toast.LENGTH_SHORT);
            showToast.setGravity(Gravity.BOTTOM, 0, 0);
            showToast.show();
        }
    }
}
