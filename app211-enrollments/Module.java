
/**
 * This class models a BNU module which forms part of a course.
 *
 * @author Maryam Hanif
 * @version 1.0 
 */
public class Module
{
    // Variables 
    private String code;
    private String title;
    private int credit;

    /**
     * Constructor for objects of class Module
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
     * An example of a method 
     * @param
     * @return code
     */
    public String getCode()
    {
        return this.code;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public int getCredit()
    {
        return this.credit;
    }
    
    public void setCredit(int credit)
    {
       this.credit = credit; 
    }
    /**
     *  Print the details of the course, the list
     * of students enrolled and the module
     *
     */
    private void print()
    {
        //printHeading();
        
        System.out.println(" Module Code: " + code + ": " + title);
        System.out.println();
    }
}
