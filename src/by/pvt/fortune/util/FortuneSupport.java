package by.pvt.fortune.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import by.pvt.fortune.model.Chamomile;
import by.pvt.fortune.model.Fortune;

public class FortuneSupport {
	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();
	private static final int MIN_NUM_PETAL = 1;

	public static List<Chamomile> createChamomiles(int capacity) {
		List<Chamomile> chamomile = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			chamomile.add(new Chamomile());
		}
		return chamomile;
	}

	public static int readChoiseNumber() {
		int choice = 0;
		do {
			System.out.println("Make your choice thoughtfully!");
			while (!sc.hasNextInt()) {
				System.out.println("This is not a number!");
				sc.next();
			}
			choice = sc.nextInt();
		} while (choice > 2 || choice < 1);
		return choice;
	}

	public static int getRandomNumber() {
		return MIN_NUM_PETAL + rd.nextInt(10);
	}

	public static Map<Integer, List<String>> setFortunes() {
		Map<Integer, List<String>> fortunes = new HashMap<>();
		fortunes.put(1, Fortune.getLoveFortune());
		fortunes.put(2, Fortune.getKidsFortune());
		return fortunes;
	}

}
