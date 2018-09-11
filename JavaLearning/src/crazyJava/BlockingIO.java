package crazyJava;

import java.util.concurrent.*;
import java.util.*;

class MessageQueue extends LinkedBlockingQueue<Character> {}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private MessageQueue messageQueue;
    public Sender(MessageQueue mq) { messageQueue = mq; }
    public void run() {
        try {
            while(!Thread.interrupted())
                for (char c = 'A'; c <= 'z'; c++) {
                    messageQueue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch(InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
    

}

class Receiver implements Runnable {
    private MessageQueue messageQueue;
    public Receiver(MessageQueue mq) { messageQueue = mq; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.print("Read: " + messageQueue.take() + ", ");
            }
        } catch(InterruptedException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}

public class BlockingIO {
    public static void main(String[] args) throws Exception {
        MessageQueue messageQueue = new MessageQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Sender(messageQueue));
        exec.execute(new Receiver(messageQueue));
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
} 