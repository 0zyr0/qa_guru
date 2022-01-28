package ozero.qa;


import java.lang.module.Configuration;
import java.math.BigDecimal;

public class HelloWorld {

        //Примитивные типы данных
        boolean boolVar = true;
        char aChar = 'T';
        byte aByte = 1;
        int anInt = 1;
        short aShort = 1;
        long aLong = 1L;
        float aFloat = 1.0F; //Если математические операции с float и double встречаются, то скорее всего м.б. проблемы в программе
        double aDouble = 1.0D;
        double doubleWithoutD = 1.0;

//Объекты
    String str = "test";

    static class Human {
        int age; //0
        String text; //null

        public void say() {
            System.out.println(text);
        }

        public void incrementAge() {
            age = age++;
        }

        public void sayAge() {
            System.out.println("My age is " + age);
        }

    }



    public static void main(String[] args) {
        System.out.println("Hello New QA!");

        Human max = new Human(); //создали экземпляр класса Human
        max.text = "Yo!";
        max.age = 28;

        System.out.println(max.age);
        System.out.println(max.text);

        max.incrementAge();

        max.sayAge();
    }

        void myNewVoid () {
            System.out.println("Hello New QA!");
        }


}
