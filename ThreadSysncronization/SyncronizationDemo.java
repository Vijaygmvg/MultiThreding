package ThreadSysncronization;

public class SyncronizationDemo {
    private static int  counter=0;
    public static void main(String[] args) {
        
        Thread one=new Thread(()->{
            for(int i=0;i<10000;i++){
                counter++;
            }
        });
       Thread two=new Thread(()->{
        for(int i=0;i<10000;i++){
            counter++;
        }
       });
       one.start();
       two.start();
       try{
       one.join();
       two.join();
       }
       catch(Exception e){
        e.printStackTrace();
       }
       System.out.println("the counter value is "+counter);

    }
}
