package frontsystem;

public class Client implements Runnable {

    private final FrontSystem frontSystem;
    private final String name;
    private final Request request;

    public Client(FrontSystem frontSystem, String name, Request request) {
        this.frontSystem = frontSystem;
        this.name = name;
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("Заявка клиента " + name + " отправлена.");
        frontSystem.addRequest(request);
    }
}
