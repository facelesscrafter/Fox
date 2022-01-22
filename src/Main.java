import operation.Poirot;
import java.util.Scanner;

public class Main {
    public static String[] richCitizen = {"Райан","Сол","Делл","Оушен","Роман","Тэсс","Мэллой","Тулур","Терк","Рубен","Тарр"};
    public static String[] bank={"1,3,5,4", "8,1,4,5","8,1,4,7","1,4,8","3,9,7,1","5,8,9","5,3,2,4","1,5,6,9","2,5,4","6,5,4,5","2,4,5,3"};

    public static void main(String[] args) {
        Poirot poirot=new Poirot();
        poirot.getMessage();
        poirot.watsonPower(richCitizen,bank);
    }
}


