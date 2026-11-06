package org.example.guiaparaprueba2.Model;

public class CartasPokemonModel {
    private String Categoria;
    private String NombreCarta;
    private int Ano;
    private int Cantidad;
    private String Datos_especificos;
    private int valor_estimado;

    public CartasPokemonModel(String categoria, String nombreCarta, int ano,int cantidad, String datos_especificos, int valor_estimado ){
        this.Categoria = categoria;
        this.NombreCarta = nombreCarta;
        this.Ano = ano;
        this.Cantidad = cantidad;
        this.Datos_especificos = datos_especificos;
        this.valor_estimado = valor_estimado;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getNombreCarta() {
        return NombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        NombreCarta = nombreCarta;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        Ano = ano;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getDatos_especificos() {
        return Datos_especificos;
    }

    public void setDatos_especificos(String datos_especificos) {
        Datos_especificos = datos_especificos;
    }

    public int getValor_estimado() {
        return valor_estimado;
    }

    public void setValor_estimado(int valor_estimado) {
        this.valor_estimado = valor_estimado;
    }

    @Override
    public String toString(){
        return "[" + Categoria + "]" +  NombreCarta + "[" + Ano + "]" + Cantidad + "[" + Datos_especificos + "]" + valor_estimado;
    }
}
