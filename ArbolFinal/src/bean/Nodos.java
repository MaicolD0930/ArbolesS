package bean;

public class Nodos {
    private char dato;
    private Nodos Li;
    private Nodos Ld;
    private int fb;

    public Nodos(char dato) {
        this.dato = dato;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodos getLi() {
        return Li;
    }

    public void setLi(Nodos li) {
        Li = li;
    }

    public Nodos getLd() {
        return Ld;
    }

    public void setLd(Nodos ld) {
        Ld = ld;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

}
