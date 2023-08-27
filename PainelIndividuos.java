import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * PainelIdivividuos
 * 
 * @author André Cavalcanti Teles dos Santos RA00321629
 * @author João Marcos Ribeirete Garbelini RA00321617
 * @author Mateus Neves Erédia RA00318954
 * @author Vitor Assunção Silva RA00320255
 * @version 19/06/2023
 */
public class PainelIndividuos {
    int qtdIndividuos;
    
    JFrame janelaPrincipal = null;
    Color corIndividuo = null;
    Color corFundoPainel = null;
    Color corTextoIndividuo = null;
    Container painelIndividuos = new JPanel();
    JLabel[] individuos = null;
    
    public void setCorTextoIndividuo(Color corTextoIndividuo) {
        this.corTextoIndividuo = corTextoIndividuo;
    }
    
    public void setQtdIndividuos(int qtdIndividuos) {
        this.qtdIndividuos = qtdIndividuos;
    }
    
    public void setJanelaPrincipal(JFrame janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    public void setCorFundoPainel(Color corFundoPainel) {
        this.corFundoPainel = corFundoPainel;
    }
    
    protected void setCorIndividuo(Color corIndividuo) {
        this.corIndividuo = corIndividuo;
    }
    
    public int getQtdIndividuos() {
        return this.qtdIndividuos;
    }
    
    public JFrame getJanelaPrincipal() {
        return this.janelaPrincipal;
    }
    
     public Color getCorFundoPainel() {
        return this.corFundoPainel;
    }

    public Color getCorTextoIndividuo() {
        return this.corTextoIndividuo;
    }

    protected Color getCorIndividuo() {
        return this.corIndividuo;
    }

    /**
     * Método inserirPainelIndividuos  - Insere um elemento no painel grafico
     *@param qtde int
     */
    public void inserirPainelIndividuos(int qtde) {
        adicionarLabelsNoPainelIndividuos(qtde);
        getJanelaPrincipal().add("Center", this.painelIndividuos);
    }
    
     /**
     * Método adicionarLabelsNoPainelIndividuos  - Insere um elemento no painel grafico
     * @param qtde int
     */
        public void adicionarLabelsNoPainelIndividuos(int qtd) {
        this.painelIndividuos.removeAll();
        this.painelIndividuos.repaint();

        for (int k = qtd - 1; k >= 0; k--) {
            this.individuos[k] = new JLabel();
            this.individuos[k].setPreferredSize(new Dimension(90,20));
            this.individuos[k].setToolTipText("(" + (k + 1) + ")");
            this.individuos[k].setOpaque(true);
            this.individuos[k].setHorizontalAlignment(0);
            this.individuos[k].setBackground(getCorIndividuo());
            this.painelIndividuos.add(this.individuos[k], 0);
        }
    }
    
    /**
     * Método recriarArrayIndividuos  - recria o array dos individuos
     * @param qtde int
     */
    public void recriarArrayIndividuos(int qtde) {
        setQtdIndividuos(qtde);
        this.individuos = new JLabel[getQtdIndividuos()];
    }
    
    /**
     * PainelIndividuos Construtor - configuraçoes dos individuos na parte grafica 
     *
     * @param janelaPrincipal Um parâmetro
     * @param qtdIndividuos Um parâmetro
     */
    public PainelIndividuos(JFrame janelaPrincipal, int qtdIndividuos) {
        setJanelaPrincipal(janelaPrincipal);
        setQtdIndividuos(qtdIndividuos);
        setCorTextoIndividuo(Color.WHITE);
        setCorFundoPainel(Color.DARK_GRAY);
        setCorIndividuo(Color.WHITE);
        this.painelIndividuos.setLayout(new FlowLayout(0));
        this.painelIndividuos.setBackground(getCorFundoPainel());
        this.painelIndividuos.setPreferredSize(new Dimension(950, 450)); 
        this.individuos = new JLabel[qtdIndividuos];
    }

}



