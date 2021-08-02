package trattoria.api;

import java.util.Scanner;

/*
First menu. It allows you to go to the order and close the application
In the event of entering unexpected data, an appropriate message is sent to the user
 */
public class AppController
{
    Scanner scan;
    OrderController orderController;
    public AppController() {
        scan = new Scanner(System.in);
        orderController = new OrderController();
    }

    public void start() {
        String key="";
        while (!key.equals("0")){
            System.out.println("\nTrattoria\nDo you want to place an order?\n1- Order a pizza, 0- Exit");

            key = scan.nextLine();
            if (key.equals("1")){
                orderController.choosePizza();
            }
            else if (key.equals("0")){
                System.out.println("Thank you for shopping");
            }
            else {
                System.out.println("Incorrect data entered");
            }
        }
    }
}
