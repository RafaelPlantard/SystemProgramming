package myfirstproject;

public class MyFirstProject {
    public static void main(String[] args) {
        Person me = new Person();
        me.name = "Rafael";
        me.age = 28;
        
        showPersonDetail(me);
        
        Person wife = new Person("Cleís Aurora Silveira Pereira", 35, "(11)97050-3366");
        
        showPersonDetail(wife);
        
        Person wifeOlder = new Person(wife);
        wifeOlder.age = 45;
        
        showPersonDetail(wifeOlder);
        
        Person meAgain = me;
        
        System.out.println(me);
        System.out.println(wife);
        System.out.println(wifeOlder);
        System.out.println(meAgain);
        
        meAgain.age = 33;
        
        showPersonDetail(me);
    }
    
    public static void showPersonDetail(Person person) {
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
        System.out.println("Phone: " + person.phone);
        System.out.println("");
    }
}
