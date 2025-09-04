package ThreadSysncronization.Deadlock;

import java.beans.IntrospectionException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.*;

public class DeadLockDemo {
    
    private final Lock lock1=new ReentrantLock(true);
   private final Lock lock2=new ReentrantLock(true);

   public void workerOne(){
    System.out.println("worker 1 aquired lok 1 ");

    lock1.lock();
    try{
        Thread.sleep(1000);
    }
    catch(InterruptedException e){

    }
    lock2.lock();
    System.out.println("worker 1 locked the lock2");
    lock1.unlock();
    lock2.unlock();

   }
   public void workerTwo(){
    System.out.println("worker 2 aquired lok 1 ");

    lock2.lock();
    try{
        Thread.sleep(1000);
    }
    catch(InterruptedException e){

    }
    lock1.lock();
    System.out.println("worker 1 locked the lock2");
    lock2.unlock();
    lock1.unlock();

   }
   public static void main(String[] args) {
    DeadLockDemo demo=new DeadLockDemo();
     
    new Thread(demo::workerOne,"woker one").start();
    new Thread(demo::workerTwo,"worker two").start();
    new Thread(()->{
       ThreadMXBean mxBean=ManagementFactory.getThreadMXBean();
       while(true){
        long[] threadIds=mxBean.findDeadlockedThreads();
          if(threadIds!=null){
            System.out.println("deadlock is occured");
            ThreadInfo threadInfo[]=mxBean.getThreadInfo(threadIds);
            System.out.print(threadInfo);
            for(long tId:threadIds){
                System.out.println("thread with thread id"+tId);
            }
            break;
          }
          try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       }
   }).start();
   }
}
