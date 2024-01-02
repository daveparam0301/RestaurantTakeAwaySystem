/*
THIS CLASS IS A PART OF SUBMISSION FOR FIT1051 S2 2023 - ASSIGNMENT 4

This class represents a foodItem called Pizza. It has several available
toppings for a pizza and a pizza can have multiple toppings each with
their own mealType and price. A pizza object can be a part of an order.
A pizza has a price and mealType which is based on its toppings
This class extents the foodItem class and implements PriceAndMealType

Author: Param Dave
Student ID: 33586047
Version: 1.0
Some concepts were learnt from: https://www.w3schools.com/java/default.asp
*/

import java.util.List;

public class Pizza extends FoodItem implements PriceAndMealType
{
//    Enum object type to represent pizza toppings
    public enum PizzaTopping
    {
        HAM(2.0),
        CHEESE(2.0),
        PINEAPPLE(2.5),
        MUSHROOMS(2.0),
        TOMATO(2.0),
        SEAFOOD(3.5);

        private final double toppingPrice;

        PizzaTopping(double toppingPrice)
        {
            this.toppingPrice = toppingPrice;
        }

        public double getToppingPrice()
        {
            return toppingPrice;
        }
    }

//    List of pizza toppings
    private List<PizzaTopping> toppings;

//    Constructor for a pizza object
    public Pizza(String name, List<PizzaTopping> toppings)
    {
        super(name);
        this.toppings = toppings;
//        Calculating the initial price of a pizza
        calculatePrice();
    }

//    This method overrides the getMealType method in order
//    Because pizza returns mealType based on toppings
    @Override
    public MealType getMealType()
    {
        if (toppings.contains(PizzaTopping.HAM) ||
                toppings.contains(PizzaTopping.SEAFOOD))
        {
            return MealType.MEAT;
        }
        else if (toppings.contains(PizzaTopping.CHEESE))
        {
            return MealType.VEGETARIAN;
        }
        else
        {
            return MealType.VEGAN;
        }
    }

//    Similar to above, this method calculates the price
//    of the pizza based on its toppings
    @Override
    public void calculatePrice()
    {
        price = 11.50;

        for (PizzaTopping topping : toppings)
        {
            price += topping.getToppingPrice();
        }
    }
}