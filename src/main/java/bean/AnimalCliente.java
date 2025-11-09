
package bean;


 public class AnimalCliente {
    private int idAnimal;
    private String nomeAnimal;
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;

    
    public int getIdAnimal() {
        return idAnimal; }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal; }

    public String getNomeAnimal() { 
        return nomeAnimal; }
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal; }

    public int getIdCliente() {
        return idCliente; }
    public void setIdCliente(int idCliente) { 
        this.idCliente = idCliente; }

    public String getNomeCliente() {
        return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { 
        this.nomeCliente = nomeCliente; }

    public String getCpfCliente() { 
        return cpfCliente; }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente; }
    }
