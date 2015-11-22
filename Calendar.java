/**
 * The important thing about this class is that it creates
 * a calendar that tells you the time left until a desired date
 * 
 * Created by Alex Plaza
 * June/2014
 */
import java.util.GregorianCalendar;

public class Calendar
{ 
    private GregorianCalendar date; 
    private GregorianCalendar actualDate;
    private GregorianCalendar timeLeft;
    private String display;
   
    /**
     * date creates a calendar with the given date.
     * actualDate creates a calendar with the current date.
     * timeLeft will store a calendar with the difference 
     * between the current date and the given date
     * createCalendar creates the calendar that does in timeLeft.
     */
    public Calendar( int year, int month, int day, int hour, int minute, int second)
    {
        date = new GregorianCalendar( year,month, day, hour, minute, second);
        actualDate = new GregorianCalendar();
        timeLeft = null;
        createCalendar();
        updateDisplay();
    }
    
    
    /**
     * gives back the nuber of secondes left
     */
    public int getSecondLeft()
    {
        int desiredSecond = date.get(GregorianCalendar.SECOND);
        int actualSecond = actualDate.get(GregorianCalendar.SECOND);
        int seconddiff = desiredSecond - actualSecond;
        int secondLeft;
        if(seconddiff >=0){
            secondLeft = seconddiff;
        }
        else{
            secondLeft = 60 + seconddiff;
        }
        return secondLeft;
    }
    
    
    /**
     * gives back the number of minutes left
     */
    public int getMinuteLeft()
    {
        int desiredMinute = date.get(GregorianCalendar.MINUTE);
        int actualMinute = actualDate.get(GregorianCalendar.MINUTE);
        int minutediff = desiredMinute - actualMinute;
        int minuteLeft;
        if(minutediff >=0){
            minuteLeft = minutediff;
        }
        else{
            minuteLeft = 60 + minutediff; 
        }
        return minuteLeft;
    }
    
    
    /**
     * gvies back the number of hours left
     */
    public int getHourLeft()
    {
        int desiredHour = date.get(GregorianCalendar.HOUR);
        int actualHour = actualDate.get(GregorianCalendar.HOUR);
        int hourdiff = desiredHour - actualHour;
        int hourLeft;
        if (hourdiff >= 0){
            hourLeft = hourdiff;
        }
        else{
            hourLeft = 24 + hourdiff;
        }
        return hourLeft;
    }
    
    
    /**
     * gives back the number of days left
     */
    public int getDayLeft()
    {
     int desiredDay = date.get(GregorianCalendar.DAY_OF_MONTH);
     int actualDay = actualDate.get(GregorianCalendar.DAY_OF_MONTH);
     int daydiff = desiredDay - actualDay;
     int dayLeft;
        if ( daydiff >= 0){
            dayLeft = daydiff;
        }
        else{
            dayLeft = (actualDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)) + daydiff ;
        }
    return dayLeft;
    }
    
    
    /**
     * gives back the difference between the current months
     * and the given month.
     * This difference required its own method because
     * it was used for the getYearLeft method
     */
    public int getMonthDiff()
    {
     int desiredMonth = date.get(GregorianCalendar.MONTH);
     int actualMonth = actualDate.get(GregorianCalendar.MONTH) + 1;
     int monthdiff = desiredMonth - actualMonth;
     return monthdiff;
    }
    
    
    /**
     * gives back the number of months left
     */
    public int getMonthLeft()
    {
     int monthdiff = getMonthDiff();
     int monthLeft;
        if( monthdiff < 0){
        monthLeft = 12 + monthdiff;
        }
        else{
        monthLeft = monthdiff;
        }
     return monthLeft;
    }
    
    
    /**
     * gives back the number of years left
     */
    public int getYearLeft()
    {
        int desiredYear = date.get(GregorianCalendar.YEAR);
        int actualYear = actualDate.get(GregorianCalendar.YEAR);
        int yeardiff = desiredYear - actualYear;
        int yearLeft;
        int monthdiff = getMonthDiff();
        if(monthdiff < 0){
             yearLeft = 1 - yeardiff;
        }
        else{
             yearLeft = yeardiff;
        }
        return yearLeft;
    }
   
    /** 
     * creates a new calendar with
     * the number of years, months, days
     * hours,seconds, and minutes between 
     * the current and the given dates
     * 
     */
    public void createCalendar()
    {
        int second = getSecondLeft();
        int minute = getMinuteLeft();
        int hour = getHourLeft();
        int day = getDayLeft();
        int month = getMonthLeft();
        int year = getYearLeft();
        timeLeft = new GregorianCalendar(year,month,day,hour,minute,second);

    }
 
    
    /**
     * decreases the time by once second
     */
     public void timeTick()
    {
        
        timeLeft.add(timeLeft.SECOND,-1);
        updateDisplay();
    }
    
    
    /**
     * tells you if at least one field of timeLeft
     * is zero.
     */
    public boolean zero()
    {
        boolean zero = true;
        if ((timeLeft.get(GregorianCalendar.YEAR) != 0) 
        || (timeLeft.get(GregorianCalendar.MONTH) != 0) 
        || (timeLeft.get(GregorianCalendar.DAY_OF_MONTH) != 0)
        || (timeLeft.get(GregorianCalendar.HOUR) != 0) 
        || (timeLeft.get(GregorianCalendar.MINUTE) != 0)
        || (timeLeft.get(GregorianCalendar.SECOND) != 0)){
            zero = false;
        }
        return zero;
    }
    
    
    /**
     * updates the message that tells us the time left
     */
    public String updateDisplay()
    {
        display = timeLeft.get(GregorianCalendar.YEAR) + " years, " + timeLeft.get(GregorianCalendar.MONTH)
        + " month, " + timeLeft.get(GregorianCalendar.DAY_OF_MONTH) + " days, " + timeLeft.get(GregorianCalendar.HOUR)
        + " days, " + timeLeft.get(GregorianCalendar.HOUR) + " hours, " + timeLeft.get(GregorianCalendar.MINUTE)
        + " minutes, and " +  timeLeft.get(GregorianCalendar.SECOND) + " seconds." ;
        return display;
        
    }
    
    
    /** 
     * returns the message created in unpdateDisplay
     */
    public String getTime()
    { 
    return display;
    }
}
