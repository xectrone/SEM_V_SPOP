import java.util.concurrent.Semaphore;

public class Main3
{
    static Semaphore mutex = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);

    static int readCount = 0;
    static String message = "Hello";

    static class Reader implements Runnable
    {
        public void run()
        {
            try
            {
                mutex.acquire();
                readCount++;
                if(readCount==1)
                    wrt.acquire();
                mutex.release();
                System.out.println("Thread " + Thread.currentThread().getName() + " is Reading : " + message);
                Thread.sleep(1500);
                System.out.println("Thread " + Thread.currentThread().getName() + " is Finished Reading !");
                mutex.acquire();
                if(readCount==0)
                    wrt.release();
                mutex.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Writer implements Runnable
    {
        public void run()
        {
            try
            {
                message = "Good Morning";
                mutex.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + " is Writing : " + message);
                Thread.sleep(1500);
                System.out.println("Thread " + Thread.currentThread().getName() + " is Finished Writing !");
                mutex.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        Writer write = new Writer();
        Reader read = new Reader();

        Thread w1 = new Thread(write);
        w1.setName("Writer 1");
        Thread w2 = new Thread(write);
        w2.setName("Writer 2");
        Thread w3 = new Thread(write);
        w3.setName("Writer 3");

        Thread r1 = new Thread(read);
        r1.setName("Reader 1");
        Thread r2 = new Thread(read);
        r2.setName("Reader 2");
        Thread r3 = new Thread(read);
        r3.setName("Reader 3");

        w1.start();
        r1.start();
        w2.start();
        r2.start();
        w3.start();
        r3.start();
    }
}