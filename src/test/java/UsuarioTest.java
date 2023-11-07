import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class UsuarioTest {
    @Test
    void deveNotificarUmUsuario() {
        MercadoFinanceiro moeda = new MercadoFinanceiro(5.3f, 4.8f);
        Usuario usuario = new Usuario("Usuario 1");
        usuario.inscrever(moeda);
        moeda.notificarMudancaPrecoMoeda();
        assertEquals("Usuario 1, o valor da moeda mudou: PrecoMoeda{dolar='5.3', euro=4.8}", usuario.getUltimaNotificacao());
    }
    @Test
    void deveNotificarUsuarios() {
        MercadoFinanceiro moeda = new MercadoFinanceiro(5.3f, 4.8f);
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.inscrever(moeda);
        usuario2.inscrever(moeda);
        moeda.notificarMudancaPrecoMoeda();
        assertEquals("Usuario 1, o valor da moeda mudou: PrecoMoeda{dolar='5.3', euro=4.8}", usuario1.getUltimaNotificacao());
        assertEquals("Usuario 2, o valor da moeda mudou: PrecoMoeda{dolar='5.3', euro=4.8}", usuario2.getUltimaNotificacao());
    }
    @Test
    void naoDeveNotificarUsuario() {
        MercadoFinanceiro moeda = new MercadoFinanceiro(5.3f, 4.8f);
        Usuario usuario = new Usuario("Usuario 1");
        moeda.notificarMudancaPrecoMoeda();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuario1(){
        MercadoFinanceiro mudancaUmMoeda = new MercadoFinanceiro(5.3f, 4.8f);
        MercadoFinanceiro mudancaDoisMoeda = new MercadoFinanceiro(5.0f, 4.0f);

        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");

        usuario1.inscrever(mudancaUmMoeda);
        usuario2.inscrever(mudancaDoisMoeda);

        mudancaUmMoeda.notificarMudancaPrecoMoeda();

        assertEquals("Usuario 1, o valor da moeda mudou: PrecoMoeda{dolar='5.3', euro=4.8}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }

}