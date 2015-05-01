/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeorder;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author USUARIO
 */
public class MakeOrder {

    /**
     * @param args the command line arguments
     */
    public void ProcesoCopiar(){
        
    }

    public static void main(String[] args) {

        /**
        String audioFileLoc = "C:\\Users\\USUARIO\\Music\\JBalvin - Ay Vamos.mp3";
        
        try {

            Path Origen = Paths.get(audioFileLoc);
            //Creamos directorio especificado
           
            String DestinoTemp = "C:\\Users\\USUARIO\\Downloads\\J Balvin - Ay Vamos.mp3";
            Path Destino = Paths.get(DestinoTemp);
                        //sobreescribir el fichero de destino, si existe, y copiar
            // los atributos, incluyendo los permisos rwx
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            //Se copia desde origen a destino con las condiciones especificadas en options
            Files.copy(Origen, Destino, options);

           
            InputStream input = new FileInputStream(new File(audioFileLoc));
            ContentHandler handler = (ContentHandler) new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, (org.xml.sax.ContentHandler) handler, metadata, parseCtx);
            input.close();

// List all metadata
            String[] metadataNames = metadata.names();

            for (String name : metadataNames) {
                System.out.println(name + ": " + metadata.get(name));
            }

// Retrieve the necessary info from metadata
// Names - title, xmpDM:artist etc. - mentioned below may differ based
// on the standard used for processing and storing standardized and/or
// proprietary information relating to the contents of a file.
            System.out.println("Title: " + metadata.get("title"));
            System.out.println("Artists: " + metadata.get("xmpDM:artist"));
            System.out.println("Genre: " + metadata.get("xmpDM:genre"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
    }**/
       
    
                }
}
