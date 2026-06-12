package service;

import Model_Entety.Estatistica;
import Model_Entety.Historico;
import java.sql.Connection; 
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;

public class PdfService {

    public void gerarPdfEstatistica(
            Estatistica e,
            String caminho
    ) throws Exception {

        Document document =
                new Document();

        PdfWriter.getInstance(
                document,
                new FileOutputStream(caminho)
        );

        document.open();

        document.add(
                new Paragraph(
                        "Relatorio Estatistico"
                )
        );

        document.add(
                new Paragraph(
                        "Animais adotados: "
                        + e.getAnimaisAdotados()
                )
        );

        document.add(
                new Paragraph(
                        "Animais nao adotados: "
                        + e.getAnimaisNaoAdotados()
                )
        );

        document.add(
                new Paragraph(
                        "Animais em processo: "
                        + e.getAnimaisEmProcesso()
                )
        );

        document.add(
                new Paragraph(
                        "Total de adocoes: "
                        + e.getTotalAdocoes()
                )
        );

        document.close();
    }

    public void gerarPdfHistorico(
            List<Historico> lista,
            String caminho
    ) throws Exception {

        Document document =
                new Document();

        PdfWriter.getInstance(
                document,
                new FileOutputStream(caminho)
        );

        document.open();

        document.add(
                new Paragraph(
                        "Relatorio Historico"
                )
        );

        for(Historico h : lista){

            document.add(
                    new Paragraph(
                            h.getAcao()
                            + " - "
                            + h.getDataEvento()
                    )
            );
        }

        document.close();
    }
}