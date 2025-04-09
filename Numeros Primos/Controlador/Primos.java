package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;

public class Primos {

    public Boolean isPrimo(Integer n){
        if (n <= 1) return false;
        for (int i = 2; i < n; i++){
            if(n%i ==0) return false;
        }
        return true;
    }

    public Integer contarLines(){
        Integer cantidad =0;
        String direccion ="C:\\Users\\dougl\\OneDrive\\Documents\\Dougdree\\JavaProyects\\Unidad 1\\Numeros Primos\\data.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(direccion));
            String txt = "";
            while ((txt = br.readLine()) != null){
                cantidad++;
            }
        } catch (Exception e) {
            System.out.println("no se encontro el archivo, error :" + e.getMessage());
        }
        return cantidad;
    }

    public void  numArreglo(){
        
        Long timeInicio = System.nanoTime();

        String direccion ="C:\\Users\\dougl\\OneDrive\\Documents\\Dougdree\\JavaProyects\\Unidad 1\\Numeros Primos\\data.txt";
        Integer arreglo[] = new Integer[contarLines()];
        Integer i =0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(direccion));
            String txt = "";
            while ((txt = br.readLine()) != null){
                if (!txt.trim().isEmpty()){
                    arreglo[i] = Integer.parseInt(txt.trim());
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("no se encontro el archivo, error :" + e.getMessage());
        }

        Integer cantidadPrim = 0;

        for(Integer p : arreglo){
            if (p!= null && isPrimo(p)){
                cantidadPrim++;
            }
        }

        Integer primos[] = new Integer[cantidadPrim];
        Integer j =0;
        for(Integer prim : arreglo){
            if (prim != null && isPrimo(prim)){
                primos[j] = prim;
                j++;
            }
        }

        Long timeFinal = System.nanoTime();


        presentar(primos);
        System.out.println("La cantidad de primos son:" + cantidadPrim);
        Long timeTotal = timeFinal - timeInicio;
        System.out.println("el tiempo de ejecucion es:" + timeTotal + " nanosegundos");
    }

    public void presentar(Integer[] n){
        System.out.println("Arreglo de primos");
        System.out.print("[");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
            if (i < n.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}