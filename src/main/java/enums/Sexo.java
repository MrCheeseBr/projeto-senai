package enums;

public enum Sexo {
    HOMEM("Homem"),
    MULHER("Mulher"),
    OUTROS("Outros");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
