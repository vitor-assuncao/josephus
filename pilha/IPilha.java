package pilha; 

public interface IPilha {
  Object topo();
  Object remover();
  boolean inserir(Object paramObject);
  boolean estaVazia();
  boolean estaCheia();
}