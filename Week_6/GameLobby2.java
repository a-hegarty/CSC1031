package Week_6;

import java.util.ArrayList;
import java.util.List;

public class GameLobby2{
    private List<Player> players = new ArrayList<>();
    void registerPlayer(Player player)
    {
        this.players.add(player);
        System.out.println("[GameLobby] " + player.getPlayerType() + " " + player.getPlayerName() 
                            + " has joined the lobby.");
    }

    void removePlayer(Player player)
    {
        this.players.remove(player);
        System.out.println("[GameLobby] " + player.getPlayerType() + " " + player.getPlayerName() 
                            + " has left the lobby.");
    }

    void sendMessage(String message, Player sender)
    {
        if (sender.getPlayerType() != "Spectator") {
            System.out.println("[" + sender.getPlayerName() + "] sends: " + "\"" + message + "\"");
            System.out.println("[GameLobby] Message from " + sender.getPlayerName() + ": " 
                                + "\"" + message + "\"");
            for (Player player : players) {
                if (sender != player) {
                    player.receiveMessage(message);
                }
            }
        } else {
            System.out.println("[GameLobby] Spectators cannot send messages.");
        }
    }

    void startMatch(){
        int tmp = 0, count = this.players.size();
        for (Player player : players) {
            if (player.getPlayerType() == "Spectator") {
                count--;
            }
            if (count < 2) {
                break;
            }
        }

        if (count >= 2) {
            System.out.print("[GameLobby] Starting game with players: ");
            for (Player player : players) {
                if (tmp == 0 && player.getPlayerType() != "Spectator") {
                    System.out.print(player.getPlayerName());
                    tmp++;
                } else if (tmp != 0 && player.getPlayerType() != "Spectator") {
                    System.out.print(", " + player.getPlayerName());
                }
            }
            System.out.println("");
        } else {
            System.out.println("[GameLobby] Not enough players to start a match.");
        }
    }  
}

interface Player{
    void joinGame();

    void leaveGame();

    void sendMessage(String message);

    void receiveMessage(String message);

    String getPlayerType();

    String getPlayerName();
}

abstract class AbstractPlayer implements Player {
    protected String name;
    protected GameLobby2 lobby;

    public AbstractPlayer(String name, GameLobby2 lobby) {
        this.name = name;
        this.lobby = lobby;
    }

    @Override
    public void sendMessage(String message) {
        //System.out.println("[" + this.name + "] sends: " + "\"" + message + "\"");
        lobby.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("[" + this.name + "] received: " + "\"" + message + "\"");
    }

    public abstract String getPlayerType();

    public abstract String getPlayerName();
}

class HumanPlayer extends AbstractPlayer {
    public HumanPlayer(String name, GameLobby2 lobby) {
            super(name, lobby);
    }
    
    @Override
    public void joinGame() {
        this.lobby.registerPlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has joined the lobby.");
    }

    @Override
    public void leaveGame() {
        this.lobby.removePlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has left the lobby.");
    }

    @Override
    public String getPlayerType() {
        return "HumanPlayer";
    }

    @Override
    public String getPlayerName() {
        return this.name;
    }
}

class AIPlayer extends AbstractPlayer {
    public AIPlayer(String name, GameLobby2 lobby) {
        super(name, lobby);
    }

    @Override
    public void joinGame() {
        this.lobby.registerPlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has joined the lobby.");
    }

    @Override
    public void leaveGame() {
        this.lobby.removePlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has left the lobby.");
    }

    @Override
    public String getPlayerType() {
        return "AIPlayer";
    }

    @Override
    public String getPlayerName() {
        return this.name;
    }
}

class Spectator extends AbstractPlayer {
    public Spectator(String name, GameLobby2 lobby) {
        super(name, lobby);
    }

    @Override
    public void joinGame() {
        this.lobby.registerPlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has joined the lobby.");
    }

    @Override
    public void leaveGame() {
        this.lobby.removePlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has left the lobby.");
    }

    @Override
    public String getPlayerType() {
        return "Spectator";
    }

    @Override
    public String getPlayerName() {
        return this.name;
    }
}

class AdminPlayer extends AbstractPlayer {
    public AdminPlayer(String name, GameLobby2 lobby) {
        super(name, lobby);
    }

    @Override
    public void joinGame() {
        this.lobby.registerPlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has joined the lobby.");
    }

    @Override
    public void leaveGame() {
        this.lobby.removePlayer(this);
        //System.out.println("[GameLobby] " + this.getPlayerType() + " " + this.name + " has left the lobby.");
    }

    @Override
    public String getPlayerType() {
        return "AdminPlayer";
    }

    @Override
    public String getPlayerName() {
        return this.name;
    }

   /*public void kickPlayer(String name) {
        lobby.kickPlayer(name, this);
    }*/
}

public class Main{
    public static void main(String[] args) {
        GameLobby2 lobby = new GameLobby2();
        Player alice = new HumanPlayer("Alice", lobby);
        Player bot = new AIPlayer("BotX", lobby);
        Player bob = new Spectator("Bob", lobby);
        Player admin = new AdminPlayer("Charlie", lobby);

        alice.joinGame();
        bot.joinGame();
        bob.joinGame();
        admin.joinGame();

        admin.sendMessage("Welcome to the lobby!");
        //((AdminPlayer) admin).kickPlayer("Bob"); // Admin kicks Spectator Bob
        lobby.startMatch();
    }
}
