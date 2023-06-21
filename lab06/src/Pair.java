//classe para parear dois tipos
public class Pair<A, B> {
    public final A a;
    public final B b;

    //Construtor
    public Pair(A a, B b){
        this.a = a;
        this.b = b;
    }

    //retorna o primeiro valor
    public A first() {
        return a;
    }

    //retorna o segundo valor
    public B second() {
        return b;
    }
}
