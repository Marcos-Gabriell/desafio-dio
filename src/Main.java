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
        bootcamp.adicionarConteudo(cursoJava);
        bootcamp.adicionarConteudo(cursoJs);
        bootcamp.adicionarConteudo(mentoriaJava);

        Dev camila = new Dev();
        camila.setNome("Camila");
        camila.inscreverBootcamp(bootcamp);

        imprimirRelatorio("Camila - Início", camila);
        camila.progredir();
        camila.progredir();
        imprimirRelatorio("Camila - Após 2 progressos", camila);

        System.out.println("\n========================================\n");

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverBootcamp(bootcamp);

        imprimirRelatorio("João - Início", joao);
        joao.progredir();
        joao.progredir();
        joao.progredir();
        imprimirRelatorio("João - Após 3 progressos", joao);
    }

    private static void imprimirRelatorio(String titulo, Dev dev) {
        int inscritos = dev.getConteudosInscritos().size();
        int concluidos = dev.getConteudosConcluidos().size();
        int total = inscritos + concluidos;
        double progresso = total == 0 ? 0 : (concluidos * 100.0) / total;

        System.out.println("📌 " + titulo);
        System.out.println("👤 Dev: " + dev.getNome());
        System.out.printf("📈 Progresso: %.0f%% (%d/%d)%n", progresso, concluidos, total);

        System.out.println("\n📚 Inscritos (" + inscritos + "):");
        imprimirLista(dev.getConteudosInscritos());

        System.out.println("\n✅ Concluídos (" + concluidos + "):");
        imprimirLista(dev.getConteudosConcluidos());

        System.out.printf("\n⭐ XP Total: %.2f%n", dev.calcularTotalXp());
        System.out.println("----------------------------------------");
    }

    private static void imprimirLista(Set<Conteudo> conteudos) {
        if (conteudos.isEmpty()) {
            System.out.println("  (nenhum)");
            return;
        }
        conteudos.forEach(c ->
                System.out.println("  - " + c.getTitulo() + " [" + c.getClass().getSimpleName() + "]")
        );
    }
}
