package by.pvt.fortune.logic.impl;

import static by.pvt.fortune.util.FortuneSupport.readChoiseNumber;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import by.pvt.fortune.logic.FortuneService;
import by.pvt.fortune.model.Chamomile;
import by.pvt.fortune.model.Client;
import by.pvt.fortune.model.FortuneTeller;

public class FortuneServiceImpl implements FortuneService {

	private static final int INCREASE_BY_ONE_DAY = 1;
	private FortuneTeller witch;

	public FortuneServiceImpl(FortuneTeller witch) {
		this.witch = witch;
	}

	@Override
	public void tellFortunes(Client client) {
		if (!witch.getChamomile().isEmpty() && checkDate(client)) {
			getTopics();
			int choice = readChoiseNumber();
			List<String> answers = getFortune(choice);
			setChamomileAnswers(answers);
			fortuneTelling();
			removeChamomile();
			addClient(client);
			setUsageDate(client);
		} else {
			System.out.println("go away!");
		}
	}

	private void getTopics() {
		System.out.println("Choose a topic of divination:");
		System.out.println("1 - Love - it will answer the question: are you in love or not");
		System.out.println("2 - Kids - it will answer the question: how many children will you have?");
		System.out.println("You should enter one of the above options");
		System.out.println();
	}

	private List<String> getFortune(int choice) {
		List<String> answers = null;
		if (choice > 0 && choice < 3) {
			switch (choice) {
			case 1:
				answers = witch.getFortunes().get(1);
				break;

			case 2:
				answers = witch.getFortunes().get(2);
				break;
			}
		}
		return answers;
	}

	private void setChamomileAnswers(List<String> answers) {
		int fortuneNumber = 0;
		if (answers != null && !witch.getChamomile().isEmpty()) {
			Chamomile ch = witch.getChamomile().get(0);
			for (int i = 0; i < ch.size(); i++) {
				if (fortuneNumber == answers.size()) {
					fortuneNumber = 0;
				}
				if (fortuneNumber < answers.size()) {
					ch.setPetttal(answers.get(fortuneNumber));
				}
				fortuneNumber++;
			}
		} else {
			System.out.println("Im not in the mood!");
		}
	}

	private void fortuneTelling() {
		if (!witch.getChamomile().isEmpty() && witch.getChamomile().get(0) != null) {
			Chamomile ch = witch.getChamomile().get(0);
			int size = ch.size();
			for (int i = 0; i < size; i++) {
				if (ch.getPetal(i) != null) {
					System.out.println("I'm guessing!");
					if (i == ch.size() - 1) {
						System.out.println(ch.getPetal(size - 1));
						System.out.println();
					}
				}
			}
		}
	}

	private void removeChamomile() {
		if (!witch.getChamomile().isEmpty()) {
			witch.getChamomile().remove(0);
		}
	}

	private void setUsageDate(Client client) {
		Date testDate = new Date();
		if (client != null) {
			client.setTestDate(testDate);
		}
	}

	private boolean checkDate(Client client) {
		if (client != null) {
			Date curentDate = new Date();
			Date fortuneDate = getClientsDate(client);
			if (fortuneDate != null) {
				if (curentDate.after(fortuneDate)) {
					return true;
				}
				return false;
			}
		}
		return true;
	}

	private Date getClientsDate(Client client) {
		Date fortuneDate = client.getTestDate();
		Calendar cal = Calendar.getInstance();
		if (fortuneDate != null) {
			cal.setTime(fortuneDate);
			cal.add(Calendar.DAY_OF_MONTH, INCREASE_BY_ONE_DAY);
			return cal.getTime();
		}
		return null;
	}

	private void addClient(Client client) {
		if (client != null) {
			witch.getClients().add(client);
		}
	}

}
