import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
    public static void main(String[] args) {
        int n = 15;
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        FizzBuzzThread fizzBuzzThread = new FizzBuzzThread(n, queue);
        fizzBuzzThread.start();

        try {
            while (true) {
                String result = queue.take();
                if (result.equals("done")) {
                    break;
                }
                System.out.println(result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}