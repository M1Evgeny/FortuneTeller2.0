package by.pvt.fortune.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.pvt.fortune.logic.impl.FortuneServiceImpl;

import static by.pvt.fortune.util.FortuneSupport.*;

public class FortuneTeller {
	private List<Chamomile> chamomile;
	private Map<Integer, List<String>> fortunes;
	private List<Client> clients = new ArrayList<>();
	private int capacity;

	public FortuneTeller() {
		capacity = getRandomNumber();
		chamomile = createChamomiles(capacity);
		fortunes = setFortunes();
	}

	public FortuneTeller(int capacity) {
		this.capacity = capacity;
		chamomile = createChamomiles(capacity);
		fortunes = setFortunes();
	}

	public List<Chamomile> getChamomile() {
		return chamomile;
	}

	public void setChamomile(List<Chamomile> chamomile) {
		this.chamomile = chamomile;
	}

	public Map<Integer, List<String>> getFortunes() {
		return fortunes;
	}

	public Map<Integer, List<String>> setFortunes() {
		fortunes = new HashMap<>();
		fortunes.put(1, Fortune.getLoveFortune());
		fortunes.put(2, Fortune.getKidsFortune());
		return fortunes;
	}

	public List<Client> getClients() {
		return clients;
	}

	public int getCapacity() {
		return capacity;
	}

	public void tellFortunes(FortuneTeller ft, Client client) {
		FortuneServiceImpl fSI = new FortuneServiceImpl(ft);
		fSI.tellFortunes(client);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((chamomile == null) ? 0 : chamomile.hashCode());
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((fortunes == null) ? 0 : fortunes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FortuneTeller other = (FortuneTeller) obj;
		if (capacity != other.capacity)
			return false;
		if (chamomile == null) {
			if (other.chamomile != null)
				return false;
		} else if (!chamomile.equals(other.chamomile))
			return false;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		if (fortunes == null) {
			if (other.fortunes != null)
				return false;
		} else if (!fortunes.equals(other.fortunes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FortuneTeller chamomile capacity=" + capacity + ", fortunes=" + fortunes + ", clients=" + clients;
	}

}
