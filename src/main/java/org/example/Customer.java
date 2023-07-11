package org.example;


enum Gender{
    MALE, FEMALE, OTHER
}
public class Customer {
    private String name;
    private int age;
    private String city;
    private Gender gender;
    private double purchaseAmount;

    public Customer(String name,int age, String city,Gender gender,double purchaseAmount){
        this.name =name;
        this.age=age;
        this.city=city;
        this.gender=gender;
        this.purchaseAmount=purchaseAmount;

    }

    public void setName(String newName){
        this.name=newName;
    }
    public String getName(){
        return name;
    }

    public void setCity(String newCity){
        this.city=newCity;
    }

    public String getCity(){
        return city;
    }
    public void setAge(int newAge){
        this.age =newAge;
    }

    public int getAge(){
        return age;
    }


    public void setPurchaseAmount(double amount){
        this.purchaseAmount=amount;
    }

    public double getPurchaseAmount(){
        return purchaseAmount;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}


