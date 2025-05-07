package ecommerce_java.model;

import ecommerce_java.util.Cores;

public class Camisa extends Produto {
    
    public Camisa(int id, String nome, String time, String liga, String tamanho, float preco) {
        super(id, nome, time, liga, tamanho, preco);
    }
    
    @Override
    public void visualizar() {
        System.out.println(Cores.TEXT_YELLOW + "\n------------------------------------------");
        System.out.println("Dados do Produto: ");
        System.out.println("------------------------------------------");
        System.out.println("ID: " + this.getId());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Time: " + this.getTime());
        System.out.println("Liga: " + this.getLiga());
        System.out.println("Tamanho: " + this.getTamanho());
        System.out.println("Preço: R$ " + String.format("%.2f", this.getPreco()));
        System.out.println("------------------------------------------" + Cores.TEXT_RESET);
    }
}