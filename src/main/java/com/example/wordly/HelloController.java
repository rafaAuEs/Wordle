package com.example.wordly;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.awt.*;

public class HelloController {
    @FXML
    private Button mostrarBoton00;
    @FXML
    private Button mostrarBoton01;
    @FXML
    private Button mostrarBoton02;
    @FXML
    private Button mostrarBoton03;
    @FXML
    private Button mostrarBoton04;
    @FXML
    private Button mostrarBoton05;
    @FXML
    private Button mostrarBoton06;
    @FXML
    private Button mostrarBoton07;
    @FXML
    private Button mostrarBoton08;
    @FXML
    private Button mostrarBoton09;
    @FXML
    private Button mostrarBoton10;
    @FXML
    private Button mostrarBoton11;
    @FXML
    private Button mostrarBoton12;
    @FXML
    private Button mostrarBoton13;
    @FXML
    private Button mostrarBoton14;
    @FXML
    private Button mostrarBoton15;
    @FXML
    private Button mostrarBoton16;
    @FXML
    private Button mostrarBoton17;
    @FXML
    private Button mostrarBoton18;
    @FXML
    private Button mostrarBoton19;
    @FXML
    private Button mostrarBoton20;
    @FXML
    private Button mostrarBoton21;
    @FXML
    private Button mostrarBoton22;
    @FXML
    private Button mostrarBoton23;
    @FXML
    private Button mostrarBoton24;
    @FXML
    private Button mostrarBoton25;
    @FXML
    private Button mostrarBoton26;
    @FXML
    private Button mostrarBoton27;
    @FXML
    private Button mostrarBoton28;
    @FXML
    private Button mostrarBoton29;

    private List<Button> panelBotones;
    private int filaActual = 0;
    private int columnaActual = 0;
    private final int MAX_COLUMNAS = 5;
    private final int MAX_FILAS = 6;

    @FXML
    public void initialize() {
        panelBotones = Arrays.asList(mostrarBoton00, mostrarBoton01, mostrarBoton02, mostrarBoton03, mostrarBoton04,
                mostrarBoton05, mostrarBoton06, mostrarBoton07, mostrarBoton08, mostrarBoton09, mostrarBoton10,
                mostrarBoton11, mostrarBoton12, mostrarBoton13, mostrarBoton14, mostrarBoton15, mostrarBoton16,
                mostrarBoton17, mostrarBoton18, mostrarBoton19, mostrarBoton20, mostrarBoton21, mostrarBoton22,
                mostrarBoton23, mostrarBoton24, mostrarBoton25, mostrarBoton26, mostrarBoton27, mostrarBoton28,
                mostrarBoton29);
    }

    private void finJuego() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin del juego");
        alert.setHeaderText("¡Has agotado todos tus intentos!");
        alert.setContentText("¿Quieres jugar de nuevo?");

        ButtonType botonReiniciar = new ButtonType("Reiniciar");
        ButtonType botonSalir = new ButtonType("Salir");

        alert.getButtonTypes().setAll(botonReiniciar, botonSalir);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == botonReiniciar) {
            reiniciarJuego();
        } else {
            System.exit(0);
        }
    }

    private void reiniciarJuego() {
        filaActual = 0;
        columnaActual = 0;
        for (Button boton : panelBotones) {
            boton.setText(" ");
            // para añadir stylos mas adelante: boton.setStyle("-fx-background-color: orange;");
        }
    }

    @FXML
    protected void buttonClick(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String letra = boton.getText();
        if (letra.equals("DELETE")) {
            if (columnaActual > 0) {
                columnaActual--;
                int index = filaActual * MAX_COLUMNAS + columnaActual;
                panelBotones.get(index).setText(" ");
            }
        } else if (letra.equals("ENTER")){
            if (columnaActual == MAX_COLUMNAS) {
                filaActual++;
                columnaActual = 0;
                if (filaActual >= MAX_FILAS) {
                    finJuego();
                }
            }
        } else {
            if (columnaActual < MAX_COLUMNAS && filaActual < MAX_FILAS) {
                int index = filaActual * MAX_COLUMNAS + columnaActual;
                panelBotones.get(index).setText(letra);
                columnaActual++;
            }
        }
    }
}