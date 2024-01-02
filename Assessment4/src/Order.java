/*
THIS CLASS IS A PART OF SUBMISSION FOR FIT1051 S2 2023 - ASSIGNMENT 4

This Class stores the customer information for an order,
adds fooditem to an order, calculates price of an order, and prints
the details of an order using a toString() method.

Author: Param Dave
Student ID: 33586047
Version: 1.0
Some concepts were learnt from: https://www.w3schools.com/java/default.asp
*/

import java.util.ArrayList;
import java.util.List;

public class Order implements PriceAndMealType
{
//    Customer details, list of foodItems, and price as fields
    private final String CUSTOMER_NAME;
    private final String CONTACT_NUMBER;
    private final String DELIVERY_ADDRESS;
    private List<FoodItem> foodItems;
    private double price;

//    Order constructor
    public Order(String CUSTOMER_NAME,
                 String CONTACT_NUMBER, String DELIVERY_ADDRESS)
    {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
        this.CONTACT_NUMBER = CONTACT_NUMBER;
        this.DELIVERY_ADDRESS = DELIVERY_ADDRESS;
        this.foodItems = new ArrayList<>();
    }


    public void addFoodItem(FoodItem foodItem)
    {
//        Method to add foodItem to the order and update the price
        foodItems.add(foodItem);
        calculatePrice();
    }

    private void calculatePrice()
    {
//        Calculate the total price of an order
        price = 0;
        for (FoodItem foodItem : foodItems)
        {
            price += foodItem.getPrice();
        }
    }

//    Accessor methods for customer information
    public String getContactNumber()
    {
        return CONTACT_NUMBER;
    }

    public String getCustomerName()
    {
        return CUSTOMER_NAME;
    }

    public String getDeliveryAddress()
    {
        return DELIVERY_ADDRESS;
    }

//    Creating methods to override methods in the PriceAndMealType interface
    @Override
    public FoodItem.MealType getMealType()
    {
//        Determine the meal type based on the food items in the order
        boolean hasMeat = false;
        boolean hasVegetarian = false;

        for (FoodItem foodItem : foodItems)
        {
            if (foodItem.getMealType() == FoodItem.MealType.MEAT)
            {
                hasMeat = true;
            }
            else if (foodItem.getMealType() == FoodItem.MealType.VEGETARIAN)
            {
                hasVegetarian = true;
            }
        }

        if (hasMeat)
        {
            return FoodItem.MealType.MEAT;
        }
        else if (hasVegetarian)
        {
            return FoodItem.MealType.VEGETARIAN;
        }
        else
        {
            return FoodItem.MealType.VEGAN;
        }
    }

    @Override
    public double getPrice()
    {
        return price;
    }

//    Overriding the toString method in object class
    @Override
    public String toString()
    {
        return "Customer Name: " + CUSTOMER_NAME + "\n" +
                "Contact Number: " + CONTACT_NUMBER + "\n" +
                "Delivery Address: " + DELIVERY_ADDRESS + "\n" +
                "Total Cost: $" + price + "\n" +
                "Meal Type: " + getMealType() + "\n";
    }

}
