package homework11.entity;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class Human {
   private String name;
   private String surname;
   private long birthDate;
   private int age;
   private int iq;
   private Family family;
   private Map<String,String> schedule;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.schedule = Collections.EMPTY_MAP;
    }
    public Human(){}
    public Human(String name,String surname,String dateOfBirth,int iq){
        this(name,surname);
        setIq(iq);
        LocalDate birthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.birthDate = Timestamp.valueOf(birthDate.atStartOfDay()).getTime();

    }
    public Human(String name, String surname, long birthDate, int age, int iq, Map<String,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.age = age;
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public long getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getIq() {
        return iq;
    }
    public void setIq(int iq) {
        this.iq = iq;
    }
    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }
    public void setSchedule(Map<String,String> schedule) {
        this.schedule = schedule;
    }
    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void greetPet(){
        System.out.println("Actually,there is not any pet :D");
    }
    public String describeAge(){
        LocalDate date = Instant.ofEpochSecond(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(date,LocalDate.now());
        return String.format("%s years, %s months, %s days",period.getYears(),period.getMonths(),period.getDays());
    }
    @Override
    public String toString() {
        String date = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("Human{name='%s', surname='%s', birth date=%s, age=%d, iq=%d, schedule=%s}", name, surname, date, age, iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate;
    }
    @Override
    public int hashCode() {
        return Objects.hash(birthDate);
    }
}
