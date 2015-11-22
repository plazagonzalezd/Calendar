/**
 * This class prints out the number of years, months, days, hours minutes,
 * and second that you have left given a desired date.
 * 
 * Created by Alex Plaza
 * June/2014
 */
import java.util.GregorianCalendar;
public class RunCalendar
{
    private Calendar cal;
    private double speedFactor;
    
    public RunCalendar (int year, int month, int day, int hour, int minute, int second)
        {
            cal = new Calendar ( year,month, day, hour, minute, second);
            speedFactor = 1;
        }
    
        /**
         * prints out the countdown until the desire date
         */
    public void runClock()
    {
        System.out.println(cal.getTime());
        while(!cal.zero())
        {
            cal.timeTick();
            System.out.println(cal.getTime());
            try{
                int duration = (int) (1000 / speedFactor);
                Thread.sleep(duration);
            }
            catch (InterruptedException e)
            {}
        }
    }
}

