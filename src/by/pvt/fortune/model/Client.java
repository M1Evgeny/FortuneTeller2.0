package by.pvt.fortune.model;

import java.util.Date;

public class Client {
	private Date testDate;

	public Client() {
	}

	public Client(Date date) {
		testDate = date;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testDate == null) ? 0 : testDate.hashCode());
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
		Client other = (Client) obj;
		if (testDate == null) {
			if (other.testDate != null)
				return false;
		} else if (!testDate.equals(other.testDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client testDate=" + testDate;
	}

}
