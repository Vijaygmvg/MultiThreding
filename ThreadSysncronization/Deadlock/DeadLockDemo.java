package ThreadSysncronization.Deadlock;

import java.beans.IntrospectionException;
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
   }
}
