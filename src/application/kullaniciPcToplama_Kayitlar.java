package application;

public class kullaniciPcToplama_Kayitlar {
    private int sistemId;
    private String anakart;
    private String ekranK;
    private String islemci;
    private String kasa;
    private String ram;
    private String isim;

    public kullaniciPcToplama_Kayitlar(int sistemId, String anakart, String ekranK, String islemci, String kasa, String ram) {
        this.sistemId = sistemId;
        this.anakart = anakart;
        this.ekranK = ekranK;
        this.islemci = islemci;
        this.kasa = kasa;
        this.ram = ram;
    }

    public kullaniciPcToplama_Kayitlar(String isim) {
        this.isim = isim;
    }

    public int getSistemId() {
        return sistemId;
    }

    public void setSistemId(int sistemId) {
        this.sistemId = sistemId;
    }

    public String getAnakart() {
        return anakart;
    }

    public void setAnakart(String anakart) {
        this.anakart = anakart;
    }

    public String getEkranK() {
        return ekranK;
    }

    public void setEkranK(String ekranK) {
        this.ekranK = ekranK;
    }

    public String getIslemci() {
        return islemci;
    }

    public void setIslemci(String islemci) {
        this.islemci = islemci;
    }

    public String getKasa() {
        return kasa;
    }

    public void setKasa(String kasa) {
        this.kasa = kasa;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public String toString() {
        return isim;  // ComboBox'ta bu objenin nasıl görüneceğini belirler.
    }
}
