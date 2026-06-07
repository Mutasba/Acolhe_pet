/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.SistemaController;
import Model_Entety.Animal;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import service.FotoService;

/**
 *
 * @author danie
 */
public class CadastroAnimal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroAnimal.class.getName());

    private Animal animias;
    private String caminho = null;
    private FotoService fotoService = null;

    public CadastroAnimal() {
        initComponents();
    }

    private Animal carregar(Animal a, String ft) {

        StringBuilder erros = new StringBuilder();

        String nome = edtNome.getText().trim();

        if (nome.isBlank()) {
            erros.append("- Nome não informado.\n");
        }

        String tipo = comboTipo.getSelectedItem().toString();
        if ("Selecionar".equalsIgnoreCase(tipo)) {
            erros.append("- Tipo não selecionado.\n");
        }

        String generoStr = comboGenero.getSelectedItem().toString();
        char genero = ' ';
        if ("Selecionar".equalsIgnoreCase(generoStr)) {
            erros.append("- Gênero não selecionado.\n");
        } else {
            genero = generoStr.charAt(0);
        }

        String porteStr = comboPorte.getSelectedItem().toString();
        char porte = ' ';
        if ("Selecionar".equalsIgnoreCase(porteStr)) {
            erros.append("- Porte não selecionado.\n");
        } else {
            porte = porteStr.charAt(0);
        }

        String cor = comboCor.getSelectedItem().toString();
        if ("Selecionar".equalsIgnoreCase(cor)) {
            erros.append("- Cor não selecionada.\n");
        }

        String raca = comboRaca.getSelectedItem().toString();
        if ("Selecionar".equalsIgnoreCase(raca)) {
            erros.append("- Raça não selecionada.\n");
        }

        String pesoStr = comboPeso.getSelectedItem().toString();
        float peso = 0;

        if ("Selecionar".equalsIgnoreCase(pesoStr)) {
            erros.append("- Peso não selecionado.\n");
        } else {
            peso = Float.parseFloat(pesoStr);
        }

        String idadeStr = comboIdade.getSelectedItem().toString();
        int idade = 0;

        if ("Selecionar".equalsIgnoreCase(idadeStr)) {
            erros.append("- Idade não selecionada.\n");
        } else {
            idade = Integer.parseInt(idadeStr);
        }

        String deficienciaStr = comboDeficiencia.getSelectedItem().toString();
        boolean deficiencia = false;

        if ("Selecionar".equalsIgnoreCase(deficienciaStr)) {
            erros.append("- Deficiência não selecionada.\n");
        } else {
            deficiencia = "Aceita".equalsIgnoreCase(deficienciaStr);
        }

        String fivStr = comboFiv.getSelectedItem().toString();
        boolean fiv = false;

        if ("Selecionar".equalsIgnoreCase(fivStr)) {
            erros.append("- FIV não selecionado.\n");
        } else {
            fiv = "Aceita".equalsIgnoreCase(fivStr);
        }

        String felvStr = comboFelv.getSelectedItem().toString();
        boolean felv = false;

        if ("Selecionar".equalsIgnoreCase(felvStr)) {
            erros.append("- FELV não selecionado.\n");
        } else {
            felv = "Aceita".equalsIgnoreCase(felvStr);
        }

        String castradoStr = comboCastrado.getSelectedItem().toString();
        boolean castrado = false;

        if ("Selecionar".equalsIgnoreCase(castradoStr)) {
            erros.append("- Castração não selecionada.\n");
        } else {
            castrado = "Sim".equalsIgnoreCase(castradoStr);
        }

        if (!erros.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, corrija os seguintes campos:\n\n" + erros,
                    "Campos Pendentes",
                    JOptionPane.WARNING_MESSAGE
            );

            return null;
        }

        a.setNome(nome);
        a.setFoto(ft);
        a.setTipo(tipo);
        a.setGenero(genero);
        a.setDeficiencia(deficiencia);
        a.setPorte(porte);
        a.setFIV(fiv);
        a.setCor(cor);
        a.setRaca(raca);
        a.setCastrado(castrado);
        a.setPeso(peso);
        a.setFELV(felv);
        a.setIdade(idade);
        a.setEstado("NAO_ADOTADO");
        return a;
    }

    private void cancelar() {

        edtNome.setText("");

        comboTipo.setSelectedIndex(0);
        comboGenero.setSelectedIndex(0);
        comboDeficiencia.setSelectedIndex(0);
        comboPorte.setSelectedIndex(0);
        comboFiv.setSelectedIndex(0);
        comboCor.setSelectedIndex(0);
        comboRaca.setSelectedIndex(0);
        comboCastrado.setSelectedIndex(0);
        comboPeso.setSelectedIndex(0);
        comboFelv.setSelectedIndex(0);
        comboIdade.setSelectedIndex(0);

        img.setIcon(new ImageIcon(getClass().getResource("/imagens/imagem.png")));

        // se você tiver uma variável para guardar o caminho da foto
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtCastrado = new javax.swing.JLabel();
        comboPorte = new javax.swing.JComboBox<>();
        txtPorte = new javax.swing.JLabel();
        comboFiv = new javax.swing.JComboBox<>();
        edtNome = new javax.swing.JTextField();
        txtNome = new javax.swing.JLabel();
        txtFiv = new javax.swing.JLabel();
        comboCor = new javax.swing.JComboBox<>();
        txtCor = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();
        txtGenero = new javax.swing.JLabel();
        comboRaca = new javax.swing.JComboBox<>();
        txtRaca = new javax.swing.JLabel();
        comboFelv = new javax.swing.JComboBox<>();
        comboDeficiencia = new javax.swing.JComboBox<>();
        txtFelv = new javax.swing.JLabel();
        txtTipo = new javax.swing.JLabel();
        comboPeso = new javax.swing.JComboBox<>();
        txtPeso = new javax.swing.JLabel();
        txtDeficiencia = new javax.swing.JLabel();
        txtPreferencias = new javax.swing.JLabel();
        comboCastrado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnProx = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        comboIdade = new javax.swing.JComboBox<>();
        txtIdade = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        painelCabecalho = new javax.swing.JPanel();
        btnNotificacao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNomeUser = new javax.swing.JLabel();
        txtBemVindo = new javax.swing.JLabel();
        btnIcon = new javax.swing.JButton();
        txtFotoUser = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1240, 656));

        jPanel1.setBackground(new java.awt.Color(232, 231, 204));

        jPanel3.setBackground(new java.awt.Color(232, 231, 204));

        txtCastrado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtCastrado.setForeground(new java.awt.Color(0, 90, 81));
        txtCastrado.setText("Castrado");

        comboPorte.setForeground(new java.awt.Color(0, 90, 81));
        comboPorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Pequeno", "Médio", "Grande" }));

        txtPorte.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtPorte.setForeground(new java.awt.Color(0, 90, 81));
        txtPorte.setText("Porte");

        comboFiv.setForeground(new java.awt.Color(0, 90, 81));
        comboFiv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Aceita", "Não aceita" }));

        edtNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        edtNome.setForeground(new java.awt.Color(0, 90, 81));
        edtNome.setToolTipText("Infome o nome do animal");
        edtNome.setOpaque(false);
        edtNome.putClientProperty("Nimbus.Overrides", new javax.swing.UIDefaults());
        edtNome.setBorder(new javax.swing.border.AbstractBorder() {
            @Override
            public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new java.awt.Color(0, 90, 81)); 
                g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15);
                g2.dispose();
            }
            @Override
            public java.awt.Insets getBorderInsets(java.awt.Component c) {
                return new java.awt.Insets(6, 12, 6, 12);
            }
        });

        txtNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 90, 81));
        txtNome.setText("Nome:");

        txtFiv.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFiv.setForeground(new java.awt.Color(0, 90, 81));
        txtFiv.setText("Fiv");

        comboCor.setForeground(new java.awt.Color(0, 90, 81));
        comboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Preto", "Branco", "Marrom", "Chocolate", "Cinza", "Azul", "Vermelho", "Laranja", "Dourado", "Fulvo", "Creme", "Tigrado", "Listrado", "Tricolor", "Merle", "Arlequim", "Siamês", "Ponteado", "Bicolor", "Preto", "Branco" }));

        txtCor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtCor.setForeground(new java.awt.Color(0, 90, 81));
        txtCor.setText("Cor");

        comboGenero.setForeground(new java.awt.Color(0, 90, 81));
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Femêa", "Macho" }));

        comboTipo.setForeground(new java.awt.Color(0, 90, 81));
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Gato", "Cachorro" }));

        txtGenero.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtGenero.setForeground(new java.awt.Color(0, 90, 81));
        txtGenero.setText("Genero");

        comboRaca.setForeground(new java.awt.Color(0, 90, 81));
        comboRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "SRD", "Persa", "Siamês", "Angorá", "Bengal", "Sphinx", "Ragdoll", "Azul Russo", "Himalaio", "Munchkin", "British Shorthair", "Pastor Alemão", "Labrador", "Golden Retriever", "Poodle", "Bulldog Francês", "Bulldog Inglês", "Rottweiler", "Beagle", "Pinscher", "Pug", "Shih Tzu", "Yorkshire", "Pitbull", "Boxer", "Border Collie", "Chow Chow", "Maltês", "Cocker Spaniel", "Lhasa Apso", "Dachshund", "Husky", "Doberman", "Cane Corso", "Chiuaua", "Schnauzer" }));

        txtRaca.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtRaca.setForeground(new java.awt.Color(0, 90, 81));
        txtRaca.setText("Raça");

        comboFelv.setForeground(new java.awt.Color(0, 90, 81));
        comboFelv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Aceita", "Não aceita" }));

        comboDeficiencia.setForeground(new java.awt.Color(0, 90, 81));
        comboDeficiencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Aceita", "Não aceita" }));

        txtFelv.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFelv.setForeground(new java.awt.Color(0, 90, 81));
        txtFelv.setText("Felv");

        txtTipo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(0, 90, 81));
        txtTipo.setText("Tipo");

        comboPeso.setForeground(new java.awt.Color(0, 90, 81));
        comboPeso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        txtPeso.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtPeso.setForeground(new java.awt.Color(0, 90, 81));
        txtPeso.setText("Peso");

        txtDeficiencia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDeficiencia.setForeground(new java.awt.Color(0, 90, 81));
        txtDeficiencia.setText("Deficiência");

        txtPreferencias.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPreferencias.setForeground(new java.awt.Color(0, 90, 81));
        txtPreferencias.setText("Informações complementares");

        comboCastrado.setForeground(new java.awt.Color(0, 90, 81));
        comboCastrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Sim", "Não" }));

        btnCancelar.setForeground(new java.awt.Color(0, 90, 81));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnProx.setBackground(new java.awt.Color(250, 166, 190));
        btnProx.setForeground(new java.awt.Color(0, 90, 81));
        btnProx.setText("Próximo");
        btnProx.setAutoscrolls(true);
        btnProx.addActionListener(this::btnProxActionPerformed);

        txtTitulo.setBackground(new java.awt.Color(232, 231, 204));
        txtTitulo.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 90, 81));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("Cadastrar Animal");

        comboIdade.setForeground(new java.awt.Color(0, 90, 81));
        comboIdade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        txtIdade.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtIdade.setForeground(new java.awt.Color(0, 90, 81));
        txtIdade.setText("Idade");

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem.png"))); // NOI18N

        jButton1.setText("Selecionar Imagem");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdade)
                                    .addComponent(txtTipo)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCor))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtGenero)
                                                    .addComponent(comboRaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtRaca)
                                                    .addComponent(comboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtDeficiencia)
                                                        .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCastrado)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtPeso)
                                                        .addComponent(comboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtPorte)
                                                        .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jButton1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboFiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFiv)
                                            .addComponent(comboFelv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFelv)
                                            .addComponent(img)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(btnCancelar)
                                        .addGap(43, 43, 43)
                                        .addComponent(btnProx))))
                            .addComponent(txtNome)
                            .addComponent(txtPreferencias)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(txtPreferencias)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDeficiencia)
                            .addComponent(txtPorte))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCastrado)
                            .addComponent(txtPeso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtFiv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFelv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFelv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnProx))
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        painelCabecalho.setBackground(new java.awt.Color(0, 90, 81));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        painelCabecalho.setForeground(new java.awt.Color(0, 90, 81));
        painelCabecalho.setEnabled(false);

        btnNotificacao.setBackground(new java.awt.Color(0, 90, 81));
        btnNotificacao.setForeground(new java.awt.Color(0, 90, 81));
        btnNotificacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/notificacao.png"))); // NOI18N
        btnNotificacao.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(0, 90, 81));

        txtNomeUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNomeUser.setForeground(new java.awt.Color(250, 166, 190));
        txtNomeUser.setText("ADM     XXXX");
        txtNomeUser.setToolTipText("");
        txtNomeUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtBemVindo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBemVindo.setForeground(new java.awt.Color(232, 231, 204));
        txtBemVindo.setText("Bem vindo!!");
        txtBemVindo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNomeUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBemVindo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIcon.setBackground(new java.awt.Color(0, 90, 81));
        btnIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_acolhepet.png"))); // NOI18N
        btnIcon.setBorder(null);
        btnIcon.addActionListener(this::btnIconActionPerformed);

        txtFotoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFotoUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNotificacao)
                .addGap(24, 24, 24))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFotoUser)
                        .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnNotificacao))
                            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        cancelar();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        try {
            // TODO add your handling code here:
            animias = new Animal();

            SistemaController sc = new SistemaController();
            try {
                sc.salvarAnimalComFoto(carregar(animias, caminho), caminho);
                JOptionPane.showMessageDialog(
                        this,
                        "Cadastrado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception ex) {
                System.getLogger(CadastroAnimal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (SQLException ex) {
            System.getLogger(CadastroAnimal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }


    }//GEN-LAST:event_btnProxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            // TODO add your handling code here:

            fotoService = new FotoService();

            caminho
                    = fotoService.salvarFoto(
                            edtNome.getText()
                    );
        } catch (IOException ex) {
            System.getLogger(CadastroAnimal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        img.setIcon(
                fotoService.render(caminho, img.getWidth(), img.getHeight())
        );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIconActionPerformed
        // TODO add your handling code here:
        
        Main m = new Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_btnIconActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CadastroAnimal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIcon;
    private javax.swing.JButton btnNotificacao;
    private javax.swing.JButton btnProx;
    private javax.swing.JComboBox<String> comboCastrado;
    private javax.swing.JComboBox<String> comboCor;
    private javax.swing.JComboBox<String> comboDeficiencia;
    private javax.swing.JComboBox<String> comboFelv;
    private javax.swing.JComboBox<String> comboFiv;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JComboBox<String> comboIdade;
    private javax.swing.JComboBox<String> comboPeso;
    private javax.swing.JComboBox<String> comboPorte;
    private javax.swing.JComboBox<String> comboRaca;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JLabel txtBemVindo;
    private javax.swing.JLabel txtCastrado;
    private javax.swing.JLabel txtCor;
    private javax.swing.JLabel txtDeficiencia;
    private javax.swing.JLabel txtFelv;
    private javax.swing.JLabel txtFiv;
    private javax.swing.JLabel txtFotoUser;
    private javax.swing.JLabel txtGenero;
    private javax.swing.JLabel txtIdade;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtNomeUser;
    private javax.swing.JLabel txtPeso;
    private javax.swing.JLabel txtPorte;
    private javax.swing.JLabel txtPreferencias;
    private javax.swing.JLabel txtRaca;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
