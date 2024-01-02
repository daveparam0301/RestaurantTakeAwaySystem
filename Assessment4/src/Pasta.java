/*
THIS CLASS IS A PART OF SUBMISSION FOR FIT1051 S2 2023 - ASSIGNMENT 4

This class represents a foodItem called Pasta. It has several available
toppings for a pasta and a pasta can have only one topping with
its own mealType and price. A pasta object can be a part of an order.
A pasta has a price and mealType which is based on its toppings
This class extents the foodItem class and implements  PriceAndMealType

Author: Param Dave
Student ID: 33586047
Version: 1.0
Some concepts were learnt from: https://www.w3schools.com/java/default.asp
*/

public class Pasta extends FoodItem implements PriceAndMealType
{
//    Enum object type to represent pizza toppings
    public enum PastaTopping
    {
        BOLOGNESE(5.20),
        MARINARA(6.80),
        PRIMAVERA(5.20),
        TOMATO(4.0);

        private final double toppingPrice;

        PastaTopping(double toppingPrice)
        {
            this.toppingPrice = toppingPrice;
        }

        public double getToppingPrice()
        {
            return toppingPrice;
        }
    }

//    A single topping as a field
    private final PastaTopping TOPPING;

//    Constructor for a pasta object
    public Pasta(String name, PastaTopping topping)
    {
        super(name);
        this.TOPPING = topping;
//        Calculate the initial price of a pasta
        calculatePrice();
    }

//    This method overrides the getMealType method in order
//    Because pasta returns mealType based on toppings
    @Override
    public MealType getMealType()
    {
        if (TOPPING == PastaTopping.BOLOGNESE ||
                TOPPING == PastaTopping.MARINARA)
        {
            return MealType.MEAT;
        }
        else if (TOPPING == PastaTopping.PRIMAVERA)
        {
            return MealType.VEGETARIAN;
        }
        else
        {
            return MealType.VEGAN;
        }
    }

//    Similar to above, this method calculates the price
//    of the pasta based on its toppings
    @Override
    public void calculatePrice()
    {
        price = 11.50 + TOPPING.getToppingPrice();
    }
}
