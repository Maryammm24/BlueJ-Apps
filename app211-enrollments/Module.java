
/**
 * This class models a BNU module which forms part of a course.
 *
 * @author Maryam Hanif
 * @version 1.0 
 */
public class Module
{
    // Variables 
    private int x;
    private String code;
    private String title;
    private int credit;

    /**
     * Constructor for objects of class Module
     * It also gives the credit a value of 0
     */
    //Module is a method 
    public Module(String code, String title)
    {
        //initialise variables 
        this.code= code;
        this.title= title;
        credit = 0;
    }

    /**
     * This method returns the code for the module
     * @return code that represents the module code
     */
    public String getCode()
    {
        return this.code;
    }
    
    /** 
     * This method returns the code for the title 
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /** 
     * This method returns the code for the title 
     */
    public int getCredit()
    {
        return this.credit;
    }
    
    /** 
     * This method returns the code for the title 
     */
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print the details of the module, including the code, 
     * title and credits 
     */
    public void print()
    {
        System.out.println(" Module Code: " + code + ": "+ "\t" + title);
        System.out.println();
    }
}
