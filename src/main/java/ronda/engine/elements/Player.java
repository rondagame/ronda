package ronda.engine.elements;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String identifier;
	private List<Card> wonCardsPerHeap = new ArrayList<Card>();
	private List<Card> handCardsPerRound = new ArrayList<Card>();
	private List<Card> initialHandCardsPerRound = new ArrayList<Card>();
	private Announcement announcementPerRound = Announcement.nothingAnnounced;

	public Player(String id) {
		assert (id != null);

		identifier = id;
	}

	public List<Card> getWonCardsPerHeap() {
		return wonCardsPerHeap;
	}

	public void setWonCardsPerHeap(List<Card> wonCardsPerHeap) {
		this.wonCardsPerHeap = wonCardsPerHeap;
	}

	public List<Card> getHandCardsPerRound() {
		return handCardsPerRound;
	}

	public void setHandCardsPerRound(List<Card> handCardsPerRound) {
		this.handCardsPerRound = handCardsPerRound;
	}

	public List<Card> getInitialHandCardsPerRound() {
		return initialHandCardsPerRound;
	}

	public void setInitialHandCardsPerRound(List<Card> initialHandCardsPerRound) {
		this.initialHandCardsPerRound = initialHandCardsPerRound;
	}

	public Announcement getAnnouncementPerRound() {
		return announcementPerRound;
	}

	public void setAnnouncementPerRound(Announcement announcementPerRound) {
		this.announcementPerRound = announcementPerRound;
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "Player [identifier=" + identifier + "]";
	}

	public Move play() {
		// TODO
		return null;
	}
}
