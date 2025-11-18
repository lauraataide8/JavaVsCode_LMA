package JBCDSimples;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {

    private int idProduto;
    private String nome;
    private String categoria;
    private BigDecimal preco;
    private LocalDate dataCadastro;

    // Getters e Setters (essenciais para o DAO)
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // toString() para formatar a saída no JOptionPane
    @Override
    public String toString() {
        return "ID: " + idProduto +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nPreço: R$ " + preco +
                "\nData Cadastro: " + dataCadastro +
                "\n--------------------\n";
    }
}