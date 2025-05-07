package ecommerce_java.model;

import ecommerce_java.util.Cores;

public class CamisaRetro extends Produto {
    
    private String anoLancamento;
    
    public CamisaRetro(int id, String nome, String time, String liga, String tamanho, float preco, String anoLancamento) {
        super(id, nome, time, liga, tamanho, preco);
        this.anoLancamento = anoLancamento;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    @Override
    public void visualizar() {
        System.out.println(Cores.TEXT_YELLOW + "\n------------------------------------------");
        System.out.println("Dados do Produto Retrô: ");
        System.out.println("------------------------------------------");
        System.out.println("ID: " + this.getId());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Time: " + this.getTime());
        System.out.println("Liga: " + this.getLiga());
        System.out.println("Tamanho: " + this.getTamanho());
        System.out.println("Preço: R$ " + String.format("%.2f", this.getPreco()));
        System.out.println("Ano de Lançamento: " + this.anoLancamento);
        System.out.println("------------------------------------------" + Cores.TEXT_RESET);
    }
}