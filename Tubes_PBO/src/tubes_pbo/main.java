/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubes_pbo;

/**
 *
 * @author Rizami
 */
import java.sql.*;
public class main {
    private static final String JDBC_Driver="com.mysql.jdbc.Driver";
    private static final String db_url="jdbc:mysql://localhost/tubes";
    private static final String user="root";
    private static final String pass="";
    
    private static Connection koneksi;
    private Statement statement;
    private PreparedStatement perintah;
    private ResultSet rs;
    
    private String nama;
    private String id_pengguna;
    private int id_mutasi;
    private int jumlahPemasukan;
    private int jumlahPengeluaran;
    private int balance;
    
    private String []NamaPengguna;
    private int []Pemasukan=new int[50];
    private int []Pengeluaran=new int[50];
    
    public static Connection koneksi(){
        try{
            Class.forName(JDBC_Driver);
            
            koneksi=DriverManager.getConnection(db_url,user,pass);          
            
        }catch(Exception e){
            System.out.println("Koneksi Tidak Berhasil");
        }
        return koneksi;
    }
    
    public void isiPengguna(){
        try{
            Connection konek=koneksi();
            statement=konek.createStatement();
            String sql="select IDPengguna from pengguna";
            rs=statement.executeQuery(sql);
            
            int i=0;
            while(rs.next()){
                NamaPengguna[i]=rs.getString("IDPengguna");
                i++;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public int cariIdMutasi(){
        try{
            Connection konek=koneksi();
            statement=konek.createStatement();
            String sql="select * from mutasi";
            rs=statement.executeQuery(sql);
            
            while(rs.next()){
                id_mutasi=Integer.parseInt(rs.getString("IDMutasi"));
            }
            return id_mutasi;
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(id_mutasi);
        return 1;
    }
    
    public String cariIdPengguna(int id){
        try{
            Connection konek=koneksi();
            statement=konek.createStatement();
            String sql="select * from mutasi";
            rs=statement.executeQuery(sql);
            
            while(rs.next()){
                if(String.valueOf(id).equals(rs.getString("IDMutasi"))){                   
                    System.out.println(rs.getString("IDPengguna"));
                    id_pengguna=rs.getString("IDPengguna");
                    return rs.getString("IDPengguna");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return "";
    }
    
    public String cariNama(String id){
        try{
            Connection konek=koneksi();
            statement=konek.createStatement();
            String sql="select mutasi.IDPengguna,pengguna.nama from mutasi,pengguna";
            rs=statement.executeQuery(sql);
            
            while(rs.next()){
                if(id.equals(rs.getString("IDPengguna"))){                   
                    System.out.println(rs.getString("nama"));
                    return rs.getString("nama");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return "";
    }
    
    public void ambilSignup(String uname, String pass, String nama, String no){
        try{
            String sql="INSERT INTO pengguna (IDPengguna,pass,nama,noHp) VALUES ('"+uname+"','"+pass+"','"+nama+"','"+no+"')";
            Connection konek=koneksi();
            perintah=konek.prepareStatement(sql);
            perintah.execute(sql);
            
            koneksi.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public int cekLogin(String username, String password){
        int cek=0;
        try{
            String sql="select IDPengguna,pass,nama from pengguna";
        
            Connection konek=koneksi();
            statement=konek.createStatement();
            rs=statement.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getString("IDPengguna").equals(username) && rs.getString("pass").equals(password)){
                    id_pengguna=rs.getString("IDPengguna");
                    System.out.println(id_pengguna);
                    this.nama=rs.getString("nama");
                    System.out.println(nama);
                    cek=1;
                    break;
                }
                else if( !(rs.getString("IDPengguna").equals(username)) || !(rs.getString("pass").equals(password)) ){
                    cek=5;
                }
                else{
                    cek=4;
//                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return cek;
    }
    
    public void tampilHome(){
        cariIdMutasi();
        cariIdPengguna(id_mutasi);
        isiMutasi();
        hitung();
//        nama=cariNama(id_pengguna);
        
        Home x=new Home(id_mutasi,id_pengguna,nama);
        x.setKeterangan(nama, balance, jumlahPemasukan, jumlahPengeluaran);
        x.setVisible(true);
    }
    
     public void tampilHome2(int a,String b, String c){
        cariIdPengguna(cariIdMutasi());
        isiMutasi();
        hitung();
//        nama=cariNama(id_pengguna);
        
        Home x=new Home(a,b,c,1);
        x.setKeterangan(nama, balance, jumlahPemasukan, jumlahPengeluaran);
        x.setVisible(true);
    }
    
    public void hitung(){
        for(int j=0;j<Pemasukan.length;j++){
            jumlahPemasukan+=Pemasukan[j];
        }
        for(int i=0;i<Pengeluaran.length;i++){
            jumlahPengeluaran+=Pengeluaran[i];
        }
        
        balance=jumlahPemasukan-jumlahPengeluaran;
    }
    
    public void isiMutasi(){
        try{
            Connection konek=koneksi();
            statement=konek.createStatement();
            String sql="select * from mutasi";
            rs=statement.executeQuery(sql);
            
            int i=0;
            int j=0;
            while(rs.next()){
                if(rs.getString("IDPengguna").equals(id_pengguna)){
                    if(rs.getString("jenis").equals("pemasukan")){
                        Pemasukan[i]=rs.getInt("jumlah");
                        i++;
                    }else if(rs.getString("jenis").equals("pengeluaran")){
                        Pengeluaran[j]=rs.getInt("jumlah");
                        j++;
                    }
                }     
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
//    public int []pemasukan(){
//        int masuk[] = new int[20];
//        try{
//            Connection konek=koneksi();
//            statement=konek.createStatement();
//            String sql="select * from mutasi";
//            rs=statement.executeQuery(sql);
//            
//            int i=0;
//            int j=0;
//            while(rs.next()){
//                if(rs.getString("IDPengguna").equals(id_pengguna)){
//                    if(rs.getString("jenis").equals("pemasukan")){
//                        masuk[i]=rs.getInt("jumlah");
//                        i++;
//                    }
//                }     
//                
//            }
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//        return masuk[];
//    }
    
    public void tambahMutasi(String tgl, String jml, String jns, String ket,int id){
//        cariIdMutasi();
//        id_pengguna=cariIdPengguna(id_mutasi);
        try{
//            int id=id_mutasi+1;
            String sql="INSERT INTO mutasi (IDMutasi,jenis,tanggal,jumlah,keterangan,IDPengguna) VALUES ('"+ id +"','"+jns+"','"+tgl+"','"+jml+"','"+ket+"','"+id_pengguna+"')";
            Connection konek=koneksi();
            perintah=konek.prepareStatement(sql);
            perintah.execute(sql);
            
            koneksi.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
//        main x=new main();
//        x.isiPengguna();
//        x.cariIdMutasi();
        
        halaman1 awal=new halaman1();
        awal.setVisible(true);
    }
}
