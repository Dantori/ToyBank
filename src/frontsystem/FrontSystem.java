package frontsystem;

import java.util.LinkedList;
import java.util.Queue;

public class FrontSystem {

    private final Queue<Request> requests = new LinkedList<>();
    private final Object lock = new Object();

    public void addRequest(Request request) {
        synchronized (lock) {
            while (requests.size() > 2) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            requests.add(request);
            lock.notifyAll();
        }
    }

    public Request getRequest() {
        synchronized (lock) {
            while (requests.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            Request request = requests.poll();
            lock.notifyAll();
            return request;
        }
    }
}
