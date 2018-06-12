package VIEW;

import DOMAIN.Usuario;
import DAO.OperacaoBancoAlugueis;
import DAO.OperacaoBancoLivro;
import DAO.OperacaoBancoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class TelaUsuario extends javax.swing.JFrame {

    OperacaoBancoUsuario ob = new OperacaoBancoUsuario();
    OperacaoBancoLivro obc = new OperacaoBancoLivro();
    OperacaoBancoAlugueis obm = new OperacaoBancoAlugueis();

    public TelaUsuario() {
        initComponents();
        listarUsuarios();
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCodigoUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

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
        setTitle("Usuários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Usuarios");

        txtCodigoUsuario.setEditable(false);
        txtCodigoUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigoUsuario.setEnabled(false);
        txtCodigoUsuario.setFocusable(false);
        txtCodigoUsuario.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo Usuario");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Pesquisar Usuario");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbUsuario);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisar)
                            .addComponent(txtNome)
                            .addComponent(txtCodigoUsuario))))
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
                    .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null,
                "Deseja realmente criar um novo usuário?",
                "Novo",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpar();
        }
    }//GEN-LAST:event_btnNovoMousePressed

    private void btnIncluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncluirMousePressed
        // TODO add your handling code here:
        if (!txtNome.getText().trim().isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setNome(txtNome.getText().trim());
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente incluir o usuário?",
                    "Incluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ob.incluir(usuario);

                limpar();
                listarUsuarios();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_btnIncluirMousePressed

    private void btnExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMousePressed
        // TODO add your handling code here:
        if (tbUsuario.getSelectedRow() != -1) {
            Usuario a = new Usuario();
            a.setCodusuario(Integer.parseInt(txtCodigoUsuario.getText()));
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente excluir o usuário?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ob.excluir(a);

                limpar();
                listarUsuarios();
            }
        }
    }//GEN-LAST:event_btnExcluirMousePressed

    private void btnAlterarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMousePressed
        // TODO add your handling code here:
        if (tbUsuario.getSelectedRow() != -1) {
            Usuario a = new Usuario();
            a.setCodusuario(Integer.parseInt(txtCodigoUsuario.getText()));
            a.setNome(txtNome.getText().trim());
            if (JOptionPane.showConfirmDialog(null,
                    "Deseja realmente alterar o usuário?",
                    "Alterar",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ob.alterar(a);

                limpar();
                listarUsuarios();
            }
        }
    }//GEN-LAST:event_btnAlterarMousePressed

    private void btnSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMousePressed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null,
                "Deseja realmente sair?",
                "Sair",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnSairMousePressed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        ResultSet rs = ob.buscarUsuarioNome(txtPesquisar.getText());
        carregarTabela(rs);
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        btnSairMousePressed(null);
    }//GEN-LAST:event_formWindowClosing

    private void tbUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseReleased
        // TODO add your handling code here:
        int linha = tbUsuario.getSelectedRow();
        String codigoUsuario = tbUsuario.getModel().getValueAt(linha, 0).toString();
        String nome = tbUsuario.getModel().getValueAt(linha, 1).toString();

        txtCodigoUsuario.setText(codigoUsuario);
        txtNome.setText(nome);

        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tbUsuarioMouseReleased

    public void listarUsuarios() {
        ResultSet rs = ob.listar();
        carregarTabela(rs);
    }

    public void carregarTabela(ResultSet rs) {
        String[] colunasTabela = new String[]{"Código", "Nome"};

        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tbUsuario.setModel(modeloTabela);
        tbUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int width = tbUsuario.getWidth() - 50;
        tbUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbUsuario.getColumnModel().getColumn(1).setPreferredWidth(width);
        tbUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            rs.previous();
            while (rs.next()) {
                modeloTabela.addRow(new String[]{
                    rs.getString(1), rs.getString(2)});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela: " + e.getMessage());
        }
    }

    public void limpar() {
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        txtCodigoUsuario.setText(null);
        txtNome.setText(null);
        txtPesquisar.setText(null);
        tbUsuario.clearSelection();
        txtNome.requestFocus();//Coloca o foco(cursor) no objeto
    }

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
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtCodigoUsuario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
