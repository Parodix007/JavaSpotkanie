package zadania.programowanie.muras;

public class Pojazd {

  private int rokProdukcji;
  private String rodzajSilnika;
  private String kolor;
  private double masa;

  public Pojazd(int rokProdukcji, String rodzajSilnika, String kolor, double masa) {
    this.rokProdukcji = rokProdukcji;
    this.rodzajSilnika = rodzajSilnika;
    this.kolor = kolor;
    this.masa = masa;
  }

  public Pojazd() {
  }
}
