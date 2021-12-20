
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Maryam Hanif
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    private StockDemo demo;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo =  new StockDemo();
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            System.out.println("You have quit the app.");
            return true;
        }
        else if (choice.equals("add"))
        {
            addProduct();
        }
        else if (choice.equals("remove"))
        {
            removeProduct();
        }
        else if (choice.equals("print"))
        {
            stock.print();
        }
        else if (choice.equals("buy"))
        {
            buyProduct();
        }
        else if (choice.equals("sell"))
        {
            sellProduct();
        }
        else if (choice.equals("search"))
        {
            String phrase = reader.getString("Please enter the name of the product >");
            stock.findProduct(phrase);
        }
        else if (choice.equals("low stock"))
        {
            runLowStock();
        }
        else if (choice.equals("re stock"))
        {
            runReStock();
        }
        else if (choice.equals("demo"))
        {
            demo.runDemo();
        }
        else 
        {
            System.out.println("Invalid input, Try again! ");
        }
        return false;
    }
    
    private void addProduct()
    {
        int id = reader.getInt("Please enter the ID: ");
        Product find= stock.findProduct(id);
        if(find==null)
        {
            String name = reader.getString("Please enter the name of the product: ");
            Product product = new Product (id, name);
            stock.add(product);
            System.out.println("Product " + product.getID()
                  + "," + product.getName() + " has been ADDED");
        }
        else 
        {
            System.out.println("This ID has already been assigned to another product");
        }
    }
    
    private void removeProduct()
    {
        int id = reader.getInt("Enter ID of product >");
        stock.remove(id);
    }
    
    private void sellProduct()
    {
       int id = reader.getInt("Enter the product ID > "); 
       int amount = reader.getInt ("Enter amount of product to sell, 1-10");
       if (1 <= amount && amount <= 10)
       {
           stock.buyProduct(id, amount);
           System.out.println("Sold product with ID " + id + amount + "times");
       }
       else 
       {
           System.out.println("Invalid input, being redirected to the main menu");
       }
    }
    
    private void runLowStock()
    {
        int amount = reader.getInt("Enter the max quantity to show, between 1-5.");
        if (1 <= amount && amount <= 5)
        {
            stock.lowStock(amount);
            String yorn= reader.getString("Do you want to restock all of these items.");
            if(yorn.equals("yes"))
            {
                stock.reStock(amount,10);
            }
            else if (yorn.equals("no"))
            {
                System.out.println("You are being redirected to the main menu");
            }
            else 
            {
                System.out.println("Invalid input, being redirected to the main menu");
            }
        }
        else 
        {
            System.out.println("Invalid input, being redirected to the main menu");
        }
    }
    
    private void runReStock()
    {
        int amount = reader.getInt("Enter the max quantity, between 1-5.");
        int quantity = reader.getInt("Enter the amount you want to buy, between 1-10.");
        if (1<= amount && amount <= 5 && 1<= quantity && quantity <= 10)
        {
            stock.reStock(amount,quantity);
        }
        else 
        {
            System.out.println("Invalid input, being redirected to main menu");
        }
    }
    
    private void buyProduct()
    {
        int id = reader.getInt("Enter ID of product >");
        int amount = reader.getInt("Enter amount of products to buy, between 1-10 >");
        if (1 <= amount && amount <= 10)
        {
            stock.buyProduct(id, amount);
            System.out.println("You have purchased product with Id " 
            + id + " " + amount + " times");
        }
        else
        {
            System.out.println("Invalid input, being redirected to the main menu");
        }
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Buy:        Buy an existing a product by ID"); 
        System.out.println("    Sell:       Sell an existing product by ID"); 
        System.out.println("    Low Stock:  Print all products have low stock"); 
        System.out.println("    Re-Stock:   Restock the selected productr"); 
        System.out.println("    Search:     Search a product with the product ID"); 
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Maryam Hanif");
        System.out.println("********************************");
    }
}