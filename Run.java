/**
 * Prints out a coundown of an inserted time
 * until it reaches 0
 * 
 * Created by Alex Plaza
 * June/2014
 */

public class Run
{
    private Timer timer;
    private double speedFactor;
    
    /**
     * creates a new timer with given initial values
     */
    public Run (int initialSeconds, int initialMinutes, int initialHours, int initialDays)
        {
            timer = new Timer(initialSeconds, initialMinutes, initialHours, initialDays);
            speedFactor = 1;
        }
        
        
    /**
     * you want speed? use this method.
     */
    public void setSpeedFactor (double s)
    {
        speedFactor = s;
    }
    
    
    /**
     * prints out the countdown
     */
    public void runClock()
    {
        System.out.println(timer.getTime());
        while(!timer.zero())
        {
            timer.timeTick();
            System.out.println(timer.getTime());
            try{
                int duration = (int) (1000 / speedFactor);
                Thread.sleep(duration);
            }
            catch (InterruptedException e)
            {}
        }
    }
}
