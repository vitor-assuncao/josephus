package listaDuplamenteLigadaCircular;

public class No {
    int cod;
    Object conteudo;
    No proximo;
    No anterior;

    public No(Object conteudo, int cod) {
        setCod(cod);
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Object getConteudo() {
        return this.conteudo;
    }

    public No getProximo() {
        return this.proximo;
    }

    public No getAnterior() {
        return this.anterior;
    }

    public int getCod() {
        return this.cod;
    }

    public String toString() {
        return this.conteudo.toString();
    }
}
