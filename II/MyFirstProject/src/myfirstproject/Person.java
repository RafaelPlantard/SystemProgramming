package myfirstproject;

public class Person {
    String name;
    int age;
    String phone;
    
    public Person() {
        name = "";
        age = 0;
        phone = "(12)93456-7890";
    }
    
    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    
    public Person(Person person) {
        this.name = person.name;
        this.age = person.age;
        this.phone = person.phone;
    }
}
