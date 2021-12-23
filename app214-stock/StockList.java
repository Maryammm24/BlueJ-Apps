import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Maryam Hanif 
 * @version 1 (16/11/2021)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        if (findProduct(item.getID()) != null)
        {
            System.out.println("Error, Product already exists");
        }
        else 
        {
            stock.add(item);
        }
    }
    
    /**
     * A method to remove a product from the list.
     */
    public void remove(int productID)
    {
        Product product = findProduct(productID);
        if (product != null)
        {
            System.out.println(product + " has been removed");
            stock.remove(product);
        }
        else
        {
            System.out.println("No items with that ID exist");
        }
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
    */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        if(product != null)
        {
            if(product.getQuantity()> 1000)
            {
                product.increaseQuantity(amount);
                System.out.println("Bought" + amount + "of" + product.getName());
            }
            else if (product.getQuantity() > 100)
            {   
            System.out.println("Not enough shelf space for" + 
            product.getName()+ ". please sell the existing stock");
            
            }
        }
        else 
        {
            System.out.println("Couldn't find product");
        }
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        {
            if(product.getID() == productID)
                return product;
        }
        return null;
    }
    
    /**
     * To find the product from the list and print it. 
     */
    public void findProduct(String phrase)
    {
        for (Product product : stock)
        {
            if(product.getName().startsWith(phrase) == true)
            {
                System.out.println(product);
            }
        }
    }

    /**
     * To find any products with low stock and print to the user.
     */
    public void lowStock(int amount)
    {
        for (Product product : stock)
        {
            if(product.getQuantity() <= 10)
            {
                System.out.println(product);
            }
        }
    }
    
    /**
     * To restock the low stock products when the quantity is under 10.
     */
    public void reStock(int amount, int quantity)
    {
        for (Product product : stock)
        {
            if (product.getQuantity() <= 10)
            {
                int id = product.getID();
                buyProduct(id, 100);
                System.out.println(product);
            }
        }
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID)
    {
        sellProduct(productID, 1);
    }
    
    /**
     * Sell many of the given product.
     * Show the before and after status of the product.
     */
    public void sellProduct(int productID, int amount)
    {
        System.out.println("Selling Quanitities of Stock\n");
        
        Product product = findProduct(productID);
        int stockQuantity = product.getQuantity();
        
        if(product != null) 
        {
                if(product.getQuantity() > 0 && product.getQuantity() > amount)
                {
                    product.decreaseQuantity(amount);
                    System.out.println("Sold" + amount + "of" + product.getName());
                }
                else if(product.getQuantity() ==0)
                {
                    System.out.println("The product " + product.getName() 
                    + " is out of stock ");
                }
                else
                {
                    System.out.println("Can't sell" + amount + " of " +
                    product.getName() + " because only have " + product.getQuantity());
                }
        }
        else
        {
            System.out.println("Counld not find product!");
        }
    }    
    
    /** Search for Product by a Phrase
     * 
     */
    public void searchProduct (String phrase)
    {
        int count = 0;

        for(Product product : stock)
        {
            if(product.getName().contains(phrase))
            {
                System.out.println(product);
                count += 1;
            }
            else
            {
                System.out.println("Not Found");
            }
            System.out.println("The search returned " + count + " query");
        }
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     */
    public int numberInStock(int productID)
    {
        Product product = findProduct(productID);
        if(product !=null)
        {
            return product.getQuantity();
        }
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Maryam's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}