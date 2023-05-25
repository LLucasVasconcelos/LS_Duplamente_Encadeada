package Domain;

public class NoDuplo<T> {
    public T num;
    public NoDuplo<T> next;
    public NoDuplo<T> ant;

    public NoDuplo(T num) {
        this.num = num;
        this.next = null;
        this.ant = null;
    }
}
