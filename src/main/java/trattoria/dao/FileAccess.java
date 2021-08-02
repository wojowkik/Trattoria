package trattoria.dao;

import trattoria.model.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
class that allows you to write order data to a text file
data is appended to the end of the existing file
 */
public class FileAccess
{
    private int counter=1;
    public void save(ArrayList<Order> input){
        StringBuilder data = new StringBuilder("Order " + (counter++) + "\n");
        for (Order order : input) {
            data.append("\tPizza Name: ").append(order.getPizzaName()).append("\n");
            data.append("\tPizza Extra Information: ").append(order.getExtraInformation()).append("\n");
            data.append("\tCustomer Name: ").append(order.getCustomerName()).append("\n\n");
        }

        try {
            FileWriter myWriter = new FileWriter("src\\main\\java\\trattoria\\orders.txt", true);
            myWriter.write(data.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

