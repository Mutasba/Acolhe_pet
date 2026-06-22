/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.SistemaController;
import Model_Entety.Adotante;
import Model_Entety.Preferencias;
import java.sql.SQLException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author danie
 */
public class CadastroAdotante extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroAdotante.class.getName());
    private javax.swing.JFrame telaAnterior; // Para voltar à tela de origem
    private boolean modoEdicao = false;
    private Adotante adotanteEdicao; // Objeto que está sendo editado

    
    public CadastroAdotante() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

   
    public CadastroAdotante(javax.swing.JFrame telaAnterior) {
        initComponents();
        this.telaAnterior = telaAnterior;
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

    
    public CadastroAdotante(Adotante a, javax.swing.JFrame telaAnterior) {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.adotanteEdicao = a;
        this.telaAnterior = telaAnterior;
        this.modoEdicao = true;
        preencherCampos(a);
    }

    private void preencherCampos(Adotante a) {
        edtNome.setText(a.getNome());
        edtCpf.setText(a.getCpf());
        edtEmail.setText(a.getEmail());
        edtEndereco.setText(a.getEndereco());

        try {
            SistemaController sc = new SistemaController();
            Preferencias p = sc.buscarPreferencias(a.getId());

            if (p != null) {
                comboTipo.setSelectedItem(p.getTipo());
                comboCor.setSelectedItem(p.getCor());
                comboRaca.setSelectedItem(p.getRaca());
                comboGenero.setSelectedItem(p.getGenero() == 'M' ? "Macho" : "Fêmea");
                comboPorte.setSelectedItem(p.getPorte() == 'P' ? "Pequeno" : (p.getPorte() == 'M' ? "Médio" : "Grande"));
                comboPeso.setSelectedItem(String.valueOf((int) p.getPeso()));
                comboCastrado.setSelectedItem(p.isCastrado() ? "Sim" : "Não");
                comboDeficiencia.setSelectedItem(p.isDeficiencia() ? "Possui" : "Não possui");
                comboFiv.setSelectedItem(p.isFIV() ? "Possui" : "Não possui");
                comboFelv.setSelectedItem(p.isFELV() ? "Possui" : "Não possui");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar preferências: " + ex.getMessage());
        }
    }

    private Adotante carregar(Adotante a, Preferencias p) {
        StringBuilder erros = new StringBuilder();


        a.setNome(edtNome.getText().trim());
        a.setCpf(edtCpf.getText().replaceAll("[^0-9]", ""));
        a.setEmail(edtEmail.getText().trim());
        a.setEndereco(edtEndereco.getText().trim());

        if (a.getNome().isBlank()) {
            erros.append("- Nome não informado.\n");
        }

        if (a.getCpf().isBlank()) {
            erros.append("- CPF não informado.\n");
        } else if (a.getCpf().length() != 11) {
            erros.append("- CPF deve possuir 11 dígitos.\n");
        }

        if (a.getEmail().isBlank()) {
            erros.append("- E-mail não informado.\n");
        } else if (!a.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            erros.append("- E-mail inválido.\n");
        }

        if (a.getEndereco().isBlank() || a.getEndereco().length() < 5) {
            erros.append("- Endereço inválido ou não informado.\n");
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


        p.setTipo(comboTipo.getSelectedItem().toString());
        p.setCor(comboCor.getSelectedItem().toString());
        p.setRaca(comboRaca.getSelectedItem().toString());

        String gen = comboGenero.getSelectedItem().toString();
        p.setGenero(gen.equals("Selecionar") ? '\0' : gen.charAt(0));

        String porte = comboPorte.getSelectedItem().toString();
        p.setPorte(porte.equals("Selecionar") ? '\0' : porte.charAt(0));

        p.setPeso(comboPeso.getSelectedItem().toString().equals("Selecionar") 
                  ? 0f : Float.parseFloat(comboPeso.getSelectedItem().toString()));

        p.setCastrado(comboCastrado.getSelectedItem().toString().equals("Sim"));
        p.setDeficiencia(comboDeficiencia.getSelectedItem().toString().equals("Possui"));
        p.setFIV(comboFiv.getSelectedItem().toString().equals("Possui"));
        p.setFELV(comboFelv.getSelectedItem().toString().equals("Possui"));


        if (a.getId() != 0) {
            p.setAdotanteId(a.getId());
        }

        return a;
 }

 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabecalho = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtCastrado = new javax.swing.JLabel();
        comboPorte = new javax.swing.JComboBox<>();
        txtEndereco = new javax.swing.JLabel();
        txtPorte = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        comboFiv = new javax.swing.JComboBox<>();
        edtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JLabel();
        edtEndereco = new javax.swing.JTextField();
        txtNome = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
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
        btnProximo = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        edtCpf = new javax.swing.JFormattedTextField();

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
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addComponent(icon)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(232, 231, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1240, 656));

        txtCastrado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtCastrado.setForeground(new java.awt.Color(0, 90, 81));
        txtCastrado.setText("Castrado");

        comboPorte.setForeground(new java.awt.Color(0, 90, 81));
        comboPorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Pequeno", "Médio", "Grande" }));

        txtEndereco.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(0, 90, 81));
        txtEndereco.setText("Endereço:");

        txtPorte.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtPorte.setForeground(new java.awt.Color(0, 90, 81));
        txtPorte.setText("Porte");

        txtEmail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 90, 81));
        txtEmail.setText("E-mail:");

        comboFiv.setForeground(new java.awt.Color(0, 90, 81));
        comboFiv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Possui", "Não possui" }));

        edtNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        edtNome.setForeground(new java.awt.Color(0, 90, 81));
        edtNome.setToolTipText("Infome o nome do adotante");
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

        txtCPF.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtCPF.setForeground(new java.awt.Color(0, 90, 81));
        txtCPF.setText("CPF:");

        edtEndereco.setForeground(new java.awt.Color(0, 90, 81));
        edtEndereco.setToolTipText("Informe o endereço do adotante");

        txtNome.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 90, 81));
        txtNome.setText("Nome:");

        edtEmail.setForeground(new java.awt.Color(0, 90, 81));
        edtEmail.setToolTipText("informe o e-mail do adotante");
        edtEmail.setName(""); // NOI18N

        txtFiv.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFiv.setForeground(new java.awt.Color(0, 90, 81));
        txtFiv.setText("Fiv");

        comboCor.setForeground(new java.awt.Color(0, 90, 81));
        comboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Preto", "Branco", "Marrom", "Chocolate", "Cinza", "Azul", "Vermelho", "Laranja", "Dourado", "Fulvo", "Creme", "Tigrado", "Listrado", "Tricolor", "Merle", "Arlequim", "Siamês", "Ponteado", "Bicolor", "Preto", "Branco" }));

        txtCor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtCor.setForeground(new java.awt.Color(0, 90, 81));
        txtCor.setText("Cor");

        comboGenero.setForeground(new java.awt.Color(0, 90, 81));
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Fêmea", "Macho" }));
        comboGenero.addActionListener(this::comboGeneroActionPerformed);

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
        comboFelv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Possui", "Não possui" }));

        comboDeficiencia.setForeground(new java.awt.Color(0, 90, 81));
        comboDeficiencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Possui", "Não possui" }));

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
        txtPreferencias.setText("Preferências:");

        comboCastrado.setForeground(new java.awt.Color(0, 90, 81));
        comboCastrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Sim", "Não" }));
        comboCastrado.addActionListener(this::comboCastradoActionPerformed);

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
        txtTitulo.setText("Cadastrar Adotante");

        edtCpf.setForeground(new java.awt.Color(0, 90, 81));
        edtCpf.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipo)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGenero)
                            .addComponent(comboRaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRaca)
                            .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeficiencia)
                            .addComponent(comboCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCastrado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPorte))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboFiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFiv)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPeso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboFelv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFelv)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(edtCpf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(edtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(edtEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(edtNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome)
                                .addComponent(txtCPF)
                                .addComponent(txtEmail)
                                .addComponent(txtEndereco)
                                .addComponent(txtPreferencias)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(208, 208, 208)
                                    .addComponent(btnCancelar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnProximo)))
                            .addGap(235, 235, 235))))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtEmail)
                .addGap(5, 5, 5)
                .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtPreferencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDeficiencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCastrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPorte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFiv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFelv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFelv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnProximo))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
                                    
            try {
            SistemaController sc = new SistemaController();
            Adotante a = modoEdicao ? adotanteEdicao : new Adotante();
            Preferencias p = new Preferencias(); 

            if (carregar(a, p) != null) {
                if (modoEdicao) {
                    sc.atualizarAdotante(a, p);
                    JOptionPane.showMessageDialog(this, "Adotante atualizado!");

                    if (telaAnterior instanceof ConfirmarAdocao) {
                        ((ConfirmarAdocao) telaAnterior).atualizarDadosAdocao();
                    }
                    

                } else {
                    sc.salvarAdotante(a, p);
                    JOptionPane.showMessageDialog(this, "Adotante cadastrado!");
                }

                if (telaAnterior != null) {
                    telaAnterior.setVisible(true);
                }
                this.dispose();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnProximoActionPerformed

    private void iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMouseClicked
        Main m = new  Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_iconMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (telaAnterior != null) {
            telaAnterior.setVisible(true); // Reexibe a tela que te chamou
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboCastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCastradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCastradoActionPerformed

    private void comboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGeneroActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new CadastroAdotante(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProximo;
    private javax.swing.JComboBox<String> comboCastrado;
    private javax.swing.JComboBox<String> comboCor;
    private javax.swing.JComboBox<String> comboDeficiencia;
    private javax.swing.JComboBox<String> comboFelv;
    private javax.swing.JComboBox<String> comboFiv;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JComboBox<String> comboPeso;
    private javax.swing.JComboBox<String> comboPorte;
    private javax.swing.JComboBox<String> comboRaca;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JFormattedTextField edtCpf;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtEndereco;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JLabel txtCPF;
    private javax.swing.JLabel txtCastrado;
    private javax.swing.JLabel txtCor;
    private javax.swing.JLabel txtDeficiencia;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JLabel txtFelv;
    private javax.swing.JLabel txtFiv;
    private javax.swing.JLabel txtGenero;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPeso;
    private javax.swing.JLabel txtPorte;
    private javax.swing.JLabel txtPreferencias;
    private javax.swing.JLabel txtRaca;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
