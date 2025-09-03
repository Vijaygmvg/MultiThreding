package ThreadSysncronization.ExecuterService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service =Executors.newFixedThreadPool(2);
        
        try{
          Future<Integer> result= service.submit(new CallDemo());
      System.out.println(result.get(10000,TimeUnit.MILLISECONDS));
      System.out.println(result.isDone());
      System.out.println(result.isCancelled());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class CallDemo implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        Thread.sleep(4000);
      return 15;
    }
    
}