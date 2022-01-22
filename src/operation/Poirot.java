package operation;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

class Watson {
    public static String bankN;
    public static String target="";
    public static String[] words;
    // I wish I had ArrayList =(
    public static String[] targets=new String[11];
    public static int l=0;
    public void getWords(String message){
        words=message.split(" ");
    }
    public boolean checkBank(String[] richCitizen,String[] bank){
        Arrays.fill(targets, "-");
        boolean f=false;
        for(int i=0;i<richCitizen.length;i++){
            if(bank[i].indexOf(bankN)!=-1) {
                targets[l] = richCitizen[i];
                l++;
                f = true;
            }
        }
        return f;
    }
    public boolean checkNames(){
        String tempName;
        String tempChar;
        boolean f=false;
        boolean globalF=false;
        int pos=-1;
        l=0;
        for(int i=0;i<targets.length;i++) {
            if(targets[i].equals("-"))break;
            f = false;
            for (int j = 0; j < words.length; j++) {
                tempName=targets[i].toLowerCase();
                for (int k = 0; k < words[j].length(); k++) {
                    pos=tempName.indexOf(words[j].charAt(k));
                    if(pos==-1){
                        f=false;
                        break;
                    }
                    else {
                        tempChar=""+words[j].charAt(k);
                        tempName=tempName.replaceFirst(tempChar,"-");
                        f=true;
                    }
                }
                if(f){
                    globalF=true;
                    l++;
                    break;
                }
            }
            if(!f)targets[i]="-";
        }

        return globalF;
    }

    public void finalSort(){
        for(int i=0;i<targets.length;i++) {
            if(!targets[i].equals("-")&& l==1)
            System.out.println("\nИмя "+targets[i]);
            else if(!targets[i].equals("-"))l--;
        }
        System.out.println("Банк №"+bankN);
    }


}

public class Poirot{
    public static Scanner scanner=new Scanner(System.in);
    public String messageContext="";
    public void getMessage(){
        scanner.useDelimiter("\n");
        System.out.println("Введите строку");
        try {
            messageContext = scanner.next();
        } catch (Exception e) {
            System.out.println("Вы ввели что-то уж совсем не то - произошла ошибка");
        }
        scanner.close();
    }
    public void watsonPower(String[] richCitizen, String[] bank){
        Watson w =new Watson();
        w.getWords(messageContext);
        if(w.words.length<2)System.out.println("Однозначно бессмыслица");
        else {
            w.bankN=String.valueOf(w.words[1].length());
            if(w.checkBank(richCitizen,bank)){
                if(w.checkNames())w.finalSort();
                else System.out.println("Имена богачей не встречаются Бессмыслица");
            }
            else System.out.println("Нет богачей, держащих деньги в банке №" + w.bankN+" --> Бессмыслица");
        }
    }
}