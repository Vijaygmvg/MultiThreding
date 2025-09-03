package ThreadSysncronization.ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CatchedThreadPoolDemo {

    static long maxId=0;
    public static void main(String[] args) {
    
        try{
        ExecutorService service=Executors.newCachedThreadPool();
        for(int i=0;i<100000;i++){
            service.execute(new TaskOne(i));
            System.out.println(maxId);
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

class TaskOne implements Runnable{

    private final int taskId;
    private static long maxId=0;

    public TaskOne(int taskId){
        this.taskId=taskId;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
       long curId= Thread.currentThread().getId();
       maxId=Math.max(maxId,curId);

    System.out.println("task :"+taskId+" being executed by "+Thread.currentThread().getName());
    CatchedThreadPoolDemo.maxId=maxId;
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    }
    
}
