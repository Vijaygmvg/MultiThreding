package ThreadSysncronization;

public class LockWithCustomObjects {


    private static Object lock1=new Object();
    private static Object lock2=new Object();
private static int counter1=0;
private static int counter2=0;
    public static void main(String[] args) {
        
        Thread one=new Thread(()->{
            for(int i=0;i<10000;i++){
                increment1();
            }
        });
        Thread two=new Thread(()->{
            for(int i=0;i<10000;i++){
                   increment2();
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
    System.out.println("tha value of counter 1 is "+counter1);
    System.out.println("the value of counter 2 is "+counter2);
    }
    private static void  increment1(){

        synchronized(lock1){
        counter1++;
        }
    }
     private static void  increment2(){
 

        synchronized(lock2){

        counter2++;
        }
    }
}