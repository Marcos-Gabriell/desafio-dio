package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() { return data; }

    public void setData(LocalDate data) {
        if (data == null)
            throw new IllegalArgumentException("Data não pode ser nula.");
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", data=" + data + "}");
    }
}
