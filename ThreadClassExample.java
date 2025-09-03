
public class ThreadClassExample {
    
    public static void main(String[] args) throws InterruptedException {
        Thread one=new ThreadEx();
    Thread two=new ThreadEx();
    Thread three=new ThreadEx();
     three.start();
     one.start();
    two.start();
     three.join();
    one.start();
    two.start();
     System.out.println("this is completed ");
    
    }
   
}
class ThreadEx extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(i+"  ");
        }

    }
}
