
package es.albertomarquez.listacoches;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coches {
    
    private ArrayList<Coche> listaCoches = new ArrayList();
    
    public ArrayList<Coche> getListaCoches(){
        return listaCoches;
    }
    
    @XmlElement(name = "listaCoches")
    public void setListaCoches(ArrayList<Coche> listaCoches){
        this.listaCoches = listaCoches;
    }
    
    public void fusionarCochess(Coches listaCochesNueva){
        this.getListaCoches().addAll(listaCochesNueva.getListaCoches());
    }

    
}
