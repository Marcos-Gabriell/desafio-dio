import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java");
        cursoJava.setDescricao("Fundamentos e POO com Java");
        cursoJava.setCargaHoraria(8);

        Curso cursoJs = new Curso();
        cursoJs.setTitulo("JavaScript");
        cursoJs.setDescricao("Base da linguagem e lógica");
        cursoJs.setCargaHoraria(4);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria Java");
        mentoriaJava.setDescricao("Tira-dúvidas e evolução prática");
        mentoriaJava.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Trilha prática de Java + Mentorias");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJs);
        bootcamp.getConteudos().add(mentoriaJava);

        Dev camila = new Dev();
        camila.setNome("Camila");
        camila.inscreverBootcamp(bootcamp);

        imprimirStatus("INÍCIO", camila);
        camila.progredir();
        camila.progredir();
        imprimirStatus("APÓS 2 PROGRESSOS", camila);

        System.out.println("\n========================================\n");

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverBootcamp(bootcamp);

        imprimirStatus("INÍCIO", joao);
        joao.progredir();
        joao.progredir();
        joao.progredir();
        imprimirStatus("APÓS 3 PROGRESSOS", joao);
    }

    private static void imprimirStatus(String titulo, Dev dev) {
        System.out.println("📌 " + titulo);
        System.out.println("👤 Dev: " + dev.getNome());

        System.out.println("\n📚 Conteúdos inscritos (" + dev.getConteudosInscritos().size() + "):");
        imprimirLista(dev.getConteudosInscritos());

        System.out.println("\n✅ Conteúdos concluídos (" + dev.getConteudosConcluidos().size() + "):");
        imprimirLista(dev.getConteudosConcluidos());

        System.out.printf("\n⭐ XP Total: %.2f\n", dev.calcularTotalXp());
        System.out.println("----------------------------------------");
    }

    private static void imprimirLista(Set<Conteudo> conteudos) {
        if (conteudos.isEmpty()) {
            System.out.println("  (nenhum)");
            return;
        }
        conteudos.forEach(c -> System.out.println("  - " + c.getTitulo() + " (" + c.getClass().getSimpleName() + ")"));
    }
}
