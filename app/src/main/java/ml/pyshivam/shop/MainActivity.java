package ml.pyshivam.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ml.pyshivam.shop.auth.RegisterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView reg_text_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg_text_btn = findViewById(R.id.reg_here);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.reg_here){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}
