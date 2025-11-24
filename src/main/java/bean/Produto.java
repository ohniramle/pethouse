
package bean;


public class Produto {
    private int id_produto;
    private String nome;
    private double preco;
    private String descricao;
    private Fornecedor fornecedor;

    public Produto(){};
    
    public Produto(int id_produto, String nome, double preco, String descricao,Fornecedor fornecedor) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.fornecedor=fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
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
    //utilizado para mostrar nomes na tabela de compra
    @Override
    public String toString(){
        return this.nome;
    }
    
    

    

    
  
}
