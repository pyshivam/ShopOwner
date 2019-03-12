package ml.pyshivam.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ml.pyshivam.shop.auth.RegisterActivity;
import ml.pyshivam.shop.dashboard.DashboardActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView reg_text_btn;
    Button signin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg_text_btn = findViewById(R.id.reg_here);
        signin_btn = findViewById(R.id.signin_btn);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.reg_here){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.signin_btn){
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }
    }
}
