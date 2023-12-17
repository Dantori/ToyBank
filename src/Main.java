import backsystem.BackSystem;
import frontsystem.*;

public class Main {
    public static void main(String[] args) {

        FrontSystem frontSystem = new FrontSystem();
        BackSystem backSystem = new BackSystem();

        RequestHandler requestHandler = new RequestHandler(frontSystem, backSystem);
        Thread handlerThread1 = new Thread(requestHandler);
        Thread handlerThread2 = new Thread(requestHandler);

        handlerThread1.start();
        handlerThread2.start();

        Thread clientThread1 = new Thread(new Client(frontSystem, "Клиент 1", new Request(100,
                OperationType.DEPOSIT)));
        Thread clientThread2 = new Thread(new Client(frontSystem, "Клиент 2", new Request(50,
                OperationType.WITHDRAW)));
        Thread clientThread3 = new Thread(new Client(frontSystem, "Клиент 3", new Request(200,
                OperationType.WITHDRAW)));
        Thread clientThread4 = new Thread(new Client(frontSystem, "Клиент 4", new Request(175,
                OperationType.DEPOSIT)));
        Thread clientThread5 = new Thread(new Client(frontSystem, "Клиент 5", new Request(125,
                OperationType.DEPOSIT)));

        clientThread1.start();
        clientThread2.start();
        clientThread3.start();
        clientThread4.start();
        clientThread5.start();
    }
}