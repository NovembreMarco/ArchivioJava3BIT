package archiviojava3bit;

/**
 * Classe utilizzata per l'oggetto da contenere nella collezione. Contiene le
 * varibili di istanza, il metodo costruttore, i setter/getter e eventuali altri
 * metodi
 *
 * @author INSERISCI_NOME
 */
public class Sneaker {

    private String codice;
    private float taglia;
    private String marca;
    private String modello;
    private String colore;
    private float prezzo;
    private int quantita;

    public Sneaker(String codice, float taglia, String marca, String modello, String colore, float prezzo, int quantita) {
        this.codice = codice;
        this.taglia = taglia;
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.prezzo = prezzo;
        this.quantita = quantita;

    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public float getTaglia() {
        return taglia;
    }

    public void setTaglia(float taglia) {
        this.taglia = taglia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        String s;
        s = "codice";
        s += ",";
        s += Float.toString(taglia);
        s += ",";
        s += marca;
        s += ",";
        s += modello;
        s += ",";
        s += colore;
        s += ",";
        s += Float.toString(prezzo);
        s += ",";
        s += Integer.toString(quantita);

        return s;
    }

}
