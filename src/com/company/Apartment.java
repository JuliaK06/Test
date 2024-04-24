package com.company;

public class Apartment implements Comparable<Apartment>{
    private String city;
    private int numberOfRooms;
    private int area;
    private int  price;
    private String telephoneNumber;

    public Apartment(String city, int numberOfRooms, int area, int price, String telephoneNumber) {
        this.city = city;
        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.price = price;
        this.telephoneNumber = telephoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "city='" + city + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", area=" + area +
                ", price=" + price +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Apartment o) {
        if(getPrice()>o.getPrice()){
            return 1;
        } else if(getPrice()==o.getPrice()){
            return 0;
        }else {return -1;}
    }
}
