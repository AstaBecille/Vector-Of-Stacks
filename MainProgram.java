package com.mycompany.progettojava;

import java.util.*;
import java.io.*;
public class MainProgram {
    
    public static void main(String[] args) {
        
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        Vector <Pila> vettoreDiPile = new Vector <Pila>();
        Scanner scanner = new Scanner(System.in);
        boolean erroreTrovato = false;
        int sceltaVettoreMenu = 0;
        char sceltaPilaMenu = ' ';
        int numeroIndicePila= 0; //variabile per stampare il numero incrementato della Pila

        
        //--
    do{   
        do{
        try{
            erroreTrovato = false;
            System.out.println("\n\n\t---MENU AZIONI CREAZIONE VETTORE DI PILE---\n1) Aggiungi una pila nel vettore;\n" +
            "2) Rimuovi una pila di posizione ... [index] dal vettore;\n" +
            "3) Mostra il numero di pile contenute nel vettore;\n" +
            "4) Stampa il vettore con le relative pile;\n" +
            "5) Ricerca un elemento nelle pile del vettore [RICERCA];\n6) Rimuovi tutti gli elementi dalle pile del vettore [RESET].\"+ \n7) Accedi al menu di una pila tramite posizione;\n8) Pulisci l'intero vettore. \n" +
            "---------------------------------------------------\n0 ) EXIT\nFai la tua scelta:");
            String valore = tastiera.readLine();
            sceltaVettoreMenu = Integer.valueOf(valore);
        }catch(Exception e){
            System.out.println("Inserisci un numero intero!");
            erroreTrovato = true;
        }
        }while(erroreTrovato);
        
        
        switch (sceltaVettoreMenu) {
            case 1: //aggiungera l'elemento nel vettore
                
                Pila stack = new Pila(); //dichiaro la pila come variabile "locale"
                numeroIndicePila += 1;
//--
            do{
                do{
                
                try {
                erroreTrovato = false;
                System.out.println("\n\n\t---MENU AZIONI PILA NUMERO: " + (numeroIndicePila) + "---\n\n ATTENZIONE: La pila inizialmente è vuota.\na) Aggiungi un elemento nella pila [PUSH];" + 
                "\nb) Rimuovi e mostra l'elemento rimosso della pila [POP];\nc) Mostra il valore in cima alla pila SENZA rimuoverlo [PEEK]; " + 
                "\nd) Mostra il numero degli elementi contenuti attualmente nella pila [SIZE];\ne) Stampa la pila nello stato corrente [PRINT];" +   
                "\nf) Ricerca un elemento nella pila [RICERCA];\ng) Rimuovi tutti gli elementi dalla pila [RESET]."+ 
                "\n---------------------------------------------------\nz ) EXIT\nFai la tua scelta:");
                    sceltaPilaMenu = scanner.next().charAt(0);
                } catch (Exception e) {
                    erroreTrovato = true;
                    System.out.println("Opzione non valida");
                }
                }while(erroreTrovato);
                //--
            
                switch (sceltaPilaMenu) {
                    case 'a':
                        
                        int addValue = 0;
                    do{
                        System.out.println("Hai deciso di effettuare un azione di push all'interno della pila");
                        try{
                            System.out.println("Inserisci il numero da pushare: ");
                            erroreTrovato = false;
                            String valore = tastiera.readLine();
                            addValue  = Integer.valueOf(valore);
                        }catch(Exception e){
                            erroreTrovato = true;
                            System.out.println("Inserisci un numero intero!");
                        }
                    }while(erroreTrovato);
                        stack.push(addValue); //inserisco l'elemento all'interno della pila

                        break;
                        
                    case 'b':   
                        System.out.println("Hai deciso di effettuare un azione di pop all'interno della pila");
                        System.out.println("\nElemento : " + stack.pop() + " RIMOSSO\nLa pila è composta attualmente da:  " + stack.totElementi() + " elementi");
                    break;
                    
                    case 'c': 
                        System.out.println("Hai deciso di vedere l'elemento in cima alla pila.");
                        System.out.println("Elemento in cima alla pila: " + stack.top());
                    break;
                    
                    case 'd':
                        System.out.println("Hai deciso di vedere il totale degli elementi attualmente contenuti in questa pila.");
                        System.out.println("La pila è composta attualmente da elementi: " + stack.totElementi());
                    break;
                    
                    case 'e':
                        System.out.println("Hai deciso di stampare la pila: ");
                        stack.stampaPila();
                    break;
                    
                    case 'f':
                        int elemento = 0;
                        
                    do{    
                        try{
                        erroreTrovato = false;    
                        String valore = tastiera.readLine();
                        elemento = Integer.valueOf(valore);
                        }catch(Exception e){
                            erroreTrovato= true;
                            System.out.println("Errore durante l'inserimento dell'elemento da ricercare, riprova");
                        }
                    }while(erroreTrovato);   
                    stack.ricercaElemento(elemento);
                    break;
                    case 'g': 
                        char sceltaReset = ' ';
                        
                        try {
                            System.out.println("Hai scelto di rimuovere definitivamente gli elementi della pila...\n Sicuro di questa scelta? [y/n]");
                            sceltaReset = scanner.next().charAt(0);
                        } catch (Exception e) {
                            System.out.println("Opzione non valida");
                        }
                        
                        if(sceltaReset=='y'){
                        System.out.println("Vettore resettato con successo. 0 elementi all'interno");
                        stack.resetPila();
                        }
                        else
                            System.out.println("Operazione annullata");
                        break;
                    case 'z':
                        break;
                    
                    default:
                        System.out.println("Opzione non valida");
                }
            }while(sceltaPilaMenu!='z');
            
                System.out.println("Pila memorizzata all'interno del vettore di Pile!\n");
                vettoreDiPile.addElement(stack);
                break;
                
            case 2:
                int indexScelto = 0;
            do{
                try{
                    erroreTrovato = false;
                    System.out.println("Inserisci il numero della pila da rimuovere dal vettore: ");
                    String valore = tastiera.readLine();
                    indexScelto = Integer.valueOf(valore);
                    
                }catch(Exception e){
                    erroreTrovato= true;
                    System.out.println("Errore durante l'inserimento dell'indice, inserisci un numero intero!");
                }
                System.out.println("Hai scelto di rimuovere la pila numero: " + indexScelto);
                
                if(!vettoreDiPile.isEmpty()){
                    erroreTrovato = false;
                    vettoreDiPile.removeElementAt(indexScelto-1);}
                else
                    System.out.println("Operazione fallita! Impossibile rimuovere la pila");
                
                
            }while(erroreTrovato);
            
                break;
            
            case 3: 
                
                System.out.println("Le pile contenute dentro il vettore sono: " +vettoreDiPile.size());
                
                break;
                
            case 4:
                
                if(!vettoreDiPile.isEmpty())
                    for(int i=0;i<vettoreDiPile.size();i++)
                    {
                        Pila pilaTemporanea = vettoreDiPile.get(i);
                        pilaTemporanea.stampaPila(i+1);
                    }
                else
                    System.out.println("Vettore vuoto");
                break;
                
            case 5: 
                   int elemento = 0;
                        System.out.println("Hai scelto di ricercare un elemento tra le pile del vettore, digita l'elemento che vuoi ricercare: ");
                    do{    
                        try{
                        erroreTrovato = false;
                        String valore = tastiera.readLine();
                        elemento = Integer.valueOf(valore);
                        
                        }catch(Exception e){
                            erroreTrovato= true;
                            System.out.println("Errore durante l'inserimento dell'elemento da ricercare, riprova");
                        }
                    }while(erroreTrovato);    
                for(int i=0;i<vettoreDiPile.size();i++)
                    {
                        Pila pilaTemporanea = vettoreDiPile.get(i);
                        pilaTemporanea.ricercaElemento(elemento,i+1);
                    }
            break;
            
            case 6:
                char sceltaReset = ' ';
                try {
                    System.out.println("Hai scelto di svuotare tutte le pile contenute all'interno del vettore...\n Sicuro di questa scelta? [y/n]");
                    sceltaReset = scanner.next().charAt(0);
                } catch (Exception e) {
                    System.out.println("Opzione non valida");
                }
                
                if(sceltaReset == 'y')
                for(int i=0;i<vettoreDiPile.size();i++)
                    {
                        Pila pilaTemporanea = vettoreDiPile.get(i);
                        pilaTemporanea.resetPila(i+1);
                    }
                else 
                    System.out.println("Operazione annullata.");
                
                break;
            case 7: 
                
                int ritornaAlMenuNumero = 0;
                
            do{    
                try {
                    erroreTrovato=false;
                    System.out.println("A quale menu di n°pila vuoi accedere? --> ");
                    String valore = tastiera.readLine();
                    ritornaAlMenuNumero = Integer.valueOf(valore);
                } catch (Exception e) {
                    erroreTrovato =true;
                    System.out.println("Impossibile acquisire il valore");
                }
            }while(erroreTrovato); 
            Pila pilaSceltaTemporanea;
            
            try{
                pilaSceltaTemporanea = vettoreDiPile.get(ritornaAlMenuNumero-1);
            }catch(Exception e) 
            {System.out.println("Errore, assicurati che la posizione inserita sia attualmente residente nel vettore."); continue;}
               
            do{
                
                try {
                    System.out.println("\n\n\t---MENU MODIFICA PILA NUMERO " + ritornaAlMenuNumero + "---\n\na) Aggiungi un elemento nella pila [PUSH];" + 
                "\nb) Rimuovi e mostra l'elemento rimosso della pila [POP];\nc) Mostra il valore in cima alla pila SENZA rimuoverlo [PEEK]; " + 
                "\nd) Mostra il numero degli elementi contenuti attualmente nella pila [SIZE];\ne) Stampa la pila nello stato corrente [PRINT];" +   
                "\nf) Ricerca un elemento nella pila [RICERCA];\ng) Rimuovi tutti gli elementi dalla pila [RESET]."+ 
                "\n---------------------------------------------------\nz ) EXIT\nFai la tua scelta:");
                    sceltaPilaMenu = scanner.next().charAt(0);
                } catch (Exception e) {
                    System.out.println("Opzione non valida");
                }
                //--
            
                switch (sceltaPilaMenu) {
                    case 'a':
                        
                        int addValue = 0;
                    do{
                        System.out.println("Hai deciso di effettuare un azione di push all'interno della pila");
                        try{
                            System.out.println("Inserisci il numero da pushare: ");
                            erroreTrovato = false;
                            String valore = tastiera.readLine();
                            addValue  = Integer.valueOf(valore);
                        }catch(Exception e){
                            erroreTrovato = true;
                            System.out.println("Inserisci un numero intero!");
                        }
                    }while(erroreTrovato);
                        pilaSceltaTemporanea.push(addValue); //inserisco l'elemento all'interno della pila

                        break;
                        
                    case 'b':   
                        System.out.println("Hai deciso di effettuare un azione di pop all'interno della pila");
                        System.out.println("\nElemento : " + pilaSceltaTemporanea.pop() + " RIMOSSO\nLa pila è composta attualmente da:  " + pilaSceltaTemporanea.totElementi() + " elementi");
                    break;
                    
                    case 'c': 
                        System.out.println("Hai deciso di vedere l'elemento in cima alla pila.");
                        System.out.println("Elemento in cima alla pila: " + pilaSceltaTemporanea.top());
                    break;
                    
                    case 'd':
                        System.out.println("Hai deciso di vedere il totale degli elementi attualmente contenuti in questa pila.");
                        System.out.println("La pila è composta attualmente da elementi: " + pilaSceltaTemporanea.totElementi());
                    break;
                    
                    case 'e':
                        System.out.println("Hai deciso di stampare la pila: ");
                        pilaSceltaTemporanea.stampaPila();
                    break;
                    
                    case 'z':
                        break;
                    
                    default:
                        System.out.println("Opzione non valida");
                }
            }while(sceltaPilaMenu!='z');
            
                
                break;
                
            case 8: 
                sceltaReset = ' ';
                try {
                    System.out.println("Hai scelto di rimuovere definitivamente tutte le pile contenute all'interno del vettore...\n Sicuro di questa scelta? [y/n]");
                    sceltaReset = scanner.next().charAt(0);
                } catch (Exception e) {
                    System.out.println("Opzione non valida");
                }
                if(sceltaReset=='y'){
                System.out.println("Vettore resettato con successo. 0 elementi all'interno");
                vettoreDiPile.removeAllElements();
                }
                else
                    System.out.println("Operazione annullata");
                break;
            default:
                System.out.println("Opzione non valida");
                break;
        }
        
    }while(sceltaVettoreMenu != 0); //fine menu principale     
}
}

