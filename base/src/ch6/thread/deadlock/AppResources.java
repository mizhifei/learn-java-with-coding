package ch6.thread.deadlock;

public class AppResources {

    private Object printer = new Object();

    private Object document = new Object();

    public Object getPrinter() {
        return printer;
    }

    public Object getDocument() {
        return document;
    }
}
