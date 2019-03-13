package ml.pyshivam.shop.api.auth;

public class SigninRequest {

    /**
     *
     * {
     * "email": "pyshivam.py@gmail.com",
     * "password": "girlfriend",
     * "imei": 98745632145698,
     * }
     *
     *
     */

    private String email;
    private String password;
    private String imei;

    public SigninRequest(String email, String password, String imei) {
        this.email = email;
        this.password = password;
        this.imei = imei;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }


}
