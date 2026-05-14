package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility { // to generate the fake random data using faker class
	Faker faker = new Faker();

	public String randomusername() {
		return faker.name().username();
	}

	public String randomPassword() {
		return faker.internet().password();
	}

	public String fullname() {
		return faker.name().fullName();
	}

	public String email() {
		return faker.internet().emailAddress();
	}

	public String mobileNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public String randomemail() {
		return email();

	}

}
