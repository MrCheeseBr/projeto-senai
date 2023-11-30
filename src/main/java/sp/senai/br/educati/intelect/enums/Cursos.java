package sp.senai.br.educati.intelect.enums;

public enum Cursos {
    ELETRO("Manhã"),
    DEV("Tarde"),
    LOG("Noite");

    private String descricao;

    Cursos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
