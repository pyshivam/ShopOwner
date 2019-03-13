package ml.pyshivam.shop.api.auth;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupShopSuccess {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("token")
    @Expose
    private String token;


    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    @SerializedName("shop_id")
    @Expose
    private String shop_id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}