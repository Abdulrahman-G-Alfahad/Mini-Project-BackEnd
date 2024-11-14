package CodedBTA.mini_project.bo;

public class UpdateProfileRequest {
    private String userName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;


    public UpdateProfileRequest(String userName, String email, String phoneNumber, String address, String password) {
        this.userName = userName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}




