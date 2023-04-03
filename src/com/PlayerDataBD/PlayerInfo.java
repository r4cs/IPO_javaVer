package com.PlayerDataBD;
import com.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PlayerInfo {
    Player player = new Player();
    private int id;
    private String nickname;
    private String email;
    private String cep;
    private String endereco;
    private String img;
    private Integer positionX;
    private Integer positionY;

    public PlayerInfo() {}


    public PlayerInfo(String nickname, String email, String cep) throws IOException {
        this.nickname = nickname;
        this.email = email;
        this.cep = cep;
        this.img = "playerDown";
//        this.img = player.getPlayerImage().get("playerDown").toString();
        this.positionX = player.position.getX();
        this.positionY = player.position.getY();
        this.endereco = BuscarCep.buscarCep(this.cep);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "player=" + player +
                ", id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", img='" + img + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
