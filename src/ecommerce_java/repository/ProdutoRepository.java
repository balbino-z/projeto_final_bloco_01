package ecommerce_java.repository;

import ecommerce_java.model.Produto;

// interface com os métodos obrigatórios para o CRUD de produtos
public interface ProdutoRepository {
    
    // create
    public void cadastrar(Produto produto);
    
    // read
    public void listarTodos();
    public void consultarPorId(int id);
    public void consultarPorNome(String nome);
    public void consultarPorLiga(String liga);
    public void listarCamisasRetro();
    
    // update
    public void atualizar(Produto produto);
    
    // delete
    public void deletar(int id);
}