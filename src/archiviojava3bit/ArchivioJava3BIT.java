package archiviojava3bit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Si occupa dell'interfaccia utente con un menu.
 * Qui si può usare println
 * @author Marco
 */
public class ArchivioJava3BIT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Archivio archivio;
    archivio = new Archivio();

    // Menu
    // System.in è la tasiera
    Scanner tastiera;
    tastiera = new Scanner(System.in);

    int scelta = 0;

    do {
      System.out.println("--- Gestione Foot loker ---");
      System.out.println("1) Visualizza elenco sneakers");
      System.out.println("2) Inserisci sneaker");
      System.out.println("3) Elimina sneaker");
      System.out.println("4) Cerca sneaker in base al prezzo");
      System.out.println("5) Cerca sneaker in base alla marca");
      System.out.println("6) Modifica sneaker");
      System.out.println("7) Esci");
      System.out.print("Scegli l'operazione (1-7): ");

      // Aspetto la scelta dell'utente
      scelta = Integer.parseInt(tastiera.nextLine()); //bloccante

      switch (scelta) {
        case 1:
          ArrayList<Sneaker> elencoSneakers;
          elencoSneakers = archivio.elencoSneakers();
          visualizzaElencoSneakers(elencoSneakers);
          break;

        case 2:
          System.out.print("Inserisci il codice: ");
          String codice = tastiera.nextLine();
          System.out.print("Inserisci la taglia: ");
          float taglia = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci la marca: ");
          String marca = tastiera.nextLine();
          System.out.print("Inserisci il modello: ");
          String modello = tastiera.nextLine();
          System.out.print("Inserisci il colore: ");
          String colore = tastiera.nextLine();
          System.out.print("Inserisci il prezzo: ");
          float prezzo = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci la quantita: ");
          int quantita = Integer.parseInt(tastiera.nextLine());
          Sneaker sneaker = new Sneaker(codice, taglia, marca, modello, colore, prezzo, quantita);

          // 3. Aggiungo larticolo nel archivio
          if (archivio.aggiungi(sneaker)) {
            System.out.println("Sneaker inserito correttamente");
          } else {
            System.out.println("Esiste gia una sneaker con lo stesso codice !");
          }
          break;

        case 3:        
          System.out.print("Inserisci il codice: ");
          codice = tastiera.nextLine();         
          if (archivio.elimina(codice)) {
            System.out.println("Articolo eliminato correttamente.");
          } else {
            System.out.println("Eliminazione non riuscita.");
          }
          break;

        case 4:
          System.out.print("Inserisci il prezzo minimo: ");
          float prezzoMinimo = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci il prezzo massimo: ");
          float prezzoMassimo = Float.parseFloat(tastiera.nextLine());
          elencoSneakers = archivio.cercaSneaker(prezzoMinimo, prezzoMassimo);
          visualizzaElencoSneakers(elencoSneakers);
          break;

        case 5:
          System.out.print("Inserisci la marca: ");
          marca = tastiera.nextLine();
          elencoSneakers = archivio.cercaSneakerPerMarca(marca);
          visualizzaElencoSneakers(elencoSneakers);
          break;
        case 6:
          System.out.print("Inserisci il codice: ");
          codice = tastiera.nextLine();
          System.out.print("Inserisci la taglia: ");
          taglia = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci la marca: ");
          marca = tastiera.nextLine();
          System.out.print("Inserisci il modello: ");
          modello = tastiera.nextLine();
          System.out.print("Inserisci il colore: ");
          colore = tastiera.nextLine();
          System.out.print("Inserisci il prezzo: ");
          prezzo = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci la quantità: ");
          quantita = Integer.parseInt(tastiera.nextLine());

          if (archivio.modificaSneaker(codice, taglia, marca, modello, colore, prezzo, quantita)) {
            System.out.println("Modifica sneaker avvenuta correttamente.");
          } else {
            System.out.println("Non è stato possibile modificare la sneaker.");
          }
          break;
      }

    } while (scelta != 7);
    }
    
    private static void visualizzaElencoSneakers(ArrayList<Sneaker> elencoSneakers) {
    System.out.println("N°\tCodice\t\tTaglia\t\tMarca\t\tModello\t\t\t\tColore\t\t\tPrezzo\t\t\tQuantità");
    for (int i = 0; i < elencoSneakers.size(); i++) {
      System.out.print(i + 1);
      System.out.print("\t" + elencoSneakers.get(i).getCodice());
      System.out.print("\t\t" + elencoSneakers.get(i).getTaglia());
      System.out.print("\t\t" + elencoSneakers.get(i).getMarca());
      System.out.print("\t\t" + elencoSneakers.get(i).getModello());
      System.out.print("\t\t\t\t" + elencoSneakers.get(i).getColore());
      System.out.print("\t\t\t" + elencoSneakers.get(i).getPrezzo());
      System.out.println("\t\t\t" + elencoSneakers.get(i).getQuantita());
    }

    System.out.println("\n");

  }
}
