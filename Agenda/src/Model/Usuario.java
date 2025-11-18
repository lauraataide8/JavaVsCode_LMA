package Model;
import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    // --- Atributos ---
    private Integer idUsuario;          // 1. Corrigido: id_Usuario -> idUsuario
    private String nome;
    private String genero;
    private LocalDate dataNascimento;   // 2. Corrigido: data_nascimento -> dataNascimento
    private String nacionalidade;

    // --- Construtores ---
    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nome, String genero, LocalDate dataNascimento, String nacionalidade) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    // --- Getters e Setters ---
    public Integer getIdUsuario() { // 1. Getters/Setters ajustados
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) { // 1. Getters/Setters ajustados
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() { // 2. Getters/Setters ajustados
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) { // 2. Getters/Setters ajustados
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario); // Ajustado para idUsuario
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario); // Ajustado para idUsuario
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario + // Ajustado para idUsuario
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dataNascimento=" + dataNascimento + // Ajustado para dataNascimento
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}