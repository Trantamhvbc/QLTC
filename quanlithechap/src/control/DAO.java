/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Dell
 */
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lopthucthe.HoSoGiaoDichTheChap;
import lopthucthe.KhachHang;
import lopthucthe.NguoiSuDung;
import lopthucthe.TaiSan;
public class DAO {
    private  Connection conn;
    public DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=quanlithechap;"
                    + "username=sa;password=123");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("");
        }   
  
    }
    public boolean addnguoisudung(NguoiSuDung s){
        String sql = "INSERT INTO tblnguoisudung(username,pass,vaitro)"+"VALUES (?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getUser());
            ps.setString(2, s.getPass());
            ps.setString(3, s.getVaitro());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean addtaisan(TaiSan TS,int idhs, int idnsd,int idkh){
        String sql = "insert into tbltaisan (tentaisan,giatritaisan,loaitaisan,mucdich,dacta,tblkhachhangID,tblnguoisudungID,tblhosothechapID) \n" +
            "values(?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, TS.getTentaisan());
            ps.setString(2, TS.getGiatritansan()+"");
            ps.setString(3, TS.getLoaitaisan());
            ps.setString(4, TS.getMucdichsudung());
            ps.setString(5, TS.getDacta());
            ps.setString(6,idkh+"" );
            ps.setString(7, idnsd+"");
            ps.setString(8, idhs+"");
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean addhosothechap(HoSoGiaoDichTheChap S,int idngs,String ngaybatdau, String ngayhethan){
        String sql1 = "select max(ID) from tblhosothechap;";
        String sql = "insert into tblhosothechap (sd,ed,tienconno,tiendagiaingan,thuctrang,laisuat,tblkhachhangID,tblnguoisudungID) \n" +
"values(?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, ngaybatdau);
            ps.setString(2, ngayhethan);
            ps.setInt(3, S.getTienconno());
            ps.setInt(4, S.getTiendagiaingan());
            ps.setString(5,S.getThuctrang());
            ps.setFloat(6, S.getLaisuat());
            ps.setInt(7, S.getKH().getId());
            ps.setInt(8, idngs);
            ps.executeUpdate();
        }catch(Exception e){
             e.printStackTrace();
        }
            
        
        int i = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i = rs.getInt(1);
                System.out.println(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       boolean oki = false;
        for(TaiSan J : S.getArrtaisan()){
            addtaisan(J, i, idngs, S.getKH().getId());
            oki = true;
            
        }
        
        return false;
 }
       
    
    public boolean addkhachhang(KhachHang s){
        String sql = "INSERT INTO tblkhachhang (cancuoc,ten,sdt,diachi)"+"VALUES (?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getScmnd());
            ps.setString(2, s.getName());
            ps.setString(3, s.getSdt());
            ps.setString(4, s.getDiachi());
            return ps.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public  ArrayList <NguoiSuDung> getlistnguoisudung(){
        ArrayList <NguoiSuDung> Arr = new ArrayList();
        String sql = "SELECT * FROM tblnguoisudung";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                NguoiSuDung nsd = new NguoiSuDung();
                nsd.setId(rs.getInt("ID"));
                nsd.setUser(rs.getString("username"));
                nsd.setPass(rs.getString("pass"));
                nsd.setVaitro(rs.getString("vaitro"));
                Arr.add(nsd);
                System.out.println(nsd);
            }
            
        }catch(Exception e){
            
        }
        return Arr;
    }
public KhachHang findKH(int k){
    String sKH = "SELECT * FROM tblkhachhang where ID = ? AND ID IS NOT NULL;";
    KhachHang KH = new KhachHang();
    try{
        PreparedStatement pskh = conn.prepareStatement(sKH);
        pskh.setString(1, "" + k);
        //System.out.println(k);
        ResultSet rskh = pskh.executeQuery();
        while(rskh.next()){
            KH.setId(rskh.getInt("ID"));
            KH.setScmnd(rskh.getString("cancuoc"));
            KH.setName(rskh.getString("ten"));
            KH.setSdt(rskh.getString("sdt"));
            KH.setDiachi(rskh.getString("diachi"));
            return KH;
        }
       
    } catch(Exception e){ 
    }
   return KH ;
}

public ArrayList <TaiSan> getListTaiSan(int k){
    String sKH = "SELECT * FROM tbltaisan where tblhosothechapID = ? ;";
    ArrayList <TaiSan> Arr = new ArrayList();
    try{
        PreparedStatement ps = conn.prepareStatement(sKH);
        ps.setString(1, "" + k);
        //System.out.println(k);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            TaiSan TS = new TaiSan();
            TS.setId(rs.getInt("ID"));
            TS.setTentaisan(rs.getString("tentaisan"));
            TS.setGiatritansan(rs.getInt("giatritaisan"));
            TS.setLoaitaisan(rs.getString("loaitaisan"));
            TS.setMucdichsudung(rs.getString("mucdich"));
            TS.setDacta(rs.getString("dacta"));
            Arr.add(TS);
        }
        //hs.setKH(KH);
        //arr.add(hs);
        //System.out.println(hs.getNgaybatdau() + " "+ hs.getKH().getName());
    } catch(Exception e){ 
       // System.out.println(e);
       // System.out.println(456789);
    }
    
   return Arr ;
   
}
public ArrayList <KhachHang> findKH(String cancuoc){
    String sKH = "SELECT * FROM tblkhachhang where cancuoc = ?;";
    ArrayList <KhachHang> Arr = new ArrayList();
    try{
        PreparedStatement pskh = conn.prepareStatement(sKH);
        pskh.setString(1, cancuoc);
        //System.out.println(k);
        ResultSet rskh = pskh.executeQuery();
        while(rskh.next()){
            KhachHang KH = new KhachHang();
            KH.setId(rskh.getInt("ID"));
            KH.setScmnd(rskh.getString("cancuoc"));
            KH.setName(rskh.getString("ten"));
            KH.setSdt(rskh.getString("sdt"));
            KH.setDiachi(rskh.getString("diachi"));
            Arr.add(KH);
        }
        //hs.setKH(KH);
        //arr.add(hs);
        //System.out.println(hs.getNgaybatdau() + " "+ hs.getKH().getName());
    } catch(Exception e){ 
       // System.out.println(e);
        System.out.println(456789);
    }
   return Arr ;
}

    /**
     *
     * @param id
     * @param sd
     * @param ed
     * @return
     */
    public ArrayList<HoSoGiaoDichTheChap> getHSGDTC(){
        
        ArrayList <HoSoGiaoDichTheChap> arr = new ArrayList();
       String sql = "SELECT * FROM tblhosothechap where ID is not null";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                HoSoGiaoDichTheChap hs = new HoSoGiaoDichTheChap();
                hs.setID(rs.getInt("ID"));
                hs.setNgaybatdau(rs.getDate("sd"));
                hs.setNgayhethan(rs.getDate("ed"));
                hs.setTienconno(rs.getInt("tienconno"));
                hs.setTiendagiaingan(rs.getInt("tiendagiaingan"));
                hs.setThuctrang(rs.getString("thuctrang"));
                hs.setLaisuat(rs.getFloat("laisuat"));
                int k = rs.getInt("tblkhachhangID");
                int h = rs.getInt("tblnguoisudungID");
                KhachHang KH = findKH(k);
                hs.setKH(KH);
                arr.add(hs);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return arr;
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public static void main(String[] args) {
       DAO A = new DAO();
    }
    
    
}
