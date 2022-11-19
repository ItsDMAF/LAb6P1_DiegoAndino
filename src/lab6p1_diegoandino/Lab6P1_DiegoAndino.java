
package lab6p1_diegoandino;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_DiegoAndino {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    
    public static void main(String[] args) {
        int opcion;
        
        do{
        System.out.println("-----------MENU-----------");
        System.out.println("1 <- Turing");
        System.out.println("2 <- Constante de Kaprekar");
        System.out.println("3 <- Salida.");
        System.out.print("Ingrese su opcion: ");
        opcion = leer.nextInt();

            
        switch(opcion){
            
//PARTE-UNO---------------------------------------------------------------------
            case 1:
                System.out.println("TURING...");
                System.out.println("Ingrese tamaño de arreglo: ");
                int tam = leer.nextInt();
                int [] numeros = lecturaRAN(tam);
                Imprimir(numeros);
                System.out.println("Ingrese Intruciones R,L,X: ");
                String Instruccion = leer.next();
                
                System.out.print("Cadena generada:" + Interpretante(Instruccion,numeros) );
                System.out.println("");
                break;
//PARTE-DOS---------------------------------------------------------------------
            case 2:
                System.out.println("CONSTANTE DE KAPREKAR...");
                System.out.println("Ingrese un numero de 4 digitos: ");
                int Entero = leer.nextInt();
                System.out.println((Kaprekar(Entero)));
                //Imprimir(ascendente(Int_ray(Entero)));
                break;
        }//Fin de switch

        }while(opcion != 3);
    }//Fin de main
    public static int[] lecturaRAN(int tam){
        int[] temporal = new int[tam];
        
        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = 1 + aleatorio.nextInt(10);
        }
        return temporal;
    }
    public static void Imprimir(int[]array){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
        }
            System.out.println("");
    }
    public static String Interpretante(String Instruccion, int[]array){
        String  respuesta = "";
        int apunt = 0;
        
        for (int i = 0; i < Instruccion.length(); i++) {
            char individual = Instruccion.charAt(i);
            
            if (individual == 'R') {
                apunt++;
            }
            if(individual == 'L'){
                apunt--;
            }
            if(individual == 'X'){
                if(apunt > Instruccion.length()-1 || apunt <= -1){
                    System.out.println("Error. instcciones invalidas.");
                }
                else{
                respuesta += array[apunt];
                }
            }
            
        }
        return respuesta;
    }
    public static int[] Int_ray (int Entero){
        //No estaba seguro si podia usar valueOf pero lo use, ahi perdon.
    int [] temp = new int[String.valueOf(Entero).length()];
    int i = String.valueOf(Entero).length()-1 ; 

    do {
        temp[i] = Entero % 10;
        Entero = Entero / 10;
        i--;
    } while(Entero>0);

    return temp;
    }
    public static int Ray_int(int [] array){
        int result = 0;
    int comp = 1;
    for(int i = array.length - 1; i >= 0; i--) {
        result += array[i] * comp;
        comp *= 10;
    }
    return result;
    }
    public static int [] descendente (int [] array){
        /*
        Con el for hago que pace varias veces por el arreglo,
        durante cada pasada que hace el arreglo por el for,
        lo que termina hacinedo es encontrando el siguinete
        numero mas grande al lugar donde tenga que ir puesto.
        (Explique esto de la peor manera creo jajaja)
        */
        for (int i = 0; i < array.length; i++) {  
            for ( int j = array.length - 1; j > i; j--) {  
                if (array[j] > array[j - 1]) {  
                    int temp = array[j];  
                    array[j] = array[j - 1];  
                    array[j - 1] = temp;  
                }  
            }  
        } 
    return array;
    }
    public static int [] ascendente (int [] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {                                                              
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    return array;
    }
    public static int Kaprekar(int Entero){
        //Bueno lo intente
        int [] valor1 = (Int_ray(Entero));
        int [] valor2 = (ascendente(valor1));
        int valor3 = (Ray_int(valor2));
        
        int primer = Entero - valor3;
        System.out.println(Entero + " - " + valor3 + " = " + primer);
        
        int cont = 0;
        int segundo;
        do{
        int [] valor5 = (Int_ray(primer));
        int [] valor6 = (descendente(valor5));
        int valor8 = (Ray_int(valor6));
        int [] valor7 = (ascendente(valor5));
        int valor9 = (Ray_int(valor7));

        segundo = valor8 - valor9;
        System.out.println(valor8 + " - " + valor9 + " = " + segundo);
        cont++;
        }while(cont != 7 || segundo == 6174);

        return segundo;
    }
    }//Fin de class
    

