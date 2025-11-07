package Animalia;

public class Animal {


    // 1. ATRIBUTOS (Variáveis da classe)

    // (Geralmente privados, para encapsulamento)

    private String nome;
    private String especie;
    private String habitat;
    private String caracteristicasCorporais;
    private String nomeCientifico;
    private String caracteristicas;
    private int peso;
    private int altura;
    private String tamanho;


    // 2. CONSTRUTOR

    // (Método especial para criar ("construir") um novo objeto Animal)

    public Animal(String nome, String especie, String habitat, String caracteristicasCorporais,
                  String nomeCientifico, String caracteristicas, int peso, int altura, String tamanho) {

        // "this.atributo" se refere ao atributo DA CLASSE
        // "= parametro" se refere ao valor que veio no construtor

        this.nome = nome;
        this.especie = especie;
        this.habitat = habitat;
        this.caracteristicasCorporais = caracteristicasCorporais;
        this.nomeCientifico = nomeCientifico;
        this.caracteristicas = caracteristicas;
        this.peso = peso;
        this.altura = altura;
        this.tamanho = tamanho;

    }


    // 3. MÉTODOS (Getters e Setters)
    // (Métodos públicos para acessar e modificar os atributos privados)
    // Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Espécie
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Habitat
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Características Corporais
    public String getCaracteristicasCorporais() {
        return caracteristicasCorporais;
    }

    public void setCaracteristicasCorporais(String caracteristicasCorporais) {
        this.caracteristicasCorporais = caracteristicasCorporais;
    }

    // Nome Científico
    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    // Características
    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    // Peso
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    // Altura
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Tamanho
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void exibirInfo() {
        System.out.println("Nome: "+nome);
        System.out.println("Altura: "+altura);
        System.out.println("Especie: "+especie);
        System.out.println("Tamanho: "+tamanho);
        System.out.println("Peso: "+peso);
        System.out.println("Caracteristicas: "+caracteristicas);
        System.out.println("Habitat: "+habitat);
        System.out.println("Caracteristicas Corporais : "+caracteristicasCorporais);
        System.out.println("Nome Científico : "+nomeCientifico);

    }
}