package Teste;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class TesteArquivo {

    public static void main(String[] args) {

        try {

            Path caminho =
                    Paths.get("src/main/java/imagens/notificacao.png");

            System.out.println(
                    "Caminho absoluto:"
            );

            System.out.println(
                    caminho.toAbsolutePath()
            );

            boolean existe =
                    Files.exists(caminho);

            System.out.println(
                    "Arquivo existe? "
                    + existe
            );

            if(existe){

                String sql =
                        Files.readString(
                                caminho
                        );

                System.out.println(
                        "Conteudo do arquivo:"
                );

                System.out.println(sql);

            }

            
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}