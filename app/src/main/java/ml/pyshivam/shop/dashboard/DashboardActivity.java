package ml.pyshivam.shop.dashboard;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ml.pyshivam.shop.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    Button add_due_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        add_due_btn = findViewById(R.id.add_due_btn);

    }

    @Override
    public void onClick(View v) {

    }

}
