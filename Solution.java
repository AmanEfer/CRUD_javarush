package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {

    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        if (args[0].equals("-c")) {
            String name = args[1];
            Date bd = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH).parse(args[3]);
            Person person = args[2].equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        if (args[0].equals("-r")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex = person.getSex() == Sex.MALE ? "м" : "ж";
            String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate());
            System.out.printf("%s %s %s", person.getName(), sex, bd);
        }
        if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String name = args[2];
            Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
            Date bd = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH).parse(args[4]);
            person.setName(name);
            person.setSex(sex);
            person.setBirthDate(bd);
        }
        if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
}
