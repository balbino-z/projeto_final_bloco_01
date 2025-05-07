package ecommerce_java.model;

public abstract class Produto {
    
    private int id;
    private String nome;
    private String time;
    private String liga;
    private String tamanho;
    private float preco;
    
    public Produto(int id, String nome, String time, String liga, String tamanho, float preco) {
        this.id = id;
        this.nome = nome;
        this.time = time;
        this.liga = liga;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public abstract void visualizar();
}