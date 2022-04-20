package es.albertomarquez.listacoches;

public class Coche {
    
    private String marca;
    private String modelo;
    private String numBastidor;
    private String fechaCreacion;
    private int numPuertas;
    private float precio;  


    public Coche(){}
    
    public Coche(String marca){  
        this.marca = marca.toUpperCase();
    }
    
    public Coche(String marca, String modelo){
        this.marca = marca.toUpperCase();
        this.modelo = modelo;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca.toUpperCase();
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public String getNumBastidor(){
        return numBastidor;
    }
    
    public void setNumBastidor(String numBastidor){
        this.numBastidor = numBastidor;
    }
    
    public int getNumPuertas(){
        return numPuertas;
    }
    
    public void setNumPuertas(int numPuertas){
        this.numPuertas = numPuertas;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
    
    public String getFechaCreacion(){
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    
     @Override
    public String toString(){
        String r = "";
        r += "Marca: " + marca + "\n";
        r += "Modelo: " + modelo;
        return r;
    }
    public String precioToString(){
       String r = "Precio: " + precio;
       return r;
    }
    
     public String puertasToString(){
       String a = "Puertas: " + numPuertas;
       return a;
    }
}