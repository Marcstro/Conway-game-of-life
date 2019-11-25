
import java.util.Timer;
//import javax.swing.Timer;
import java.util.TimerTask;



public class Engine {
    
    Label grid;
    
    int ticks = 0;
    int speed=600;
    
    boolean running;
    
    Timer timer = new Timer();
    

    
    public void start(){
        timer = new Timer();
        running=true;
        TimerTask doStuff = new TimerTask(){
            public void run(){
                ticks++;
                grid.tick();
                System.out.println("Iteration #:" + ticks);
            }
        };
        timer.scheduleAtFixedRate(doStuff, 200, speed);
            
    }
    public void pause() {
        running=false;
        this.timer.cancel();
    }
    public void faster(){
        if(speed>250){
            speed-=200;
            pause();
            timer = new Timer();
            if(running)
                start();
        }
    }
    public void slower(){
        speed+=200;
        pause();
        timer = new Timer();
        if(running)
            start();
    }
    
    public void setGrid(Label grid){
        this.grid=grid;
    }

}
