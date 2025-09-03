package ThreadSysncronization.Concurrantclass;

import java.util.concurrent.CountDownLatch;

public class Resturant {
  
    public static void main(String[] args) throws InterruptedException{
        int noOfChef=3;
        CountDownLatch latch=new CountDownLatch(noOfChef);
        new Thread(new Chef("chef A","pizza",latch)).start();
         new Thread(new Chef("chef B","pastha",latch)).start();
         new Thread(new Chef("chef A","burger",latch)).start();
        latch.await();
        System.out.println("all dishes were prepared lets we  can serve to the customers");
    
    }
    

    }
    


class Chef implements Runnable{

    private final String name;
    private final String  dish;
    private final CountDownLatch latch;

    public Chef(String name,String dish,CountDownLatch latch){
        this.name=name;
        this.dish=dish;
        this.latch=latch;
    }
    @Override
    public void run() {
       try{

        System.out.println(name+" is preparing the "+dish);
        Thread.sleep(2000);
        System.out.println(name+" comleted "+dish);
        latch.countDown();
       }
       catch(InterruptedException e){
         throw new RuntimeException(e);
       }
}
}

