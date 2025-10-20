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

    // metemos todos los botones del panel en una lista
    public void initialize() {
        panelBotones = Arrays.asList(mostrarBoton00, mostrarBoton01, mostrarBoton02, mostrarBoton03, mostrarBoton04,//lista con la id de todos los botones del panel
                mostrarBoton05, mostrarBoton06, mostrarBoton07, mostrarBoton08, mostrarBoton09, mostrarBoton10,
                mostrarBoton11, mostrarBoton12, mostrarBoton13, mostrarBoton14, mostrarBoton15, mostrarBoton16,
                mostrarBoton17, mostrarBoton18, mostrarBoton19, mostrarBoton20, mostrarBoton21, mostrarBoton22,
                mostrarBoton23, mostrarBoton24, mostrarBoton25, mostrarBoton26, mostrarBoton27, mostrarBoton28,
                mostrarBoton29);
        for (Button boton : panelBotones) {//tamaño de los botones del panel
            boton.setMinWidth(25);
            boton.setMinHeight(25);
        }
        seleccionarPalabraSecreta();//cojemos la palabra
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
        // para que no de un valor null que blockea el codigo, cuando el usuario cierra la alerta sin darle al boton(NullPointerException)
        Optional<ButtonType> result = alert.showAndWait();//objeto Optional<el tipo> result = alert.showAndWait(); Enseña la alerta y espera
        if (result.isPresent() && result.get() == botonReiniciar) {//si el boton es pulsado y se captura el botonReiniciar
            reiniciarJuego();//reinicia
        } else {//si le da a otro boton, en este caso salir
            System.exit(0);//sale del juego
        }
    }

    private void reiniciarJuego() {//igualo texto de los botones del panel a " "
        filaActual = 0;//reiniciamos
        columnaActual = 0;//reiniciamos
        for (Button boton : panelBotones) {//bucle para poner todos los botones del panel en " "
            boton.setText(" ");
            boton.setStyle(" ");
        }
        seleccionarPalabraSecreta();//volvemos a elejir palabra secreta
    }

    @FXML
    protected void buttonClick(ActionEvent event) {//funcion para recivir clics de botones del teclado
        Button boton = (Button) event.getSource();//coje el boton pulsado
        String letra = boton.getText();//cojemos la letra del boton

        if (letra.equals("DELETE")) {//letra es igual a DELETE
            if (columnaActual > 0) {//si es 0 no el panel esta vacio, no haria nada
                columnaActual--;//le restamos 1 posicion
                int index = filaActual * MAX_COLUMNAS + columnaActual;//indice para buscar el id en el objeto panelBotones
                panelBotones.get(index).setText(" ");//buscamso el id .get(index) y lo cambiamos a " " .setText
            }
        } else if (letra.equals("ENTER")){//letra es igaul a ENTER
            if (columnaActual == MAX_COLUMNAS) {//si hemos escrto una palabra
                boolean juegoGanado = comprobarPalabra();//comprobamos coincidencias con la palabra secreta
                if (!juegoGanado) {//si comprobarPalabra() devuelve falso
                    if (filaActual<MAX_FILAS) {//si no estamos en la ultima fila
                        filaActual++;//aumentamos fila
                        columnaActual = 0;//reiniciamos las columnas
                    }
                    if (filaActual >= MAX_FILAS) {//si estabamos en la ultima fila
                        finJuego();//fin de partida
                    }
                }
            }
        } else {
            if (columnaActual < MAX_COLUMNAS && filaActual < MAX_FILAS) {//para poner la letra del boton
                int index = filaActual * MAX_COLUMNAS + columnaActual;//establecemos el indice
                panelBotones.get(index).setText(letra);//buscamos el id por el indice y cambiamos la letra del boton
                columnaActual++;//aumentamos 1 columna
            }
        }
    }
    private boolean comprobarPalabra() {//funcion para comprobar
        StringBuilder palabraAdivinada = new StringBuilder();//refencia para poder manipular y comparar las palabras, StringBuilder as facil de modificar que un string, me permite usar append() ToString()
        for (int i = 0; i < MAX_COLUMNAS; i++) {//bucle para introducir todas las letras de una fila y convertirla en palabra
            int index = filaActual * MAX_COLUMNAS + i;//indice
            palabraAdivinada.append(panelBotones.get(index).getText());//añadimos en cada iteracion una letra
        }

        String palabra = palabraAdivinada.toString().toUpperCase();//convierto la palabra en string y mayusculas
        String palabraSecretaMayusculas = palabraSecreta.toUpperCase();//convierto la palabra secreta en mayusculas para compararla
        boolean aciertoCompleto = true;//booleano para alerta ganador juego

        for (int i = 0; i < MAX_COLUMNAS; i++) {//bucle para recorrer las letras de la fila, y cambiarlas de color
            Button boton = panelBotones.get(filaActual * MAX_COLUMNAS + i);//metemos el boton en un objeto
            String letra = String.valueOf(palabra.charAt(i));// cojemos el caracter del boton con .charAt() y lo convertimos en String con .valueOf

            if (palabraSecretaMayusculas.charAt(i) == letra.charAt(0)) {//si palabra secreta tiene la letra en la misma posición
                boton.setStyle("-fx-background-color: green;");//ponemos en verde
            } else if (palabraSecretaMayusculas.contains(letra)) {//si la contine pero no es su posición
                boton.setStyle("-fx-background-color: yellow;");//ponemos amarillo
                aciertoCompleto = false;//boleano para no mandar la alerta
            }else {//si no se cumple lo anterior
                boton.setStyle("-fx-background-color: gray;");//ponemos en gris
                aciertoCompleto = false;
            }
        }

        if (aciertoCompleto) {//si no se cambio el booleano aciertoCompleto enviamos alerta Ganador del juego
            Alert alert = new Alert(Alert.AlertType.INFORMATION);//creamos objeto alerta con tipo Información
            alert.setTitle("¡Felicidades!");//titulo
            alert.setHeaderText("Has acertado la palabra secreta!");//cabecera
            alert.setContentText("La palabra era: " + palabraSecreta);//pie
            alert.showAndWait();//muestra y espera
            reiniciarJuego();//reinicia juego
            return true;//devuelve true para la funcion del boton ENTER
        }
        return false;//devuelve false en el boton ENTER, si no se acertó la palabra
    }
}