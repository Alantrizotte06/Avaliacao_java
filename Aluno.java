
public class Aluno {

    public String matricula;
    public String nomeAluno;
    public Double nota;

    public Aluno(String matricula, String nomeAluno, double nota) {
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.nota = nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nomeAluno=" + nomeAluno + ", nota=" + nota + "]";
    }
}
