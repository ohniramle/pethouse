
package bean;

public class Compra {
    private int idCompra;
    private String dataCompra;
    private int idProduto;
    private int idFornecedor;
    private int quantidade;
    private double precoUnitario;
    private double valorTotal;

    public Compra() {
        
    }

    public Compra(int idCompra, String dataCompra, int idProduto, int idFornecedor, int quantidade, double precoUnitario, double valorTotal) {
        this.idCompra = idCompra;
        this.dataCompra = dataCompra;
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
    }
    
    
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double preco) {
        this.valorTotal = valorTotal;
    }
    
    
}
