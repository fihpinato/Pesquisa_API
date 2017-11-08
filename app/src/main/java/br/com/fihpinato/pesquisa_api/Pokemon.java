package br.com.fihpinato.pesquisa_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    //Campos da api que queremos trazer pro apk
    @SerializedName(value = "name")
    private String name;

    //Lista de tipos do pokemon
    private List<Types> types;

    //Sprite do pokemon
    private Sprites sprites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
}
