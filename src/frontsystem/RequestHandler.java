package frontsystem;

import backsystem.BackSystem;

public class RequestHandler implements Runnable {

    private final FrontSystem frontSystem;
    private final BackSystem backSystem;

    public RequestHandler(FrontSystem frontSystem, BackSystem backSystem) {
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
    }

    @Override
    public void run() {
        while (true) {
            backSystem.rebalance(frontSystem.getRequest());
            System.out.println("Произошло изменение баланса: " + backSystem.getBalance());
        }
    }
}
