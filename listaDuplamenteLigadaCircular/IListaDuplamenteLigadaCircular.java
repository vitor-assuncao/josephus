package listaDuplamenteLigadaCircular; 

public interface IListaDuplamenteLigadaCircular {
  void inserirInicio(Object paramObject, int paramInt);
  void inserirFim(Object paramObject, int paramInt);
  No removerInicio();
  No removerFim();
  No removerPelaChave(int paramInt);
  boolean estaVazia();
  boolean inserirApos(int paramInt1, Object paramObject, int paramInt2);
}