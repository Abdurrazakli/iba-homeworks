package homework12.util;

import homework12.entity.Family;
import homework12.entity.Human;
import homework12.entity.Man;
import homework12.entity.Woman;
import homework12.entity.pets.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomComponents {
    public static List<String> manNames = Arrays.asList("Adil","Ayxan","Aydin","Rustem","Ferrux","John","Jason");
    public static List<String> surnames = Arrays.asList("Abdayev","Hasanov","Aydinli","Rustemli","Jackson","Jacob","Statham");
    public static List<String> womanNames = Arrays.asList("Aytac","Nigar","Natavan","Seide","Susen","Gozel","Nazile");
    public static List<String> nicknames = Arrays.asList("Yummy","Little","I need Love","Puppy","NigaMeddin","Chuck","Toplan");

    public static String getRandomManName(){
        return manNames.get((int)(Math.random() * manNames.size()));
    }
    public static String getRandomSurname(){
        return surnames.get((int)(Math.random() * surnames.size()));
    }
    public static String getRandomWomanName(){
        return womanNames.get((int)(Math.random() * womanNames.size()));
    }
    public static Human getRandomHuman(){
        return ((int)(Math.random() * 2)) == 0 ? getRandomMan() : getRandomWoman();
    }
    public static Pet getRandomPet(){
         String nickname = nicknames.get((int)(Math.random() * nicknames.size()));
         int age = (int)(Math.random() * 8);
         int trickLevel = (int)(Math.random() * 100);
         Set<String> habits = Arrays.stream(new String[]{"sleep"}).collect(Collectors.toSet());
         Pet pet;
          Species species = Species.values()[(int)(Math.random() * Species.values().length)];
          switch (species){
              case DOG: pet = new Dog(nickname);break;
              case FISH: pet = new Fish(nickname);break;
              case ROBOCAT: pet = new RoboCat(nickname);break;
              default: pet = new DomesticCat(nickname);break;
          }
          pet.setAge(age);
          pet.setHabits(habits);
          pet.setTrickLevel(trickLevel);
          return pet;
    }
    public static Family getRandomFamily(){
        Family family = new Family(getRandomWoman(), getRandomMan());
        Stream.generate(()->RandomComponents.getRandomHuman())
                .limit((int)(Math.random() * 5))
                .forEach(child->family.addChild(child));
        family.setPets(
                Stream.generate(()->RandomComponents.getRandomPet())
                .limit(3)
                .collect(Collectors.toList()));

        return family;
    }
    public static Woman getRandomWoman(){
        String name = getRandomWomanName();
        String surname = getRandomSurname();
        String year = Integer.toString(1950 + (int)(Math.random() * 51));
        String months[] = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
        String month = months[(int)(Math.random() * 12)];
        String day = Integer.toString((int)(Math.random()*18) + 10);
        String dateOfBirth = String.format("%s/%s/%s",day,month,year);
        int iq = 10 + (int)(Math.random() * 91);
        return new Woman(name,surname,dateOfBirth,iq);
    }
    public static Man getRandomMan(){
        String name = getRandomManName();
        String surname = getRandomSurname();
        String year = Integer.toString(1950 + (int)(Math.random() * 51));
        String months[] = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
        String month = months[(int)(Math.random() * 12)];
        String day = Integer.toString((int)(Math.random()*18) + 10);
        String dateOfBirth = String.format("%s/%s/%s",day,month,year);
        int iq = 10 + (int)(Math.random() * 91);
        return new Man(name,surname,dateOfBirth,iq);
    }
}
