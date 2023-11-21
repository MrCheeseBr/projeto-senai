package enums;

public enum Perfil {
    ADMINISTRADOR("Administrador"),
    PROFESSOR("Professor"),
    ALUNO("Aluno");

    private String descricao;

    Perfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
