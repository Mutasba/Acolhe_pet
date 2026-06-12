/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.MatchController;
import Controller.SistemaController;
import Model_Entety.Adotante;
import Model_Entety.Animal;
import Model_Entety.FiltroAnimal;
import Model_Entety.Notificacao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import service.MatchAutomaticoService;
import service.WrapLayout;

/**
 *
 * @author fanim
 */
public class Main extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pai, BorderLayout.CENTER);

        lista.removeAll();

        lista.setLayout(new WrapLayout(
                FlowLayout.LEFT,
                5,
                30
        ));

        jScrollPane1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        );

        jScrollPane1.getViewport().setBackground(Color.BLUE);
        // lista.setPreferredSize(new Dimension(1100, 2000));
        SistemaController c;
        List<Animal> animais = null;
        try {
            c = new SistemaController();
            animais = c.listarAnimais();
        } catch (SQLException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        carregar(animais);
    }

    void carregar(List<Animal> l) {
        lista.removeAll();
        for (Animal a : l) {

            Item item = new Item(a, this);

            item.setPreferredSize(new Dimension(232, 500));
            item.setMinimumSize(new Dimension(250, 290));
            item.setMaximumSize(new Dimension(250, 290));

            lista.add(item);
        }
        lista.revalidate();
        lista.repaint();
    }

    List<Animal> filtrar(FiltroAnimal f) {
        try {
            MatchController mc = new MatchController();

            f.setTipo(
                    "Selecionar".equals(comboTipo.getSelectedItem())
                    ? null
                    : comboTipo.getSelectedItem().toString()
            );

            f.setCor(
                    "Selecionar".equals(comboCor.getSelectedItem())
                    ? null
                    : comboCor.getSelectedItem().toString()
            );

            f.setRaca(
                    "Selecionar".equals(comboRaca.getSelectedItem())
                    ? null
                    : comboRaca.getSelectedItem().toString()
            );

            String genero = comboGenero.getSelectedItem().toString();

            f.setGenero(
                    genero.equals("Selecionar")
                    ? '\0'
                    : genero.charAt(0)
            );

            String porte = comboPorte.getSelectedItem().toString();

            f.setPorte(
                    porte.equals("Selecionar")
                    ? '\0'
                    : porte.charAt(0)
            );

            f.setPeso(
                    "Selecionar".equals(comboPeso.getSelectedItem())
                    ? null
                    : Double.valueOf(
                            comboPeso.getSelectedItem().toString()
                    )
            );

            f.setCastrado(
                    "Selecionar".equals(comboCastrado.getSelectedItem())
                    ? null
                    : "Sim".equalsIgnoreCase(
                            comboCastrado.getSelectedItem().toString()
                    )
            );

            f.setDeficiencia(
                    "Selecionar".equals(comboDeficiencia.getSelectedItem())
                    ? null
                    : "Sim".equalsIgnoreCase(
                            comboDeficiencia.getSelectedItem().toString()
                    )
            );

            f.setFiv(
                    "Selecionar".equals(comboFIV.getSelectedItem())
                    ? null
                    : "Sim".equalsIgnoreCase(
                            comboFIV.getSelectedItem().toString()
                    )
            );

            f.setFelv(
                    "Selecionar".equals(comboFELV.getSelectedItem())
                    ? null
                    : "Sim".equalsIgnoreCase(
                            comboFELV.getSelectedItem().toString()
                    )
            );

            return mc.filtro(f);
        } catch (SQLException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }

    }

    void monitorar() {

        new Thread(() -> {

            while (true) {

                try {

                    MatchAutomaticoService ms
                            = new MatchAutomaticoService();

                    ms.gerarMatches();

                    SistemaController sc
                            = new SistemaController();

                    List<Notificacao> lista
                            = sc.listarNotificacoes();

                    boolean possuiNaoLidas = false;

                    for (Notificacao n : lista) {

                        if (!n.isVisualizada()) {

                            possuiNaoLidas = true;
                            break;

                        }
                    }

                    final boolean mostrar
                            = possuiNaoLidas;

                    SwingUtilities.invokeLater(() -> {

                        if (mostrar) {

                            btnNotificacao.setForeground(
                                    Color.RED
                            );

                        } else {

                            btnNotificacao.setForeground(
                                    Color.GRAY
                            );

                        }

                    });

                    Thread.sleep(5000);

                } catch (Exception ex) {

                    ex.printStackTrace();

                }
            }

        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pai = new javax.swing.JPanel();
        jPanel_Filtros_Main = new javax.swing.JPanel();
        jLabel_Tipo = new javax.swing.JLabel();
        jLabel_Genero = new javax.swing.JLabel();
        jLabel_Deficiencia = new javax.swing.JLabel();
        jLabel_Porte = new javax.swing.JLabel();
        jLabel_FIV = new javax.swing.JLabel();
        jLabel_Cor = new javax.swing.JLabel();
        jLabel_Castrado = new javax.swing.JLabel();
        jLabel_Raça = new javax.swing.JLabel();
        jLabel_Peso = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();
        comboFIV = new javax.swing.JComboBox<>();
        comboPorte = new javax.swing.JComboBox<>();
        comboCastrado = new javax.swing.JComboBox<>();
        comboDeficiencia = new javax.swing.JComboBox<>();
        comboFELV = new javax.swing.JComboBox<>();
        comboCor = new javax.swing.JComboBox<>();
        comboRaca = new javax.swing.JComboBox<>();
        comboPeso = new javax.swing.JComboBox<>();
        jLabel_FELV = new javax.swing.JLabel();
        jLabel_Filtro = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel8_Cabecalho = new javax.swing.JPanel();
        btnCadastrarAdt = new javax.swing.JButton();
        btnCadastrarAnimal = new javax.swing.JButton();
        btnHistorico = new javax.swing.JButton();
        btnEstatisticas = new javax.swing.JButton();
        btnPerfilIcon = new javax.swing.JButton();
        edtNomeUser = new javax.swing.JLabel();
        jLabel_Welcome = new javax.swing.JLabel();
        btnNotificacao = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnCadastrarAdt1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pai.setBackground(new java.awt.Color(232, 231, 204));
        pai.setPreferredSize(new java.awt.Dimension(1512, 1044));

        jPanel_Filtros_Main.setBackground(new java.awt.Color(232, 231, 204));
        jPanel_Filtros_Main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_Tipo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel_Tipo.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Tipo.setText("Tipo:");

        jLabel_Genero.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Genero.setText("Gênero:");

        jLabel_Deficiencia.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Deficiencia.setText("Deficiência:");

        jLabel_Porte.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Porte.setText("Porte:");

        jLabel_FIV.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_FIV.setText("FIV:");

        jLabel_Cor.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Cor.setText("Cor:");

        jLabel_Castrado.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Castrado.setText("Castrado:");

        jLabel_Raça.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Raça.setText("Raça:");

        jLabel_Peso.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Peso.setText("Peso:");

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Fêmea", "Macho" }));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Gato", "Cão" }));

        comboFIV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Sim", "Não" }));

        comboPorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Pequeno", "Médio", "Grande" }));

        comboCastrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Sim", "Não" }));

        comboDeficiencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Sim", "Não", " " }));

        comboFELV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Sim", "Não" }));

        comboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Preto", "Branco", "Castanho ", "Caramelo ", "Indiferente" }));

        comboRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Vira-lata (SRD)", "Caramelo", "Pinscher", "Spitz Alemão", "Shih Tzu", "Poodle", "Siamês", "Persa", "Angorá", "Maine Coon." }));

        comboPeso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        jLabel_FELV.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_FELV.setText("FELV:");

        jLabel_Filtro.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel_Filtro.setForeground(new java.awt.Color(0, 90, 81));
        jLabel_Filtro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Filtro.setText("Filtrar Animais ");

        btnBuscar.setBackground(new java.awt.Color(0, 90, 81));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        javax.swing.GroupLayout jPanel_Filtros_MainLayout = new javax.swing.GroupLayout(jPanel_Filtros_Main);
        jPanel_Filtros_Main.setLayout(jPanel_Filtros_MainLayout);
        jPanel_Filtros_MainLayout.setHorizontalGroup(
            jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Filtros_MainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Genero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_Filtros_MainLayout.createSequentialGroup()
                        .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Deficiencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_Filtros_MainLayout.createSequentialGroup()
                        .addComponent(jLabel_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272))
                    .addGroup(jPanel_Filtros_MainLayout.createSequentialGroup()
                        .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboCastrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Castrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Porte, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFIV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_FIV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFELV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_FELV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Cor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Raça, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_Filtros_MainLayout.createSequentialGroup()
                        .addComponent(comboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_Filtros_MainLayout.setVerticalGroup(
            jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Filtros_MainLayout.createSequentialGroup()
                .addComponent(jLabel_Filtro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Tipo)
                        .addComponent(jLabel_Genero)
                        .addComponent(jLabel_Raça)
                        .addComponent(jLabel_Deficiencia)
                        .addComponent(jLabel_Castrado)
                        .addComponent(jLabel_Peso)
                        .addComponent(jLabel_Porte))
                    .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_FIV)
                        .addComponent(jLabel_FELV)
                        .addComponent(jLabel_Cor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Filtros_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDeficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFIV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFELV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8_Cabecalho.setBackground(new java.awt.Color(0, 90, 81));
        jPanel8_Cabecalho.setForeground(new java.awt.Color(0, 90, 81));
        jPanel8_Cabecalho.setPreferredSize(new java.awt.Dimension(276, 68));

        btnCadastrarAdt.setBackground(new java.awt.Color(0, 90, 81));
        btnCadastrarAdt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCadastrarAdt.setForeground(new java.awt.Color(232, 231, 204));
        btnCadastrarAdt.setText("Cadastrar Adotante");
        btnCadastrarAdt.setBorder(null);
        btnCadastrarAdt.addActionListener(this::btnCadastrarAdtActionPerformed);

        btnCadastrarAnimal.setBackground(new java.awt.Color(0, 90, 81));
        btnCadastrarAnimal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCadastrarAnimal.setForeground(new java.awt.Color(232, 231, 204));
        btnCadastrarAnimal.setText("Cadastrar Animal");
        btnCadastrarAnimal.setBorder(null);
        btnCadastrarAnimal.addActionListener(this::btnCadastrarAnimalActionPerformed);

        btnHistorico.setBackground(new java.awt.Color(0, 90, 81));
        btnHistorico.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnHistorico.setForeground(new java.awt.Color(232, 231, 204));
        btnHistorico.setText("Histórico");
        btnHistorico.setBorder(null);
        btnHistorico.addActionListener(this::btnHistoricoActionPerformed);

        btnEstatisticas.setBackground(new java.awt.Color(0, 90, 81));
        btnEstatisticas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEstatisticas.setForeground(new java.awt.Color(232, 231, 204));
        btnEstatisticas.setText("Estatísticas");
        btnEstatisticas.setBorder(null);
        btnEstatisticas.addActionListener(this::btnEstatisticasActionPerformed);

        btnPerfilIcon.setBackground(new java.awt.Color(0, 90, 81));
        btnPerfilIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_user.png"))); // NOI18N
        btnPerfilIcon.setBorder(null);
        btnPerfilIcon.addActionListener(this::btnPerfilIconActionPerformed);

        edtNomeUser.setForeground(new java.awt.Color(250, 166, 190));
        edtNomeUser.setText("ADM ****");

        jLabel_Welcome.setForeground(new java.awt.Color(232, 231, 204));
        jLabel_Welcome.setText("Bem-vindo!");

        btnNotificacao.setBackground(new java.awt.Color(0, 90, 81));
        btnNotificacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/notificacao.png"))); // NOI18N
        btnNotificacao.setToolTipText("");
        btnNotificacao.setAutoscrolls(true);
        btnNotificacao.setBorder(null);
        btnNotificacao.addActionListener(this::btnNotificacaoActionPerformed);

        btnHome.setBackground(new java.awt.Color(0, 90, 81));
        btnHome.setForeground(new java.awt.Color(0, 90, 81));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_acolhepet.png"))); // NOI18N
        btnHome.setBorder(null);
        btnHome.addActionListener(this::btnHomeActionPerformed);

        btnCadastrarAdt1.setBackground(new java.awt.Color(0, 90, 81));
        btnCadastrarAdt1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCadastrarAdt1.setForeground(new java.awt.Color(232, 231, 204));
        btnCadastrarAdt1.setText("Sincronizar com Adotante");
        btnCadastrarAdt1.setBorder(null);
        btnCadastrarAdt1.addActionListener(this::btnCadastrarAdt1ActionPerformed);

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("!");

        javax.swing.GroupLayout jPanel8_CabecalhoLayout = new javax.swing.GroupLayout(jPanel8_Cabecalho);
        jPanel8_Cabecalho.setLayout(jPanel8_CabecalhoLayout);
        jPanel8_CabecalhoLayout.setHorizontalGroup(
            jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8_CabecalhoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 546, Short.MAX_VALUE)
                .addComponent(btnCadastrarAdt1)
                .addGap(18, 18, 18)
                .addGroup(jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8_CabecalhoLayout.createSequentialGroup()
                        .addComponent(btnCadastrarAdt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrarAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHistorico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEstatisticas))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPerfilIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Welcome)
                    .addGroup(jPanel8_CabecalhoLayout.createSequentialGroup()
                        .addComponent(edtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnNotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        jPanel8_CabecalhoLayout.setVerticalGroup(
            jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8_CabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8_CabecalhoLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8_CabecalhoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEstatisticas)
                            .addComponent(btnHistorico)
                            .addComponent(btnCadastrarAnimal)
                            .addComponent(btnCadastrarAdt)
                            .addComponent(btnCadastrarAdt1)))
                    .addGroup(jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPerfilIcon)
                        .addGroup(jPanel8_CabecalhoLayout.createSequentialGroup()
                            .addGroup(jPanel8_CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(edtNomeUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNotificacao))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel_Welcome))))
                .addContainerGap())
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1240, 656));

        lista.setBackground(new java.awt.Color(232, 231, 204));

        javax.swing.GroupLayout listaLayout = new javax.swing.GroupLayout(lista);
        lista.setLayout(listaLayout);
        listaLayout.setHorizontalGroup(
            listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1308, Short.MAX_VALUE)
        );
        listaLayout.setVerticalGroup(
            listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(lista);

        javax.swing.GroupLayout paiLayout = new javax.swing.GroupLayout(pai);
        pai.setLayout(paiLayout);
        paiLayout.setHorizontalGroup(
            paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paiLayout.createSequentialGroup()
                .addGroup(paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_Filtros_Main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(paiLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8_Cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 1389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        paiLayout.setVerticalGroup(
            paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paiLayout.createSequentialGroup()
                .addComponent(jPanel8_Cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_Filtros_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        FiltroAnimal f = new FiltroAnimal();
        carregar(filtrar(f));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCadastrarAdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAdtActionPerformed
        // TODO add your handling code here:

        CadastroAdotante ca = new CadastroAdotante();
        this.dispose();
        ca.setVisible(true);
    }//GEN-LAST:event_btnCadastrarAdtActionPerformed

    private void btnCadastrarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAnimalActionPerformed
        // TODO add your handling code here:

        CadastroAnimal a = new CadastroAnimal();
        this.dispose();
        a.setVisible(true);
    }//GEN-LAST:event_btnCadastrarAnimalActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void btnEstatisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatisticasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstatisticasActionPerformed

    private void btnPerfilIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerfilIconActionPerformed

    private void btnNotificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacaoActionPerformed
        SistemaController sc;
        try {

            JPopupMenu popup = new JPopupMenu();

            sc = new SistemaController();

            List<Notificacao> notificacoes
                    = sc.listarNotificacoes();

            for (Notificacao n : notificacoes) {

                if (n.isVisualizada()) {
                    continue;
                }

                JMenuItem item = new JMenuItem(
                        n.getTitulo()
                );

                item.addActionListener(e -> {

                    JOptionPane.showMessageDialog(
                            null,
                            n.getMensagem(),
                            n.getTitulo(),
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    try {

                        sc.marcarNotificacaoVisualizada(
                                n.getId()
                        );

                    } catch (SQLException ex) {

                        ex.printStackTrace();

                    }
                });

                popup.add(item);
            }

            if (popup.getComponentCount() == 0) {

                popup.add(
                        new JMenuItem(
                                "Nenhuma notificação pendente"
                        )
                );
            }

            popup.show(
                    btnNotificacao,
                    0,
                    btnNotificacao.getHeight()
            );

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }//GEN-LAST:event_btnNotificacaoActionPerformed

    private void btnCadastrarAdt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAdt1ActionPerformed
        // TODO add your handling code here:
        JTextField txtCpf = new JTextField();

        Object[] campos = {
            "CPF:", txtCpf
        };

        int op = JOptionPane.showConfirmDialog(
                this,
                campos,
                "Buscar Adotante",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (op == JOptionPane.OK_OPTION) {

            String cpf = txtCpf.getText();
            try {

                SistemaController sc = new SistemaController();

                Adotante adotante = sc.buscarPorCpf(cpf);

                if (adotante == null) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Adotante não encontrado!"
                    );

                    return;
                }

                AnimaisCompativeis tela
                        = new AnimaisCompativeis(adotante);

                tela.setVisible(true);
                this.dispose();
            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao buscar adotante: " + ex.getMessage()
                );
            }

        }

    }//GEN-LAST:event_btnCadastrarAdt1ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrarAdt;
    private javax.swing.JButton btnCadastrarAdt1;
    private javax.swing.JButton btnCadastrarAnimal;
    private javax.swing.JButton btnEstatisticas;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNotificacao;
    private javax.swing.JButton btnPerfilIcon;
    private javax.swing.JComboBox<String> comboCastrado;
    private javax.swing.JComboBox<String> comboCor;
    private javax.swing.JComboBox<String> comboDeficiencia;
    private javax.swing.JComboBox<String> comboFELV;
    private javax.swing.JComboBox<String> comboFIV;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JComboBox<String> comboPeso;
    private javax.swing.JComboBox<String> comboPorte;
    private javax.swing.JComboBox<String> comboRaca;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel edtNomeUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Castrado;
    private javax.swing.JLabel jLabel_Cor;
    private javax.swing.JLabel jLabel_Deficiencia;
    private javax.swing.JLabel jLabel_FELV;
    private javax.swing.JLabel jLabel_FIV;
    private javax.swing.JLabel jLabel_Filtro;
    private javax.swing.JLabel jLabel_Genero;
    private javax.swing.JLabel jLabel_Peso;
    private javax.swing.JLabel jLabel_Porte;
    private javax.swing.JLabel jLabel_Raça;
    private javax.swing.JLabel jLabel_Tipo;
    private javax.swing.JLabel jLabel_Welcome;
    private javax.swing.JPanel jPanel8_Cabecalho;
    private javax.swing.JPanel jPanel_Filtros_Main;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lista;
    private javax.swing.JPanel pai;
    // End of variables declaration//GEN-END:variables
}
