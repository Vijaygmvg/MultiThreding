package ThreadSysncronization.locks;
import java.util.*;
import java.util.concurrent.locks.*;

public class ConditionDemo {
    
    private final Integer MAX_SIZE=5;
    private final Lock lock=new ReentrantLock();
    private final Queue<Integer> buffer=new LinkedList<>();
    private final Condition bufferNotFull=lock.newCondition();
    private final Condition bufferNotEmpty=lock.newCondition();


    private void produce(int item){
        lock.lock();
    
        try{
           while (buffer.size()==MAX_SIZE) {
            bufferNotFull.await();
            
           }
           buffer.offer(item);
           System.out.println("produced >>"+item);
           bufferNotEmpty.signal();
        }
        catch(Exception e){

        }
        finally{
        lock.unlock();
        }
    }
    private void consume() throws InterruptedException{
        lock.lock();
        try{
            while (buffer.isEmpty()) {
                bufferNotEmpty.await();
            }
            System.out.println("consumed >>"+buffer.poll());
            bufferNotFull.signal();

        }

        finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo demo=new ConditionDemo();
        Thread producerThread=new Thread(()->{
            try{
        for(int i=0;i<10;i++){
            demo.produce(i);
            Thread.sleep(1000);
        }
            }
            catch(InterruptedException e){
               throw new RuntimeException(e);
            }
        
        });
        Thread consumerThread=new Thread(()->{
            try{
        for(int i=0;i<10;i++){
            demo.consume();
            Thread.sleep(1000);
        }
            }
            catch(InterruptedException e){
               throw new RuntimeException(e);
            }
        
        });
        producerThread.start();
        consumerThread.start();
    }
}
