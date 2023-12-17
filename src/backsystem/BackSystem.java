package backsystem;

import frontsystem.Request;

public class BackSystem {

    private long balance = 5000;

    public synchronized void rebalance(Request request) {
        switch (request.getOperationType()) {
            case DEPOSIT -> balance += request.getAmount();
            case WITHDRAW -> balance -= request.getAmount();
        }
    }

    public long getBalance() {
        return balance;
    }
}
