import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import listaDuplamenteLigadaCircular.ListaDuplamenteLigadaCircular;
import listaDuplamenteLigadaCircular.No;
import pilha.Pilha;

/**
 * JosephusGui
 * 
 * @author André Cavalcanti Teles dos Santos RA00321629
 * @author João Marcos Ribeirete Garbelini RA00321617
 * @author Mateus Neves Erédia RA00318954
 * @author Vitor Assunção Silva RA00320255
 * @version 19/06/2023
 */
public class JosephusGui extends JFrame implements ActionListener
{
    int qtdIndividuos;
    int intervalo;
    int tempoEspera;

    Container painelPrincipal = getContentPane();
    PainelEntrada pne = null;
    PainelIndividuos pni = null;
    PainelComandos pnc = null;
    Animacao animar;
    Color corIndividuoExecutado = null;
    ListaDuplamenteLigadaCircular ldlcIndividuos = null;
    Pilha executados = null;

    /**
     * Construtor para objetos da classe JosephusGui
     * 
     * @param qtdIndividuos int , quantidade de Individuos 
     * @param intervalo int, intervalo para contagem do josephus
     * @param tempoEspera int, tempo para cada clico do josephus
     * @param serie int, serie 
     * @param disc array de Disciplinas
     */
    public JosephusGui(int qtdIndividuos, int intervalo, int tempoEspera) {

        super("Josephus LED v1.0");

        setSize(800, 400);
        setDefaultCloseOperation(3);
        setResizable(false);
        setCorIndividuoExecutado(Color.BLACK);

        this.pne = new PainelEntrada(this, qtdIndividuos, intervalo, tempoEspera);
        this.pni = new PainelIndividuos(this, qtdIndividuos);
        this.pnc = new PainelComandos(this);

        setQtdIndividuos(qtdIndividuos);
        setIntervalo(intervalo);
        setTempoEspera(tempoEspera);

        this.ldlcIndividuos = new ListaDuplamenteLigadaCircular();
        this.executados = new Pilha(qtdIndividuos);

        criarListaIndividuos(getQtdIndividuos());
    }

    public void setPainelPrincipal(Container painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
    }

    public void setPne(PainelEntrada pne) {
        this.pne = pne;
    }

    public void setPni(PainelIndividuos pni) {
        this.pni = pni;
    }

    public void setPnc(PainelComandos pnc) {
        this.pnc = pnc;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public void setQtdIndividuos(int qtdIndividuos) {
        this.qtdIndividuos = qtdIndividuos;
    }

    public void setAnimar(Animacao animar) {
        this.animar = animar;
    }

    public void setLdlcIndividuos(ListaDuplamenteLigadaCircular ldlcIndividuos) {
        this.ldlcIndividuos = ldlcIndividuos;
    }

    public void setExecutados(Pilha executados) {
        this.executados = executados;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public void setCorIndividuoExecutado(Color corIndividuoExecutado) {
        this.corIndividuoExecutado = corIndividuoExecutado;
    }

    public Container getPainelPrincipal() {
        return this.painelPrincipal;
    }

    public Color getCorIndividuoExecutado() {
        return this.corIndividuoExecutado;
    }

    public PainelEntrada getPne() {
        return this.pne;
    }

    public PainelIndividuos getPni() {
        return this.pni;
    }

    public int getIntervalo() {
        return this.intervalo;
    }

    public int getQtdIndividuos() {
        return this.qtdIndividuos;
    }

    public int getTempoEspera() {
        return this.tempoEspera;
    }

    public PainelComandos getPnc() {
        return this.pnc;
    }

    public Pilha getExecutados() {
        return this.executados;
    }

    public Animacao getAnimar() {
        return this.animar;
    }

    public ListaDuplamenteLigadaCircular getLdlcIndividuos() {
        return this.ldlcIndividuos;
    }

    private void limparListaIndividuos() {
        getLdlcIndividuos().limparLista();
    }

    /**
     * Método criarListaIndividuos - cria lista de individuos de acordo com a quantidade 
     *
     * @param qtdIndividuos int, quantidade de individuos
     */
    private void criarListaIndividuos(int qtdIndividuos) {
        for (int i = 1; i <= qtdIndividuos; i++) {
            getLdlcIndividuos().inserirFim("" + i, i);
        }
    }

    /**
     * Método reconfigurar - reinicia o josephus 
     *
     * @param qtdIndividuos int, quantidade de individuos
     * @param intervalo int, intervalo entre os saltos do josephus
     * @param tempoEspera int, quantidade de tempo para cada ciclo do josephus
     */
    private void reconfigurar(int qtdeIndividuos, int intervalo, int tempoEspera) {
        setQtdIndividuos(qtdeIndividuos);
        setIntervalo(intervalo);
        setTempoEspera(tempoEspera);

        reiniciarEd();

        this.pni.inserirPainelIndividuos(getQtdIndividuos());
        setVisible(true);
    }

    /**
     * Método mostrargui - ativa a parte grafica 
     *
     */
    public void mostrarGui() {
        adicionarPaineis();
        pack();
        setVisible(true);
    }

    /**
     * Método mostrarListaIndividuos - mostra a lista com os individuos
     *
     */
    private void mostrarListaIndividuos() {
        System.out.println(getLdlcIndividuos());
    }

    /**
     * Método adicionarPaineis
     *
     */
    public void adicionarPaineis() {
        this.pne.inserirPainelEntrada();
        this.pni.inserirPainelIndividuos(getQtdIndividuos());
        this.pnc.inserirPainelComandos();
    }

    /**
     * Método actionPerformed - caso seja acionado um dos botoes do painel 
     *
     * @param evt Um parâmetro
     */
    public void actionPerformed(ActionEvent evt) {
        String comando = evt.getActionCommand();
        if (comando.equals("Sair")) {
            sair();
        } else if (comando.equals("Executar")) {
            executar();
        } else if (comando.equals("Reiniciar")) {
            reiniciar();
        } 
    }

    /**
     * Método reiniciarEd - reinicia a simulação do Josephus
     *
     */
    private void reiniciarEd() {
        this.executados = new Pilha(getQtdIndividuos() - 1);
        limparListaIndividuos();
        criarListaIndividuos(getQtdIndividuos());
        this.pni.recriarArrayIndividuos(getQtdIndividuos());
    }

    private class Animacao extends Thread{
        private Animacao() {}

        /**
         * Método run-inicia a logica josephus 
         *
         */
        public void run() {
            int numIndividuos = JosephusGui.this.getQtdIndividuos();
            int intervalo = JosephusGui.this.getIntervalo();

            realizarAlgoritmoJosephus(numIndividuos, intervalo);
        }

        /**
         * Método realizar - 
         *
         * @param numIndividuos int, quantidade de individuos
         * @param intervalo int, intervalo entre os saltos do josephus
         */
        public void realizarAlgoritmoJosephus(int numIndividuos, int intervalo) {
            int qtdRem = 0;
            int interCont = 1;

            while (numIndividuos > 1) {
                No paux = JosephusGui.this.getLdlcIndividuos().getInicio();
                for (int nInd = 1; nInd <= numIndividuos; nInd++) {

                    if (interCont == intervalo) {
                        int chave = Integer.parseInt((String)paux.getConteudo());

                        paux = paux.getProximo();
                        No individuo = JosephusGui.this.ldlcIndividuos.removerPelaChave(chave);
                        JosephusGui.this.executados.inserir(individuo);

                        mostraDadosIndividuoExecutado(individuo);

                        try {
                            Thread.sleep(JosephusGui.this.getTempoEspera());
                        } catch (InterruptedException e) {
                            System.out.println("ERRO INESPERADO");
                            System.exit(0);
                        }

                        interCont = 1;
                        qtdRem++;
                    } else {
                        paux = paux.getProximo();
                        interCont++;
                    } 
                }
                numIndividuos -= qtdRem;
                qtdRem = 0;
            } 
            mostraDadosFinais();

            JosephusGui.this.pnc.jbReiniciar.setEnabled(true);
            JosephusGui.this.pnc.jIndividuoR.setVisible(true);
            JosephusGui.this.pnc.jIndividuoRestV.setVisible(true);
        }

        /**
         * Método mostraDadosFinais - mostra os dados finais após a simulação 
         *
         */
        public void mostraDadosFinais() {
            JosephusGui.this.pnc.jIndividuoRestV.setForeground(Color.BLUE);
            JosephusGui.this.pnc.jIndividuoR.setText("Sobrevivente: ");
            JosephusGui.this.pnc.jIndividuoRestV.setText(JosephusGui.this.ldlcIndividuos.getInicio().toString());

            System.out.println("Sobrevivente: " + JosephusGui.this.ldlcIndividuos);
            System.out.println("Lista de mortos: " + JosephusGui.this.executados);
        }

        /**
         * Método mostraDadosIndividuoExecutado - mostra individuos executados
         *
         *@param individuo Um parâmetro
         */
        public void mostraDadosIndividuoExecutado(No individuo) {
            System.out.println("\tIndividuo " + individuo + " executado... ");
            JosephusGui.this.mostrarListaIndividuos();
            JosephusGui.this.pni.individuos[individuo.getCod() - 1].setBackground(JosephusGui.this.getCorIndividuoExecutado());
            JosephusGui.this.pnc.jIndividuoRestV.setText(individuo.getConteudo().toString());
        }

    }

    /**
     * Método sair - encerra oprograma
     *
     */
    private void sair() {
        System.exit(0);
        JOptionPane.showMessageDialog(null,"Simulação encerrada");
    }

    /**
     * Método iniciarAnimacao - Inicio a "animação" da parte grafica do codigo
     *
     */
    public void iniciarAnimacao() {
        this.animar = new Animacao();
        this.animar.start();
    }

    /**
     * Método finalizarAnimacao - Finaliza a "animação" da parte grafica do codigo
     *
     */
    public void finalizarAnimacao() {
        this.animar.interrupt();
        this.animar = null;
    }

    /**
     * Método executar - da inicio a simulaçao do Josephus
     *
     */
    private void executar() {
        if (getIntervalo() > 1 && getIntervalo() < getQtdIndividuos() && getTempoEspera() > 0) {
            (getPnc()).jbExecutar.setEnabled(false);
            (getPnc()).jbReiniciar.setEnabled(false);
            (getPnc()).jIndividuoR.setVisible(true);
            (getPnc()).jIndividuoRestV.setVisible(true);
            (getPnc()).jIndividuoRestV.setForeground(Color.RED);

            System.out.printf("\nLista de individuos: %d\n", new Object[] { Integer.valueOf(getQtdIndividuos()) });
            mostrarListaIndividuos();
            System.out.printf("\nIntervalo de execucao: %d\n", new Object[] { Integer.valueOf(getIntervalo()) });
            System.out.println();

            try {
                iniciarAnimacao();
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null,"Erro!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores Invalidos", "Erro", 0);
        }
    }

    /**
     * Método reiniciar - reinicia a simulaçao do josephus
     *
     */
    private void reiniciar() {
        int interv = Integer.parseInt((getPne()).fIntervalo.getText());
        int tempo = Integer.parseInt((getPne()).fTempoEspera.getText());
        int qtdSold = Integer.parseInt((getPne()).fNpont.getText());
        if (interv > 1 && interv < qtdSold && tempo > 0) {
            reconfigurar(qtdSold, interv, tempo);

            (getPnc()).jbExecutar.setEnabled(true);
            (getPnc()).jbReiniciar.setEnabled(false);
            (getPnc()).jIndividuoR.setVisible(false);
            (getPnc()).jIndividuoRestV.setVisible(false);
            (getPne()).fNpont.setEnabled(false);
            (getPne()).fIntervalo.setEnabled(false);
            (getPne()).fTempoEspera.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Valores Invalidos", "Erro", 0);
        }
    }

}

