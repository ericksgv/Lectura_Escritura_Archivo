package com.ingesoft.arquetipo_ingesoft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;

public class ArquetipoController {

    @FXML
    private Button btnCargarArchivo;

    @FXML
    private Button btnGuardarArchivo;

    @FXML
    private Button btnLimpiarPantalla;

    @FXML
    private Button btnSalir;

    @FXML
    private TextArea pantallaArchivo;

    @FXML
    void cargarArchivo(ActionEvent event) {
        String linea = "";
        try (FileReader fr = new FileReader(new File("archivo.txt"));
             BufferedReader br = new BufferedReader(fr)) {
            pantallaArchivo.setText("");
            while ((linea = br.readLine()) != null) {
                pantallaArchivo.appendText(linea);
                pantallaArchivo.appendText("\n");
            }

        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("No se encuentra el archivo especificado!");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Error con la carga del archivo!");
            alert.showAndWait();
        }

    }

    @FXML
    void guardarArchivo(ActionEvent event) throws IOException {
        String texto = "";
        try (FileWriter fw = new FileWriter("archivo.txt");
             BufferedWriter salida = new BufferedWriter(fw)) {
            texto = pantallaArchivo.getText();
            salida.write(texto);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error con la escritura del archivo!");
            alert.showAndWait();
        }
    }

    @FXML
    void limpiarPantalla(ActionEvent event) {
        pantallaArchivo.setText("");
    }

    @FXML
    void terminarPrograma(ActionEvent event) {
        System.out.println("Arquetipo");
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

}
