package frontsystem;

public class Request {

    private final long amount;
    private final OperationType operationType;

    public Request(long amount, OperationType operationType) {
        this.amount = amount;
        this.operationType = operationType;
    }

    public long getAmount() {
        return amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }
}
