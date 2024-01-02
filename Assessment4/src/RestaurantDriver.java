/*
THIS CLASS IS A PART OF SUBMISSION FOR FIT1051 S2 2023 - ASSIGNMENT 4

This class is a driver class, which runs the entire takeaway order system.
It can create a new order based on customer information and fooditems.
It can deliver(remove) the most awaited order, and it can print all information
of all existing order such as name, contact, address, mealtype, and price.

Author: Param Dave
Student ID: 33586047
Version: 1.0
Some concepts were learnt from: https://www.w3schools.com/java/default.asp
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantDriver
{
    private static Order createCustomerOrder(Scanner input)
    {
//        This method creates and returns a new Order

//        Asking user details
        System.out.println("======= CUSTOMER DETAILS =======");
        System.out.print("Enter customer name: ");
        String customerName = input.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = input.nextLine();
        System.out.print("Enter delivery address: ");
        String deliveryAddress = input.nextLine();
        System.out.println();

        Order order = new Order(customerName, contactNumber, deliveryAddress);

        System.out.println("===== CREATE AN ORDER =====");
        boolean orderMore = true;
        while (orderMore)
        {
            System.out.println("Select food item:");
            System.out.println("1. Pizza");
            System.out.println("2. Pasta");
            System.out.println("3. Done adding items");
            System.out.print("Enter your choice: ");
            String foodChoice = input.nextLine();
            System.out.println();

            switch (foodChoice)
            {
                case "1":
//                    Creates a new pizza
                    Pizza pizza = createPizza(input);
                    order.addFoodItem(pizza);
                    break;

                case "2":
//                    Creates a new pasta
                    Pasta pasta = createPasta(input);
                    order.addFoodItem(pasta);
                    break;

                case "3":
//                    Complete an order then exit the loop
                    orderMore = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        System.out.println("Order added successfully!\n");
        return order;
    }

    private static Pasta createPasta(Scanner input)
    {
//        This method creates and returns a
//        pasta object with users choice of topping

//        Display available toppings for pasta
        System.out.println("Select pasta topping:\n" +
                "(you can only enter one topping for pasta)");
        for (int i = 0; i < Pasta.PastaTopping.values().length; i++)
        {
            System.out.println((i + 1) + ". " +
                    Pasta.PastaTopping.values()[i].name());
        }

//        Ask for the user's choice of topping and interpret the input
        System.out.print("Please enter your topping number (e.g. 2):");
        int toppingChoice = input.nextInt();
//            If the user input is valid, add the topping with pasta
        if (toppingChoice >= 1 &&
                toppingChoice <= Pasta.PastaTopping.values().length)
        {
            Pasta.PastaTopping selectedTopping =
                    Pasta.PastaTopping.values()[toppingChoice - 1];
            System.out.println("Pasta with " + selectedTopping.name() +
                    " topping has been added to your cart!\n");
            return new Pasta("Pasta", selectedTopping);
        }
        else
        {
            System.out.println("Invalid topping choice.");
            return null;
        }
    }

    private static Pizza createPizza(Scanner input)
    {
//        This method creates and returns a
//        pizza object with users choice of toppings

//        Display the available toppings:
        System.out.println("Select pizza toppings (separate with commas):");
        for (int i = 0; i < Pizza.PizzaTopping.values().length; i++)
        {
            System.out.println((i + 1) + ". " +
                    Pizza.PizzaTopping.values()[i].name());
        }

//        Ask for user input and create pizza accordingly
        System.out.println("For a pizza with extra toppings," +
                " enter the same number twice");
        System.out.print("Enter the topping numbers (e.g. 1,2,3): ");
        String toppingChoices = input.nextLine();
        String[] toppingChoiceArray = toppingChoices.split(",");
        List<Pizza.PizzaTopping> selectedToppings = new ArrayList<>();

        for (String topping : toppingChoiceArray)
        {
            int toppingChoice = Integer.parseInt(topping);
//            If the user input is valid, add the topping to an array
            if (toppingChoice >= 1 &&
                    toppingChoice <= Pizza.PizzaTopping.values().length)
            {
                selectedToppings.add
                        (Pizza.PizzaTopping.values()[toppingChoice - 1]);
            }
            else
            {
                System.out.println("Invalid topping choice: " + topping);
            }
        }
        System.out.println("A pizza has been added to your cart!\n");
        return new Pizza("Pizza", selectedToppings);
    }

    private static void deliverOrder(List<Order> orderList)
    {
//        This method removes the oldest order
//        from the orderList and prints its details
        if (!orderList.isEmpty())
        {
            Order oldestOrder = orderList.get(0);
            orderList.remove(oldestOrder);
            System.out.println("Delivered order details:");
            System.out.println(oldestOrder.toString());
        }
        else
        {
            System.out.println("No orders to deliver.\n");
        }
    }

    private static void displayMainMenu()
    {
        System.out.println("============= MAIN MENU =============");
        System.out.println("Please select the numbers below to make a choice");
        System.out.println("1. Enter the details of a customer order");
        System.out.println("2. Deliver an order");
        System.out.println("3. Print out details of all orders");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args)
    {
//        Define main objects
        Scanner input = new Scanner(System.in);
        List<Order> orderList = new ArrayList<>();

        while (true)
        {
            displayMainMenu();
            String choice = input.nextLine();
            System.out.println("====================================\n");

            switch (choice)
            {
                case "1":
                    Order order = createCustomerOrder(input);
                    orderList.add(order);
                    break;

                case "2":
                    deliverOrder(orderList);
                    break;

                case "3":
                    printOrderDetails(orderList);
                    break;

                case "4":
                    System.out.println("Thank you for dining with us!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please " +
                            "select a valid option.");
                    break;
            }
        }
    }

    private static void printOrderDetails(List<Order> orderList)
    {
//        This method prints all undelivered orders using toString() method
        if (!orderList.isEmpty())
        {
            System.out.println("Details of all orders:");
            for (int i = 0; i < orderList.size(); i++)
            {
                System.out.println("Order " + (i + 1) + ":");
                System.out.println(orderList.get(i).toString());
            }
        }
        else
        {
            System.out.println("There are no existing orders\n");
        }
    }
}
