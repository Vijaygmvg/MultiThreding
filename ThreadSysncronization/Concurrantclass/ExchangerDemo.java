package ThreadSysncronization.Concurrantclass;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    
    public static void main(String[] args) {
        Exchanger<Integer> exchanger=new Exchanger<>();
        Thread one=new Thread(new FirstThread(exchanger));
        Thread two=new Thread(new SecondThread(exchanger));
        one.start();
        two.start();
    }
}
 class FirstThread implements Runnable {


    private final Exchanger<Integer> exchanger;
        public FirstThread(Exchanger<Integer> exchanger){
            this.exchanger=exchanger;
        }
    @Override
    public void run() {

         int dataToSend=10;
         System.out.println("first thread is sending data"+dataToSend);
         try {
            Integer recivedData=exchanger.exchange(dataToSend);
              System.out.println("first thread recived data");
    }

         catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}

 class SecondThread implements Runnable {


    private final Exchanger<Integer> exchanger;
        public SecondThread(Exchanger<Integer> exchanger){
            this.exchanger=exchanger;
        }
    @Override
    public void run() {

         int dataToSend=20;
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         System.out.println("second  thread is sending data"+dataToSend);
         try {
            Integer recivedData=exchanger.exchange(dataToSend);
            System.out.println("second  thread recived data");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }

    
}
