
package bean;



public class Cliente {
    private int id_cliente;
    private String CPF;
    private String nome;
    private String email;
    private String dataNascimento;
    private String sexo;
    private String telefone;
    private String CEP;
    private String endereco;
    

    public Cliente (){}; 
    
    public Cliente( int id_cliente, String CPF, String nome, String email, String dataNascimento,String sexo, String CEP, String endereco , String telefone) {
        this.id_cliente= id_cliente;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.CEP = CEP;
        this.endereco = endereco;
        this.telefone = telefone;
        
    }

    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNacimento) {
        this.dataNascimento = dataNacimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // para exibir o nome no ComboBox
    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
