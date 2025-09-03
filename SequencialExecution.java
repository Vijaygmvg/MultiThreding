public class SequencialExecution{

    public static void method1(){
        for(int i=0;i<5;i++){
            System.out.println("from method 1 "+i);
        }
    }
    public static void method2(){
        for(int i=0;i<5;i++){
            System.out.println("from method 2  "+i);
        }
    }

    public static void main(String[] args) {
        
        method1();
        method2();
    }
}