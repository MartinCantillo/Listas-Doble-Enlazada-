
package taller_25_sept_martin_cantillo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author martin cantillo
 */
public class Taller_25_sept_Martin_Cantillo {

    /**
     * @param args the command line arguments
     */
       Scanner entrada = new Scanner(System.in);

    public class nodo {

        int dato;
        nodo sig;
        nodo ant;

    }
    nodo cab,p;

    public  Taller_25_sept_Martin_Cantillo() {
        this.cab = null;
        this.p = null;
        
    }

    public boolean listavacia() {
        if (cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public nodo insertar_inicio(int info) {
        nodo n = new nodo();
        n.dato = info;
        n.sig = null;
        n.ant = null;
        if (listavacia()) {
            cab = n;
            cab.ant = null;
        } else {
            n.sig = cab;
            cab.ant = n;
            cab = n;
        }
        return cab;
    }

    public nodo insertar_final(int info) {
        nodo n = new nodo();
        n.dato = info;
        n.sig = null;
        n.ant = null;
        if (listavacia()) {
            cab = n;
            cab.ant = null;
        } else {
            nodo q;
            q = cab;
            while (q.sig != null) {
                q = q.sig;
            }
            q.sig = n;
            n.ant = q;

        }
        return n;
    }

  
    public void Intercambiar_Antes() {
        int dato;
        if (listavacia()) {
            System.out.print("la lista esta vacia ");  //lista vacia 
        } else {
            int opc;
            System.out.println("ingrese el dato a encontrar ");
            dato = entrada.nextInt();
            p = cab;

            while (p != null && p.dato != dato) {
                p = p.sig;
            }
            if (p != null) {
                System.out.println("****************");
                System.out.println("Dato encontrado ");

                if (p == cab && cab.sig != null) { // el dato encontrado es cab 
                    System.out.println("******************");
                    System.out.println("No Hay Nodo anterior");
                } else {
                    if (p.sig != null && (p.ant != cab && p.sig.sig == null)) { // hay mas de dos nodos pero el anterior de p no es cab  ,esta bien 
                        p.ant.ant.sig = p;
                        p.sig.ant = p.ant;
                        p.ant.sig = p.sig;
                        p.sig = p.ant;
                        p.ant = p.sig.ant;
                        p.sig.ant = p;

                    } else if (cab.sig == null) {
                        System.out.println("************************");
                        System.out.println("Solo hay un solo nodo en la Lista ");
                    } else if (cab.sig.sig == null) { // hay dos nodos  esta bien 
                        p.ant.sig = p.sig;
                        p.ant.ant = p;
                        p.sig = p.ant;
                        p.ant = null;
                        cab = p;
                    } else if (p.sig != null && p.ant == cab) { //  p esta despues de cab  
                        p.ant.sig = p.sig;
                        p.ant.ant = p;
                        p.sig.ant = p.ant;
                        p.sig = p.ant;
                        p.ant = null;
                        cab = p;

                    } 
                     else { // el dato encontrado esta en el ultimo nodo
                        p.ant.sig = p.sig;
                        p.sig = p.ant;
                        p.sig.ant.sig = p;
                        p.ant = p.sig.ant;
                        p.sig.ant = p;
                    }
                }
            } else {
                System.out.println("*******************************");
                System.out.println("El dato No se encuentra en la lista");
            }
        }
    }

    public void Intercambiar_Despues() {
        int dato;
        if (listavacia()) {
            System.out.print("la lista esta vacia ");
        } else {
            int opc;
            System.out.println("ingrese el dato a encontrar ");
            dato = entrada.nextInt();
            p = cab;
            while (p != null && p.dato != dato) {
                p = p.sig;
            }
            if (p != null) {
                System.out.println("****************");
                System.out.println("Dato encontrado ");

            if (p != null && p.sig != null) {
                if (p.sig.sig != null) {
                    p.sig.sig.ant = p;
                }

                if (p.ant != null) {
                    p.ant.sig = p.sig;
                } else {
                    cab = p.sig;
                }
                p.sig.ant = p.ant;
                p.ant = p.sig;
                p.sig = p.sig.sig;
                p.ant.sig = p;
                p.ant.sig = p;
            }
            else{
                if(p.sig ==null){
                    System.out.println("No hay Nodo despues "); // si hay un solo dato ademas y el dato es cab o esta en la ultima posicion 
                }
            }
        }
            else{
                System.out.println("*******************************");
                System.out.println("El dato No se encuentra en la lista");
            }
    }
    }
    public void mostrarlista() {
        if (listavacia()) {
            System.out.print("la lista esta vacia ");
        } else {
            nodo r = cab;

            while (r.sig != null) {
                System.out.print("->");
                System.out.print(r.dato + " -> ");
                r = r.sig;
            }
            System.out.println(r.dato + "->");

        }
    }

    
    
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("LISTAS ENLAZADAS ");
        System.out.println("---MARTIN CANTILLO ---");
        Taller_25_sept_Martin_Cantillo listas = new Taller_25_sept_Martin_Cantillo();
        int opc, num, dato;
        do {
            System.out.println("************");
            System.out.println("\nMENÚ "
                    + "\n------LISTAS   DOBLES ----------"
                    + "\n******************************"
                    + "\n CODIGO OPTIMIZADO Y PRESENTADO POR MARTIN CANTILLO ");
            System.out.println("1. Insertar elemento al inicio ");
            System.out.println("2. Insertar elemento al final ");
            System.out.println("3. Muestre la lista");
            System.out.println("4. Buscar Nodo e Intercambiar con el nodo anterior . Utilizando una Referencia");
            System.out.println("5. Buscar Nodo e Intercambiar con el nodo despues . Utilizando una Referencia");
            System.out.println("10. Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    num = rnd.nextInt(100);
                    listas.insertar_inicio(num);
                    break;
                case 2:
                    num = rnd.nextInt(100);
                    listas.insertar_final(num);
                    break;
                case 3:
                    listas.mostrarlista();
                    break;
                case 4:
                    listas.Intercambiar_Antes();
                    break;
                case 5:
                   listas.Intercambiar_Despues();
                    break;
            }
        } while (opc != 10);
    }

    }
    

