import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * PainelComandos
 * 
 * @author André Cavalcanti Teles dos Santos RA00321629
 * @author João Marcos Ribeirete Garbelini RA00321617
 * @author Mateus Neves Erédia RA00318954
 * @author Vitor Assunção Silva RA00320255
 * @version 19/06/2023
 */
public class PainelComandos {
    JFrame janelaPrincipal = null;
    Container painelComandos = new JPanel();
    JLabel jIndividuoRestV = null;
    JLabel jIndividuoR = null;
    JButton jbSair = null;
    JButton jbReiniciar = null;
    JButton jbExecutar = null;
    
    

    public void setJanelaPrincipal(JFrame janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    public JFrame getJanelaPrincipal() {
        return this.janelaPrincipal;
    }

    public PainelComandos(JFrame janelaPrincipal) {
        setJanelaPrincipal(janelaPrincipal);
        this.painelComandos.setLayout(new FlowLayout());
    }

    /**
     * Método inserirPainelComandos - configuraçoes dos comandos na parte grafica
     *
     */
    public void inserirPainelComandos() {
        this.jIndividuoR = new JLabel("Individuo executado: ");
        this.jIndividuoR.setVisible(false);
        this.jIndividuoRestV = new JLabel("  ");
        this.jIndividuoRestV.setBackground(Color.GRAY);
        this.jIndividuoRestV.setVisible(false);
        this.jbExecutar = new JButton("Executar");
        this.jbExecutar.setToolTipText("Executar regras do Josephus");
        this.jbExecutar.addActionListener((ActionListener) getJanelaPrincipal());
        this.jbReiniciar = new JButton("Reiniciar");
        this.jbReiniciar.setToolTipText("Reiniciar Josephus com os mesmos valores");
        this.jbReiniciar.addActionListener((ActionListener) getJanelaPrincipal());
        this.jbReiniciar.setEnabled(false);
        this.jbSair = new JButton("Sair");
        this.jbSair.setToolTipText("Termina programa");
        this.jbSair.addActionListener((ActionListener) getJanelaPrincipal());
        this.painelComandos.add(this.jIndividuoR);
        this.painelComandos.add(this.jIndividuoRestV);
        this.painelComandos.add(this.jbExecutar);
        this.painelComandos.add(this.jbReiniciar);
        this.painelComandos.add(this.jbSair);

        getJanelaPrincipal().add("South", this.painelComandos);
    }
}
