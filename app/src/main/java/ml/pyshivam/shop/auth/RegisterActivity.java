package ml.pyshivam.shop.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ml.pyshivam.shop.MainActivity;
import ml.pyshivam.shop.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView signin_text_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signin_text_btn = findViewById(R.id.signin_text_btn);
    }


    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.signin_text_btn){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
