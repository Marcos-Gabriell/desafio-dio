package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() { return cargaHoraria; }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0)
            throw new IllegalArgumentException("Carga horária deve ser maior que zero.");
        this.cargaHoraria = cargaHoraria;
    }
}
