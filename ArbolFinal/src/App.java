import java.util.Scanner;
import logica.Larbol;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean Bandera=false, Bandera2=false;
        int Valor,ValorRecorrer, cont=0;;
        char dato;
// "ABCDEFGHIJKLMNOPQRSTWXYZ" "ZYXWTSRQPONMLKJIHGFEDCBA" "GBHADCFEMJNILK"
        System.out.println("Arboles ");
        String Arbol;
        Arbol = "GBHADCFEMJNILK";
        Larbol h = new Larbol(Arbol);

        do{
            System.out.println("""
            -----------------------------------------------------------------------
                    Ingrese el numero de alguna de las siguientes opciones:

                1.  Recorrer Arbol
                2.  Mostrar Arbol
                3.  Contar Hojas
                4.  Contar Padres
                5.  Insertar Dato
                6.  Mostrar hermanos del Dato ingresado
                7.  Mostrar nivel del Dato ingresado
                8.  Mostrar altura del Dato Ingresado
                9. Mostrar Primos Hermanos del Dato Ingresado
                10. Mostrar Ancestros
                0. Salir
            -------------------------------------------------------------------
            """);
            Valor= sc.nextInt();

            switch (Valor) {

                case 1:
                    System.out.println("""
                        Ingrese en cual de las siguientes opciones desea recorrer el Arbol:

                        1.  Recorrer Inorden
                        2.  Recorrer Posorden
                        3.  Recorrer Preorden
                            
                            """);
                        ValorRecorrer= sc.nextInt();
                        if (ValorRecorrer == 1) {
                            System.out.println("""
                            -------------------------
                            Los datos en Inorden son:
                            """);
                            h.RecorrerInorden(h.getPunta());
                            System.out.println("\n-------------------------");
                        }
                        else if(ValorRecorrer == 2){
                            System.out.println("""
                            -------------------------
                            Los datos en Inorden son:
                            """);
                            h.RecorrerPosorden(h.getPunta());
                            System.out.println("\n-------------------------");
                        }
                        else if(ValorRecorrer == 3){
                            System.out.println("""
                            -------------------------
                            Los datos en Inorden son:
                            """);
                            h.RecorrerPreorden(h.getPunta());
                            System.out.println("\n-------------------------");
                        }else{
                            System.out.println("!!!OPCION NO VALIDA!!!");
                        }
                        System.out.println("\n");
                    break;

                case 2:
                        System.out.println("""
                            Con árboles de mucha altura se podría ver roto, 
                            pero en realidad si está funcionando bien, es solo 
                            que el árbol es demasiado ancho y la consola no lo 
                            puede mostrar correctamente
                                """);
                        h.MostratArbol();
                    break;
            

                case 3:
                    cont=0;
                        cont = h.ContarHojas(h.getPunta(), cont);
                        System.out.println(cont);
                    break;

                case 4:
                    cont=0;
                        cont = h.ContarPadres(h.getPunta(), cont);
                        System.out.println(cont);
                    break;

                case 5:
                        System.out.println("Ingrese el dato a insertar: ");
                        dato = sc.next().charAt(0);
                        h.Insertar(dato, h.getPunta());
                    break;

                case 6:
                        System.out.println("Ingrese el dato para buscar hermanos: ");
                        dato = sc.next().charAt(0);
                        h.MostrarHermanoDerecho(h.getPunta(), dato, Bandera2);
                        h.MostrarHermanoIzquierdo(h.getPunta(), dato, Bandera2);
                    break;

                case 7:
                    cont=1;
                        System.out.println("Ingrese el dato: ");
                        dato = sc.next().charAt(0);
                        h.NivelDato(h.getPunta(), dato, cont);
                    break;
                
                case 8:
                        System.out.println("Ingrese el dato: ");
                        dato = sc.next().charAt(0);
                        h.Altura(dato);
                    break;

                case 9:
                        System.out.println("Ingrese el dato: ");
                        dato = sc.next().charAt(0);
                        cont = h.CalcularPrimos(h.getPunta(), dato, cont);
                        System.out.println("\n");
                    break;
                
                case 10:
                    System.out.println("Ingrese el dato: ");
                        dato = sc.next().charAt(0);
                        h.Ancestros(h.getPunta(), dato);
                        System.out.println("\n");
                    break;
                
                case 0:
                    System.out.println("Saliendo del menu....");
                        Bandera=true;
                    break;
                

                default:
                System.out.println("!!!OPCION NO VALIDA!!!");
                    break;
            }
            
        }while (!Bandera);
    }
}
