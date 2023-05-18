/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package online_store;

import java.util.ArrayList;

/**
 *
 * @author Fouad obaid
 */
public class Customer {
    private int customerId;
    private String customerName;
    private ArrayList<Item> shoppingCart;
    
    
       Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.shoppingCart = new ArrayList<>();
    }

    Customer() {
        
    }

    

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
        

  
    
            public void addItemToCart(Item item) {
                shoppingCart.add(item);
        
    }
           public void removeItemFromCart(Item itemId) {
        shoppingCart.remove(itemId);
    }

    public void viewCart() {
        if (shoppingCart.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart Items:");
            for (Item item : shoppingCart) {
                System.out.println(item.getItemId() + " - " + item.getItemName() + " - " + item.getItemPrice() + " - " + item.getItemQuantity());
            }
        }
    }

    public void emptyCart() {
        shoppingCart.clear();
        System.out.println("Customer cart emptied.");
    }
    
}
