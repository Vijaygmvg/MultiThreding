import java.io.*;
import java.util.*;
public class RunnableExample {
    
    public static void main(String[] args) {
        System.out.println();
         Thread one=new Thread(new ThreadOne());
    Thread two=new Thread(new ThreadTwo());
    Thread three=new Thread(()->{
        for(int i=0;i<5;i++){
            System.out.println("thread three  "+i);
        }
    });
     Thread four=new Thread(()->{
        for(int i=0;i<5;i++){
            System.out.println("thread four  "+i);
        }
    });
     Thread five=new Thread(()->{
        for(int i=0;i<5;i++){
            System.out.println("thread five  "+i);
        }
    });
     Thread six=new Thread(()->{
        for(int i=0;i<5;i++){
            System.out.println("thread six  "+i);
        }
    });
    one.start();
    two.start();
    three.start();
    four.start();
    five.start();
    six.start();
    try {
        one.join();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println("done by cpu");
    Scanner s=new Scanner(System.in);
      System.out.println("done by cpu");

    }
   
}




class ThreadOne implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("THread one   "+i+" ");
        }
    }
}
class ThreadTwo implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("THread two   "+i+" ");
        }
    }
}