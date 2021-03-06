/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_pbo;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class History extends javax.swing.JFrame {

    /**
     * Creates new form History
     */
    
    main x=new main();
    
    private String nama;
    private String id_pengguna;
    private int id_mutasi;
    
    public History(int idm,String idp, String nm) {
        nama=nm;
        id_pengguna=idp;
        id_mutasi=idm;
        initComponents();
    }
    
    private void load_table(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah");
        model.addColumn("Jenis");
        model.addColumn("Keterangan");
        
        int no=1;
        
        try{
            String sql = "select * from mutasi";
            java.sql.Connection conn=(Connection)tubes_pbo.main.koneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                
                if(id_pengguna.equals(res.getString("IDPengguna"))){
                     model.addRow(new Object[]{no++ +". ",res.getString(3),res.getString(4),res.getString(2),res.getString(5),res.getString(1)});
                }
                
               
            }
            jTable1.setModel(model);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    private void kosong(){
//        jumlah.setText(null);
//        jFormattedTextField1.setText(null);
//        jComboBox1.setSelectedItem(null);
//        jenis.setText(null);
    }
    
//    private void cariIdMutasi(){
//        try{
//            Connection konek=tubes_pbo.main.koneksi();
//            Statement statement=konek.createStatement();
//            String sql="select * from mutasi";
//            ResultSet rs=statement.executeQuery(sql);
//            
//            while(rs.next()){
//                id_mutasi=Integer.parseInt(rs.getString("IDMutasi"));
//            }
//            return id_mutasi;
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//        System.out.println(id_mutasi);
//        return 1;
//    }
//    
//    private String cariIdPengguna(int id){
//        try{
//            Connection konek=tubes_pbo.main.koneksi();
//            Statement statement=konek.createStatement();
//            String sql="select * from mutasi";
//            ResultSet rs=statement.executeQuery(sql);
//            
//            while(rs.next()){
//                if(String.valueOf(id).equals(rs.getString("IDMutasi"))){                   
//                    System.out.println(rs.getString("IDPengguna"));
//                    id_pengguna=rs.getString("IDPengguna");
//                    return rs.getString("IDPengguna");
//                }
//            }
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//        
//        return "";
//    }
//    
//    private String cariNama(String id){
//        try{
//            Connection konek=tubes_pbo.main.koneksi();
//            Statement statement=konek.createStatement();
//            String sql="select mutasi.IDPengguna,pengguna.nama from mutasi,pengguna";
//            ResultSet rs=statement.executeQuery(sql);
//            
//            while(rs.next()){
//                if(id.equals(rs.getString("IDPengguna"))){                   
//                    System.out.println(rs.getString("nama"));
//                    return rs.getString("nama");
//                }
//            }
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//        
//        return "";
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jml_lbl = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        tgl_lbl = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        ket_lbl = new javax.swing.JLabel();
        keterangan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kelompok 8");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("HISTORY");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        edit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edit.setText("Edit");
        edit.setEnabled(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hapus.setText("Delete");
        hapus.setEnabled(false);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        kembali.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kembali.setText("Back");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jml_lbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jml_lbl.setText("Jumlah pemasukan   :");

        jumlah.setEnabled(false);
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });

        tgl_lbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tgl_lbl.setText("Jumlah pengeluaran  :");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFormattedTextField1.setEnabled(false);

        ket_lbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ket_lbl.setText("Balance                   :");

        keterangan.setEnabled(false);
        keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keteranganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tgl_lbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jml_lbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ket_lbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jml_lbl)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl_lbl)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ket_lbl)
                    .addComponent(keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        int baris = jTable1.rowAtPoint(evt.getPoint());
//        String id = jTable1.getValueAt(baris, 0).toString();
//        String jmlh = jTable1.getValueAt(baris, 1).toString();
//        jumlah.setText(jmlh);
//        String tgl = jTable1.getValueAt(baris, 2).toString();
//        jFormattedTextField1.setText(tgl);
//        String ket = jTable1.getValueAt(baris, 3).toString();
//        jComboBox1.setSelectedItem(ket);
//        String jns = jTable1.getValueAt(baris, 4).toString();
//        jenis.setText(jns);
        hapus.setEnabled(true);
        edit.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        new Edit(id_mutasi,id_pengguna,nama).setVisible(true);
        setVisible(false);
//            try{
//                String sql ="UPDATE mutasi SET IDMutasi = '"+keterangan.getText()+"' , Jumlah = '"+jumlah.getText()+"' , Tgl = '"+jFormattedTextField1.getText()+"' , Keterangan = '"+jComboBox1.getSelectedItem()+"' , Jenis = '"+jenis.getText()+"'";
//                java.sql.Connection conn=(Connection)tubes_pbo.main.koneksi();
//                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
//                pst.execute();
//                JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "Perubahaan Data Gagal"+e.getMessage());
//            }
//        
//        
//        load_table();
//        kosong();
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int baris=jTable1.getSelectedRow();
        if(baris<0){
            String id=String.valueOf(jTable1.getModel().getValueAt(baris, 5));
            try{
                String sql = "delete from mutasi where IDMutasi = '"+id+"'";
                java.sql.Connection conn=(Connection)tubes_pbo.main.koneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Data Berhasil di Hapus");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            load_table();
            kosong();
        }
        else{
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel yang ingin dihapus");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        new Home(id_mutasi,id_pengguna,nama).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_kembaliActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keteranganActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new History().setVisible(true);
//            }
//        });
//        
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jml_lbl;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel ket_lbl;
    private javax.swing.JTextField keterangan;
    private javax.swing.JLabel tgl_lbl;
    // End of variables declaration//GEN-END:variables
}
