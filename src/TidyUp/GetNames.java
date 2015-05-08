/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TidyUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Nelson Portilla
 */
public class GetNames {

    public GetNames() {

    }

    public Vector <String> leerArchivo(String ruta) {
        ruta="C:/Users/USUARIO/Music/zzzzzznombres.txt";        
        Vector <String> canciones = new Vector<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(ruta),"Cp850");
            //fr = new FileReader(archivo);
            br = new BufferedReader(isr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                canciones.add(linea);   
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        
        return canciones;
    }

}
