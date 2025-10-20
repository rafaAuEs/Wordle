package com.example.wordly;

import javafx.fxml.FXML;//importo el FXML
import javafx.scene.control.Label;
import javafx.scene.control.Button;//importo los botones
import javafx.event.ActionEvent;//importo el evento de click etc.
import javafx.scene.control.Alert;//importo la alerta
import javafx.scene.control.ButtonType;//importo los botones para la alerta

import java.util.Arrays;//importamos para el array que necesita la lista
import java.util.List;//importamos para usar la lista
import java.util.Optional;//importamas para la alerta el famoso error NullPointerException
import java.util.Random;//importamos para coger aleatoriamente una palabra

import java.awt.*;

public class HelloController {
    //<-- importamos los botones de FXML en java -->
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

    //<-- variable globales -->
    //tipo Lista <el tipo de la lista>
    private List<Button> panelBotones;
    private int filaActual = 0;
    private int columnaActual = 0;
    private final int MAX_COLUMNAS = 5;
    private final int MAX_FILAS = 6;
    private String palabraSecreta;
    private List<String> diccionario = Arrays.asList("actas", "aguas", "aires", "ajena", "almas", "altar", "autos", "aulas", "avión", "barra", "barco", "bases", "bello", "bocas", "bolso", "botón", "cabra", "calle", "campo", "canta", "carta", "casas", "causa", "cebra", "cejas", "celda", "cenar", "cerca", "claro", "clase", "clave", "coche", "comer", "copas", "corro", "corto", "costa", "crema", "cruce", "culpa", "curar", "datos", "deber", "dedos", "dicha", "diez", "dinos", "dolor", "donde", "dueño", "entró", "estar", "fecha", "feliz", "final", "fondo", "forma", "frase", "fuego", "gente", "grito", "grupo", "hacer", "hojas", "hotel", "ideas", "jugar", "junto", "largo", "lejos", "libra", "libros", "línea", "lugar", "lunes", "males", "manos", "marco", "meter", "miedo", "monte", "moral", "motor", "mujer", "nacer", "noche", "norte", "nueva", "nubes", "ondas", "orden", "otros", "padre", "palma", "papel", "parte", "pasos", "pausa", "peces", "perro");
    private Random random = new Random();

    // metemos todos los botones en una lista
    public void initialize() {
        panelBotones = Arrays.asList(mostrarBoton00, mostrarBoton01, mostrarBoton02, mostrarBoton03, mostrarBoton04,
                mostrarBoton05, mostrarBoton06, mostrarBoton07, mostrarBoton08, mostrarBoton09, mostrarBoton10,
                mostrarBoton11, mostrarBoton12, mostrarBoton13, mostrarBoton14, mostrarBoton15, mostrarBoton16,
                mostrarBoton17, mostrarBoton18, mostrarBoton19, mostrarBoton20, mostrarBoton21, mostrarBoton22,
                mostrarBoton23, mostrarBoton24, mostrarBoton25, mostrarBoton26, mostrarBoton27, mostrarBoton28,
                mostrarBoton29);
        seleccionarPalabraSecreta();
    }

    //funcion para cojer una palabra secreta aleatoria
    private void seleccionarPalabraSecreta() {
        //.get cojemos algo de diccionario (random.nextInt(aqui va la cantidad de elementos aleatorios que vamos a randomizar))
        palabraSecreta = diccionario.get(random.nextInt(diccionario.size()));
        System.out.println("Palabra secreta: " + palabraSecreta);
    }

    //funcion para la alerta de fin de partida o gameOver
    private void finJuego() {
        //objeto tipo alerta , nueva alerta (alerta.indicamos alertType.tipo de alerta
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin del juego");//titulo
        alert.setHeaderText("¡Has agotado todos tus intentos!");//cabecera
        alert.setContentText("¿Quieres jugar de nuevo?");//cuerpo

        ButtonType botonReiniciar = new ButtonType("Reiniciar");//un boton para reiniciar nuevo ButtonType(texto)
        ButtonType botonSalir = new ButtonType("Salir");//lo mismo pero para salir

        alert.getButtonTypes().setAll(botonReiniciar, botonSalir);//llamamos a los botnes .gettButtonTypes() los sustituimos por los parametros .setAll(parametro1, parametro2)

        Optional<ButtonType> result = alert.showAndWait();// para que no de un valor null que blockea el codigo,
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
            boton.setStyle(" ");
        }
        seleccionarPalabraSecreta();
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
                boolean juegoGanado = comprobarPalabra();
                if (!juegoGanado) {
                    if (filaActual<MAX_FILAS) {
                        filaActual++;
                        columnaActual = 0;
                    }
                    if (filaActual >= MAX_FILAS) {
                        finJuego();
                    }
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
    private boolean comprobarPalabra() {
        StringBuilder palabraAdivinada = new StringBuilder();
        for (int i = 0; i < MAX_COLUMNAS; i++) {
            int index = filaActual * MAX_COLUMNAS + i;
            palabraAdivinada.append(panelBotones.get(index).getText());
        }

        String palabra = palabraAdivinada.toString().toUpperCase();
        String palabraSecretaMayusculas = palabraSecreta.toUpperCase();
        boolean aciertoCompleto = true;

        for (int i = 0; i < MAX_COLUMNAS; i++) {
            Button boton = panelBotones.get(filaActual * MAX_COLUMNAS + i);
            String letra = String.valueOf(palabra.charAt(i));

            if (palabraSecretaMayusculas.charAt(i) == letra.charAt(0)) {
                boton.setStyle("-fx-background-color: green;");
            } else if (palabraSecretaMayusculas.contains(letra)) {
                boton.setStyle("-fx-background-color: yellow;");
                aciertoCompleto = false;
            }else {
                boton.setStyle("-fx-background-color: gray;");
                aciertoCompleto = false;
            }
        }

        if (aciertoCompleto) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("¡Felicidades!");
            alert.setHeaderText("Has acertado la palabra secreta!");
            alert.setContentText("La palabra era: " + palabraSecreta);
            alert.showAndWait();
            reiniciarJuego();
            return true;
        }
        return false;
    }
}