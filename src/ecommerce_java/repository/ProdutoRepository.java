package ecommerce_java.repository;

import ecommerce_java.model.Produto;

public interface ProdutoRepository {
    
    // CRUD básico
    public void cadastrar(Produto produto);
    public void listarTodos();
    public void deletar(int id);
    public void atualizar(Produto produto);
    
    // Métodos específicos
    public void consultarPorId(int id);
    public void consultarPorNome(String nome);
    public void consultarPorLiga(String liga);
    public void listarCamisasRetro();
}