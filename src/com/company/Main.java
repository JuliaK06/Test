package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {



    public static void main(String[] args) {
        Path resourceDirectory= Paths.get("src");
        String absolutePath=resourceDirectory.toFile().getAbsolutePath();
        File f1=new File(absolutePath+"/testData_Apartments.txt");
	Scanner sc=null;
        List<Apartment> aprts=new ArrayList<>();
    Map<String,Integer> numApartments=new HashMap<>();
Set<String> brokers=new HashSet<>();
        //това е писък с телефонни номера

            try{
sc=new Scanner(f1);
while(sc.hasNext()){
    String city=sc.next();
    int  rooms=sc.nextInt();
    int area=sc.nextInt();
    int cost=sc.nextInt();
    String tel=sc.next();

    Apartment a=new Apartment(city,rooms,area,cost,tel);
    if(rooms==3 && area>=100 && (city.equals("Бургас") || city.equals("София") || city.equals("Варна"))){
        aprts.add(a);
    }
    if(!numApartments.containsKey(city)){
        numApartments.put(city,1);
    } else{
    numApartments.put(city,numApartments.get(city)+1);
    }

    }
if(aprts.size()==0){
    throw new UnsuitableApartmentException();
}


  }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch(UnsuitableApartmentException e){
                System.out.println("No suitable apartmenhts");
            }finally{
             //   sc.close();
            }
            Collections.sort(aprts);
            //сортира апартамнети във възходящ ред според цената
for(int i=0;i<5;i++) {
    if (!brokers.contains(aprts.get(i).getTelephoneNumber())) {
 brokers.add(aprts.get(i).getTelephoneNumber());
 //проверява дали в сет има веюе тефонен номер,като обхожда първите пет елемнта на веюе сортитания списък
    }
} /*for(Apartment a:aprts){
            System.out.println(a.toString());
        }*/
        PrintWriter output=null;
            try{
                Map<String, Integer> cityApCounter = new HashMap<>();

                List<Map.Entry<String, Integer>> list = new ArrayList<>(numApartments.entrySet());

                list.sort(Map.Entry.comparingByValue());

 String city1=list.get(3).getKey();
                for (Map.Entry<String, Integer> entry : list) {
                    cityApCounter.put(entry.getKey(), entry.getValue());
                }
                numApartments=cityApCounter;
                File file2=new File(absolutePath+"/output.txt");
                output=new PrintWriter(file2);

             /*   System.out.println(city1);
                for(String s:brokers){
                System.out.println( s);}*/
                output.println(city1);
              for(String s:brokers){
                    output.println( s);}
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally{
               output.close();
            }

    }
    }

