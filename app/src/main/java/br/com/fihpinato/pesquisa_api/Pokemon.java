package br.com.fihpinato.pesquisa_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    @SerializedName(value = "name")
    private String name;

    private List<Types> types;

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
