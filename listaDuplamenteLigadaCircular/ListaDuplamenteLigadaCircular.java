package listaDuplamenteLigadaCircular;

public class ListaDuplamenteLigadaCircular implements IListaDuplamenteLigadaCircular {
    private No inicio;
    private No fim;

     public void setFim(No fim) {
        this.fim = fim;
    }
    
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }
    
    public No getInicio() {
        return this.inicio;
    }

    public No getFim() {
        return this.fim;
    }

    public ListaDuplamenteLigadaCircular() {
        setInicio(null);
        setFim(null);
    }

    public boolean estaVazia() {
        return (getInicio() == null);
    }

    public void inserirInicio(Object elem, int cod) {
        No novoNo = new No(elem, cod);

        if (estaVazia()) {
            setFim(novoNo);
        } else {
            getInicio().setAnterior(novoNo);
        }

        novoNo.setProximo(getInicio());
        setInicio(novoNo);
        getFim().setProximo(getInicio());
        getInicio().setAnterior(getFim());
    }

    public void inserirFim(Object elem, int cod) {
        No novoNo = new No(elem, cod);

        if (estaVazia()) {
            setInicio(novoNo);
        } else {
            getFim().setProximo(novoNo);
            novoNo.setAnterior(getFim());
        }

        setFim(novoNo);
        getFim().setProximo(getInicio());
        getInicio().setAnterior(getFim());
    }

    public No removerInicio() {
        No temp = null;
        if (getInicio() != null && getFim() != null) {
            temp = getInicio();

            if (getInicio() == getFim()) {
                setInicio(null);
                setFim(null);
            } else {
                getFim().setProximo(getInicio().getProximo());
                getInicio().getProximo().setAnterior(getFim());
                setInicio(getInicio().getProximo());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        return temp;
    }

    public No removerFim() {
        No temp = null;
        if (getFim() != null && getInicio() != null) {
            temp = getFim();

            if (getFim() == getInicio()) {
                setFim(null);
                setInicio(null);
            } else {
                getInicio().setAnterior(getFim().getAnterior());
                setFim(getFim().getAnterior());
                getFim().setProximo(getInicio());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        return temp;
    }

    public boolean inserirApos(int key, Object elem, int cod) {
        No noAtual = getInicio();

        while (noAtual.getCod() != key) {
            if (noAtual == getFim()) {
                return false;
            }
            noAtual = noAtual.getProximo();
        }
        No novoNo = new No(elem, cod);

        if (noAtual == getFim()) {
            novoNo.setProximo(getInicio());
            setFim(novoNo);
        } else {
            novoNo.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(noAtual);
        noAtual.setProximo(novoNo);
        return true;
    }

    public No removerPelaChave(int chave) {
        No noAtual = null;
        if (getInicio() != null) {
            noAtual = getInicio();

            while (noAtual.getCod() != chave) {
                if (noAtual == getFim()) {
                    return null;
                }
                noAtual = noAtual.getProximo();
            }

            if (noAtual == getInicio()) {
                noAtual = removerInicio();
            } else if (noAtual == getFim()) {
                noAtual = removerFim();
            } else {
                noAtual.getAnterior().setProximo(noAtual.getProximo());
                noAtual.getProximo().setAnterior(noAtual.getAnterior());
            }
            noAtual.setAnterior(null);
            noAtual.setProximo(null);
        }

        return noAtual;
    }

    public void limparLista() {
        No temp = getInicio();

        while (temp != getFim()) {
            removerFim();
        }

        setInicio(null);
        setFim(null);
    }
    
        public String toString() {
        String s = "[ ";
        No noAtual = getInicio();
        if (noAtual != null) {
            do {
                s = s + noAtual.toString() + " ";
                noAtual = noAtual.getProximo();
            } while (noAtual != getInicio());
        }
        s = s + "]";
        return s;
    }

    public String toStrinDoFim() {
        String s = "[ ";
        No noAtual = getFim();

        if (noAtual != null) {
            do {
                s = s + noAtual.toString() + " ";
                noAtual = noAtual.getAnterior();
            } while (noAtual != getFim());
        }
        s = s + "]";
        return s;
    }

}
