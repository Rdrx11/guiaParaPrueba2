package org.example.guiaparaprueba2.cotroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.guiaparaprueba2.Dao.cartasPokemonDao;
import org.example.guiaparaprueba2.Model.CartasPokemonModel;

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
    int ValorEstimado = Integer.parseInt(campoValorEstimado.getText().trim());
    @FXML
    private Button botonRegistrar;

    @FXML
    private TableView<CartasPokemonModel>  tablaCartasPokemon;
    @FXML
    private TableColumn<CartasPokemonModel, String> colCategoria;
    @FXML
    private TableColumn<CartasPokemonModel, String> colNombreCarta;
    @FXML
    private TableColumn<CartasPokemonModel, String> colAno;
    @FXML
    private TableColumn<CartasPokemonModel, String> colCantidad;
    @FXML
    private TableColumn<CartasPokemonModel, String> colDatosEspecifico;
    @FXML
    private TableColumn<CartasPokemonModel, String> colValorEstimado;


    private final cartasPokemonDao dao = new cartasPokemonDao();
    private final ObservableList<CartasPokemonModel> CartasPokeObservableList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        CartasPokeObservableList.addAll(dao.cargar());

        colCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("año"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        colDatosEspecifico.setCellValueFactory(new PropertyValueFactory<>("Datos especificos"));
        colValorEstimado.setCellValueFactory(new PropertyValueFactory<>("Valor estimado"));

        tablaCartasPokemon.setItems(CartasPokeObservableList);


        comboCategoria.getItems().addAll("Pokemon", "Energia");
        comboCategoria.getSelectionModel().selectFirst();

    SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1996, 2026, 2026);
            spinnerAno.setValueFactory(valueFactory);
            int ano = spinnerAno.getValue();

            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1);
            spinnerCantidad.setValueFactory(valueFactory);
            int Cantidad = spinnerCantidad.getValue();
    }

    @FXML
    private void setBotonRegistrarClick(){
        String categoria = comboCategoria.getValue();
        String nombre = campoNombreCarta.getText().trim();

    }
}
