package model;

/**
 *
 * @author g3ra1d0
 */
public class Produto {

    private int id;
    private String nome;
    private double preco;
    private String unidade;

    public String[] VetorTo(String[] dados) {

        dados[0] = String.valueOf(this.id);
        dados[1] = this.nome;
        dados[2] = String.valueOf(this.preco);
        dados[3] = this.unidade;
        
        return dados;
    }

    public String[] toVetor() {
        String vetor[] = new String[4];

        vetor[0] = String.valueOf(getId());
        vetor[1] = getNome();
        vetor[2] = String.valueOf(getPreco());
        vetor[3] = getUnidade();

        return vetor;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

}
