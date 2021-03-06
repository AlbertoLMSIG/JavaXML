package es.albertomarquez.listacoches;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    Pane paneRoot;
    int cocheActual = 0;
    TextArea textArea;
    
    @Override
    public void start(Stage stage) {
        
        paneRoot = new Pane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Label enun = new Label("INFORMACION COCHES");
        enun.setStyle("-fx-font: 40 arial;");
        enun.setLayoutX(90);
        paneRoot.getChildren().add(enun);
        
        Coche coche1 = new Coche("BMW");
        coche1.setModelo("M4 COMPETITION");
        coche1.setPrecio(104000f);
        coche1.setNumPuertas(3);
        coche1.setNumBastidor("17389F");
        coche1.setFechaCreacion("08/01/2021");
        
        Coche coche2 = new Coche("AUDI");
        coche2.setModelo("RS6");
        coche2.setPrecio(615000f);
        coche2.setNumPuertas(5);
        coche2.setNumBastidor("43155G");
        coche2.setFechaCreacion("12/11/2018");
        
        Coche coche3 = new Coche("MERCEDES");
        coche3.setModelo("Clase C AMG");
        coche3.setPrecio(120000f);
        coche3.setNumPuertas(5);
        coche3.setNumBastidor("98428M");
        coche3.setFechaCreacion("29/10/2016");
        
        
        Coches coches = new Coches();
        coches.getListaCoches().add(coche1);
        coches.getListaCoches().add(coche2);
        coches.getListaCoches().add(coche3);
        Label labelMarca = new Label();
        labelMarca.setLayoutX(100);
        labelMarca.setLayoutY(200);
        Label labelModelo = new Label();
        labelModelo.setLayoutX(100);
        labelModelo.setLayoutY(220);
        Label labelNumPuertas = new Label();
        labelNumPuertas.setLayoutX(100);
        labelNumPuertas.setLayoutY(240);
        Label labelPrecio = new Label();
        labelPrecio.setLayoutX(100);
        labelPrecio.setLayoutY(260);
        
         //CREACION DE BOTON GUARDAR XML
        Button boton = new Button("Guardar XML");
        boton.setLayoutX(150);
        boton.setLayoutY(100);
        paneRoot.getChildren().add(boton);
        boton.setOnAction((t) -> { 
            UtilXML.guardarDatosXML(stage,coches);
        });
        
        
        //CREACION BOTON IMPORTAR XML
        Button boton2 = new Button("Importar XML"); 
        boton2.setLayoutX(400);
        boton2.setLayoutY(100);
        paneRoot.getChildren().add(boton2);
        boton2.setOnAction((t) -> { 
            Coches cochesImport = UtilXML.importarDatosXML(stage);
            //System.out.println("Numero de libros importados: ");
            //System.out.println(cochesImport.getListaCoches().size());
            System.out.println("Has pulsado el bot??n importar");
            coches.fusionarCochess(cochesImport);
            labelMarca.setText("Marca: "+ coches.getListaCoches().get(cocheActual).getMarca());
            labelModelo.setText("Modelo: "+coches.getListaCoches().get(cocheActual).getModelo());
            labelNumPuertas.setText(coches.getListaCoches().get(cocheActual).puertasToString());
            labelPrecio.setText(coches.getListaCoches().get(cocheActual).precioToString() + "???");
        });
           
        
        
        paneRoot.getChildren().add(labelMarca);
        paneRoot.getChildren().add(labelModelo);
         paneRoot.getChildren().add(labelNumPuertas);
        paneRoot.getChildren().add(labelPrecio);
        
        Coche coche = coches.getListaCoches().get(cocheActual);
      
        //CREACION BOTON SIGUIENTE
        Button botonSiguiente = new Button("Siguiente"); 
        botonSiguiente.setLayoutX(220);
        botonSiguiente.setLayoutY(150);
        paneRoot.getChildren().add(botonSiguiente);
        botonSiguiente.setOnAction((t) -> { 
            cocheActual++;
             if(cocheActual >= coches.getListaCoches().size()) {
                cocheActual = 0;
            }
            try {
                labelMarca.setText("Marca: "+ coches.getListaCoches().get(cocheActual).getMarca());
                labelModelo.setText("Modelo: "+coches.getListaCoches().get(cocheActual).getModelo());
                labelNumPuertas.setText(coches.getListaCoches().get(cocheActual).puertasToString());
                labelPrecio.setText(coches.getListaCoches().get(cocheActual).precioToString() + "???");
            } catch (Exception ex){}
         });
        //CREACION BOTON ANTERIOR
        Button botonAnterior = new Button("Anterior"); 
        botonAnterior.setLayoutX(350);
        botonAnterior.setLayoutY(150); 
        paneRoot.getChildren().add(botonAnterior);
        botonAnterior.setOnAction((t) -> { 
            cocheActual--;
            if(cocheActual < 0) {
                cocheActual = coches.getListaCoches().size()-1;
            }
            try {
                labelMarca.setText("Marca: "+ coches.getListaCoches().get(cocheActual).getMarca());
                labelModelo.setText("Modelo: "+coches.getListaCoches().get(cocheActual).getModelo());
                labelNumPuertas.setText(coches.getListaCoches().get(cocheActual).puertasToString());
                labelPrecio.setText(coches.getListaCoches().get(cocheActual).precioToString() + "???");
            } catch (Exception ex){} 
         });
    }
    
    public static void main(String[] args) {
        launch();
    }

}