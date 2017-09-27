package api.dataBase;

import api.Person.Address;
import api.Person.Person;

public class Main {

	public static void main(String[] args) {
		Person person = new Person(3, "hossein", "sharifi", 9124612272L	, new Address());

		SaveObject so = new SaveObject();

		try {
			so.setJavaObject(person);
			so.saveObject();
			so.getObject(person.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
