import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void inscrever(MercadoFinanceiro moeda) {
        moeda.addObserver(this);
    }

    public void update(Observable moeda, Object arg1) {
        this.ultimaNotificacao = this.nome + ", o valor da moeda mudou: " + moeda.toString();
    }
}