package Animalia;

// 1. ADICIONAMOS "extends Animal"
public class AnimaisMarinhos extends Animal {


    // 1. ATRIBUTOS (Específicos desta classe)

    private String respiracao; // Ex: "Branquial" ou "Pulmonar"
    private String locomocao;  // Ex: "Nadadeiras"


    // 2. CONSTRUTOR (Corrigido)
    // (Precisa receber TODOS os parâmetros)
    public AnimaisMarinhos(
            // --- Parâmetros para a classe-pai (Animal) ---
            String nome, String especie, String habitat, String caracteristicasCorporais,
            String nomeCientifico, String caracteristicas, int peso, int altura, String tamanho,

            // --- Parâmetros específicos desta classe ---
            String respiracao, String locomocao
    ) {

        // 1. CHAME O CONSTRUTOR PAI (super) PRIMEIRO
        super(nome, especie, habitat, caracteristicasCorporais, nomeCientifico,
                caracteristicas, peso, altura, tamanho);

        // 2. DEPOIS, configure os atributos desta classe
        this.respiracao = respiracao;
        this.locomocao = locomocao;
    }


    // 3. MÉTODOS (Getters e Setters - os seus estavam perfeitos!)
    public String getRespiracao() {
        return respiracao;
    }

    public void setRespiracao(String respiracao) {
        this.respiracao = respiracao;
    }

    public String getLocomocao() {
        return locomocao;
    }

    public void setLocomocao(String locomocao) {
        this.locomocao = locomocao;
    }
@Override
    public void exibirInfo() {
        super.exibirInfo();

    }
}