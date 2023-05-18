/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package online_store;

import java.util.Scanner;

/**
 *
 * @author Fouad obaid
 */
public class Online_store {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
               Store store =new Store();
              
                Scanner sc = new Scanner(System.in); 

     System.out.println("Welcome to the online store!");
        int x ;
     

     do { 

       System.out.println("Please choose an option:");
       System.out.println("1. Add a new Item to Store");
       System.out.println("2. Add a new Customer to Store");
       System.out.println("3. Add an item to Customer shopping cart");
       System.out.println("4. Remove an item from Customer shopping cart");
       System.out.println("5. View the items in Customer shopping cart");
       System.out.println("6. Modify customer data");
       System.out.println("7. Empty Customer shopping cart");
       System.out.println("8. End shopping and go to checkout");
       System.out.println("9. Exit the program.");
                     x = sc.nextInt();
            sc.nextLine();


       switch(x){
           case 1:
               System.out.println("Enter the item Num :");
               int num=sc.nextInt();
               System.out.println("Enter the item name:");
           sc.nextLine(); 
           String name = sc.nextLine(); 
           System.out.println("Enter the item price:");
           double price = sc.nextDouble();  
           System.out.println("Enter the item quantity:");
           int  quantity = sc.nextInt(); 
               System.out.println("Enter the type of the item (B|Book,s|shoes,G|Game):");
               String type=sc.next();
               if(type.equalsIgnoreCase("b")){
                   System.out.println("Enter the Book title:");
                   String title=sc.next();
                   System.out.println("Enter the Book Auther name:");
                   String auther=sc.next();
                   Item item = new Item(num,name, price, quantity ,type,title,auther); 
                   store.addItem(item);
               System.out.println("item added Successfully....");
               System.out.println("****************************");
               }
               else{Item item = new Item(name, price, num ,quantity); 
              store.addItem(item);
               System.out.println("item added Successfully....");
               System.out.println("******************************");}
           break;

           case 2:
              
               System.out.println("Enter the Customer ID:");
               int id=sc.nextInt();
               System.out.println("Enter the Customer Name:");
               String cname=sc.next();
               Customer customer = new Customer(id, cname);
               store.addCustomer(customer);
           
               System.out.println("Customer added with empty  Shopping cart Successfully....");
               System.out.println("****************************");
           break;

           case 3:
              System.out.print("Enter the customer number: ");
                int customerNumber = sc.nextInt();
                sc.nextLine();
                Customer c = null;
                for (Customer cus : store.getCustomers()) {
                    if (cus.getCustomerId()== customerNumber) {
                        c = cus;
                        break;
                    }
                }
                if (c == null) {
                    System.out.println("Customer not found in the store.");
                    break;
                }
                System.out.println("Items in the store:");
                for (Item i : store.getItems()) {
                    System.out.println(i.getItemId()+ " - " + i.getItemName()+ " - $" + i.getItemPrice()+ " x " + i.getItemQuantity());
                }
                System.out.print("Enter the item number: ");
           int itemNumber = sc.nextInt();
                sc.nextLine();
                Item storeItem = null;
                for (Item i : store.getItems()) {
                    if (i.getItemId()== itemNumber) {
                        storeItem = i;
                        break;
                    }
                }
                if (storeItem == null) {
                    System.out.println("Item not found in the store.");
                    break;
                }
                System.out.print("Enter the item quantity: ");
                int itemQuantity = sc.nextInt();
                store.addItemToCustomerCart(c, storeItem, itemQuantity);
                break;

           case 4:System.out.print("Enter the customer number: ");
                customerNumber = sc.nextInt();
                sc.nextLine();
                c = null;
                for (Customer cus : store.getCustomers()) {
                    if (cus.getCustomerId() == customerNumber) {
                        c = cus;
                        break;
                    }
                }
                if (c == null) {
                    System.out.println("Customer not found in the store.");
                    break;
                }
                store.viewCustomerCart(c);
                System.out.print("Enter the item number: ");
                itemNumber = sc.nextInt();
                sc.nextLine();
                storeItem = null;
                for (Item i : c.getShoppingCart()) {
                    if (i.getItemId() == itemNumber) {
                        storeItem = i;
                        break;
                    }
                }
                if (storeItem == null) {
                    System.out.println("Item not found in the cart.");
                    break;
                }
                store.removeItemFromCustomerCart(c, storeItem);
                break;
           case 5:System.out.print("Enter the customer number: ");
                customerNumber = sc.nextInt();
                sc.nextLine();
                c = null;
                for (Customer cus : store.getCustomers()) {
                    if (cus.getCustomerId() == customerNumber) {
                        c = cus;
                        break;
                    }
                }
                if (c == null) {
                    System.out.println("Customer not found in the store.");
                    break;
                }
                store.viewCustomerCart(c);
                
                break;
           case 6:System.out.print("Enter the customer number: ");
                                 customerNumber = sc.nextInt();
                    sc.nextLine();
                    c = null;
                    for (Customer cus : store.getCustomers()) {
                        if (cus.getCustomerId() == customerNumber) {
                            c = cus;
                            break;
                        }
                    }
                    if (c == null) {
                        System.out.println("Customer not found in the store.");
                        break;
                    }
                    System.out.print("Enter the new customer name: ");
           String customerName = sc.nextLine();
                    store.modifyCustomerData(c, customerName);
                    break;

           case 7:System.out.print("Enter the customer number: ");
                    customerNumber = sc.nextInt();
                    sc.nextLine();
                    c = null;
                    for (Customer cus : store.getCustomers()) {
                        if (cus.getCustomerId() == customerNumber) {
                            c = cus;
                            break;
                        }
                    }
                    if (c == null) {
                        System.out.println("Customer not found in the store.");
                        break;
                    }
                    store.emptyCustomerCart(c);
                    break;
           
           case 8:System.out.print("Enter the customer number: ");
                    customerNumber = sc.nextInt();
                    sc.nextLine();
                    c = null;
                    for (Customer cus : store.getCustomers()) {
                        if (cus.getCustomerId() == customerNumber) {
                            c = cus;
                            break;
                        }
                    }
                    if (c == null) {
                        System.out.println("Customer not found in the store.");
                        break;
                    }
                    store.checkout(c);
                    break;
           case 9:System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice,Please enter a valid choice.");
            }
     } while (x != 9);
        sc.close();
       
       }
                
                
    
    
}
    
    

