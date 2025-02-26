/*  program name: Product.java
//author: aoibhe
//date: 05/02/2025
//input; */

import java.util.ArrayList;
import java.util.List;

public class Product 
{
    String productName;
    long price;
    boolean inStock;
    ArrayList<String> tags;

    //default constructor
    public Product() 
    {
        this.productName = "Unknown";
        this.price = 0;
        this.inStock = false;
        //this.tags = new ArrayList<java.util.Collections.emptyList>();
    }

    //constructor declaration
    public Product(String name, long price, boolean stocked, List<String> newtags)
    {
        this.productName = name;
        this.price = price;
        this.inStock = stocked;
        this.tags = new ArrayList<String>();
    }



    public static void main(String[] args)
    {
        Product my_Product = new Product("pears", 5, true, new ArrayList<>());
        System.out.println(my_Product.productName);
        System.out.println(my_Product.price);
        System.out.println(my_Product.inStock);
        System.out.println(my_Product.tags);
    }
    
}
