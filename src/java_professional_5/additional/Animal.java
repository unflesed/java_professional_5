package java_professional_5.additional;

import java.lang.reflect.Field;

public class Animal {
    public String name = "Barsik";
    private int age = 11;
    protected String breed = "Main-kun";
}
class Cat extends Animal{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Animal animal = new Animal();
        Class<?> cl = Animal.class;
        Field field = cl.getField("name");
        field.setAccessible(true);
        field.set(animal, "Vaska");
        Field[] fields = cl.getDeclaredFields();
        fields[1].setAccessible(true);
        fields[1].setInt(animal, 2);
        fields[2].setAccessible(true);
        fields[2].set(animal, "Bengali");
        System.out.println("Имя: " + field.get(animal) + " Ворзраст: " +
                fields[1].getInt(animal) + " Порода: " + fields[2].get(animal));
    }
}