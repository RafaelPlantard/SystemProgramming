package schoolsystem;

import java.util.Scanner;

public class SchoolSystem {
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno " + index + ": ");
        String nome = scanner.nextLine();
        int ra = index;
        double[] notas = new double[4];

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota " + (i + 1) + " do aluno " + nome + ": ");
            String nota = scanner.nextLine();
            notas[i] = Double.parseDouble(nota);
        }

        return new Aluno(nome, ra, notas[0], notas[1], notas[2], notas[3]);
    }
}
