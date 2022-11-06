import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Доброе время суток, вас приветствует калькулятор. " +
                "Введите арифметическое выражение из двух чисел, " +
                "каждое из которых находится в интервале от 1 до 10");
        Scanner scanner = new Scanner(System.in);
        String vh = scanner.nextLine();
        String otvet = calc(vh);
        System.out.println(otvet);
    }

    public static String calc(String input) {
        String[] bukveniCifri;//убрали все пробелы из входящего выражения и разбили строку на слова по знакам +,-,*,/
        bukveniCifri = input.replaceAll("\\s+", "").split("\\+|\\*|/|-");
        VhChecks.getChecks(bukveniCifri);//проверили выражение соответствует 2м операндам и знаку


        String[] valuesRimskieCifri = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int count =0;
        for (int i = 0; i < bukveniCifri.length; i++) {

            for (int j = 0; j < valuesRimskieCifri.length; j++) {
                if (bukveniCifri[i].equals(valuesRimskieCifri[j])) {
                    count++;
                    RimskieCifri ano = RimskieCifri.valueOf(valuesRimskieCifri[j]);
                    bukveniCifri[i] = ano.getArabskie();
                    //  System.out.println(bukveniCifri[i]);
                }
            }
        }
            if (count>=1&&count<2) {
                try {
                    throw new NumberFormatException();

                } catch (NumberFormatException e) {
                    System.err.println("throws Exception //т.к. используются одновременно разные системы счисления");
                    System.exit(2);
                }
            }

        int chislo1 = Integer.parseInt(bukveniCifri[0]);//переделываем слова в числа
        int chislo2 = Integer.parseInt(bukveniCifri[1]);


        if (chislo1 < 1 || chislo1 > 10) {
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("throws Exception //заданные числа не входят в диапазан от 1 до 10");
                System.exit(3);
            }
        } else if (chislo2 < 1 || chislo2 > 10) {
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("throws Exception //заданные числа не входят в диапазан от 1 до 10");
                System.exit(3);
            }
        }
        String otvet = Calculation.getCalculation(valuesRimskieCifri, input, chislo1, chislo2);
        return otvet;
    }
}




