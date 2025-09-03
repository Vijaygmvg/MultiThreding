package ThreadSysncronization;
import java.beans.IntrospectionException;
import java.util.*;
public class ProducerConsumer {


static class Worker {


        private int sequence=0;

        private final Integer top;

        private final Integer bottom;

        private final List<Integer> container;

        private final Object lock=new Object();
        

        public Worker(Integer top,Integer bottom){
            this.top=top;
            this.bottom=bottom;
            this.container=new ArrayList<>();
        }
        public void produce() throws InterruptedException{

            synchronized(lock){
                while (true) {
                    if (container.size()==top) {
                        System.out.println("the container is full ");
                         lock.wait();
                        
                    }
                    else{
                        System.out.println(sequence +" added to the container ");
                        container.add(sequence++);
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }

        public void consume() throws InterruptedException{

            synchronized(lock){
                while(true){
                    if(container.size()==bottom){
                        System.out.println("the  contaie is empty");
                        lock.wait();
                    }
                    else{
                        System.out.println("consuming the "+container.remove(--sequence));
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }

        
        
    }

    
    public static void main(String[] args) {
        
         Worker worker=new Worker(10,0);
         Thread producer=new Thread(()->{
            try {
                worker.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         });

         Thread consume=new Thread(()->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         });
         producer.start();
         consume.start();
    }
}
