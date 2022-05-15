package zadania.programowanie.muras;

public class Kolowe extends Pojazd {

  private final String rodzajOpon;

  public Kolowe(String rodzajOpon) {
    this.rodzajOpon = rodzajOpon;
  }

  public Kolowe(int rokProdukcji, String rodzajSilnika, String kolor, double masa,
      String rodzajOpon) {
    super(rokProdukcji, rodzajSilnika, kolor, masa);
    this.rodzajOpon = rodzajOpon;
  }
}
