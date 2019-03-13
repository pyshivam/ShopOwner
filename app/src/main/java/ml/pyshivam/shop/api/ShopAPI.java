package ml.pyshivam.shop.api;


import ml.pyshivam.shop.api.auth.LoginRequestSuccess;
import ml.pyshivam.shop.api.auth.SigninRequest;
import ml.pyshivam.shop.api.auth.SignupRequest;
import ml.pyshivam.shop.api.auth.SignupShopSuccess;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class ShopAPI {
    private static final String BASE_URL = "http://udhar.pyshivam.ml/";

    public static ShopService shopService = null;

    public static ShopService getShopService() {
        if (shopService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            shopService = retrofit.create(ShopService.class);
        }

        return shopService;
    }

    public interface ShopService {

        @POST("/singup_shop")
        Call<SignupShopSuccess> registerShop(@Body SignupRequest signupRequest);

        @POST("/login_shop")
        Call<LoginRequestSuccess> loginShop(@Body SigninRequest signinRequest);

    }


}