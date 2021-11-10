package practise.task_1;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cl = Cat.class;
        Cat cat = new Cat("cat", 5);
        System.out.println("Имя класс: " + cl.getName());
        int mod = cl.getModifiers();
        if (Modifier.isPublic(mod))
            System.out.println("Модификатор класса: public");
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            System.out.println("Поле: " + field);
        }
        Field[] fieldsPrivate = cl.getDeclaredFields();
        for (Field field : fieldsPrivate) {
            System.out.println("Приватное поле: " + field);
        }
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Конструктор: " + constructor);
        }
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Метод: " + method);
        }
        Field field = cl.getField("name");
        field.set(cat, "Vaska");
        Field fieldPrivate = cl.getDeclaredField("age");
        fieldPrivate.setAccessible(true);
        fieldPrivate.set(cat, 2);
        System.out.println("Имя кота: " + cat.name + " Возраст: " + fieldPrivate.get(cat));
        Method method = cl.getDeclaredMethod("sayMeow");
        method.setAccessible(true);
        method.invoke(cat);
    }
}
