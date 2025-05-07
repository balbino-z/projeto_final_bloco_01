package ecommerce_java.model;

// classe CamisaRetro (subclasse de Produto)
public class CamisaRetro extends Produto {
    
    // atributo adicional
    private String anoLancamento;

    // construtor
    public CamisaRetro(int id, String nome, String time, String liga, String tamanho, float preco, String anoLancamento) {
        super(id, nome, time, liga, tamanho, preco);
        this.anoLancamento = anoLancamento;
    }

    // getter e setter para o atributo adicional
    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    // implementação do método visualizar (sobrescrita)
    @Override
    public void visualizar() {
        System.out.println("\n***********************************************************");
        System.out.println("                  Dados do Produto                         ");
        System.out.println("***********************************************************");
        System.out.println("ID: " + this.getId());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Time: " + this.getTime());
        System.out.println("Liga: " + this.getLiga());
        System.out.println("Tamanho: " + this.getTamanho());
        System.out.println("Preço: R$ " + String.format("%.2f", this.getPreco()));
        System.out.println("Tipo: Camisa Retrô");
        System.out.println("Ano de Lançamento: " + this.anoLancamento);
        System.out.println("***********************************************************");
    }
}