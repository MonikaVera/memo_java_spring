package com.memo.game.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.memo.game.entity.MemoUsers;
import com.memo.game.model.MultiPlayer;
import com.memo.game.service.MemoUsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

public class MultiPlayerMessage implements Message {
    private MemoUsersService memoUsersService;
    private UUID player1;
    private UUID player2;
    @JsonProperty("type")
    private String type;
    @JsonProperty("gameId")
    private UUID gameId;
    @JsonProperty("player1Name")
    private String player1Name;
    @JsonProperty("player2Name")
    private String player2Name;
    @JsonProperty("winner")
    private String winner;
    @JsonProperty("turn")
    private String turn;
    @JsonProperty("content")
    private String content;
    @JsonProperty("board")
    private Integer[] board;
    @JsonProperty("index")
    private int index;
    @JsonProperty("senderToken")
    private String senderToken;
    private boolean isGameStarted;
    private boolean isGameOver;
    private Map<Integer,Integer> lastMove;

    public MultiPlayerMessage() {

    }

    public MultiPlayerMessage (MemoUsersService memoUsersService) {
        this.memoUsersService = memoUsersService;
    }

    public MultiPlayerMessage(MultiPlayer game, MemoUsersService memoUsersService) {
        this.memoUsersService = memoUsersService;
        this.gameId = game.getPlayId();
        this.player1 = game.getPlayer1Id();
        this.player2 = game.getPlayer2Id();
        this.player1Name = memoUsersService.getUserNameById(player1);
        this.player2Name = memoUsersService.getUserNameById(player1);
        this.winner = game.getWinner();
        if(game.isPlayer1sTurn()) {
            this.turn = this.player1Name;
        } else {
            this.turn = this.player2Name;
        }
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
        this.player1Name = memoUsersService.getUserNameById(player1);
    }

    public UUID getPlayer2() {
        return player2;
    }

    public void setPlayer2(UUID player2) {
        this.player2 = player2;
        this.player2Name = memoUsersService.getUserNameById(player2);
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setTurn(boolean isPlayer1sTurn) {
        if(isPlayer1sTurn) {
            this.turn = player1Name;
        } else {
            this.turn = player2Name;
        }
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

    public String getSenderToken() {
        return senderToken;
    }

    public void setSender(String senderToken) {
        this.senderToken = senderToken;
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

    public Map<Integer, Integer> getLastMove() {
        return lastMove;
    }

    public void setLastMove(Map<Integer, Integer> lastMove) {
        this.lastMove = lastMove;
    }
}
