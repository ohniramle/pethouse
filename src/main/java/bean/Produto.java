
package bean;


public class Produto {
    private int id_produto;
    private String nome;
    private double preco;
    private String descricao;
    private int fornecedor;

    public Produto(){};
    
    public Produto(int id_produto, String nome, double preco, String descricao,int fornecedor) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.fornecedor=fornecedor;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    
    
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    

    

    
  
}
