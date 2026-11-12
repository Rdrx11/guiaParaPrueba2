package org.example.guiaparaprueba2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;
import org.example.guiaparaprueba2.Dao.cartasPokemonDao;
import org.example.guiaparaprueba2.Model.CartasPokemonModel;

import java.io.IOException;
import java.util.ArrayList;

public class CartasPokemonController {
    @FXML
    private ComboBox<String> comboCategoria;
    @FXML
    private TextField campoNombreCarta;
    @FXML
    private Spinner<Integer> spinnerAno;
    @FXML
    private Spinner<Integer> spinnerCantidad;
    @FXML
    private TextField campoDatosEspecifico;
    @FXML
    private TextField campoValorEstimado;
    @FXML
    private Button botonRegistrar;

    @FXML
    private TableView<CartasPokemonModel>  tablaCartasPokemon;
    @FXML
    private TableColumn<CartasPokemonModel, String> colCategoria;
    @FXML
    private TableColumn<CartasPokemonModel, String> colNombreCarta;
    @FXML
    private TableColumn<CartasPokemonModel, Integer> colAno;
    @FXML
    private TableColumn<CartasPokemonModel, Integer> colCantidad;
    @FXML
    private TableColumn<CartasPokemonModel, String> colDatosEspecifico;
    @FXML
    private TableColumn<CartasPokemonModel, Integer> colValorEstimado;


    private final cartasPokemonDao dao = new cartasPokemonDao();
    private final ObservableList<CartasPokemonModel> CartasPokeObservableList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        CartasPokeObservableList.addAll(dao.cargar());

        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colNombreCarta.setCellValueFactory(new PropertyValueFactory<>("nombreCarta"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colDatosEspecifico.setCellValueFactory(new PropertyValueFactory<>("datosEspecificos"));
        colValorEstimado.setCellValueFactory(new PropertyValueFactory<>("valorEstimado"));

        tablaCartasPokemon.setItems(CartasPokeObservableList);


        comboCategoria.getItems().addAll("Pokemon", "Energia");
        comboCategoria.getSelectionModel().selectFirst();

        SpinnerValueFactory<Integer> factoryAno =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1996, 2026, 2026);
        spinnerAno.setValueFactory(factoryAno);

        SpinnerValueFactory<Integer> factoryCantidad =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1);
        spinnerCantidad.setValueFactory(factoryCantidad);
    }

   @FXML
   private void onBotonRegistrarClick(){
       String categoria = comboCategoria.getValue();
       String nombre = campoNombreCarta.getText().trim();
       int ano = spinnerAno.getValue();
       int cantidad = spinnerCantidad.getValue();
       String datosEspecificos = campoDatosEspecifico.getText().trim();
       int valorEstimado = Integer.parseInt(campoValorEstimado.getText().trim());

       CartasPokemonModel nuevaCarta = new CartasPokemonModel(categoria, nombre, ano, cantidad, datosEspecificos, valorEstimado);
       CartasPokeObservableList.add(nuevaCarta);
       try{
           dao.guardar(new ArrayList<>(CartasPokeObservableList));
           Notifications.create()
                   .title("Registro exitoso")
                   .text("Se guardo"+ nombre + "correctamente")
                   .showInformation();


       }catch(IOException ex){
           Notifications.create()
                   .title("ERROR DE GUARDADO")
                   .text("no se pudo guardar en el sistema")
                   .showError();
           ex.printStackTrace();
       }

   }
}
