package ml.pyshivam.shop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ml.pyshivam.shop.api.ShopAPI;
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
    private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg_text_btn = findViewById(R.id.reg_here);
        signin_btn = findViewById(R.id.signin_btn);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        SharedPreferences sharedPreferences = getSharedPreferences(Common.MAIN, 0);
        sharedPrefs = new SharedPrefs(sharedPreferences);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.reg_here){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.signin_btn){
            String email = email_input.getText().toString();
            String pass = password_input.getText().toString();
            if ("".equals(email)) {
                Toast.makeText(this, "Email should not be empty.", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("".equals(pass)){
                Toast.makeText(this, "Password should not be empty.", Toast.LENGTH_SHORT).show();
                return;
            }



            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }
    }


    public void loginShop(SigninRequest signinRequest){
        Call<LoginRequestSuccess> loginRequestSuccessCall = ShopAPI.getShopService().loginShop(signinRequest);
        loginRequestSuccessCall.enqueue(new Callback<LoginRequestSuccess>() {
            @Override
            public void onResponse(Call<LoginRequestSuccess> call, Response<LoginRequestSuccess> response) {

            }

            @Override
            public void onFailure(Call<LoginRequestSuccess> call, Throwable t) {

            }
        });
    }
}
