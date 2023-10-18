package model;



public class Destino {

    private int id;
    private String nomeDestino;
    private String valorPadrao;
    private String valorPromocional;

    public Destino() {
    }


    public Destino(int id, String nomeDestino, String valorPadrao, String valorPromocional) {
        this.id = id;
        this.nomeDestino = nomeDestino;
        this.valorPadrao = valorPadrao;
        this.valorPromocional = valorPromocional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(String valorPadrao) {
        this.valorPadrao = valorPadrao;
    }



    public String getvalorPromocional() {
        return valorPromocional;
    }

    public void setValorPromocional(String valorPromocional) {
        this.valorPromocional = valorPromocional;
    }
}






