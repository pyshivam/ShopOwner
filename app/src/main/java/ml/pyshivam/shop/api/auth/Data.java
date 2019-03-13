
package ml.pyshivam.shop.api.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("imei")
    @Expose
    private Integer imei;
    @SerializedName("owner_email")
    @Expose
    private String ownerEmail;
    @SerializedName("owner_name")
    @Expose
    private String ownerName;
    @SerializedName("owner_pno")
    @Expose
    private Integer ownerPno;
    @SerializedName("session_token")
    @Expose
    private String sessionToken;
    @SerializedName("shop_address")
    @Expose
    private String shopAddress;
    @SerializedName("shop_city")
    @Expose
    private String shopCity;
    @SerializedName("shop_id")
    @Expose
    private String shopId;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_pin_code")
    @Expose
    private Integer shopPinCode;
    @SerializedName("shop_state")
    @Expose
    private String shopState;
    @SerializedName("shop_telephone")
    @Expose
    private Integer shopTelephone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getImei() {
        return imei;
    }

    public void setImei(Integer imei) {
        this.imei = imei;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getOwnerPno() {
        return ownerPno;
    }

    public void setOwnerPno(Integer ownerPno) {
        this.ownerPno = ownerPno;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopCity() {
        return shopCity;
    }

    public void setShopCity(String shopCity) {
        this.shopCity = shopCity;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopPinCode() {
        return shopPinCode;
    }

    public void setShopPinCode(Integer shopPinCode) {
        this.shopPinCode = shopPinCode;
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState;
    }

    public Integer getShopTelephone() {
        return shopTelephone;
    }

    public void setShopTelephone(Integer shopTelephone) {
        this.shopTelephone = shopTelephone;
    }

}
