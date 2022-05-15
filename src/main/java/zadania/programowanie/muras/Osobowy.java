package zadania.programowanie.muras;

public class Osobowy extends Kolowe {

  private int ilosOsob;

  public Osobowy(int rokProdukcji, String rodzajSilnika, String kolor, double masa,
      String rodzajOpon, int ilosOsob) {
    super(rokProdukcji, rodzajSilnika, kolor, masa, rodzajOpon);
    this.ilosOsob = ilosOsob;
  }

}
