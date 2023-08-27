package pilha;
import listaLigada.IListaLigadaSimples;
import listaLigada.ListaLigadaSimples;
import listaLigada.No;

public class Pilha implements IPilha {
    int tam;
    int qtde;
    IListaLigadaSimples armazen;

    public Pilha(int tam) {
        this.armazen = (IListaLigadaSimples) new ListaLigadaSimples();
        setTam(tam);
        setQtde(0);
    }

     public void setTam(int tam) {
        this.tam = tam;
    }
    
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    public void setArmazen(IListaLigadaSimples armazen) {
        this.armazen = armazen;
    }

    public int getTam() {
        return this.tam;
    }
    
    public int getQtde() {
        return this.qtde;
    }

    public IListaLigadaSimples getArmazen() {
        return this.armazen;
    }

    public boolean inserir(Object elem) {
        boolean ret = false;
        if (!estaCheia()) {
            No novo = new No(elem);
            this.armazen.inserirInicio(novo);
            setQtde(getQtde() + 1);
            ret = true;
        }
        return ret;
    }

    public Object remover() {
        Object elem = null;

        if (!estaVazia()) {
            elem = this.armazen.removerInicio().getConteudo();
            setQtde(getQtde() - 1);
        }
        return elem;
    }

    public boolean estaCheia() {
        return (getQtde() == getTam());
    }
    
    public boolean estaVazia() {
        return (getQtde() == 0);
    }

    public Object topo() {
        Object elem = null;

        if (!estaVazia()) {
            elem = ((ListaLigadaSimples) this.armazen).getInicio().getConteudo();
        }
        return elem;
    }

    public String toString() {
        return getArmazen().toString();
    }
}
