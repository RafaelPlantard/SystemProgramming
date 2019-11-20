package schoolsystem;

public class Aluno {
    protected String nome;
    protected int ra;
    protected double nota1, nota2, nota3, nota4;

    public Aluno(String nome, int ra, double nota1, double nota2, double nota3, double nota4) {
        this.nome = nome;
        this.ra = ra;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public double getMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }
}
