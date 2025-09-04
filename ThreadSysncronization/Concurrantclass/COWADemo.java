package ThreadSysncronization.Concurrantclass;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class COWADemo {

    public static void main(String[] args) {
        new Simulation().simulate();
    }
    
}

class Simulation{

    private final List<Integer> list;
    public Simulation(){
        this.list=new CopyOnWriteArrayList<>();
        this.list.addAll(Arrays.asList(0,0,0,0,0,0,0));
    }

    public void simulate(){
        Thread one=new Thread(new WriteTask(list));
        Thread two=new Thread(new WriteTask(list));
        Thread three=new Thread(new WriteTask(list));
        Thread four=new Thread(new Readtask(list));
        one.start();
        two.start();
        three.start();
        four.start();
    }

}

 class Readtask implements Runnable {

    private  final List<Integer> list;


    public Readtask(List<Integer> list){
        this.list=list;
    }
    @Override
    public void run() {
    
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(list);
            
        }
    }


    
}

class WriteTask implements Runnable {

    private List<Integer> list;
    private Random random;

    public WriteTask(List<Integer> list){
        this.list=list;
        this.random=new Random();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            list.add(random.nextInt(10));
            
        }
    }

    
}