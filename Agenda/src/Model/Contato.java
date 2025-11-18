package Model;

import java.util.Objects;

public class Contato {

    // --- Atributos ---
    private Integer idContato;
    private Integer idUsuario; // Chave estrangeira para ligar ao Usuário
    private String telefone;
    private String celular;
    private String email;
    private boolean principal;

    // --- Construtores ---
    public Contato() {
    }

    public Contato(Integer idContato, Integer idUsuario, String telefone, String celular, String email, boolean principal) {
        this.idContato = idContato;
        this.idUsuario = idUsuario;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.principal = principal;
    }

    // --- Getters e Setters ---
    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ADICIONADO: Método necessário para resolver o erro de compilação em UsuarioCompleto.java
    public boolean getPrincipal() {
        return principal;
    }

    // Método Idiomático Java (isPrincipal)
    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    // --- Métodos Sobrescritos ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(idContato, contato.idContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContato);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idUsuario=" + idUsuario +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", principal=" + principal +
                '}';
    }
}