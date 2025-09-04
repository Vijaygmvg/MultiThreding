package ThreadSysncronization.Concurrantclass;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentCatche {
    
    private static Map<String,String> catche=new ConcurrentHashMap<>();
    public static void main(String[] args) {
        

        for(int i=0;i<10;i++){
            final int threadNum=i;
            new Thread(()->{
                String key="key @"+threadNum;
                for(int j=0;j<3;j++){
                    String value=getCatchedValue(key);
                    System.out.println("thread "+Thread.currentThread().getName()+" key=  "+key+"  value= "+value);
                }
            }).start();
        }
    }

    public static String getCatchedValue(final String key){
        String value=catche.get(key);
        if(value==null){
            value=compute(key);
            catche.put(key,value);

        }
        return value;
    }

    private static String compute(String key){
      System.out.println("the value is not present in catche ");
      try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return "value for "+key;
    }


}

