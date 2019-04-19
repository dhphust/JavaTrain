package Paradigm;

public class GenericContainer<T> {
    private T obj;

    public GenericContainer(T obj) {
        this.obj = obj;
    }

    public GenericContainer() {

    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }



}
