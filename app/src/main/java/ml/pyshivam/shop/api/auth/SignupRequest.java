package ml.pyshivam.shop.api.auth;

public class SignupRequest {
//    {
//        "shop_name": "pyshivam",
//            "shop_address": "some where",
//            "shop_telephone": 98974666565,
//            "shop_pin_code": 789855,
//            "shop_city": "mumabi",
//            "shop_state": "maharashtra",
//            "owner_name": "Shivam",
//            "owner_pno": 9965889659,
//            "owner_email": "pyshivam.py@gmail.com",
//            "owner_password": "girlfriend",
//            "imei": 98745632145698,
//            "hash": "32125d2ea2008777404f2d6eb610757d"
//    }

    public SignupRequest(String shop_name, String shop_address, String shop_telephone, String shop_pin_code, String shop_city, String shop_state, String owner_name, String owner_pno, String owner_email, String owner_password, String imei) {
        this.shop_name = shop_name;
        this.shop_address = shop_address;
        this.shop_telephone = shop_telephone;
        this.shop_pin_code = shop_pin_code;
        this.shop_city = shop_city;
        this.shop_state = shop_state;
        this.owner_name = owner_name;
        this.owner_pno = owner_pno;
        this.owner_email = owner_email;
        this.owner_password = owner_password;
        this.imei = imei;
    }

    private String shop_name;
    private String shop_address;
    private String shop_telephone;
    private String shop_pin_code;

    private String shop_city;
    private String shop_state;
    private String owner_name;
    private String owner_pno;

    private String owner_email;
    private String owner_password;
    private String imei;

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_telephone() {
        return shop_telephone;
    }

    public void setShop_telephone(String shop_telephone) {
        this.shop_telephone = shop_telephone;
    }

    public String getShop_pin_code() {
        return shop_pin_code;
    }

    public void setShop_pin_code(String shop_pin_code) {
        this.shop_pin_code = shop_pin_code;
    }

    public String getShop_city() {
        return shop_city;
    }

    public void setShop_city(String shop_city) {
        this.shop_city = shop_city;
    }

    public String getShop_state() {
        return shop_state;
    }

    public void setShop_state(String shop_state) {
        this.shop_state = shop_state;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_pno() {
        return owner_pno;
    }

    public void setOwner_pno(String owner_pno) {
        this.owner_pno = owner_pno;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }

    public String getOwner_password() {
        return owner_password;
    }

    public void setOwner_password(String owner_password) {
        this.owner_password = owner_password;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }


}
