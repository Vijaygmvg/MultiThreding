public class ThreadPriorityExample{
    
    public static void main(String[] args) {
      System.out.println("hello everyone ");
      Thread one =new Thread(()->{
        for(int i=0;i<5;i++){
            System.out.println(i);
            if(i==3)
             Thread.currentThread().setPriority(3);
            System.out.println(Thread.currentThread().getName());
                        System.out.println(Thread.currentThread().getPriority());
        }
      });
      one.setPriority(Thread.MAX_PRIORITY);
      one.start();
      System.out.println(Thread.currentThread().getName());
      
      System.out.println("this is the ending ");
    }

}


