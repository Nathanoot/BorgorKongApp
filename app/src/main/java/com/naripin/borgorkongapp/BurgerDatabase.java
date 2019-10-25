package com.naripin.borgorkongapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BurgerDatabase {

    //Retrieves a BurgerItem object using the provided id.
    public static BurgerItem getBurgerItemById(int burgerID) {
        return burgers.get(burgerID);
    }

    // Return an ArrayList containing all the burgers in the database.
    public static ArrayList<BurgerItem> getAllBurgers() {
        return new ArrayList<BurgerItem>((List) Arrays.asList(burgers.values().toArray()));
    }

    // Set up the hash map data structure to store the burger data
    private static final HashMap<Integer, BurgerItem> burgers = new HashMap<>();

    // Adding burger data into the hash map
    static {
        burgers.put(1, new BurgerItem(
                1,
                "Kong Burger",
                5.00,
                "Burger that contains a 99% ground beef patty, cheese, onions, pickles and special borger kong sauce. Served on a sesame seed bun from our artisan bakery in Dubai.",
                R.drawable.burger1
        ));

        burgers.put(2, new BurgerItem(
                2,
                "Wagyu Beef Burger",
                10.50,
                "Burger that contains two wagyu beef, cheese, bacon, tomatoes, lettuce and kong mayonnaise sauce.",
                R.drawable.burger2
        ));

        burgers.put(3, new BurgerItem(
                3,
                "Grilled Chicken Burger",
                7.00,
                "Burger that contains a grilled chicken breast from a free range chicken, tomatoes, lettuce and kong mayonnaise sauce.",
                R.drawable.burger3
        ));

        burgers.put(4, new BurgerItem(
                4,
                "Crispy Chicken Burger",
                7.00,
                "Burger that contains a double fried chicken breast from a free range chicken, cos lettuce and kong mayonnaise sauce.",
                R.drawable.burger4
        ));

        burgers.put(5, new BurgerItem(
                5,
                "Fish Burger",
                8.50,
                "Burger that contains a freshly caught cod fillet which has been fried, cheese, tomatoes,cos lettuce and kong mayonnaise sauce. ",
                R.drawable.burger5
        ));

        burgers.put(6, new BurgerItem(
                6,
                "Fish Finger Burger",
                6.50,
                "Popular kids burger that contains 3 fish fingers made from hake and battered in polenta, cos lettuce and kong mayonnaise.",
                R.drawable.burger6
        ));

        burgers.put(7, new BurgerItem(
                7,
                "Mozzarella Burger",
                4.00,
                "For the vegetarians, the burger contains a mozzarella patty with lettuce and velveeta cheese sauce.",
                R.drawable.burger7
        ));

        burgers.put(8, new BurgerItem(
                8,
                "Breakfast Beef Burger",
                7.50,
                "Burger that contains a beef sausage patty, with cheese, egg, and ketchup.",
                R.drawable.burger8
        ));

        burgers.put(9, new BurgerItem(
                9,
                "Bacon and Egg Burger",
                5.00,
                "Burger that contains bacon, egg and barbecue sauce",
                R.drawable.burger9
        ));

        burgers.put(10, new BurgerItem(
                10,
                "Shrimp Burger",
                8.00,
                "Burger that contains a shrimp patty, cheese, cos lettuce, radicchio, and special borger kong sauce.",
                R.drawable.burger10
        ));

        burgers.put(11, new BurgerItem(
                11,
                "Charcoal Beef Burger",
                10.00,
                "Burger that contains a charcoal seeded bun with beef patties, bacon, cheese, tomato and ketchup.",
                R.drawable.burger11
        ));

        burgers.put(12, new BurgerItem(
                12,
                "Sunshine Sandwich",
                8.00,
                "Burger on sandwich buns, that contains a crispy chicken patty, bacon, cheese, lettuce, and Australian pineapple, with kong mayonnaise.",
                R.drawable.burger12
        ));

        burgers.put(13, new BurgerItem(
                13,
                "Monster Burger",
                16.50,
                "Burger with a 1kg wagyu beef patty, egg, bacon, spinach and kong special sauce.",
                R.drawable.burger13
        ));

        burgers.put(14, new BurgerItem(
                14,
                "Breakfast Burger",
                9.50,
                "Burger with brioche toast slices, mozzarella patty, sausage burger, cheese, tomato, lettuce, pickles and special kong sauce.",
                R.drawable.burger14
        ));

        burgers.put(15, new BurgerItem(
                15,
                "Pork Burger",
                8.00,
                "Burger that contains pork patty covered in teriyaki sauce, lettuce and mayonnaise",
                R.drawable.burger15
        ));

        burgers.put(16, new BurgerItem(
                16,
                "Donut Burger",
                7.50,
                "Burger with bacon, egg, cheese and sandwiched between two glazed donuts.",
                R.drawable.burger16
        ));

        burgers.put(17, new BurgerItem(
                17,
                "Spicy Burger",
                8.50,
                "Burger that contains crumbed chicken covered in chili sauce with pickles, jalapenos and blue cheese sauce.",
                R.drawable.burger17
        ));
    }
}
