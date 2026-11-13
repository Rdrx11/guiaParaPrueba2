package org.example.guiaparaprueba2.Model;

public class CartasPokemonModel {
    private String Categoria;
    private String NombreCarta;
    private int Ano;
    private int Cantidad;
    private String DatosEspecificos;
    private int valorEstimado;

    public CartasPokemonModel(String categoria, String nombreCarta, int ano,int cantidad, String datos_especificos, int valor_estimado ){
        this.Categoria = categoria;
        this.NombreCarta = nombreCarta;
        this.Ano = ano;
        this.Cantidad = cantidad;
        this.DatosEspecificos = datos_especificos;
        this.valorEstimado = valor_estimado;
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

    public String getDatosEspecificos() {
        return DatosEspecificos;
    }

    public void setDatosEspecificos(String datosEspecificos) {
        DatosEspecificos = datosEspecificos;
    }

    public int getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(int valor_estimado) {
        this.valorEstimado = valorEstimado;
    }

    @Override
    public String toString(){
        return "[" + Categoria + "]" +  NombreCarta + "[" + Ano + "]" + Cantidad + "[" + DatosEspecificos + "]" + valorEstimado;
    }
}
