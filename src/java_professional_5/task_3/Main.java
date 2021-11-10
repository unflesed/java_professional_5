package java_professional_5.task_3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    private String field1 = "fdfvd";
    public int field2 = 31;
    protected double field3 = 21.2;
    public Main(){}
    public Main(String field1, int field2, double field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }
    public int getField2() {
        return field2;
    }
    public void setField2(int field2) {
        this.field2 = field2;
    }
    public double getField3() {
        return field3;
    }
    public void setField3(double field3) {
        this.field3 = field3;
    }
    public static void main(String[] args) throws IllegalAccessException {
        Main main = new Main();
        Class<?> cl = Main.class;
        Field[] fields = cl.getDeclaredFields();
        int counter = 1;
        for (Field field : fields) {
            System.out.println("Тип " + counter++ + " поля: " + field.getType().getName() + " Имя: " + field.getName() +
                    " Значение: " + field.get(main));
            int mod = field.getModifiers();
            if (Modifier.isPublic(mod))
                System.out.println("Модификатор - Public");
            if (Modifier.isPrivate(mod))
                System.out.println("Модификатор - Private");
            if (Modifier.isProtected(mod))
                System.out.println("Модификатор - Protected");
        }
        counter = 1;
        Constructor<?>[] constructors = cl.getConstructors();
        for (Constructor<?> constr : constructors) {
            Class[] getTypes = constr.getParameterTypes();
            System.out.println("Типы " + counter + " конструктора: ");
            for (Class getType : getTypes) {
                System.out.print(getType.getName() + " ");
            }
            System.out.println();
            counter++;
            int mod = constr.getModifiers();
            if (Modifier.isPublic(mod))
                System.out.println("Модификатор - Public");
        }
        counter = 1;
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Class[] getTypes = method.getParameterTypes();
            System.out.println("Типы " + counter + " Метода: ");
            for (Class getType : getTypes) {
                System.out.print(getType.getName() + " ");
            }
            System.out.println();
            counter++;
            int mod = method.getModifiers();
            if (Modifier.isPublic(mod))
                System.out.println("Модификатор - Public");
        }
    }
}
