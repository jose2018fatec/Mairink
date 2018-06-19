package VIEW;

import DAO.OperacaoBancoAlugueis;
import DAO.OperacaoBancoLivro;
import DAO.OperacaoBancoUsuario;
import DOMAIN.Alugueis;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * Classe para criar a tela de cadastro de aluguéis.
 * @author Jose
 */
public class TelaAlugueis extends javax.swing.JFrame {

    OperacaoBancoAlugueis obm = new OperacaoBancoAlugueis();

    public TelaAlugueis() {
        initComponents();
        init();
    } // Fim do método construtor

    private void init() {
        listarAlugueis();
        carregarUsuarios();
        carregarLivros();
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage()); // definindo o ícone da janela/Frame
    } // Fim do método init

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoAluguel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAluguel = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cbNomeUsuario = new javax.swing.JComboBox<>();
        cbNomeLivro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDtDevolucao = new javax.swing.JFormattedTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Aluguéis");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Aluguéis");

        txtCodigoAluguel.setEditable(false);
        txtCodigoAluguel.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigoAluguel.setEnabled(false);
        txtCodigoAluguel.setFocusable(false);
        txtCodigoAluguel.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo Aluguel");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome Usuário");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Pesquisar Aluguel");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        tbAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbAluguelMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbAluguel);

        btnNovo.setText("Novo");
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNovoMousePressed(evt);
            }
        });

        btnIncluir.setText("Incluir");
        btnIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIncluirMousePressed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAlterarMousePressed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExcluirMousePressed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSairMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome Livro");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data Devolução");

        try {
            txtDtDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(txtCodigoAluguel, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(cbNomeUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbNomeLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDtDevolucao))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMousePressed
		// confirmando para limpar os dados dos campos
        if (JOptionPane.showConfirmDialog(null,
                "Deseja realmente criar um novo aluguel?",
                "Novo",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpar();
        }
    }//GEN-LAST:event_btnNovoMousePressed

    private void btnIncluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncluirMousePressed
        // verificando o preenchimento dos campos obrigatórios.
        if (cbNomeUsuario.getSelectedIndex() != -1 && cbNomeLivro.getSelectedIndex() != -1
                && !txtDtDevolucao.getText().replaceAll("/", "").trim().isEmpty()) {
            Alugueis aluguel = new Alugueis();
            aluguel.setNomeusuario(cbNomeUsuario.getSelectedItem().toString());
            aluguel.setNomelivro(cbNomeLivro.getSelectedItem().toString());
            String[] data = txtDtDevolucao.getText().split("/");
            aluguel.setDtdevolucao(new Date(Integer.parseInt(data[2]) - 1900,
                    Integer.parseInt(data[1]) - 1,
                    Integer.parseInt(data[0])));
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente incluir o aluguel?",
                    "Incluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                obm.incluir(aluguel); // inserir o registro na tabela

                limpar();
                listarAlugueis();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_btnIncluirMousePressed

    private void btnExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMousePressed
        // verificando se possui elemento selecionado na tabela de aluguéis
        if (tbAluguel.getSelectedRow() != -1) {
            Alugueis aluguel = new Alugueis();
            aluguel.setCodaluguel(Integer.parseInt(txtCodigoAluguel.getText()));
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente excluir o aluguel?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                obm.excluir(aluguel); // excluir o registro da tabela

                limpar();
                listarAlugueis();
            }
        }
    }//GEN-LAST:event_btnExcluirMousePressed

    private void btnAlterarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMousePressed
        // verificando se possui elemento selecionado na tabela de aluguéis
        if (tbAluguel.getSelectedRow() != -1) {
            Alugueis aluguel = new Alugueis();
            aluguel.setCodaluguel(Integer.parseInt(txtCodigoAluguel.getText()));
            aluguel.setNomeusuario(cbNomeUsuario.getSelectedItem().toString());
            aluguel.setNomelivro(cbNomeLivro.getSelectedItem().toString());
            String[] data = txtDtDevolucao.getText().split("/");
            aluguel.setDtdevolucao(new Date(Integer.parseInt(data[2]) - 1900,
                    Integer.parseInt(data[1]) - 1,
                    Integer.parseInt(data[0])));
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente alterar o aluguel?",
                    "Alterar",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                obm.alterar(aluguel); // altera o registro na tabela

                limpar();
                listarAlugueis();
            }
        }
    }//GEN-LAST:event_btnAlterarMousePressed

    private void btnSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMousePressed
        // confirmando para fechar a janela/Frame
        if (JOptionPane.showConfirmDialog(null,
                "Deseja realmente sair?",
                "Sair",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose(); // fecha a janela
        }
    }//GEN-LAST:event_btnSairMousePressed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // busca o(s) registro(s) e carrega na tabela
        ResultSet rs = obm.buscarAluguel(txtPesquisar.getText());
        carregarTabela(rs);
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // executar o método btnSairMousePressed, pois também serve para confirmar o fechamento da janela
        btnSairMousePressed(null);
    }//GEN-LAST:event_formWindowClosing

    private void tbAluguelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAluguelMouseReleased
        // obtém o número da linha selecionada na tabela
        int linha = tbAluguel.getSelectedRow();
        // obtém os dados nas colunas
        String codigoAluguel = tbAluguel.getModel().getValueAt(linha, 0).toString();
        String nomeusuario = tbAluguel.getModel().getValueAt(linha, 1).toString();
        String nomelivro = tbAluguel.getModel().getValueAt(linha, 2).toString();
        String dtdevolucao = tbAluguel.getModel().getValueAt(linha, 3).toString();
        // define nos campos, os dados obtidos na tabela
        txtCodigoAluguel.setText(codigoAluguel);
        cbNomeUsuario.setSelectedItem(nomeusuario);
        cbNomeLivro.setSelectedItem(nomelivro);
        txtDtDevolucao.setValue(dtdevolucao);

        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tbAluguelMouseReleased

    public void listarAlugueis() {
	// lista o(s) registro(s) e carrega na tabela
        ResultSet rs = obm.listar();
        carregarTabela(rs);
    } // Fim do método listarAlugueis

    public void carregarTabela(ResultSet rs) {
        String[] colunasTabela = new String[]{"Código", "Nome Usuário", "Nome Livro", "Data Devolução"};

        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tbAluguel.setModel(modeloTabela);
        tbAluguel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int width = (tbAluguel.getWidth() - 150) / 2;
        tbAluguel.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbAluguel.getColumnModel().getColumn(1).setPreferredWidth(width);
        tbAluguel.getColumnModel().getColumn(2).setPreferredWidth(width);
        tbAluguel.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            rs.previous(); // volta o cursor do ResultSet
            while (rs.next()) { // enquanto possuir registro no ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                String[] dt = rs.getString("dtdevolucao").split("-");
                modeloTabela.addRow(new String[]{
                    rs.getString(1), rs.getString(2), rs.getString(3), dt[2] + "/" + dt[1] + "/" + dt[0]});
            }
        } catch (SQLException e) { // ocorreu algum erro
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela: " + e.getMessage());
        }
    } // Fim do método carregarTabela

    public void carregarUsuarios() {
        ResultSet rs = new OperacaoBancoUsuario().listar(); // lista o(s) usuário(s)
        cbNomeUsuario.removeAllItems(); // remover todos os itens da ComboBox
        try {
            rs.previous(); // volta o cursor do ResultSet
            while (rs.next()) { // enquanto possuir registro no ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                cbNomeUsuario.addItem(rs.getString("nome")); // add item na ComboBox
            }
            cbNomeUsuario.setSelectedIndex(-1);
        } catch (SQLException e) { // ocorreu algum erro
            JOptionPane.showMessageDialog(null, "Erro ao carregar usuarios: " + e.getMessage());
        }
    } // Fim do método carregarUsuarios

    public void carregarLivros() {
        ResultSet rs = new OperacaoBancoLivro().listar(); // lista o(s) livro(s)
        cbNomeLivro.removeAllItems(); // remover todos os itens da ComboBox
        try {
            rs.previous(); // volta o cursor do ResultSet
            while (rs.next()) { // enquanto possuir registro no ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                cbNomeLivro.addItem(rs.getString("nome")); // add item na ComboBox
            }
            cbNomeLivro.setSelectedIndex(-1);
        } catch (SQLException e) { // ocorreu algum erro
            JOptionPane.showMessageDialog(null, "Erro ao carregar livros: " + e.getMessage());
        }
    } // Fim do método carregarLivros

    public void limpar() {
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        txtCodigoAluguel.setText(null);
        cbNomeUsuario.setSelectedIndex(-1);
        cbNomeLivro.setSelectedIndex(-1);
        txtDtDevolucao.setValue(null);
        txtDtDevolucao.setText(null);
        txtPesquisar.setText(null);
        tbAluguel.clearSelection();
        cbNomeUsuario.requestFocus(); //Coloca o foco(cursor) no objeto
    } // Fim do método limpar

    public static void main(String args[]) {
        /* Set the GraphiteLookAndFeel look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaAlugueis().setVisible(true);
            }
        });
    } // Fim do método main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbNomeLivro;
    private javax.swing.JComboBox<String> cbNomeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbAluguel;
    private javax.swing.JTextField txtCodigoAluguel;
    private javax.swing.JFormattedTextField txtDtDevolucao;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

} // Fim da classe
