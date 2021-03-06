package ronda.engine.evolution;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ronda.engine.elements.Player;
import ronda.engine.elements.Team;

public class Match {

	protected Logger logger = Logger.getLogger(Match.class);
	private final Team team1;
	private final Team team2;
	private final Game currentGame = new Game(this);
	private final List<Player> players = new ArrayList<Player>();

	public Match(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
		initializePlayers(team1, team2);
	}

	/**
	 * @return the team1
	 */
	public synchronized Team getTeam1() {
		return team1;
	}

	/**
	 * @return the team2
	 */
	public synchronized Team getTeam2() {
		return team2;
	}

	private void initializePlayers(Team team1, Team team2) {
		players.add(team1.getPlayer(1));
		players.add(team2.getPlayer(1));
		if (twoPlayersVersusTwoPlayersGame()) {
			players.add(team1.getPlayer(2));
			players.add(team2.getPlayer(2));
		}
	}

	public boolean twoPlayersVersusTwoPlayersGame() {
		return team1.getPlayer(2) != null & team2.getPlayer(2) != null;
	}

	protected Player getDistributor() {
		Team team = currentGame.getDistributorTeamIndex() == 1 ? team1 : team2;
		return team.getPlayer(currentGame.getDistributorPlayerIndex() == 1 ? 1
				: 2);
	}

	protected Player getNextPlayer(Player currentPlayer) {
		// get nextPlayer
		int currentPlayerIndex = players.indexOf(currentPlayer);
		return players.get(++currentPlayerIndex % players.size());
	}

	protected Game getCurrentGame() {
		return currentGame;
	}

	protected Team getPlayerTeam(Player player) {
		if (team1.isPlayerInTeam(player)) {
			return team1;
		} else {
			return team2;
		}
	}

	public void run() {
		while (!matchEnded()) {
			currentGame.run();
		}
	}

	public boolean matchEnded() {
		return (getWinnerTeam() != null);
	}

	/*
	 * public void startGame(Match match) { while
	 * (!currentGame.getHeap().isEmpty()) { currentGame.initializeHeap();
	 * currentGame.selectNextDistributor(); Round.startRound(match); }
	 * 
	 * }
	 */
	public Team getWinnerTeam() {
		if (team1.getScore() > 20) {
			logger.debug("Team 1 won with score :" + team1.getScore());
			return team1;
		} else if (team2.getScore() > 20) {
			logger.debug("Team 2 won with score :" + team2.getScore());
			return team2;
		} else {
			return null;
		}
	}

	protected void incrementScore(Team teamToReward, byte increment) {
		teamToReward.setScore((byte) (teamToReward.getScore() + increment));
	}

	public String getOverallScore() {
		return team1.getScore() + "#" + team2.getScore();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		// TODO Auto-generated method stub

	}

}
