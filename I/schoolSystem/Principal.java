import java.io.Console;

public class Principal {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[5];

        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = criarNovoAlunoEImprimirMediaDeNota(i);
        }

        Turma turma = new Turma(alunos);

        System.out.println("A média de notas da turma é: " + turma.mediaTurma());
    }

    private static Aluno criarNovoAlunoEImprimirMediaDeNota(int index) {
        Aluno aluno = getAlunoDataFromInput(index);

        System.out.println("A média do aluno " + aluno.nome + " é: " + aluno.getMedia());

        return aluno;
    }

    private static Aluno getAlunoDataFromInput(int index) {
        Console console = System.console();

        String nome = console.readLine("Digite o nome do aluno " + index + ": ");
        int ra = index;
        double[] notas = new double[4];

        for (int i = 0; i < notas.length; i++) {
            String nota = console.readLine("Digite a nota " + (i + 1) + " do aluno " + nome + ": ");
            notas[i] = Double.parseDouble(nota);
        }

        return new Aluno(nome, ra, notas[0], notas[1], notas[2], notas[3]);
    }
}