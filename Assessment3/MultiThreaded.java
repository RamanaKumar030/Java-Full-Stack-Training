package DAY3;

class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Task failed!");
            }
            System.out.println(taskName + " executed successfully.");
        } catch (RuntimeException e) {
            System.out.println("Error in " + taskName + ": " + e.getMessage());
        }
    }
}

public class MultiThreaded {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("Task 1"));
        Thread t2 = new Thread(new Task("Task 2"));
        Thread t3 = new Thread(new Task("Task 3"));

        t1.start();
        t2.start();
        t3.start();
    }
}

