package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) throw new IllegalArgumentException("Bootcamp não pode ser nulo.");

        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.inscreverDev(this);
    }

    public boolean progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isEmpty()) return false;

        Conteudo c = conteudo.get();
        this.conteudosConcluidos.add(c);
        this.conteudosInscritos.remove(c);
        return true;
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() { return Collections.unmodifiableSet(conteudosInscritos); }
    public Set<Conteudo> getConteudosConcluidos() { return Collections.unmodifiableSet(conteudosConcluidos); }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", inscritos=" + conteudosInscritos.size() +
                ", concluidos=" + conteudosConcluidos.size() +
                ", xp=" + String.format("%.2f", calcularTotalXp()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev)) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
