package ThreadSysncronization;

public class SyncronizedKeyword {
    
    private static int counter=0;
    public static void main(String[] args) {
        
        Thread one=new Thread(()->{
            for(int i=0;i<10000;i++){
                increment();
            }
        });

        Thread two=new Thread(()->{
            for(int i=0;i<10000;i++){
              increment();
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
        System.out.println("the value of counter is "+counter );
    }
    public synchronized static void increment(){
        counter++;

    }
}
