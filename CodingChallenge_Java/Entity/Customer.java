package Entity;

public class Customer {
    private int Customer_ID;
    private String Name;
    private String Email_Address;
    private  String Phone_Number;
    private String Address;
    private  int creditScore;

    public Customer(int customer_ID, String name, String email_Address, String phone_Number, String address, int creditScore) {
        Customer_ID = customer_ID;
        Name = name;
        Email_Address = email_Address;
        Phone_Number = phone_Number;
        Address = address;
        this.creditScore = creditScore;
    }

    public Customer() {

    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return
                "Customer_ID=" + Customer_ID +
                ", Name='" + Name + '\'' +
                ", Email_Address='" + Email_Address + '\'' +
                ", Phone_Number='" + Phone_Number + '\'' +
                ", Address='" + Address + '\'' +
                ", creditScore=" + creditScore;
    }
}
