public class Turma {
    protected Aluno[] alunos;

    public Turma(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public double mediaTurma() {
        double soma = 0;

        for (Aluno aluno : alunos) {
            soma += aluno.getMedia();
        }

        return soma / alunos.length;
    }
}