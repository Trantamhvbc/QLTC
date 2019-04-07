package lopthucthe;

import java.util.*;

public class HoSoGiaoDichTheChap {
    private int ID;
    private ArrayList <TaiSan> arrtaisan;
    private KhachHang KH;
    private Date ngaybatdau;
    private Date ngayhethan;
    private int tienconno;
    private int tiendagiaingan;
    private String thuctrang;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
    private float laisuat;
    private ArrayList <LaiSuatTheoThang> arrlaisuat;

    public HoSoGiaoDichTheChap() {
    }

    public HoSoGiaoDichTheChap(ArrayList<TaiSan> arrtaisan, KhachHang KH, Date ngaybatdau, Date ngayhethan, int tienconno, int tiendagiaingan, String thuctrang) {
        this.arrtaisan = arrtaisan;
        this.KH = KH;
        this.ngaybatdau = ngaybatdau;
        this.ngayhethan = ngayhethan;
        this.tienconno = tienconno;
        this.tiendagiaingan = tiendagiaingan;
        this.thuctrang = thuctrang;
        arrlaisuat = null;
    }

    public void setArrtaisan(ArrayList<TaiSan> arrtaisan) {
        this.arrtaisan = arrtaisan;
    }

    public void setKH(KhachHang KH) {
        this.KH = KH;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public void setArrlaisuat(ArrayList<LaiSuatTheoThang> arrlaisuat) {
        this.arrlaisuat = arrlaisuat;
    }

    public float getLaisuat() {
        return laisuat;
    }

    public void setLaisuat(float laisuat) {
        this.laisuat = laisuat;
    }

    public ArrayList<TaiSan> getArrtaisan() {
        return arrtaisan;
    }

    public KhachHang getKH() {
        return KH;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public int getTienconno() {
        return tienconno;
    }

    public int getTiendagiaingan() {
        return tiendagiaingan;
    }

    public String getThuctrang() {
        return thuctrang;
    }

    public ArrayList<LaiSuatTheoThang> getArrlaisuat() {
        return arrlaisuat;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public void setTienconno(int tienconno) {
        this.tienconno = tienconno;
    }

    public void setTiendagiaingan(int tiendagiaingan) {
        this.tiendagiaingan = tiendagiaingan + tiendagiaingan;
    }

    public void setThuctrang(String thuctrang) {
        this.thuctrang = thuctrang;
    }
    
    public void addLaiSuatTheoThang(LaiSuatTheoThang O){
        arrlaisuat.add(O);
    }
    
    
}
