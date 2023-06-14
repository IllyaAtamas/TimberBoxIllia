import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzThread {
    private final int n;
    private final BlockingQueue<String> queue;

    public FizzBuzzThread(int n, BlockingQueue<String> queue) {
        this.n = n;
        this.queue = queue;
    }

    private boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    private boolean isDivisibleBy5(int number) {
        return number % 5 == 0;
    }

    public void fizz() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (isDivisibleBy3(i) && !isDivisibleBy5(i)) {
                queue.put("fizz");
            }
        }
    }

    public void buzz() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (!isDivisibleBy3(i) && isDivisibleBy5(i)) {
                queue.put("buzz");
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (isDivisibleBy3(i) && isDivisibleBy5(i)) {
                queue.put("fizzbuzz");
            }
        }
    }

    public void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (!isDivisibleBy3(i) && !isDivisibleBy5(i)) {
                queue.put(Integer.toString(i));
            }
        }
    }
}