/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.SistemaController;
import Database.DB;
import Model_Entety.Animal;
import Model_Entety.AnimalVacina;
import Model_Entety.Vacina;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import service.AnimalVacinaService;

/**
 *
 * @author danie
 */
public class VacinarAnimal extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VacinarAnimal.class.getName());
    
    private Animal animal;

    public VacinarAnimal(Animal animal) {
        initComponents();
        this.animal = animal;
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        carregarVacinasNoCombo();
    }
    

   
    private void carregarVacinasNoCombo() {
        try {
            SistemaController sc = new SistemaController();
            List<Vacina> vacinas = sc.listarVacinas(); 
            
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Selecionar");
            for (Vacina v : vacinas) {
                model.addElement(v.getNome() + " (ID:" + v.getId() + ")");
            }
            comboNomeVacina.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar vacinas: " + e.getMessage());
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabecalho = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        comboNomeVacina = new javax.swing.JComboBox<>();
        txtReforco = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        edtAplicacao = new javax.swing.JTextField();
        comboReforço1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelCabecalho.setBackground(new java.awt.Color(0, 90, 81));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        painelCabecalho.setForeground(new java.awt.Color(0, 90, 81));
        painelCabecalho.setEnabled(false);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_acolhepet.png"))); // NOI18N
        icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(icon))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon)
        );

        jPanel3.setBackground(new java.awt.Color(232, 231, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(1240, 656));

        txtEmail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 90, 81));
        txtEmail.setText("Data Aplicação");

        txtNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 90, 81));
        txtNome.setText("Nome:");

        comboNomeVacina.setForeground(new java.awt.Color(0, 90, 81));
        comboNomeVacina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        comboNomeVacina.addActionListener(this::comboNomeVacinaActionPerformed);

        txtReforco.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtReforco.setForeground(new java.awt.Color(0, 90, 81));
        txtReforco.setText("Tempo de Reforço:");
        txtReforco.setToolTipText("Em Anos");

        btnCancelar.setForeground(new java.awt.Color(0, 90, 81));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnProximo.setBackground(new java.awt.Color(250, 166, 190));
        btnProximo.setForeground(new java.awt.Color(0, 90, 81));
        btnProximo.setText("Próximo");
        btnProximo.setAutoscrolls(true);
        btnProximo.addActionListener(this::btnProximoActionPerformed);

        txtTitulo.setBackground(new java.awt.Color(232, 231, 204));
        txtTitulo.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 90, 81));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("Vacinar Animal");

        edtAplicacao.setForeground(new java.awt.Color(0, 90, 81));
        edtAplicacao.setToolTipText("");
        edtAplicacao.setName(""); // NOI18N

        comboReforço1.setForeground(new java.awt.Color(0, 90, 81));
        comboReforço1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        comboReforço1.addActionListener(this::comboReforço1ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnProximo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(comboNomeVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail)
                    .addComponent(edtAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReforco)
                    .addComponent(comboReforço1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtTitulo)
                .addGap(40, 40, 40)
                .addComponent(txtNome)
                .addGap(4, 4, 4)
                .addComponent(comboNomeVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtEmail)
                .addGap(6, 6, 6)
                .addComponent(edtAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtReforco)
                .addGap(6, 6, 6)
                .addComponent(comboReforço1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnProximo))
                .addContainerGap(346, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMouseClicked
        Main m = new  Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_iconMouseClicked

    private void comboNomeVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNomeVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNomeVacinaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

       Main m = new  Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        if (comboNomeVacina.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Selecione uma vacina válida!");
                return;
            }

            try {
                String selecionado = comboNomeVacina.getSelectedItem().toString();
                
                int vacinaId = Integer.parseInt(selecionado.substring(selecionado.indexOf("ID:") + 3, selecionado.length() - 1));

                String dataInput = edtAplicacao.getText().replaceAll("[^0-9]", "");
                if (dataInput.length() != 8) {
                    JOptionPane.showMessageDialog(this, "Data inválida! Digite (ex: 20052025).");
                    return;
                }
                LocalDate dataAplicacao = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("ddMMyyyy"));

               
                AnimalVacina av = new AnimalVacina();
                av.setAnimalId(this.animal.getId());
                av.setVacinaId(vacinaId);
                av.setDataAplicacao(dataAplicacao); 

                int tempoReforco = Integer.parseInt(comboReforço1.getSelectedItem().toString());

                
                SistemaController sc = new SistemaController();

                
                sc.registrarVacinacao(av, tempoReforco); 

                JOptionPane.showMessageDialog(this, "Vacinação registrada com sucesso!");
                new Main().setVisible(true);
                this.dispose();

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Data inválida. Verifique se o dia/mês existem.");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao vacinar: " + e.getMessage());
            }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void comboReforço1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboReforço1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboReforço1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
    java.awt.EventQueue.invokeLater(() -> {
        
        new VacinarAnimal(new Animal()).setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProximo;
    private javax.swing.JComboBox<String> comboNomeVacina;
    private javax.swing.JComboBox<String> comboReforço1;
    private javax.swing.JTextField edtAplicacao;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtReforco;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
