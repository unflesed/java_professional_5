package java_professional_5.task_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int check = 0;
        do {
            System.out.println("Выберите класс о котором хотите узнать информацию: ");
            System.out.println("1 - Integer\n2 - String\n3 - Double\n4 - Object\n5 - Выход");
            check = sc.nextInt();
            switch (check) {
                case 1:
                    Class clInt = Integer.class;
                    Field[] fieldsInt = clInt.getDeclaredFields();
                    Constructor[] constructorsInt = clInt.getDeclaredConstructors();
                    Method[] methodsInt = clInt.getDeclaredMethods();
                    info(fieldsInt,constructorsInt,methodsInt);
                    break;
                case 2 :
                    Class clStr = String.class;
                    Field[] fieldsStr = clStr.getDeclaredFields();
                    Constructor[] constructorsStr = clStr.getDeclaredConstructors();
                    Method[] methodsStr = clStr.getDeclaredMethods();
                    info(fieldsStr,constructorsStr,methodsStr);
                    break;
                case 3 :
                    Class clDou = Double.class;
                    Field[] fieldsDou = clDou.getDeclaredFields();
                    Constructor[] constructorsDou = clDou.getDeclaredConstructors();
                    Method[] methodsDou = clDou.getDeclaredMethods();
                    info(fieldsDou,constructorsDou,methodsDou);
                    break;
                case 4 :
                    Class clObj = Object.class;
                    Field[] fieldsObj = clObj.getDeclaredFields();
                    Constructor[] constructorsObj = clObj.getDeclaredConstructors();
                    Method[] methodsObj = clObj.getDeclaredMethods();
                    info(fieldsObj,constructorsObj,methodsObj);
                    break;
            }
        }while(check != 5);
    }
    static void info(Field[] fields, Constructor[] constructors, Method[] methods){
        int counter = 1;
        for (Field field : fields) {
            System.out.println("Тип " + counter++ + " поля: " + field.getType().getName() + " Имя: " + field.getName());
        }
        counter = 1;
        for (Constructor constr : constructors) {
            Class[] params = constr.getParameterTypes();
            System.out.println("Параметры " + counter + " конструктора: ");
            for (Class param : params) {
                System.out.print(param.getName() + " ");
            }
            System.out.println();
            counter++;
        }
        counter = 1;
        for (Method method : methods) {
            System.out.println("Имя " + counter + " метода: " + method.getName() + " Тип: " +
                    method.getReturnType().getName());
            Class[] params = method.getParameterTypes();
            System.out.println("Параметры " + counter + " метода: ");
            for (Class param : params) {
                System.out.print(param.getName() + " ");
            }
            System.out.println();
            counter++;
        }
    }
}
