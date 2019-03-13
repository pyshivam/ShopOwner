package ml.pyshivam.shop.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ml.pyshivam.shop.MainActivity;
import ml.pyshivam.shop.R;
import ml.pyshivam.shop.utils.Common;
import ml.pyshivam.shop.utils.SharedPrefs;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    Button add_due_btn;
    TextView shop_name, shop_address;
    private SharedPrefs sharedPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        add_due_btn = findViewById(R.id.add_due_btn);
        SharedPreferences sharedPreferences = getSharedPreferences(Common.MAIN, 0);
        sharedPrefs = new SharedPrefs(sharedPreferences);
        shop_name = findViewById(R.id.shop_name);
        shop_address = findViewById(R.id.shop_address);
        shop_name.setText(sharedPrefs.getString(Common.SHOP_NAME));
        shop_address.setText(sharedPrefs.getString(Common.SHOP_ADD));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logout_btn){
            sharedPrefs.putBoolean(Common.IS_LOGGED, false);
            sharedPrefs.clear();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.shop_info_btn){
            ShopInfoDialog shopInfoDialog = new ShopInfoDialog();
            shopInfoDialog.show(getSupportFragmentManager(), "ShopINfo");
        }
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

}
