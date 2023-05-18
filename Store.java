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
public class Store {
    private ArrayList<Item> items; // Store items
    private ArrayList<Customer> customers; // Store customers
    private int lastCustomerNumber = 0; // Last customer number

    // Constructor for the Store class
    public Store() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Method to add an item to the store
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added to the store: " + item.getItemName() + " - $" + item.getItemPrice());
    }

    // Method to add a customer to the store
    public void addCustomer(Customer customer) {
        lastCustomerNumber++;
        customer = new Customer(lastCustomerNumber, customer.getCustomerName());
        customers.add(customer);
        System.out.println("Customer added to the store: " + customer.getCustomerName() + " with number " +customer.getCustomerId());
    }
  // Method to add an item to a customer's shopping cart
    public void addItemToCustomerCart(Customer customer, Item item, int quantity) {
        Item storeItem = null;
        for (Item i : items) {
            if (i.getItemId() == item.getItemId()) {
                storeItem = i;
                break;
            }
        }
        if (storeItem == null) {
            System.out.println("Item not found in the store.");
            return;
        }
        if (quantity > storeItem.getItemQuantity()) {
            System.out.println("The store doesn't have enough quantity for this item.");
            return;
        }
        storeItem.setItemQuantity(storeItem.getItemQuantity() - quantity);
        Item cartItem = new Item( item.getItemName(),item.getItemPrice(),item.getItemId(), quantity );
        customer.addItemToCart(cartItem);
        System.out.println("Item added to customer cart: " + item.getItemName()+ " - $" + item.getItemPrice()+ " x " + quantity);
    }

    // Method to remove an item from a customer's shopping cart
    public void removeItemFromCustomerCart(Customer customer, Item item) {
        customer.removeItemFromCart(item);
        System.out.println("Item removed from customer cart: " + item.getItemName());
    }

    // Method to view a customer's shopping cart
    public void viewCustomerCart(Customer customer) {
        System.out.println("Customer " + customer.getCustomerName() + " - Shopping Cart:");
        customer.viewCart();
    }

    // Method to modify customer data
    public void modifyCustomerData(Customer customer, String name) {
        customer = new Customer(customer.getCustomerId(), name);
        System.out.println("Customer data modified.");
    }

    // Method to empty a customer's shopping cart
    public void emptyCustomerCart(Customer customer) {
        customer.emptyCart();
    }

    // Method to perform the checkout process for a customer
    public void checkout(Customer customer) {
        double total = 0.0;
        System.out.println("Customer " + customer.getCustomerName() + " - Checkout:");
        ArrayList<Item> cart = customer.getShoppingCart();
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }
        for (Item item : cart) {
            System.out.println(item.getItemName() + " - $" + item.getItemPrice() + " x " + item.getItemQuantity());
            total += item.getItemPrice() * item.getItemQuantity();
        }
        System.out.println("Total: $" + total);
        customers.remove(customer);
        System.out.println("Customer removed from the store.");
    }

    // Getter methods for the store's attributes
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Item> getItems() {
        return items;
    
}
}
