package id.hikari.hikari.test.latihan;

import java.util.Random;

public class QuestionContent {

    public static void package1Low(Integer a,Integer b){

        String result  = "You're right";
        String resultElse = "You're failed";

        String soal = "Integer a = "+a+";\n" +
                "        if(a == "+b+"){\n" +
                "            System.out.println(\""+result+"\");\n" +
                "        }else{\n" +
                "            System.out.println(\""+resultElse+"\");\n" +
                "        }";

        System.out.println(soal);

        if(a == b){
            System.out.println(result);
        }else{
            System.out.println(resultElse);
        }

        System.out.println("\n\n\n\n");

    }

    public static  void shortAnswerPackage1(){
        Integer number = 1;
        Boolean captain = true;
        if(number == 1){
            if(captain){
                number = 10;
            }
        }
        if(number >= 10){
            number = 1;
        }

        if(captain){
            number = 100;
        }
        System.out.println(number);
    }

    public static void shortAnswerPackage2(){
        Boolean isChicken = false;
        String chickenVoice = "Kok kok";
        Boolean isCat = false;
        String catVoice = "Meow meow";
        if(!isChicken){
            isCat = true;
        }
        if(!isCat){
            System.out.println(catVoice);
        }else{
            System.out.println(chickenVoice);
        }
    }

    public static void shortAnswerPackage3(){
        for (int i = 1; i <= 7; i++) {
            if(i%2==0){
                System.out.print(i);
            }else if(i%3==0){
                System.out.print("0");
            }else{
                System.out.print("*");
            }
        }
    }

    public static void shortAnswerPackage4(){
        for (int i = 1; i <=2 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            System.out.print("*");
        }
    }

    public static void shortAnswerPackage5(){
        for (int i = 1; i <=3 ; i++) {
            for (int j = 1; j <=2 ; j++) {
                if(i%2==0){
                    System.out.print(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        shortAnswerPackage5();

    }
}
