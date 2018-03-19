package by.pvt.fortune.model;

import java.util.ArrayList;
import java.util.List;
import static by.pvt.fortune.util.FortuneSupport.*;

public class Chamomile {

	private List<String> petal;
	private int capacity;

	public Chamomile() {
		capacity = getRandomNumber();
		petal = new ArrayList<>(capacity);
	}

	public Chamomile(int capacity) {
		this.capacity = capacity;
		petal = new ArrayList<>(capacity);
	}

	public List<String> getChamomilePetal() {
		return petal;
	}

	public void setPetttal(String s) {
		if (petal != null) {
			petal.add(s);
		}
	}

	public String getPetal(int index) {
		String s = null;
		if (index < petal.size()) {
			s = petal.get(index);
		}
		return s;
	}

	public int size() {
		return capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((petal == null) ? 0 : petal.hashCode());
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
		Chamomile other = (Chamomile) obj;
		if (capacity != other.capacity)
			return false;
		if (petal == null) {
			if (other.petal != null)
				return false;
		} else if (!petal.equals(other.petal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chamomile capacity=" + capacity;
	}

}
