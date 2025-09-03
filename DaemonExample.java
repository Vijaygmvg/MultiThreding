public class DaemonExample {

    public static void main(String[] args) {
        Thread one=new Thread(new UserThread());
        Thread two=new Thread(new DaemonThread());
          two.setDaemon(true);
        
        one.start();
        two.start();
         System.out.println("Deamon priority"+two.getPriority()+" user is "+one.getPriority());
       
      

    }
}

class UserThread implements Runnable{

    @Override
    public void run() {
         for(int i=0;i<2;i++){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("userThread "+i);
       }
       System.out.println("user thresd is complted succesfully ");
    }

}
class DaemonThread implements Runnable{

    @Override
    public void run() {
       for(int i=0;i<10;i++){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("DaemonThread "+i);
       }
    }

}