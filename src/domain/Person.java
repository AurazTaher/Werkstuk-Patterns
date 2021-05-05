package domain;


import domain.observer.Observer;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Observer {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person){
            Person person = (Person)o;
            return person.lastName.equals(this.lastName) && this.firstName.equals(person.firstName) && this.birthDate.equals(person.birthDate);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }

    @Override
    public void update(Object value) { // value should be an order
        Order order = (Order)value;
        if (order.getOrderer().equals(this)) {
            double prijs = order.getTotalPrice();
            System.out.println("The order of " + this.firstName + " " + this.lastName + " is ready for pickup and the total price is €" + prijs);
        }
    }
}
