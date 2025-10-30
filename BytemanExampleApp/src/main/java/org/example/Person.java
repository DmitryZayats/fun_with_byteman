package org.example;
public class Person {
    int Age;
    String FirstName;
    String LastName;
    public Person(int Age, String FirstName, String LastName){
        this.Age = Age;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public Person growOneYearOlder(){
        Age++;
        return this;
    }

    public Person changeLastName(String newLastName){
        LastName = newLastName;
        return this;
    }

    public void displayPerson(){
        System.out.println("First Name : " + FirstName);
        System.out.println("Last Name : " + LastName);
        System.out.println("Age : " + Age);
    }
}
