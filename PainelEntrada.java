import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * PainelEntrada
 * 
 * @author André Cavalcanti Teles dos Santos RA00321629
 * @author João Marcos Ribeirete Garbelini RA00321617
 * @author Mateus Neves Erédia RA00318954
 * @author Vitor Assunção Silva RA00320255
 * @version 19/06/2023
 */
public class PainelEntrada {
    int qtdIndividuos;
    int intervalo;
    int esperaT;

    JFrame janelaPrincipal = null;
    Container painelEntrada = new JPanel();
    JLabel jNpont = null;//JLabel jNpont = null;//
    JLabel jTempoEspera = null;//JLabel jTempoEspera = null;
    JLabel jIntervalo = null;// JLabel jIntervalo = null
    JTextField fTempoEspera = null;
    JTextField fNpont = null;
    JTextField fIntervalo = null;
    JButton jbSobre = null;

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }
    
    public void setPainelEntrada(Container painelEntrada) {
        this.painelEntrada = painelEntrada;
    }
    
    public void setTempoEspera(int esperaT) {
        this.esperaT = esperaT;
    }

    public void setJanelaPrincipal(JFrame janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    public void setQtdIndividuos(int qtdIndividuos) {
        this.qtdIndividuos = qtdIndividuos;
    }

    public Container getPainelEntrada() {
        return this.painelEntrada;
    }
    
    public int getQtdIndividuos() {
        return this.qtdIndividuos;
    }
    
    public int getIntervalo() {
        return this.intervalo;
    }

    public JFrame getJanelaPrincipal() {
        return this.janelaPrincipal;
    }

    public int getTempoEspera() {
        return this.esperaT;
    }

    /**
     * Método a PainelEntrada  - Entradas no painel
     * @param janelaPrincipal JFrame ,Um parâmetro
     * @param qtdIndividuos int ,quantidade de individuos 
     * @param esperaT int ,tempo de espera entre os cliclos josephus
     */
    public PainelEntrada(JFrame janelaPrincipal, int qtdIndividuos, int intervalo, int esperaT) {
        setJanelaPrincipal(janelaPrincipal);
        setQtdIndividuos(qtdIndividuos);
        setIntervalo(intervalo);
        setTempoEspera(esperaT);
    }

    /**
     * Método inserirPainelEntrada - configuração das entradas na parte grafica 
     *
     */
    public void inserirPainelEntrada() {
        this.jNpont = new JLabel("Numero de individuos");
        this.fNpont = new JTextField("" + getQtdIndividuos());
        this.fNpont.setColumns(4);
        this.fNpont.setEnabled(false);
        this.fNpont.setToolTipText("numero de individuos na lista");
        this.jIntervalo = new JLabel("Intervalo");
        this.fIntervalo = new JTextField("" + getIntervalo());
        this.fIntervalo.setColumns(4);
        this.fIntervalo.setEnabled(false);
        this.fIntervalo.setToolTipText("Intervalo de execucao");
        this.jTempoEspera = new JLabel("Tempo de espera");
        this.fTempoEspera = new JTextField("" + getTempoEspera());
        this.fTempoEspera.setColumns(4);
        this.fTempoEspera.setEnabled(false);
        this.fTempoEspera.setToolTipText("Tempo de espera");
        this.painelEntrada.add(this.jNpont);
        this.painelEntrada.add(this.fNpont);
        this.painelEntrada.add(this.jIntervalo);
        this.painelEntrada.add(this.fIntervalo);
        this.painelEntrada.add(this.jTempoEspera);
        this.painelEntrada.add(this.fTempoEspera);

        getJanelaPrincipal().add("North", this.painelEntrada);
    }
}