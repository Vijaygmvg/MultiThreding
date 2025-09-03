package ThreadSysncronization.ExecuterService;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service =Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new ProbeTask(), 1000, 2000,TimeUnit.MILLISECONDS);

        try{
            if(!service.awaitTermination(10000,TimeUnit.MILLISECONDS ))
               service.shutdownNow();
        }
        catch(InterruptedException e){
            e.printStackTrace();
            service.shutdownNow();
        }
    }
}

class ProbeTask implements Runnable{

    @Override
    public void run() {
        System.out.println("probing end point for updates ");
    }
    

}
