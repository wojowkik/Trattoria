package trattoria.api;

import trattoria.dao.FileAccess;
import trattoria.model.Order;

import java.util.ArrayList;
import java.util.Scanner;
/*
class " "trattoria.model.Order Controler" is responsible for the management of specific customer orders
 */
public class OrderController
{
    private ArrayList<Order> currentOrder, allOrders;
    private Scanner scan = new Scanner(System.in);
    private FileAccess fileAccess;
    private boolean isNameEntered = false;
    private String customerName;

    public OrderController(){
        fileAccess = new FileAccess();
        currentOrder = new ArrayList<>();
        allOrders = new ArrayList<>();
    }

    //the main menu that allows you to order a specific pizza
    // and carry out the operations required for this purpose
    public void choosePizza(){
        String pizzaName, pizzaExtraInformation, key;//key is used to control the menu
        currentOrder.clear(); //current order cleared for each new user
        enterName(); //entering a username

        while (isNameEntered){
            System.out.println("Order a pizza, \n1- Margherita, 2- Capriciosa, 3- Calzone, 4- Confirm the order, 5- View the order,  0- Exit");
            key = scan.nextLine();
            if (key.equals("1"))pizzaName = "Margherita";
            else if (key.equals("2"))pizzaName = "Capriciosa";
            else if (key.equals("3"))pizzaName = "Calzone";
            else if (key.equals("4")) {
                if(currentOrder.size() != 0){
                    //if the order is not empty,
                    allOrders.addAll(currentOrder); //saving the order data
                    System.out.println("Order accepted");
                    printOrder();
                    fileAccess.save(currentOrder);  //saving the data to a text file
                    break;
                }
                else {//if the order is empty, displaying relevant information
                    System.out.println("Your order is empty");
                    continue;
                }
            }
            else if (key.equals("0")) {
                System.out.println("The order was canceled");
                break;
            }
            else if (key.equals("5")){
                printOrder();
                continue;
            }
            else {
                System.out.println("Order error - enter correct data");
                continue;
            }

            pizzaExtraInformation = extraInformationCheck();
            addOrder(pizzaName, pizzaExtraInformation);
            printOrder();
        }
    }

    //the method allows you to check whether the user wants to add additional information about the order
    //and allows you to get this information
    private String extraInformationCheck()
    {
        String key = "", extraInformation = "none";
        while (!key.equals("1") && !key.equals("2"))
        {
            System.out.println("Do you want to provide the kitchen with additional information about the order?\n1- yes\n2- no");
            key = scan.nextLine();
            if(key.equals("1")) {
                System.out.print("Enter information for the cook: ");
                extraInformation = scan.nextLine();
            }
            else if(key.equals("2")) extraInformation = "none";
            else System.out.println("Incorrect data entered");
        }
        return extraInformation;
    }

    //a method that allows you to enter the username of a given order.
    // Possible expansion with additional username validation options
    private void enterName(){
        customerName = "";
        while (customerName.equals(""))
        {
            System.out.print("Please tell us your name: ");
            customerName = scan.nextLine();
        }
        isNameEntered = true;
    }

    //the method allows you to add an order to the list of orders
    // with all the required information
    private void addOrder(String pizzaName, String extraInformation){
        Order order = new Order();
        order.setPizzaName(pizzaName);
        order.setExtraInformation(extraInformation);
        order.setCustomerName(customerName);
        currentOrder.add(order);
    }

    //the method allows you to view all orders of the current user.
    //If no order has been placed, correct information will be provided
    private void printOrder(){
        if (currentOrder.size() == 0){
            System.out.println("Your order is empty");
        }
        else {
            System.out.println("Summary of your order "+ customerName);
            for (int i=0 ; i<currentOrder.size() ; i++){
                System.out.println("Pizza "+ (i+1) +":\nType: " + currentOrder.get(i).getPizzaName() +
                        "\nExtra information: " + currentOrder.get(i).getExtraInformation() + "\n");
            }
        }
    }
}
