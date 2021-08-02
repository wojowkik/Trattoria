package trattoria.model;

/*
the class contains the information that will be used to process each order
 */
public class Order
{
    private String pizzaName, extraInformation, customerName;

    public String getPizzaName() {
        return pizzaName;
    }

    //the method checks if the given data matches the list of available types of pizza
    public void setPizzaName(String pizzaName) {
        if (pizzaName.equals("Margherita") || pizzaName.equals("Capriciosa") || pizzaName.equals("Calzone")){
            this.pizzaName = pizzaName;
        }
        else {
            this.pizzaName = "Unknown pizza";
        }
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
