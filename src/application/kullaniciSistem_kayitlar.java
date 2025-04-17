package application;

public class kullaniciSistem_kayitlar {
    private int kullanici_sistem_id;
    private String kullanici_mail;
    private String kullanici_anakart;
    private String kullanici_islemci;
    private String kullanici_ekrankarti;
    private String kullanici_ram;
    private String kullanici_kasa;
    private String kullanici_monitor;

    // Constructor
    public kullaniciSistem_kayitlar(int kullanici_sistem_id, String kullanici_mail, String kullanici_anakart, String kullanici_islemci, 
                                    String kullanici_ekrankarti, String kullanici_ram, String kullanici_kasa, String kullanici_monitor) {
        this.kullanici_sistem_id = kullanici_sistem_id;
        this.kullanici_mail = kullanici_mail;
        this.kullanici_anakart = kullanici_anakart;
        this.kullanici_islemci = kullanici_islemci;
        this.kullanici_ekrankarti = kullanici_ekrankarti;
        this.kullanici_ram = kullanici_ram;
        this.kullanici_kasa = kullanici_kasa;
        this.kullanici_monitor = kullanici_monitor;
    }

    public kullaniciSistem_kayitlar(int kullanici_sistem_id, String kullanici_anakart, String kullanici_ekrankarti, String kullanici_islemci, 
                                    String kullanici_kasa, String kullanici_ram) {
        this.kullanici_sistem_id = kullanici_sistem_id;
        this.kullanici_anakart = kullanici_anakart;
        this.kullanici_ekrankarti = kullanici_ekrankarti;
        this.kullanici_islemci = kullanici_islemci;
        this.kullanici_kasa = kullanici_kasa;
        this.kullanici_ram = kullanici_ram;
    }

    // Getter and Setter methods
    public int getKullanici_sistem_id() {
        return kullanici_sistem_id;
    }

    public void setKullanici_sistem_id(int kullanici_sistem_id) {
        this.kullanici_sistem_id = kullanici_sistem_id;
    }

    public String getKullanici_mail() {
        return kullanici_mail;
    }

    public void setKullanici_mail(String kullanici_mail) {
        this.kullanici_mail = kullanici_mail;
    }

    public String getKullanici_anakart() {
        return kullanici_anakart;
    }

    public void setKullanici_anakart(String kullanici_anakart) {
        this.kullanici_anakart = kullanici_anakart;
    }

    public String getKullanici_islemci() {
        return kullanici_islemci;
    }

    public void setKullanici_islemci(String kullanici_islemci) {
        this.kullanici_islemci = kullanici_islemci;
    }

    public String getKullanici_ekrankarti() {
        return kullanici_ekrankarti;
    }

    public void setKullanici_ekrankarti(String kullanici_ekrankarti) {
        this.kullanici_ekrankarti = kullanici_ekrankarti;
    }

    public String getKullanici_ram() {
        return kullanici_ram;
    }

    public void setKullanici_ram(String kullanici_ram) {
        this.kullanici_ram = kullanici_ram;
    }

    public String getKullanici_kasa() {
        return kullanici_kasa;
    }

    public void setKullanici_kasa(String kullanici_kasa) {
        this.kullanici_kasa = kullanici_kasa;
    }

    public String getKullanici_monitor() {
        return kullanici_monitor;
    }

    public void setKullanici_monitor(String kullanici_monitor) {
        this.kullanici_monitor = kullanici_monitor;
    }
}
