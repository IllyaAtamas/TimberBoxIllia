import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
    public static void main(String[] args) {
        int n = 15;
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread fizzThread = new Thread(() -> {
            try {
                FizzBuzzThread fizzBuzz = new FizzBuzzThread(n, queue);
                fizzBuzz.fizz();
                queue.put("done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                FizzBuzzThread fizzBuzz = new FizzBuzzThread(n, queue);
                fizzBuzz.buzz();
                queue.put("done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                FizzBuzzThread fizzBuzz = new FizzBuzzThread(n, queue);
                fizzBuzz.fizzbuzz();
                queue.put("done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                FizzBuzzThread fizzBuzz = new FizzBuzzThread(n, queue);
                fizzBuzz.number();
                queue.put("done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        try {
            int doneCount = 0;
            while (doneCount < 4) {
                String result = queue.take();
                if (result.equals("done")) {
                    doneCount++;
                } else {
                    System.out.println(result);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}