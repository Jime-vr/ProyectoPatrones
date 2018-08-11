package bd;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amanda
 */
public class FileReader {
    //Declaración e inicialización de las variables de entrada y salida de datos.

    static BufferedReader   in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream      out = System.out;

    //Método principal de la aplicación. Muestra el menú con las diferentes opciones.
    public static void main(String args []) throws  java.io.IOException
    {
        int opcion = -1; //variable que almacena la opción que selecciona el usuario del menú.
        do {

                out.println("1.Imprimir todos los caracteres");
                out.println("2.Imprimir lineas");
                out.println("3.Guardar");
                out.println("4.Actuatlizar");
                out.println("5. Salir");
                out.println("Digite la opcion");
                opcion = Integer.parseInt(in.readLine());
                procesarOpcion(opcion);

        }while(opcion !=5);
    }


    public static void procesarOpcion(int pOpcion) throws java.io.IOException
    {
        switch (pOpcion)
        {
            case 1:
                //En esta opción se maneja un ejemplo de un try and catch no procesado en las 
                //fuciones llamadas.
                //En caso de que se produzca un error se muestra un mensaje al usuario.
                try{
                    imprimirCaracteres();
                }
                catch(IOException e)
                {
                    out.println("No se encontró el archivo");
                }

                break;
            case 2:
                imprimirLineas();
                break;
            case 3:
                guardar();
                break;
            case 4:
                actualizar();
                break;

            case 5://el usuario selecciona la opción de salir.
                out.println( "Fin !!");
                break;
            default: // el usuario ingresa un valor que no está dentro de las opciones del menú
                out.println("Opcion inválida");
                break;

        }
    }

    public static void imprimirCaracteres() throws IOException
    {
        try
        {
            java.io.FileReader reader = new java.io.FileReader("Archivos.txt");
            int caracter;

            while((caracter = reader.read()) != -1)//se hace un ciclo para leer los caracteres.
            {
                System.out.println((char)caracter);
            }
            reader.close(); //se cierra el reader.
        }
        catch (IOException e)
        {
           throw e;

        }
    }

    public static void imprimirLineas()
    {
        try
        {
            java.io.FileReader reader = new java.io.FileReader("Archivo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo 
             //es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            while((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, 
            // que se almacenan en la variable datos.
            {
                System.out.println(datos);
            }
            reader.close();//se cierra el reader.
        }
        catch(IOException e)
        {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
    }

    public static void guardar()
    {
        try {
            FileOutputStream stream = new FileOutputStream("Archivo.txt");
            OutputStreamWriter output = new OutputStreamWriter(stream, "UTF-8");
            //se crea la variable usando en encoding UTF-8, para español.
            BufferedWriter buffer = new BufferedWriter(output);

            buffer.write("Pablo Mármol");//se escribe el nombre
            buffer.newLine();//se pasa a la siguiente línea.
            buffer.write("Pedro Picapiedra");//se escribe el otro nombre.

            buffer.close();//se cierra el Buffered.
        } catch (IOException e) {
            e.printStackTrace();//se imprimie la pila de llamdas.
        }
    }

    public static void actualizar()
    {
        try {
            FileWriter writer = new FileWriter("Archivo.txt", true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write("\nVilma Picapiedra");
            buffer.newLine();
            buffer.write("Betty Mármol");

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
