public class Pair<A, B> {
    public final A a;
    public final B b;

    public Pair(A a, B b){
        this.a = a;
        this.b = b;
    }

    public A first() {
        return a;
    }

    public B second() {
        return b;
    }
}
