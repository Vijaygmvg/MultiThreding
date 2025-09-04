package ThreadSysncronization.Concurrantclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiStageTour {
    
    public static final int NUM_TOURIST=5;
    private static final int NUM_STAGES=3;

    private static final CyclicBarrier barrier=new CyclicBarrier(NUM_TOURIST,()->{
        System.out.println("tour guide start speaking ");
    });

    static class Tourist implements Runnable{

        private final int touristId;

        public Tourist(int touristId){
            this.touristId=touristId;
        }
        @Override
        public void run() {
           for(int i=0;i<NUM_STAGES;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                       System.out.println("tourist"+touristId+"ariives at "+i+1);
                       try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
           }

        }
        
    }
    public static void main(String[] args) {
        for(int i=0;i<20;i++)
        {
            Thread touristThread=new Thread(new Tourist(i));
            touristThread.start();
        }
    }


}
