package lopthucthe;


public class NguoiSuDung {
    private int id;
    private String user;
    private String pass;
    private String vaitro;

    public NguoiSuDung() {
    }

    public NguoiSuDung(int id, String user, String pass, String vaitro) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.vaitro = vaitro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getVaitro() {
        return vaitro;
    }


    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
