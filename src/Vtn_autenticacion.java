import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vtn_autenticacion extends Application {
    @Override
    public void start(Stage stage) {

        //titulo de la ventana
        stage.setTitle("Iniciar Sesión");

        //creamos el nodo raiz donde se van a agregar el resto de nodos
        //usamos primero el layout vertical para darle estructura al login
        //con el VBox se generan diversas filas, pero en una sola columna

        //PANEL DEL LOGIN (para una mejor comodidad)
        VBox pnlLogin = new VBox();

        //creamos las label, input, checkbox y boton que se van a usar en el login
        Label lblInicioSesion = new Label("Iniciar Sesion");
        Label lblUsuario = new Label("Usuario");
        Label lblContraseña = new Label("Contraseña");

        TextField txtUsuario = new TextField();
        PasswordField pswdContraseña = new PasswordField();

        //CHECKBOX y estilos
        CheckBox verPswd = new CheckBox();
        verPswd.setText("ver Contraseña");
        verPswd.setStyle("-fx-font-size: 25;");
        verPswd.setStyle("-fx-text-fill: #000000");

        Button btnIngresar = new Button("Ingresar");

        //cambiamos los estilos de cada nodo
        lblInicioSesion.setFont(new Font("SofiaSansSemiCondensed", 50));
        lblUsuario.setFont(new Font("SansSerif", 30));
        lblContraseña.setFont(new Font("SansSerif", 30));

        lblInicioSesion.setStyle("-fx-text-fill: #000000;");
        lblUsuario.setStyle("-fx-text-fill: #000000;");
        lblContraseña.setStyle("-fx-text-fill: #000000;");

        txtUsuario.setPrefWidth(300);
        txtUsuario.setPrefHeight(50);
        pswdContraseña.setPrefWidth(300);
        pswdContraseña.setPrefHeight(50);
        txtUsuario.setStyle("-fx-background-radius: 8");
        pswdContraseña.setStyle("-fx-background-radius: 8");

        //colocamos placeholders en cada input
        txtUsuario.setPromptText("Ingresar usuario");
        pswdContraseña.setPromptText("Ingresar Contraseña");

        btnIngresar.setFont(new Font("SansSerif", 15));
        btnIngresar.setPrefWidth(200);
        btnIngresar.setPrefHeight(50);

        //cursor y color para el boton
        btnIngresar.setCursor(Cursor.HAND);
        btnIngresar.setStyle("-fx-background-color: #c7c8ca;");
        btnIngresar.setStyle("-fx-text-fill: #000000;");
        btnIngresar.setStyle("-fx-background-radius: 8;");

        //agregamos el form al panel del LOGIN
        pnlLogin.getChildren().addAll(lblUsuario, txtUsuario, lblContraseña, pswdContraseña, verPswd, btnIngresar);
        //definimos como se va a posicionar
        pnlLogin.setAlignment(Pos.TOP_LEFT);

        //ponemos margin para que no se vea tan pegado
        VBox.setMargin(lblUsuario, new Insets(40, 0, 10, 0));
        VBox.setMargin(txtUsuario, new Insets(20, 0, 10, 0));

        VBox.setMargin(lblContraseña, new Insets(30, 0, 10, 0));
        VBox.setMargin(pswdContraseña,new Insets(20, 0, 10, 0) );

        VBox.setMargin(verPswd,new Insets(20, 0, 10, 0));
        VBox.setMargin(btnIngresar,new Insets(40, 0, 0, 0) );

        //este es el PANEL IZQUIERDO
        VBox leftForm = new VBox();

        //agregamos el panel del login dentro del panel izquiero
        leftForm.getChildren().addAll(lblInicioSesion, pnlLogin);

        //le damos estilo al panel izquierdo
        leftForm.setPrefSize(500, 800);
        leftForm.setStyle("-fx-background-color: #194986;");
        leftForm.setAlignment(Pos.CENTER);

        //agregamos margin al panel izquierdo
        VBox.setMargin(pnlLogin, new Insets(0, 50, 0, 50));

        //PANEL DERECHO

        //creamos el PANEL DERECHO
        VBox rightForm = new VBox();

        //logo de la empresa y sus estilos
        Image imagen = new Image("file:imgs/COPACAM PNG.png");
        ImageView logoEmpresa = new ImageView(imagen);
        logoEmpresa.setFitWidth(350);
        logoEmpresa.setFitHeight(320);

        //label de la informacion y sus estilos
        Label lblInformacion = new Label("Sistema de Gestión de Ventas e Inventario");
        lblInformacion.setStyle("-fx-text-fill: #194986;");
        lblInformacion.setFont(new Font("SansSerif", 25));
        //lblInformacion.setStyle("-fx-font-weight: bold");

        //agregamos el logo y el label al contenedor derecho
        rightForm.getChildren().addAll(logoEmpresa, lblInformacion);

        //le damos estilo al panel derecho
        rightForm.setAlignment(Pos.CENTER);
        rightForm.setStyle("-fx-background-color: #FFFFFF;");
        rightForm.setPrefSize(500, 800);

        //contenedor principal, usamos el HBox para colocar ambos HBox uno junto al otro
        HBox root = new HBox();

        //agregamos los paneles al nodo raiz
        root.getChildren().addAll(leftForm, rightForm);

        //con el HGrow, al maximizar la ventana, los componentes se deben de redimenzionar
        HBox.setHgrow(leftForm, Priority.ALWAYS);
        HBox.setHgrow(rightForm, Priority.ALWAYS);

        //creamos la SCENE
        Scene scene = new Scene(root, 1000, 800);

        //agregamos la Scene al Stage
        stage.setScene(scene);
        //mostramos el stage
        stage.show();

    }

    public static void main(String[] args) {
        //lanzamos la aplicación
        launch();
    }
}
