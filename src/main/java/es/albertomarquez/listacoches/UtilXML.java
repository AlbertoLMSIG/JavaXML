package es.albertomarquez.listacoches;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class UtilXML {
    
    public static void guardarDatosXML(Stage stage, Coches listaCoches){
        JAXBContext contexto;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Guardar XML en");
                File fileListaCoches = fileChooser.showSaveDialog(stage);
                contexto = JAXBContext.newInstance(Coches.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                marshaller.marshal(listaCoches, System.out);
                marshaller.marshal(listaCoches, fileListaCoches);
            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
            }
    }
    public static Coches importarDatosXML(Stage stage){
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Importar XML");
                File fileListaCoches = fileChooser.showOpenDialog(stage);
                JAXBContext contexto = JAXBContext.newInstance(Coches.class);
                Unmarshaller unmarshaller = contexto.createUnmarshaller(); 
                Coches coches = new Coches();
                coches = (Coches)unmarshaller.unmarshal(fileListaCoches);        
                return coches;
                
            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
                return null;
            }
        
    }
}

    
        
