/*
THIS INTERFACE IS A PART OF SUBMISSION FOR FIT1051 S2 2023 - ASSIGNMENT 4

This is a public interface which is implemented in
Order, Pizza, and Pasta classes.

Author: Param Dave
Student ID: 33586047
Version: 1.0
Some concepts were learnt from: https://www.w3schools.com/java/default.asp
*/

public interface PriceAndMealType
{
//    Method to get the type of meal (Vegan, Vegetarian, or Meat)
    FoodItem.MealType getMealType();

//    Method to get price of a meal
    double getPrice();
}
