package lopthucthe;

public class TaiSan {
    private int id;
    private int giatritansan;
    private String tentaisan;
    private String loaitaisan;
    private String mucdichsudung;
    private String dacta;
    private KhachHang KH;

    public TaiSan(int id, int giatritansan, String tentaisan, String loaitaisan, String mucdichsudung, String dacta, KhachHang KH) {
        this.id = id;
        this.giatritansan = giatritansan;
        this.tentaisan = tentaisan;
        this.loaitaisan = loaitaisan;
        this.mucdichsudung = mucdichsudung;
        this.dacta = dacta;
        this.KH = KH;
    }


    public int getId() {
        return id;
    }

    public int getGiatritansan() {
        return giatritansan;
    }



    public String getTentaisan() {
        return tentaisan;
    }

    public void setTentaisan(String tentaisan) {
        this.tentaisan = tentaisan;
    }

    public String getLoaitaisan() {
        return loaitaisan;
    }

    public void setLoaitaisan(String loaitaisan) {
        this.loaitaisan = loaitaisan;
    }

    public String getMucdichsudung() {
        return mucdichsudung;
    }

    public void setMucdichsudung(String mucdichsudung) {
        this.mucdichsudung = mucdichsudung;
    }

    public String getDacta() {
        return dacta;
    }

    public void setDacta(String dacta) {
        this.dacta = dacta;
    }

    public KhachHang getKH() {
        return KH;
    }

    public void setKH(KhachHang KH) {
        this.KH = KH;
    }
    
}
