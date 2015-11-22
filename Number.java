/**
 * This class gives the display of the Numbers,
 * meaning the display of the hours, minutes, etc...
 * 
 * Created by Alex Plaza
 * June/2014
 */
public class Number
{
    private int value; //current value of the counter.
    private int start; //start is the value of the counter when it restarts.
    
    public Number(int value, int start)
    {
        this.value=value;
        this.start=start;
    }
    
    
    /**
     * returns the current value
     */
    public int getValue()
    {
        return value;
    }
    
    
    /**
     * returns the start value
     */
    public int getStart()
    {
        return start;
    }
    
    
    /** 
     * simulates the actual display
     */
    public String getDisplayValue()
    {    
        if(value < 10) {
            return "0" + value;
            }
        else{
            return "" + value;
        }
    }
    
    
    /**
     * replaces the current value
     */
     public void setValue(int replacementValue)
    {
        if(replacementValue >= 0) {
            value = replacementValue;
        }
        else{
            System.out.println("Please insert positive numbers or 0");
        }
    }
    
    
    /**
     * decreases the number on the display by 1.
     */
    public void decrement()
    {
        /**
         * if the value of the counter equal 0, it needs to re-start at the
         * start value
         */
        if(value == 0){  
             value = start;
        }
        else{
             value = value - 1;
        }
    }
}
