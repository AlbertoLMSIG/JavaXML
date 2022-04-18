module es.albertomarquez.listacoches {
    requires javafx.controls;
    exports es.albertomarquez.listacoches;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    opens es.albertomarquez.listacoches to java.xml.bind;
}
