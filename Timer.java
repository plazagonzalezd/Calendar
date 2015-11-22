/**
 * This class creates a Timer that includes
 * a days, hours, minutes, and seconds!
 * 
 * Created by Alex Plaza
 * June/2014
 */
public class Timer
{
    private Number days;
    private Number hours;
    private Number minutes;
    private Number seconds;
    private String displayString;
     
    public Timer()
    {
    days = new Number (0,99); //Assumes that the user won't put a three digits number.
    hours = new Number (0,23);
    minutes = new Number(0,59);
    seconds = new Number(0,59);
    updateDisplay();
    }
    
    
    /**
     *  creates a timer with given initial values, and start values
     */
    public Timer(int initialSeconds, int initialMinutes, int initialHours, int initialDays)
    {
    days = new Number (0,99); 
    hours = new Number (0,23);
    minutes = new Number(0,59);
    seconds = new Number(0,59);
    setTime(initialSeconds, initialMinutes, initialHours, initialDays);
    updateDisplay();
    }
    
    
    /**
     * tells you when all the counters are 0
     */
    public boolean zero() 
    {
    boolean zero = true;
    if((minutes.getValue() != 0) || (seconds.getValue() != 0) || (hours.getValue() != 0) || (days.getValue() != 0)){
        zero = false;
    }
    return zero;
    }
    
    
    /**
     * decreases the time one second at a time
     */
    public void timeTick()
    {
        boolean zero = zero();
        if(!zero)
        {
        seconds.decrement();
        if(seconds.getValue() == seconds.getStart())
        {
            minutes.decrement();
        }
         if(minutes.getValue() == minutes.getStart() 
         && seconds.getValue() == seconds.getStart() )
        {
            hours.decrement();
        }
         if(hours.getValue() == hours.getStart()
         &&  days.getValue() != 0 
         && minutes.getValue() == minutes.getStart() 
         && seconds.getValue() == seconds.getStart())
        {
            days.decrement();
        }
        updateDisplay();
        }
    }
   
    
        /**
         * sets new time and tells you if you inserted an invalid number.
         */
    public void setTime(int newSeconds, int newMinutes, int newHours, int newDays)
    {
        
        if((newSeconds > seconds.getStart()) 
        || (newMinutes > minutes.getStart()) 
        || (newHours > hours.getStart()) 
        || (newDays > days.getStart())){
         if(newSeconds > seconds.getStart())
         {
            System.out.println("Seconds must be less than 60");
         }
         if(newMinutes > minutes.getStart())
         {
            System.out.println("Minutes must be less than 60");
         }
         if(newHours > hours.getStart())
         {
            System.out.println("Hours must be less than 24");
         }
          if(newDays > days.getStart())
         {
            System.out.println("Hours must be less than 100");
         }
        }
        else{
        minutes.setValue(newMinutes);
        seconds.setValue(newSeconds);
        hours.setValue(newHours);
        days.setValue(newDays);
        updateDisplay();
        }
    }
    
    
    /** 
     * simulates the actual time
     */
    public void updateDisplay()
    {
        displayString = days.getDisplayValue() + ":" + hours.getDisplayValue() + ":" + minutes.getDisplayValue() + ":" + 
     seconds.getDisplayValue();
    }
    
    
    public String getTime()
    { 
    return displayString;
    }   
}