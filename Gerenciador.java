
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Gerenciador {

    public static void main(String[] args) {
        String arquivoCSV = "/home/alan/Avaliacao_java/alunos.csv";
        String separador = ";"; // Ponto e vírgula como separador

        try {
            List<Aluno> alunos = Files.lines(Paths.get(arquivoCSV))
                    .skip(1)
                    .map(linha -> {
                        String[] dados = linha.split(separador);
                        if (dados.length >= 3) {
                            return new Aluno(dados[0], dados[1], Double.parseDouble(dados[2].replace(",", ".")));
                        } else {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            alunos.forEach(System.out::println);

            int quantidadeAlunos = alunos.size();
            int aprovados = (int) alunos.stream().filter(a -> a.getNota() >= 6.0).count();
            int reprovados = quantidadeAlunos - aprovados;

            String resumo = String.format(
                    "Quantidade de Alunos: %d\nAprovados: %d\nReprovados: %d",
                    quantidadeAlunos, aprovados, reprovados
            );

            System.out.println("Resumo:");
            System.out.println(resumo);

            Files.write(Paths.get("resumo.csv"), resumo.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
