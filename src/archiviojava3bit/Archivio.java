package archiviojava3bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contiene gli oggetti del programma. Implementata tramite un ArrayList. Ci
 * permette di inserire gli oggetti, effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 *
 * @author INSERISCI_NOME
 */
public class Archivio {

    private ArrayList<Sneaker> archivio;

    public Archivio() {
        archivio = leggiDaFile();
    }

    public void inserisci(Sneaker sneaker) {
        archivio.add(sneaker);
    }

    public ArrayList<Sneaker> elencoSneakers() {
        return archivio;
    }

    public Sneaker cercaSneaker(String codice) {
        for (int i = 0; i < archivio.size(); i++) {
            Sneaker sneaker = archivio.get(i);
            if (sneaker.getCodice() == codice) {
                return sneaker;
            }
        }
        return null;
    }

    public boolean elimina(String codice) {
        Sneaker sneaker;
        sneaker = cercaSneaker(codice);
        if (sneaker != null) {
            archivio.remove(sneaker);
            return true;
        }
        return false;
    }

    public ArrayList<Sneaker> cercaSneaker(float prezzoMinimo, float prezzoMassimo) {
        ArrayList<Sneaker> sneakerTrovate;
        sneakerTrovate = new ArrayList(0);
        for (int i = 0; i < archivio.size(); i++) {
            Sneaker sneaker = archivio.get(i);
            if (sneaker.getPrezzo() >= prezzoMinimo && sneaker.getPrezzo() <= prezzoMassimo) {
                sneakerTrovate.add(sneaker);
            }
        }
        return sneakerTrovate;
    }

     public ArrayList<Sneaker> cercaSneakerPerMarca(String marca) {
    ArrayList<Sneaker> sneakersTrovate = new ArrayList(0);
    String marcaDaCercareMinuscolo = marca.toLowerCase();
    for (int i = 0; i < archivio.size(); i++) {
      String marcaMinuscolo = archivio.get(i).getMarca().toLowerCase();
      if (marcaMinuscolo.contains(marcaDaCercareMinuscolo)) {
        sneakersTrovate.add(archivio.get(i));
      }
    }
    return sneakersTrovate;
  }
     
    public String toString() {
        String s = "";
        for (int i = 0; i < archivio.size(); i++) {
            Sneaker sneaker = archivio.get(i);
            s += sneaker.toString();
            if (i < archivio.size() - 1) {
                s += "\r\n";
            }
        }
        return s;
    }

    private ArrayList<Sneaker> leggiDaFile() {
        ArrayList<Sneaker> sneakers;
        sneakers = new ArrayList(0);
        try {
            FileReader filereader;
            filereader = new FileReader("archivio.txt");
            BufferedReader in;
            in = new BufferedReader(filereader);
            String linea;
            while ((linea = in.readLine()) != null) {
                String campi[];
                campi = linea.split(",");
                float taglia = Float.parseFloat(campi[1]);
                float prezzo = Float.parseFloat(campi[5]);
                int quantita = Integer.parseInt(campi[6]);
                Sneaker sneaker = new Sneaker(campi[0], taglia, campi[2], campi[3], campi[4], prezzo, quantita);
                sneakers.add(sneaker);
            }
            return sneakers;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sneakers;
    }

    public void salvaSuFile() {
        FileWriter out;
        try {
            out = new FileWriter("archivio.txt");
            String stringaArchivio;
            stringaArchivio = toString();
            out.write(stringaArchivio);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean aggiungi(Sneaker sneaker) {
        if (Archivio.this.cercaSneaker(sneaker.getCodice()) != null) {
            return false;
        }
        archivio.add(sneaker);
        salvaSuFile();
        return true;
    }
    
    
     public boolean modificaSneaker(String codice, float taglia, String marca, String modello, String colore, float prezzo, int quantita) {
    Sneaker sneaker;
    sneaker = Archivio.this.cercaSneaker(codice);
    if (sneaker != null) {
      sneaker.setTaglia(taglia);
      sneaker.setMarca(marca);
      sneaker.setModello(modello);
      sneaker.setColore(colore);
      sneaker.setPrezzo(prezzo);
      sneaker.setQuantita(quantita);
      salvaSuFile();
      return true;
    } else {
      return false;
    }
  }
      public ArrayList<Sneaker> cercaSneakerInBaseAlPrezzo(float prezzoMinimo, float prezzoMassimo) {
    ArrayList<Sneaker> sneakersTrovate = new ArrayList(0);

    for (int i = 0; i < archivio.size(); i++) {
      if (archivio.get(i).getPrezzo() >= prezzoMinimo && archivio.get(i).getPrezzo() <= prezzoMassimo) {
        sneakersTrovate.add(archivio.get(i));
      }
    }
    return sneakersTrovate;
  }
}
