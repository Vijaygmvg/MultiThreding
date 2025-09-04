package ThreadSysncronization.Atomicvariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicVariable {
    
    private  static  int count=0;
    private static final AtomicInteger atomicCounter=new AtomicInteger(0);

    public static void main(String[] args)  {
        Thread threadOne=new Thread(()->{
            for(int i=0;i<100000;i++)
           atomicCounter.incrementAndGet();
        });
        Thread threadTwo=new Thread(()->{
            for(int i=0;i<100000;i++)
            atomicCounter.incrementAndGet();
        });
        //  Thread threadThree=new Thread(()->{
        //     for(int i=0;i<10000;i++)
        //     count++;
        // });
        //  Thread threadFour=new Thread(()->{
        //     for(int i=0;i<10000;i++)
        //     count++;
        // });
        threadOne.start();
        threadTwo.start();
        // threadThree.start();
        // threadFour.start();
        try{
        threadOne.join();
        threadTwo.join();
        // threadThree.join();
        // threadFour.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("the final updtaed count is "+atomicCounter.get());


    }
}
