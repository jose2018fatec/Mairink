package VIEW;

import DAO.OperacaoBancoAlugueis;
import DAO.OperacaoBancoLivro;
import DOMAIN.Livros;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * Classe para criar a tela de cadastro de livros.
 * @author Jose
 */
public class TelaLivro extends javax.swing.JFrame {

    OperacaoBancoLivro ob = new OperacaoBancoLivro();
    OperacaoBancoLivro obc = new OperacaoBancoLivro();
    OperacaoBancoAlugueis obm = new OperacaoBancoAlugueis();

    public TelaLivro() {
        initComponents();
        listarLivros();
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage()); // definindo o ícone da janela/Frame
    } // Fim do método construtor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCodigoLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLivro = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();

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
        setTitle("Livros");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Livros");

        txtCodigoLivro.setEditable(false);
        txtCodigoLivro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigoLivro.setEnabled(false);
        txtCodigoLivro.setFocusable(false);
        txtCodigoLivro.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo Livro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Pesquisar Livro");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        tbLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbLivroMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbLivro);

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
        jLabel4.setText("Autor");

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
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoLivro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(txtCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
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
                "Deseja realmente criar um novo livro?",
                "Novo",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpar();
        }
    }//GEN-LAST:event_btnNovoMousePressed

    private void btnIncluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncluirMousePressed
        // verificando o preenchimento dos campos obrigatórios.
        if (!txtNome.getText().trim().isEmpty() && !txtAutor.getText().trim().isEmpty()) {
            Livros livro = new Livros();
            livro.setNome(txtNome.getText().trim());
            livro.setAutor(txtAutor.getText().trim());
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente incluir o livro?",
                    "Incluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ob.incluir(livro); // inserir o registro na tabela

                limpar();
                listarLivros();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_btnIncluirMousePressed

    private void btnExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMousePressed
        // verificando se possui elemento selecionado na tabela de livros
        if (tbLivro.getSelectedRow() != -1) {
            Livros livro = new Livros();
            livro.setCodlivro(Integer.parseInt(txtCodigoLivro.getText()));
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente excluir o livro?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ob.excluir(livro); // excluir o registro da tabela

                limpar();
                listarLivros();
            }
        }
    }//GEN-LAST:event_btnExcluirMousePressed

    private void btnAlterarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMousePressed
        // verificando se possui elemento selecionado na tabela de livros
        if (tbLivro.getSelectedRow() != -1) {
            Livros livro = new Livros();
            livro.setCodlivro(Integer.parseInt(txtCodigoLivro.getText()));
            livro.setNome(txtNome.getText().trim());
            livro.setAutor(txtAutor.getText().trim());
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente alterar o livro?",
                    "Alterar",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ob.alterar(livro); // altera o registro na tabela

                limpar();
                listarLivros();
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
        ResultSet rs = ob.buscarLivroNome(txtPesquisar.getText());
        carregarTabela(rs);
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // executar o método btnSairMousePressed, pois também serve para confirmar o fechamento da janela
        btnSairMousePressed(null);
    }//GEN-LAST:event_formWindowClosing

    private void tbLivroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLivroMouseReleased
        // obtém o número da linha selecionada na tabela
        int linha = tbLivro.getSelectedRow();
		// obtém os dados nas colunas
        String codigoLivro = tbLivro.getModel().getValueAt(linha, 0).toString();
        String nome = tbLivro.getModel().getValueAt(linha, 1).toString();
        String autor = tbLivro.getModel().getValueAt(linha, 2).toString();
		// define nos campos, os dados obtidos na tabela
        txtCodigoLivro.setText(codigoLivro);
        txtNome.setText(nome);
        txtAutor.setText(autor);

        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tbLivroMouseReleased

    public void listarLivros() {
        // lista o(s) registro(s) e carrega na tabela
        ResultSet rs = ob.listar();
        carregarTabela(rs);
    } // Fim do método listarLivros

    public void carregarTabela(ResultSet rs) {
        String[] colunasTabela = new String[]{"Código", "Nome", "Autor"};

        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tbLivro.setModel(modeloTabela);
        tbLivro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int width = (tbLivro.getWidth()-50)/2;
        tbLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbLivro.getColumnModel().getColumn(1).setPreferredWidth(width);
        tbLivro.getColumnModel().getColumn(2).setPreferredWidth(width);
        tbLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            rs.previous(); // volta o cursor do ResultSet
            while (rs.next()) { // enquanto possuir registro no ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                modeloTabela.addRow(new String[]{
                    rs.getString(1), rs.getString(2), rs.getString(3)});
            }
        } catch (SQLException e) { // ocorreu algum erro
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela: " + e.getMessage());
        }
    } // Fim do método carregarTabela

    public void limpar() {
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        txtCodigoLivro.setText(null);
        txtNome.setText(null);
        txtAutor.setText(null);
        txtPesquisar.setText(null);
        tbLivro.clearSelection();
        txtNome.requestFocus(); // Coloca o foco(cursor) no objeto
    } // Fim do método limpar|

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
                new TelaLivro().setVisible(true);
            }
        });
    } // Fim do método main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbLivro;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCodigoLivro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

} // Fim da classe
