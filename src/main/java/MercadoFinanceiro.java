import java.util.Observable;

public class MercadoFinanceiro extends Observable {

    private Float dolar;
    private Float euro;

    public MercadoFinanceiro(Float dolar, Float euro) {
        this.dolar = dolar;
        this.euro = euro;
    }

    public void notificarMudancaPrecoMoeda(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
    return "PrecoMoeda{" +
            "dolar='" + dolar + '\'' +
            ", euro=" + euro +
            '}';
}
}
