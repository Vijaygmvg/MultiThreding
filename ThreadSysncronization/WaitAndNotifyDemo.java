package ThreadSysncronization;

public class WaitAndNotifyDemo {

    private static final  Object lock=new Object();
    public static void main(String[] args) {
        
        Thread one=new Thread(()->{
             try {
                one();
             } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             }
        });

        Thread two=new Thread(()->{
                try {
                    two();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        });
        one.start();
        two.start();
    }
    private static void one() throws InterruptedException{

        synchronized(lock){
            System.out.println("helo form method one ");
            lock.wait();
            System.out.println("back again the method one ");
        }

    }
    private static void two() throws InterruptedException{

        synchronized(lock){
            System.out.println("helo form method two ");
            lock.notify();
            System.out.println("helo the methjod 2 after the nofying ");
        }

    }
}

