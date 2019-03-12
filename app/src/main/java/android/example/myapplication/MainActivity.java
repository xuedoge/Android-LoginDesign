package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
    }

    public void btnRegister_onClick(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("UsersInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText et_email = findViewById(R.id.email);
        EditText et_password = findViewById(R.id.password);

        editor.putString("email", et_email.getText().toString());
        editor.putString("password", et_password.getText().toString());

        editor.commit();

        Toast showToast=Toast.makeText(this, "success", Toast.LENGTH_SHORT);
        showToast.setGravity(Gravity.BOTTOM, 0, 0);
        showToast.show();
    }
    public void btnLinkToLoginScreen_onClick(View view){
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}
