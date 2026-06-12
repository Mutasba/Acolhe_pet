package View;

import Controller.SistemaController;
import Model_Entety.Adotante;
import Model_Entety.Animal;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.FotoService;
import View.Main;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author fanim
 */
public class Item extends javax.swing.JPanel {

    private Animal animal;
    private Adotante adotante;
    private JFrame  main;
    public Item(Animal a, JFrame main) {
        initComponents();
        animal = a;
        this.main = main;
        carregar(a);
    }
    public Item(Animal a) {
        initComponents();
        animal = a;
        this.main = main;
        carregar(a);
    }

    public void carregar(Animal a) {

        FotoService ft = new FotoService();
        jLabel_Nome_Animal.setText(a.getNome());

        edtipo.setText(a.getTipo());
        edcor.setText(a.getCor());
        edidade.setText(String.valueOf(a.getIdade()));
        edgenero.setText(String.valueOf(a.getGenero()));
        edraca.setText(a.getRaca());

        eddificiencia.setText(
                a.isDeficiencia() ? "Sim" : "Não"
        );

        edcastrado.setText(
                a.isCastrado() ? "Sim" : "Não"
        );

        edpeso.setText(String.valueOf(a.getPeso()));

//        edchip.setText(
//                a.isChip() ? "Sim" : "Não"
//        );
        eddata.setText(
                a.getDataEntrada() == null
                ? ""
                : a.getDataEntrada().toString()
        );

        img.setIcon(ft.render(a.getFoto(), img.getWidth(), img.getHeight()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel57 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel_Nome_Animal = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        edtipo = new javax.swing.JLabel();
        edcor = new javax.swing.JLabel();
        edidade = new javax.swing.JLabel();
        edgenero = new javax.swing.JLabel();
        edraca = new javax.swing.JLabel();
        eddificiencia = new javax.swing.JLabel();
        edcastrado = new javax.swing.JLabel();
        edpeso = new javax.swing.JLabel();
        eddata = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 90, 81));
        setPreferredSize(new java.awt.Dimension(232, 418));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(250, 166, 190));
        jLabel57.setText("Castrado:");

        jLabel54.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(250, 166, 190));
        jLabel54.setText("Idade:");

        jLabel53.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(250, 166, 190));
        jLabel53.setText("Genêro:");

        jLabel58.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(250, 166, 190));
        jLabel58.setText("Peso:");

        jLabel_Nome_Animal.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel_Nome_Animal.setForeground(new java.awt.Color(250, 166, 190));
        jLabel_Nome_Animal.setText("Nome animal");

        jLabel52.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(250, 166, 190));
        jLabel52.setText("Tipo:");

        jLabel55.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(250, 166, 190));
        jLabel55.setText("Raça:");

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(250, 166, 190));
        jLabel51.setText("Cor:");
        jLabel51.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel51ComponentShown(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(250, 166, 190));
        jLabel60.setText("Data_entrada:");

        jLabel56.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(250, 166, 190));
        jLabel56.setText("Deficiência:");

        edtipo.setText("jLabel1");

        edcor.setText("jLabel1");

        edidade.setText("jLabel1");

        edgenero.setText("jLabel1");

        edraca.setText("jLabel1");

        eddificiencia.setText("jLabel1");

        edcastrado.setText("jLabel1");

        edpeso.setText("jLabel1");

        eddata.setText("jLabel1");

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem.png"))); // NOI18N
        img.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                imgAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(img))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_Nome_Animal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(edraca))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(edgenero))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eddificiencia)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtipo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edcor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edpeso))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edcastrado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eddata)))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(img)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Nome_Animal)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(edtipo))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(edcor))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(edidade))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(edgenero))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(edraca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(eddificiencia))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(edcastrado))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(edpeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(eddata))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel51ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel51ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51ComponentShown

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        String cpf = "00000000001";

        try {

            if ( cpf  .equals("")) {

                cpf = JOptionPane.showInputDialog(
                        null,
                        "Informe o CPF do adotante:"
                );

                if (cpf == null || cpf.trim().isEmpty()) {
                    return;
                }
                SistemaController sc = new SistemaController();

                adotante = sc.buscarPorCpf(cpf);

                if (adotante == null) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Adotante não encontrado!"
                    );

                    return;
                }
            }

            ConfirmarAdocao cf
                    = new ConfirmarAdocao(
                            animal,
                            cpf,
                             main
                    );

            cf.setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage()
            );

        }
    }//GEN-LAST:event_formMouseClicked

    private void imgAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_imgAncestorAdded
        // TODO add your handling code here:
//        String cpf = null;
//
//        try {
//
//            if (adotante == null) {
//
//                cpf = JOptionPane.showInputDialog(
//                        null,
//                        "Informe o CPF do adotante:"
//                );
//
//                if (cpf == null || cpf.trim().isEmpty()) {
//                    return;
//                }
//                SistemaController sc = new SistemaController();
//
//                adotante = sc.buscarPorCpf(cpf);
//
//                if (adotante == null) {
//
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Adotante não encontrado!"
//                    );
//
//                    return;
//                }
//            }
//
//            ConfirmarAdocao cf
//                    = new ConfirmarAdocao(
//                            animal,
//                            cpf
//                    );
//
//            cf.setVisible(true);
//
//        } catch (Exception ex) {
//
//            JOptionPane.showMessageDialog(
//                    null,
//                    ex.getMessage()
//            );
//
//        }
    }//GEN-LAST:event_imgAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel edcastrado;
    private javax.swing.JLabel edcor;
    private javax.swing.JLabel eddata;
    private javax.swing.JLabel eddificiencia;
    private javax.swing.JLabel edgenero;
    private javax.swing.JLabel edidade;
    private javax.swing.JLabel edpeso;
    private javax.swing.JLabel edraca;
    private javax.swing.JLabel edtipo;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel_Nome_Animal;
    // End of variables declaration//GEN-END:variables
}
