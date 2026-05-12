package exercicios;

import exercicios.base.Aula;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Esta é uma classe para você poder implementar as atividades propostas no README.
 * Você <b>NÃO</b> deve alterar:
 * <ul>
 *     <li>a estrutura deste arquivo;</li>
 *     <li>o nome da classe, dos métodos ou dos atributos;</li>
 *     <li>parâmetros e tipo de retorno dos métodos.</li>
 * </ul>
 *
 * <b>Mas você PRECISA alterar valores dos atributos existentes</b>.
 *
 * <p>Você pode alterar o código interno dos métodos, criar métodos auxiliares que podem ser chamados
 * pelos existentes, mas não deve alterar a estrutura dos métodos disponíveis.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Aula06 extends Aula {

    /**
     * Predicate composto:
     * mulheres + matriculadas (curso != null) + nota >= 6
     */
    private final Predicate<Estudante> mulheresAprovadas =
            s -> s.getSexo() == 'F'
                    && s.getCurso() != null
                    && s.getNota() >= 6;

    public Aula06() {

        System.out.println("\nMulheres aprovadas:");
        getEstudantesMulheresAprovadas()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Aula06();
    }

    /**
     * Lista NÃO modificável
     */
    public List<Estudante> getEstudantesMulheresAprovadas() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .toList();
    }

    /**
     * Ordenadas por curso (crescente) e nota (crescente)
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        java.util.Comparator
                                .comparing((Estudante e) -> e.getCurso().getNome())
                                .thenComparing(Estudante::getNota)
                )
                .toList();
    }

    /**
     * Curso decrescente + nota crescente
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        java.util.Comparator
                                .comparing((Estudante e) -> e.getCurso().getNome(), java.util.Comparator.reverseOrder())
                                .thenComparing(Estudante::getNota)
                )
                .toList();
    }

    /**
     * Lista modificável (IMPORTANTE)
     */
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return new java.util.ArrayList<>(
                estudantes.stream()
                        .filter(mulheresAprovadas)
                        .toList()
        );
    }

    /**
     * Totalmente decrescente (curso + nota)
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        java.util.Comparator
                                .comparing((Estudante e) -> e.getCurso().getNome(), java.util.Comparator.reverseOrder())
                                .thenComparing(Estudante::getNota, java.util.Comparator.reverseOrder())
                )
                .toList();
    }

    /**
     * Curso crescente + nota decrescente
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        java.util.Comparator
                                .comparing((Estudante e) -> e.getCurso().getNome())
                                .thenComparing(Estudante::getNota, java.util.Comparator.reverseOrder())
                )
                .toList();
    }
}
