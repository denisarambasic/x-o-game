package com.sandro.models;

public class Player {
    private String name;
    private String sign;
    private Boolean isCurrentPlayer;

    public Player(String name, String sign, Boolean isCurrentPlayer) {
        this.name = name;
        this.sign = sign;
        this.isCurrentPlayer = isCurrentPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getCurrentPlayer() {
        return isCurrentPlayer;
    }

    public void setCurrentPlayer(Boolean currentPlayer) {
        isCurrentPlayer = currentPlayer;
    }
}
