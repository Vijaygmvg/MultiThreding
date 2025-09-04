package ThreadSysncronization.Concurrantclass;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
  
    static final int  QUEUE_CAPACITY=10;
    static BlockingQueue<Integer> taskQueue=new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    public static void main(String[] args) {

        Thread producer=new Thread(()->{
        
            int count=0;
            while (true) {
                
                taskQueue.add(count++);
                System.out.println("producer produced "+count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });

        Thread consumerOne=new Thread(()->{
               while (true) {
                
                   try {
                    int count=taskQueue.take();
                    consumerMessage("consumer one", count);
                  
                   }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });
        
        Thread consumerTwo=new Thread(()->{
               while (true) {
                
                   try {
                    int count=taskQueue.take();
                    consumerMessage("consumer two", count);
                  
                   }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });
        producer.start();
        consumerOne.start();
        consumerTwo.start();
        
    }

    public static void consumerMessage(String consumer,int count){
        System.out.println(consumer+" is consumed the resouse "+count);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
