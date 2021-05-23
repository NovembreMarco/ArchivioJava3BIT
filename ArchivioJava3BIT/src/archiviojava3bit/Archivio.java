package archiviojava3bit;

import java.io.FileReader;
import java.util.ArrayList;

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

    public ArrayList<Sneaker> elencoSnaker() {
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
    
    public ArrayList<Sneaker> ceraSneakerPerMarca(String marca){
        ArrayList<Sneaker> sneakerTrovate=new ArrayList(0);
        String marcaDaCercareMinuscolo=marca.toLowerCase();
        for(int i=0; i<archivio.size();i++){
            Sneaker sneaker=archivio.get(i);
            String marcaMinuscola=sneaker.getMarca().toLowerCase();
            if(marcaMinuscola.contains(marcaDaCercareMinuscolo)){
                
            }
        }
    }
    
    public String toString(){
        String s="";
        for(int i=0; i<archivio.size();i++){
            Sneaker sneaker=archivio.get(i);
            s += sneaker.toString();
            if(i<archivio.size()-1){
                s+="\r\n";
            }
        }
        return s;
    }
    
    private ArrayList<Sneaker> leggiDaFile(){
        
        ArrayList<Sneaker> sneakers;
        sneakers=new ArrayList(0);
        
        FileReader filereader;
        filereader=new Filereader("archivio.txt");
        BufferedReader in;
        in=new BufferedReader(filereader);
        String linea;
        while((linea=in.readLine())!=null){
            String campi[];
            campi=linea.split(",");
            float taglia=Float.parseFloat(campi[1]);
            float prezzo=Float.parseFloat(campi[5]);
            int quantita=Integer.parseInt(campi[6]);
            Sneaker sneaker= new Sneaker(campi[0],taglia,campi[2],campi[3],campi[4],prezzo,quantita);
            sneakers.add(articolo);
            
            
            
        }
        return sneakers;
    }
}
