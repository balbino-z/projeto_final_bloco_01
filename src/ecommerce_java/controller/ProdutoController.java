package ecommerce_java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ecommerce_java.model.Camisa;
import ecommerce_java.model.CamisaRetro;
import ecommerce_java.model.Produto;
import ecommerce_java.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
    
    private List<Produto> listaProdutos;
    private int ultimoId;
    
    public ProdutoController() {
        this.listaProdutos = new ArrayList<Produto>();
        this.ultimoId = 0;
    }
    
    public int gerarId() {
        return ++ultimoId;
    }
    
    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nProduto " + produto.getNome() + " foi cadastrado com sucesso!");
    }

    @Override
    public void listarTodos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("\nNão há produtos cadastrados no sistema.");
            return;
        }
        
        for (Produto produto : listaProdutos) {
            produto.visualizar();
        }
    }

    @Override
    public void deletar(int id) {
        Optional<Produto> produtoOptional = buscarNaListaPorId(id);
        
        if (produtoOptional.isPresent()) {
            if (listaProdutos.remove(produtoOptional.get())) {
                System.out.println("\nProduto foi excluído com sucesso!");
            }
        } else {
            System.out.println("\nProduto com ID: " + id + " não foi encontrado.");
        }
    }

    @Override
    public void atualizar(Produto produto) {
        Optional<Produto> produtoOptional = buscarNaListaPorId(produto.getId());
        
        if (produtoOptional.isPresent()) {
            int index = listaProdutos.indexOf(produtoOptional.get());
            listaProdutos.set(index, produto);
            System.out.println("\nProduto atualizado com sucesso!");
        } else {
            System.out.println("\nProduto com ID: " + produto.getId() + " não foi encontrado.");
        }
    }

    @Override
    public void consultarPorId(int id) {
        Optional<Produto> produtoOptional = buscarNaListaPorId(id);
        
        if (produtoOptional.isPresent()) {
            produtoOptional.get().visualizar();
        } else {
            System.out.println("\nProduto com ID: " + id + " não foi encontrado.");
        }
    }
    
    public Produto buscarPorId(int id) {
        Optional<Produto> produtoOptional = buscarNaListaPorId(id);
        
        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        }
        
        return null;
    }
    
    private Optional<Produto> buscarNaListaPorId(int id) {
        return listaProdutos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    @Override
    public void consultarPorNome(String nome) {
        List<Produto> produtosEncontrados = listaProdutos.stream()
                .filter(produto -> produto.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
        
        if (produtosEncontrados.isEmpty()) {
            System.out.println("\nNão foram encontrados produtos com o nome: " + nome);
            return;
        }
        
        for (Produto produto : produtosEncontrados) {
            produto.visualizar();
        }
    }

    @Override
    public void consultarPorLiga(String liga) {
        try {
            List<Produto> produtosEncontrados = listaProdutos.stream()
                    .filter(produto -> produto.getLiga().equalsIgnoreCase(liga))
                    .collect(Collectors.toList());
            
            if (produtosEncontrados.isEmpty()) {
                System.out.println("\nNão foram encontrados produtos da liga: " + liga);
                return;
            }
            
            for (Produto produto : produtosEncontrados) {
                produto.visualizar();
            }
        } catch (Exception e) {
            System.out.println("\nOcorreu um erro ao consultar produtos por liga: " + e.getMessage());
        }
    }

    @Override
    public void listarCamisasRetro() {
        try {
            List<Produto> produtosRetro = listaProdutos.stream()
                    .filter(produto -> produto instanceof CamisaRetro)
                    .collect(Collectors.toList());
            
            if (produtosRetro.isEmpty()) {
                System.out.println("\nNão há camisas retrô cadastradas no sistema.");
                return;
            }
            
            for (Produto produto : produtosRetro) {
                produto.visualizar();
            }
        } catch (Exception e) {
            System.out.println("\nOcorreu um erro ao listar camisas retrô: " + e.getMessage());
        }
    }
    
    // método para verificar o tipo do produto (1 - Camisa, 2 - CamisaRetro)
    public int verificarTipo(int id) {
        Optional<Produto> produtoOptional = buscarNaListaPorId(id);
        
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            if (produto instanceof CamisaRetro) {
                return 2;
            } else if (produto instanceof Camisa) {
                return 1;
            }
        }
        
        return 0;
    }
}