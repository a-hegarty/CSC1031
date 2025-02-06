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
    ArrayList<String> tags = new ArrayList<>();

    //constructor declaration
    public Product(String name, long price, boolean stocked, )
    {
        this.productName = name;
        this.price = price;
        this.inStock = stocked;
        this.tags = 
    }

    public Product() 
    {
        this.productName = "Unknown";
        this.price = 0;
        this.inStock = false;
    }



    public static void main(String[] args)
    {
        Product my_Product = new Product();
        System.out.println(my_Product.price);
    }
    
}
