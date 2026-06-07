package service;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class FotoService {

    private static final String PASTA = "fotos_animais/";

    public String selecionarArquivo() {

        try {
            Process process = new ProcessBuilder(
                    "zenity",
                    "--file-selection",
                    "--title=Selecionar imagem",
                    "--file-filter=*.png *.jpg *.jpeg"
            ).start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String caminho = reader.readLine();

            process.waitFor();

            return caminho;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String salvarFoto(String nomeAnimal) throws IOException {

        File pasta = new File(PASTA);

        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        String caminhoOriginal = selecionarArquivo();

        if (caminhoOriginal == null || caminhoOriginal.isBlank()) {
            return null;
        }

        File arquivoOriginal = new File(caminhoOriginal);

        String extensao = caminhoOriginal.substring(
                caminhoOriginal.lastIndexOf(".")
        );

        String novoNome
                = System.currentTimeMillis()
                + "_"
                + nomeAnimal.replace(" ", "_")
                + extensao;

        Path destino = Paths.get(PASTA, novoNome);

        Files.copy(
                arquivoOriginal.toPath(),
                destino,
                StandardCopyOption.REPLACE_EXISTING
        );

        return destino.toString();
    }

    public ImageIcon render(String caminho, int largura, int altura) {

        if (caminho == null || caminho.isBlank()) {
            return null;
        }

        if (largura <= 0) {
            largura = 128;
        }
        if (altura <= 0) {
            altura = 128;
        }
        ImageIcon icon = new ImageIcon(caminho);

        Image imagem = icon.getImage().getScaledInstance(
                largura,
                altura,
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(imagem);
    }
}
