/*
THIS CLASS IS A PART OF SUBMISSION FOR FIT1051 S2 2023 - ASSIGNMENT 4

This is an abstract class for a Food item, which defines common properties
of all foodItems in this program. It contains a foodItems name, price and its
mealType. It is extended in both Pizza and Pasta classes.

Author: Param Dave
Student ID: 33586047
Version: 1.0
Some concepts were learnt from: https://www.w3schools.com/java/default.asp
*/

public abstract class FoodItem
{

//    Creating an enum to represent the meal types
    public enum MealType
    {
        MEAT, VEGETARIAN, VEGAN
    }

//    Defining common properties to all food items
    protected String name;
    protected double price;
    protected MealType mealType;

//    Constructor
    public FoodItem(String name)
    {
        this.name = name;
    }

//    Creating an abstract method to calculate the price
    public abstract void calculatePrice();

//    Getters for mealType and price
    public MealType getMealType()
    {
        return mealType;
    }

    public double getPrice()
    {
        return price;
    }
}
