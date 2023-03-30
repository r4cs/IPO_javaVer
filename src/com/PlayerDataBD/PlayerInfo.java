package com.PlayerDataBD;
import com.Utils.KeyHandler;
import com.entity.Player;

import java.awt.image.BufferedImage;

public class PlayerInfo {
    Player player = new Player();
    private int id;
    private String nickname;
    private String email;
    private String cep;
    private String img;
    private Integer positionX;
    private Integer positionY;


    public PlayerInfo() {}
    public PlayerInfo(String nickname, String email, String cep) {
        this.nickname = nickname;
        this.email = email;
        this.cep = cep;
        this.img = "playerDown";
//        this.img = player.getPlayerImage().get("playerDown").toString();
        this.positionX = player.position.getX();
        this.positionY = player.position.getY();
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


    @Override
    public String toString() {
        return "PlayerInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", cep='" + cep + '\'' +
                ", img='" + img + '\'' +
                ", positionX='" + positionX + '\'' +
                ", positionY='" + positionY + '\'' +
                '}';
    }
}
