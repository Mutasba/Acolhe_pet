package service;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FotoService {

    private static final String PASTA = "fotos_animais/";

    
    public String selecionarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecionar imagem do animal");
        
        // Filtro de extensões
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Imagens (JPG, PNG)", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        return null;
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

        
        String extensao = "";
        int i = caminhoOriginal.lastIndexOf('.');
        if (i > 0) {
            extensao = caminhoOriginal.substring(i);
        }

        String novoNome = System.currentTimeMillis()
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

        File file = new File(caminho);
        if (!file.exists()) {
            return null; 
        }

        if (largura <= 0) largura = 128;
        if (altura <= 0) altura = 128;

        ImageIcon icon = new ImageIcon(caminho);
        Image imagem = icon.getImage().getScaledInstance(
                largura,
                altura,
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(imagem);
    }
}