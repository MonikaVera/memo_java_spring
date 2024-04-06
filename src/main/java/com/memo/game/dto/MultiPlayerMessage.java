package com.memo.game.dto;

import com.memo.game.model.MultiPlayer;

import java.util.UUID;

public class MultiPlayerMessage implements Message {
    private String type;
    private UUID gameId;
    private UUID player1;
    private UUID player2;
    private String winner;
    private boolean isPlayer1sturn;
    private String content;
    private Integer[] board;
    private int index;
    private UUID sender;
    private boolean isGameStarted;
    private boolean isGameOver;

    public MultiPlayerMessage () {
    }

    public MultiPlayerMessage(MultiPlayer game) {
        this.gameId = game.getPlayId();
        this.player1 = game.getPlayer1Id();
        this.player2 = game.getPlayer2Id();
        this.winner = game.getWinner();
        this.isPlayer1sturn = game.isPlayer1sTurn();
        this.board = game.getGuessedBoard();
        this.isGameStarted = game.isGameStarted();
        this.isGameOver = game.isGameOver();
    }

    /**
     * Getters and Setters
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getGameId() {
        return gameId;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public UUID getPlayer1() {
        return player1;
    }

    public void setPlayer1(UUID player1) {
        this.player1 = player1;
    }

    public UUID getPlayer2() {
        return player2;
    }

    public void setPlayer2(UUID player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isPlayer1sTurn() {
        return isPlayer1sturn;
    }

    public void setTurn(boolean turn) {
        this.isPlayer1sturn = turn;
    }

    public Integer[] getBoard() {
        return board;
    }

    public void setBoard(Integer[] board) {
        this.board = board;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        isGameStarted = gameStarted;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getSender() {
        return sender;
    }

    public void setSender(UUID sender) {
        this.sender = sender;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}