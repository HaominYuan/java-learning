package 图解Java多线程设计模式.singlethreadedexecution.spoonandfork;

public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
