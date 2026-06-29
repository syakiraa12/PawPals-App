/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pawpals;

/**
 *
 * @author Syakira
 */
public class Transaction extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Transaction.class.getName());
    private javax.swing.JTable tblPeliharaan;
    private String currentIdAdopter;
    private int idHewanDipilih;
    
    /**
     * Creates new form Transaction
     */
    public Transaction(String idAdopter, int idHewan, String namaHewan) {
        initComponents();
        
        this.currentIdAdopter = idAdopter;
        this.idHewanDipilih = idHewan;
        aksiNavigasi();
    tampilkanRiwayatTransaksi();
    tampilkanPeliharaanSaya();
        if (namaHewan.equals("")) {
            txtNamaHewan.setText("- Silakan Pilih di Pet List -");
        } else {
            txtNamaHewan.setText(namaHewan);
        }
        
        txtNamaHewan.setEditable(false);
        
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);
        
        txtKembali.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        txtKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new PetList(currentIdAdopter).setVisible(true);
                dispose();
            }
        });
        
        aksiNavigasi();
        tampilkanRiwayatTransaksi();
        
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 920));
        jPanel1.revalidate();
    }

    public void tampilkanRiwayatTransaksi() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] {"ID Transaksi", "Nama Hewan", "Tanggal Pengajuan", "Status Pengajuan"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblTsc.setModel(model);
        tblTsc.setRowHeight(35);

        try {
            java.sql.Connection conn = pawpals.Koneksi.getKoneksi();
            String sql = "SELECT t.id_transaksi, h.nama_hewan, t.tgl_pengajuan, t.status_transaksi " +
                         "FROM transaksi t JOIN hewan h ON t.id_hewan = h.id_hewan " +
                         "WHERE t.id_adopter = ?";
            
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(currentIdAdopter));
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_transaksi"),
                    rs.getString("nama_hewan"),
                    rs.getDate("tgl_pengajuan"),
                    rs.getString("status_transaksi")
                };
                model.addRow(row);
            }
            
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Gagal memuat riwayat transaksi: " + e.getMessage());
        }
    }
    public void tampilkanPeliharaanSaya() {
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] {"ID", "Nama Hewan", "Jenis"}
    );
    // Asumsikan Anda punya tabel bernama tblPeliharaan di form Anda
    // tblPeliharaan.setModel(model); 

    try {
        java.sql.Connection conn = pawpals.Koneksi.getKoneksi();
        String sql = "SELECT h.id_hewan, h.nama_hewan, h.jenis_hewan " +
                     "FROM transaksi t JOIN hewan h ON t.id_hewan = h.id_hewan " +
                     "WHERE t.id_adopter = ? AND t.status_transaksi = 'Disetujui'";
        
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(currentIdAdopter));
        java.sql.ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_hewan"),
                rs.getString("nama_hewan"),
                rs.getString("jenis_hewan")
            });
        }
        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Gagal memuat peliharaan: " + e.getMessage());
    }
}
    
    private void aksiNavigasi() {
        lblDb.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        lblDb.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Dashboard(currentIdAdopter).setVisible(true);
                dispose();
            }
        });

        lblPetList.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        lblPetList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new PetList(currentIdAdopter).setVisible(true);
                dispose();
            }
        });
        
        lblIcon.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        lblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Profile(currentIdAdopter).setVisible(true); 
                dispose();
            }
        });
        
        imgLog.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        imgLog.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            new Dashboard(currentIdAdopter).setVisible(true);
            dispose();
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblDb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPetList = new javax.swing.JLabel();
        lblTsc = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNamaHewan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        btnAjukan = new javax.swing.JButton();
        txtKembali = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTsc = new javax.swing.JTable();
        imgLog = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 810));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setPreferredSize(new java.awt.Dimension(1280, 810));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 810));

        lblDb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDb.setForeground(new java.awt.Color(0, 0, 255));
        lblDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pawpals/image/j.png"))); // NOI18N
        lblDb.setText("Dashboard");

        jLabel4.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        jLabel4.setText("PawPals");

        lblPetList.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPetList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pawpals/image/3.png"))); // NOI18N
        lblPetList.setText("Pet list ");

        lblTsc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pawpals/image/i.png"))); // NOI18N
        lblTsc.setText("Transaction");

        lblIcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pawpals/image/5.png"))); // NOI18N
        lblIcon.setText("Profile");

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FORM ADOPSI ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FORM ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(1055, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Alasan Mengadopsi");

        txtNamaHewan.setEditable(false);
        txtNamaHewan.addActionListener(this::txtNamaHewanActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Nama Hewan Dipilih");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        btnAjukan.setText("Ajukan");
        btnAjukan.addActionListener(this::btnAjukanActionPerformed);

        txtKembali.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtKembali.setText("Kembali");

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Riwayat Pengajuan");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FORM ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(1009, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTsc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Nama Hewan", "Tanggal Pengajuan", "Status Pengajuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTsc);

        imgLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pawpals/image/log.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lblDb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(lblPetList, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblTsc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(txtNamaHewan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnAjukan)
                .addGap(978, 978, 978)
                .addComponent(txtKembali))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLog)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTsc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDb)
                            .addComponent(lblPetList)
                            .addComponent(lblIcon))))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaHewan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAjukan)
                    .addComponent(txtKembali))
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgLog)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel1);

        getContentPane().add(jScrollPane3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaHewanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaHewanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaHewanActionPerformed

    private void btnAjukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjukanActionPerformed
        // TODO add your handling code here:
        String catatan = txtNote.getText().trim();
        
        if (catatan.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Mohon isi alasan mengadopsi terlebih dahulu!");
            return;
        }

        try {
            java.sql.Connection conn = pawpals.Koneksi.getKoneksi();
            String sql = "INSERT INTO transaksi (id_adopter, id_hewan, tgl_pengajuan, catatan, status_transaksi) VALUES (?, ?, CURDATE(), ?, 'Menunggu Verifikasi')";
            
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(currentIdAdopter));
            ps.setInt(2, idHewanDipilih); 
            ps.setString(3, catatan);
            
            int rows = ps.executeUpdate();
            if (rows > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pengajuan adopsi berhasil dikirim! Mohon tunggu verifikasi admin.");
                txtNote.setText(""); 
                tampilkanRiwayatTransaksi(); 
            }
            
            ps.close();
            conn.close();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal mengirim pengajuan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAjukanActionPerformed

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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Transaction("", 0, "").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjukan;
    private javax.swing.JLabel imgLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDb;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblPetList;
    private javax.swing.JLabel lblTsc;
    private javax.swing.JTable tblTsc;
    private javax.swing.JLabel txtKembali;
    private javax.swing.JTextField txtNamaHewan;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables
}
