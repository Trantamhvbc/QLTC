package lopthucthe;

public class KhachHang {
    private int id;
    private String scmnd;
    private String name;
    private String sdt;
    private String diachi;
    public KhachHang(int id, String scmnd, String name, String sdt, String diachi) {
        this.id = id;
        this.scmnd = scmnd;
        this.name = name;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScmnd(String scmnd) {
        this.scmnd = scmnd;
    }

    public KhachHang() {
    }

    public String getScmnd() {
        return scmnd;
    }

   

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
