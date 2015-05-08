/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TidyUp;
import java.awt.List;
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
 * @author Nelson Portilla
 */
public class TidyUp {
    
    //Counters for each Genre
    private int countSalsa,countVallenato,countReggaeton,countTechno,
                countDescargas, countReggae, countRomantico, countPopular,
                countMerengue;
   
    public TidyUp(){
        //Inicialization
        countSalsa=countVallenato=countReggaeton=countTechno=
        countDescargas=countReggae=countRomantico=countPopular=
        countMerengue=0;
    }
    
    /**
     * @brief Process of Copy of a mp3 File to the path specified
     * @param mp3:String with the name of the mp3 file
     * @param ruta: String with the folder path for the copy
     * @throws IOException 
     */
    private void copyProcess(String mp3, String ruta) throws IOException{                        
        try {
            String audioFileLoc = "C:\\Users\\USUARIO\\Music\\"+mp3;
            Path Origen = Paths.get(audioFileLoc);
            //Creamos directorio para la copia           
            String DestinoTemp = ruta+mp3;
            Path Destino = Paths.get(DestinoTemp);
            //sobreescribir el fichero de destino, si existe, y copiar
            // los atributos, incluyendo los permisos rwx
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            //Se copia desde origen a destino con las condiciones especificadas en options
            Files.copy(Origen, Destino, options);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @brief Procces of clasify for Genre Tag of the mp3 File
     * @param mp3name: String with the name of the Mp3 file
     */
    public void clasifyProcess(String mp3name) {
        String genero = "";
        //Creation of the source mp3 path
        String audioFileLoc = "C:\\Users\\USUARIO\\Music\\"+mp3name;
        try {
            InputStream input = new FileInputStream(new File(audioFileLoc));
            ContentHandler handler = (ContentHandler) new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, (org.xml.sax.ContentHandler) handler, metadata, parseCtx);
            input.close();
            // List all metadata
            String[] metadataNames = metadata.names();
            System.out.println("Mp3: "+mp3name);
            genero = metadata.get("xmpDM:genre");
            System.out.println("Genre: " + genero);
            //Acording to Genre, call to copyProcess with the mp3-path and the destiny path
            switch(genero){
                case "Salsa": copyProcess(mp3name, "D:\\MUSICA\\SALSA\\"); countSalsa++;break;
                case "Reggaeton": copyProcess(mp3name, "D:\\MUSICA\\REGGAETON\\"); countReggaeton++; break;
                case "Techno": copyProcess(mp3name, "D:\\MUSICA\\[- Techno -]\\"); countTechno++; break;
                case "Vallenatos": copyProcess(mp3name, "D:\\MUSICA\\VALLENATOS\\"); countVallenato++; break;
                case "Descargas": copyProcess(mp3name, "D:\\MUSICA\\DESCARGAS\\"); countDescargas++;break;
                case "Romantico": copyProcess(mp3name, "D:\\MUSICA\\ROMANTICO\\VARIOS\\"); countRomantico++; break;
                case "Popular": copyProcess(mp3name, "D:\\MUSICA\\POPULAR\\"); countPopular++; break;
                case "Reggae": copyProcess(mp3name, "D:\\MUSICA\\REGGAE\\"); countReggae++; break;
                case "Merengue": copyProcess(mp3name, "D:\\MUSICA\\Merengue\\"); countMerengue++; break;
                default: System.out.println("Null"); break;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @brief Method that return a message specified the counters
     * @return A String with each genre and your respective counters 
     */
    public String getCounters(){
        String test =   "\nSalsa: "+countSalsa+
                        "\nVallenato: "+countVallenato+
                        "\nReggaeton: "+countReggaeton+
                        "\nTechno: "+countTechno+
                        "\nDecargas: "+countDescargas+
                        "\nRomantico: "+countRomantico+
                        "\nPopular: "+countPopular+
                        "\nReggae: "+countReggae+
                        "\nMerengue: "+countMerengue;
        return test;
    }
    
}
