package ThreadSysncronization.ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    
    public static void main(String[] args) {
        ExecutorService service =Executors.newFixedThreadPool(2);

        try{
         for(int i=0;i<7;i++){
         service.execute(new Task(i));
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Task implements Runnable{

    private final int taskId;
    public Task(int taskId){
        this.taskId=taskId;
    }
    public void run(){
        System.out.println("executing the "+this.taskId+" from the currrent thread "+Thread.currentThread().getName());
       
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
