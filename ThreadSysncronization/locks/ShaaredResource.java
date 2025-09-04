package ThreadSysncronization.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShaaredResource {
    
    private final ReadWriteLock lock=new ReentrantReadWriteLock();
    private int counter=0;
    public void increment(){
        lock.writeLock().lock();
        try{
            counter++;
            System.out.println(Thread.currentThread().getName()+"reader"+counter);

        }
        finally{
     lock.writeLock().unlock();
        }
    }

    public void getVlaue(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"reads :"+counter);
        }
        finally{
            lock.readLock().unlock();
        }
    }
    public static void main(String[] args) {
        ShaaredResource sharedResource=new ShaaredResource();
        for(int i=0;i<2;i++){
            Thread readerThread=new Thread(()->{
                for(int j=0;j<3;j++){
                    sharedResource.getVlaue();
                }
            });
            readerThread.setName("reader "+i);
            readerThread.start();

        }
        Thread writerThread=new Thread(()->{
            for(int i=0;i<5;i++){
                sharedResource.increment();
            }
        });
        writerThread.setName("witer thread");
        writerThread.start();
    }
}
