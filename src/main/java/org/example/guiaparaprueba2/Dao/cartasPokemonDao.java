package org.example.guiaparaprueba2.Dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.guiaparaprueba2.Model.CartasPokemonModel;


import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class cartasPokemonDao {
    private static Path RUTA_ARCHIVO = Path.of("CartasPokemon.json");

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardar (List<CartasPokemonModel> lista) throws IOException {
        String Json = gson.toJson(lista);
        Files.writeString(RUTA_ARCHIVO, Json, StandardCharsets.UTF_8);
    }

    public List<CartasPokemonModel> cargar () {
        if (!Files.exists(RUTA_ARCHIVO)) {
            return new ArrayList<>();
        }
        try {
            String json = Files.readString(RUTA_ARCHIVO, StandardCharsets.UTF_8);
            Type tipoLista = new TypeToken<ArrayList<CartasPokemonModel>>() {}.getType();
            List<CartasPokemonModel> lista = gson.fromJson(json, tipoLista);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
