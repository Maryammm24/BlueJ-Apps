import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Maryam Hanif
 * @version 1 (16/11/2021)
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    
    private Random random;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = new StockList();
        this.random = new Random();
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Iphone 12"));
        stock.add(new Product(102, "Iphone 11"));
        stock.add(new Product(103, "Airpods (2nd Generation)"));
        stock.add(new Product(104, "Airpods Pro"));
        stock.add(new Product(105, "Ipad Pro"));
        stock.add(new Product(106, "Ipad Air"));
        stock.add(new Product(107, "Ipad mini"));
        stock.add(new Product(108, "Macbook Pro"));
        stock.add(new Product(109, "Macbook Air"));
        stock.add(new Product(110, "Apple Pencil (1st Gen)"));
        
        runDemo();
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    private void buyProducts()
    {
        for (int i = 101; i <= 110; i++)
        {
           stock.buyProduct(i, random.nextInt(1001)); 
        }
    }

    private void sellProducts()
    {
        for (int i = 101; i <= 110; i++)
        {
           stock.sellProduct(i, random.nextInt(1001)); 
        }
    }    
}