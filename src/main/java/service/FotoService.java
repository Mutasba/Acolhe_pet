package service;

import java.io.File;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FotoService {

    private final String PASTA
            = "fotos_animais/";

    public String selecionar() {

        JFileChooser chooser
                = new JFileChooser();

        chooser.setDialogTitle(
                "Selecionar imagem"
        );
        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter(
                        "Imagens",
                        "jpg",
                        "png",
                        "jpeg" );

        chooser.setFileFilter(
                filtro
        );
        int resultado
                = chooser.showOpenDialog(null);

        if (resultado
                == JFileChooser.APPROVE_OPTION) {

            File arquivo
                    = chooser.getSelectedFile();

            return arquivo
                    .getAbsolutePath();
        }
        return null;
    }

    public String salvarFoto(
            String nomeAnimal
    ) throws IOException {

        File pasta
                = new File(PASTA);

        if (!pasta.exists()) {

            pasta.mkdirs();

        }
        String caminhoOriginal = selecionar();

        File arquivoOriginal
                = new File(caminhoOriginal);

        String extensao
                = caminhoOriginal.substring(
                        caminhoOriginal
                                .lastIndexOf(".")
                );

        String novoNome
                = System.currentTimeMillis()
                + "_"
                + nomeAnimal.replace(" ", "_")
                + extensao;

        Path destino
                = Paths.get(
                        PASTA
                        + novoNome
                );

        Files.copy(
                arquivoOriginal.toPath(),
                destino,
                StandardCopyOption.REPLACE_EXISTING
        );

        return destino.toString();

    }
    
    public static void main(String[] args) {
        new FotoService() .selecionar();
    }
}