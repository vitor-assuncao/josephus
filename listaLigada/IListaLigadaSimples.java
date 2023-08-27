package listaLigada; 

public interface IListaLigadaSimples {
  void inserirInicio(Object paramObject);
  void inserirFim(Object paramObject);
  boolean estaVazia();
  No removerInicio();
  No removerFim();
}