package sp.senai.br.educati.intelect.enums;

public enum PeriodoTurmas {
    MANHÃ("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite"),
    INTEGRAL("Integral");

    private String descricao;

    PeriodoTurmas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
