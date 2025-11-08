
package bean;


public class ProdutoEstoque {
    
    private int id;
    private String nome;
    private double precoUnitario;
    private int quantidade;
    private double valorTotal;

    
    public int getId() {
        return id; }
    public void setId(int id) { 
        this.id = id; }

    public String getNome() { 
        return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPrecoUnitario() {
        return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }

    public int getQuantidade() {
        return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorTotal() { 
        return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
}

