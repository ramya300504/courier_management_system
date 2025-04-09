package Entity;

public class HomeLoan extends Loan{
    private String  propertyAddress;
    private int propertyValue;

    public HomeLoan(String propertyAddress, int propertyValue) {
        this.propertyAddress = propertyAddress;
        this.propertyValue = propertyValue;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public String toString() {
        return "propertyAddress='" + propertyAddress + '\'' +
                ", propertyValue=" + propertyValue ;
    }
}
