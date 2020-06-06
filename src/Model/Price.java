package Model;

//POJO to handle price data
public class Price {

    Price()
    {
        value =0.00;
        currency= "UNSET";
    }

    Price(double value, String currency)
    {
        this.value = value;
        this.currency = currency;
    }

    private double value;
    private String currency;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
