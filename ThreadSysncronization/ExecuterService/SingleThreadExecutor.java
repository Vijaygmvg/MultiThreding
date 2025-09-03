package ThreadSysncronization.ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public static void main(String[] args) {
        // Create a single-thread executor
        ExecutorService service = Executors.newSingleThreadExecutor();
        try  {
            for (int i = 0; i < 5; i++) {
                // Submit tasks to the executor
                service.execute(new Task(i));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

// Runnable Task implementation
class Task implements Runnable {

    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    public void run() {
        System.out.println("Task with ID " + taskId + " is being executed by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Proper interruption handling
            System.err.println("Task interrupted: " + taskId);
        }
    }
}