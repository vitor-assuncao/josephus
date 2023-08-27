package listaLigada;

public class No {
    Object conteudo;
    No proximo;

    public No(Object conteudo) {
        setConteudo(conteudo);
        setProximo(null);
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public Object getConteudo() {
        return this.conteudo;
    }

    public No getProximo() {
        return this.proximo;
    }

    public String toString() {
        return this.conteudo.toString();
    }
}
