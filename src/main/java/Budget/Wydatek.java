package Budget;

public class Wydatek {
    private StringBuilder linijka;
    private int typ;

    public Wydatek(StringBuilder linijkatypwydatku, int typ) {
        this.linijka = linijkatypwydatku;
        this.typ = typ;
    }

    public StringBuilder getLinijka() {
        return linijka;
    }

    public void setLinijka(StringBuilder linijka) {
        this.linijka = linijka;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }
}
