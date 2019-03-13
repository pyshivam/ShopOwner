package ml.pyshivam.shop.auth;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ml.pyshivam.shop.MainActivity;
import ml.pyshivam.shop.R;
import ml.pyshivam.shop.api.ShopAPI;
import ml.pyshivam.shop.api.auth.SignupRequest;
import ml.pyshivam.shop.api.auth.SignupShopSuccess;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int READ_PHONE_STATE = 1;
    TextView signin_text_btn;

    EditText s_name_text, o_name_text, s_email_text, shop_pass_text, shop_add_text,
            s_city_text, s_state_text, s_phone_text, pin_code_in;
    Button reg_btn;

    String IMEI = null;
    private TelephonyManager telmamanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signin_text_btn = findViewById(R.id.signin_text_btn);
        s_name_text = findViewById(R.id.s_name_text);
        o_name_text = findViewById(R.id.o_name_text);
        s_email_text = findViewById(R.id.s_email_text);
        shop_pass_text = findViewById(R.id.shop_pass_text);
        shop_add_text = findViewById(R.id.shop_add_text);
        s_city_text = findViewById(R.id.s_city_text);
        s_state_text = findViewById(R.id.s_state_text);
        s_phone_text = findViewById(R.id.s_phone_text);
        pin_code_in = findViewById(R.id.pin_code_in);
        reg_btn = findViewById(R.id.reg_btn);
        telmamanger = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);


        // Here, thisActivity is the current activity
        Activity thisActivity = RegisterActivity.this;
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


        if (v.getId() == R.id.signin_text_btn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.reg_btn) {
            String s_name = s_name_text.getText().toString();
            String o_name = o_name_text.getText().toString();
            String s_email = s_email_text.getText().toString();
            String shop_pass = shop_pass_text.getText().toString();
            String shop_add = shop_add_text.getText().toString();
            String s_city = s_city_text.getText().toString();
            String s_state = s_state_text.getText().toString();
            String s_phone = s_phone_text.getText().toString();
            String pin_code = pin_code_in.getText().toString();
            if ("".equals(s_name)) {
                Toast.makeText(this, "Shop name shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(o_name)) {
                Toast.makeText(this, "Owner Name shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(s_email)) {
                Toast.makeText(this, "Email shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(shop_pass)) {
                Toast.makeText(this, "Password shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(shop_add)) {
                Toast.makeText(this, "Shop address shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(s_city)) {
                Toast.makeText(this, "City shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(s_state)) {
                Toast.makeText(this, "State shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(s_phone)) {
                Toast.makeText(this, "Phone shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(pin_code)) {
                Toast.makeText(this, "Pin code shouldn't be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (IMEI == null) {
                Toast.makeText(this, "Need READ_PHONE_STATE Permission", Toast.LENGTH_SHORT).show();
                return;
            }

            registerShop(new SignupRequest(s_name, shop_add, s_phone, pin_code, s_city, s_state, o_name, s_phone, s_email, shop_pass, IMEI));
        }

    }


    private void registerShop(SignupRequest signupRequest) {
        Call<SignupShopSuccess> signupShopSuccessCall = ShopAPI.getShopService().registerShop(signupRequest);
        signupShopSuccessCall.enqueue(new Callback<SignupShopSuccess>() {
            @Override
            public void onResponse(Call<SignupShopSuccess> call, Response<SignupShopSuccess> response) {
                if (response.code() == 200){
                    SignupShopSuccess res = response.body();
                    assert res != null;
                    Toast.makeText(RegisterActivity.this, res.getMessage() + " " + res.getToken(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SignupShopSuccess> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
