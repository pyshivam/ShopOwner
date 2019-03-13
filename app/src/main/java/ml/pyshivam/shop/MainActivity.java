package ml.pyshivam.shop;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.TrustAnchor;

import ml.pyshivam.shop.api.ShopAPI;
import ml.pyshivam.shop.api.auth.Data;
import ml.pyshivam.shop.api.auth.LoginRequestSuccess;
import ml.pyshivam.shop.api.auth.SigninRequest;
import ml.pyshivam.shop.auth.RegisterActivity;
import ml.pyshivam.shop.dashboard.DashboardActivity;
import ml.pyshivam.shop.utils.Common;
import ml.pyshivam.shop.utils.SharedPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView reg_text_btn;
    Button signin_btn;
    EditText email_input, password_input;
    private static final int READ_PHONE_STATE = 1;
    String IMEI = null;
    private SharedPrefs sharedPrefs;
    private TelephonyManager telmamanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(Common.MAIN, 0);
        sharedPrefs = new SharedPrefs(sharedPreferences);
        if (sharedPrefs.getBoolean(Common.IS_LOGGED)){
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_main);
        reg_text_btn = findViewById(R.id.reg_here);
        signin_btn = findViewById(R.id.signin_btn);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);

        telmamanger = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        // Here, thisActivity is the current activity
        Activity thisActivity = MainActivity.this;
        if (ContextCompat.checkSelfPermission(thisActivity,
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(thisActivity,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    READ_PHONE_STATE);

        } else {
            IMEI = telmamanger.getDeviceId();
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.reg_here) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.signin_btn) {
            String email = email_input.getText().toString();
            String pass = password_input.getText().toString();
            if ("".equals(email)) {
                Toast.makeText(this, "Email should not be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(pass)) {
                Toast.makeText(this, "Password should not be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (IMEI == null) {
                Toast.makeText(this, "Need READ_PHONE_STATE permission", Toast.LENGTH_SHORT).show();
                return;
            }


            loginShop(new SigninRequest(email, pass, IMEI));

        }
    }


    public void loginShop(SigninRequest signinRequest) {
        Call<LoginRequestSuccess> loginRequestSuccessCall = ShopAPI.getShopService().loginShop(signinRequest);
        loginRequestSuccessCall.enqueue(new Callback<LoginRequestSuccess>() {
            @Override
            public void onResponse(Call<LoginRequestSuccess> call, Response<LoginRequestSuccess> response) {
                if (response.code() == 200) {
                    LoginRequestSuccess res = response.body();
                    assert res != null;
                    Toast.makeText(MainActivity.this, res.getStatus() + " ", Toast.LENGTH_SHORT).show();
                    Data data = res.getData();
                    sharedPrefs.putString(Common.EMAIL, data.getOwnerEmail());
                    sharedPrefs.putString(Common.SHOP_NAME, data.getShopName());
                    sharedPrefs.putString(Common.SHOP_ADD, data.getShopAddress());
                    sharedPrefs.putString(Common.SHOP_CITY, data.getShopCity());
                    sharedPrefs.putString(Common.SHOP_ID, data.getShopId());
                    sharedPrefs.putString(Common.SHOP_STATE, data.getShopState());
                    sharedPrefs.putString(Common.SHOP_PIN_CODE, String.valueOf(data.getShopPinCode()));
                    sharedPrefs.putString(Common.SHOP_PHONE, String.valueOf(data.getShopTelephone()));
                    sharedPrefs.putString(Common.OWNER_EMAIL, data.getOwnerEmail());
                    sharedPrefs.putString(Common.OWNER_NAME, data.getOwnerName());
                    sharedPrefs.putString(Common.OWNER_PHONE, String.valueOf(data.getOwnerPno()));
                    sharedPrefs.putString(Common.IMEI, String.valueOf(data.getImei()));
                    sharedPrefs.putString(Common.SESSION_TOKEN, data.getSessionToken());
                    sharedPrefs.putBoolean(Common.IS_LOGGED, true);
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Error occurred." + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginRequestSuccess> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error occurred." + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.

                        Toast.makeText(this, "Need READ_PHONE_STATE permission for registration", Toast.LENGTH_SHORT).show();

                        return;
                    }
                    IMEI = telmamanger.getDeviceId();
                } else {
                    Toast.makeText(this, "Need READ_PHONE_STATE permission for registration", Toast.LENGTH_SHORT).show();
                }
                break;

            }
        }
    }
}
