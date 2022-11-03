import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        System.out.println("Доброе время суток, вас приветсвует калькулятор. " +
                "Введите арифметическое выражение из двух чисел, " +
                "каждое из которых находится в интервале от 1 до 10");
        Scanner scanner = new Scanner(System.in);
        String vh = scanner.nextLine();
        String otvet = calc(vh);
    }

    public static String calc(String input) {
        String[] bukveniCifri;//убрали все пробелы из входящего выражения и разбили строку на слова по знакам +,-,*,/
        bukveniCifri = input.replaceAll("\\s+", "").split("\\+|\\*|/|-");

        if (bukveniCifri.length > 2) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        if (bukveniCifri.length == 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }

        String[] valuesRimskieCifri = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (int i = 0; i < bukveniCifri.length; i++) {

            for (int j = 0; j < valuesRimskieCifri.length; j++) {
                if (bukveniCifri[i].equals(valuesRimskieCifri[j])) {

                    RimskieCifri ano = RimskieCifri.valueOf(valuesRimskieCifri[j]);
                    bukveniCifri[i] = ano.getArabskie();
                    System.out.println(bukveniCifri[i]);
                }
            }
            if (i < 1 && i > 0) {
                try {
                    throw new NumberFormatException("throws Exception //т.к. используются одновременно разные системы счисления");

                } catch (NumberFormatException e) {
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                }
            }
        }
        int chislo1 = Integer.parseInt(bukveniCifri[0]);//переделываем слова в числа
        int chislo2 = Integer.parseInt(bukveniCifri[1]);


        if (chislo1 < 1 && chislo1 > 10 && chislo2 < 1 && chislo2 > 10) {
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("throws Exception //заданные числа не входят в диапазан от 1 до 10");
            }
        }
        String otvet =Calculation.getCalculation(valuesRimskieCifri, input, chislo1, chislo2);
        return otvet;

    }
}
//            int result;
//            String[] bukveniCifriVh = input.replaceAll("\\s+", "").split("\\+|\\*|/|-");
//            String vichisleniieSlov;
//
//            if (plus > 0) {
//                result = chislo1 + chislo2;
//                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                    RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                    return Rim.name();
//                } else {
//                    return vichisleniieSlov;
//                }
//
//            } else if (minus > 0) {
//                result = chislo1 - chislo2;
//                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//
//                if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)&&result>0) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                    try {
//                        throw new IOException();
//
//                        RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                        System.out.println("Ответ равен: " + Rim);
//                    } catch (IOException e) {
//                        System.out.println("//т.к. в римской системе нет отрицательных чисел");
//                    }
//
//                } else {
//                    System.out.println("Ответ равен: " + result);
//                }
//            } else if (umnogh > 0) {
//                result = chislo1 * chislo2;
//                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                    RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                    return Rim.name();
//                } else {
//                    return vichisleniieSlov;
//                }
//            } else if (delenie > 0) {
//                result = chislo1 / chislo2;
//                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                    RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                    return Rim.name();
//                } else {
//                    return vichisleniieSlov;
//                }
//            }
//        }
//    }
//}




//        String vhodviraghenie = scanner.nextLine();
//        String[] bukveniCifri;//убрали все пробелы из входящего выражения и разбили строку на слова по знакам +,-,*,/
//        bukveniCifri = vhodviraghenie.replaceAll("\\s+", "").split("\\+|\\*|/|-");
//        // while(true) {
//        if (bukveniCifri.length > 2) {
//            try {
//                throw new IllegalArgumentException();
//            } catch (IllegalArgumentException e) {
//                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
//            }
//        }
//        if (bukveniCifri.length == 1) {
//            try {
//                throw new IOException();
//            } catch (IOException e) {
//                System.out.println("throws Exception //т.к. строка не является математической операцией");
//            }
//        }
//        //}
//        //for (String element:bukveniCifri) {
//        //System.out.println(element);
//        // }
//        String[] valuesRimskieCifri = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
//        int plus = vhodviraghenie.indexOf("+");//ищем плюс
//        int minus = vhodviraghenie.indexOf("-");
//        int umnogh = vhodviraghenie.indexOf("*");
//        int delenie = vhodviraghenie.indexOf("/");
//
//
//        for (int i = 0; i < bukveniCifri.length; i++) {
//
//            for (int j = 0; j < valuesRimskieCifri.length; j++) {
//                if (bukveniCifri[i].equals(valuesRimskieCifri[j])) {
//
//                    RimskieCifri ano = RimskieCifri.valueOf(valuesRimskieCifri[j]);
//                    bukveniCifri[i] = ano.getArabskie();
//                    System.out.println(bukveniCifri[i]);
//                }
//            }
//                 if (i < 1&&i>0) {
//                try {
//                    throw new NumberFormatException("throws Exception //т.к. используются одновременно разные системы счисления");
//
//                } catch (NumberFormatException e) {
//                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
//                }
//                 }
//                    int chislo1 = Integer.parseInt(bukveniCifri[0]);//переделываем слова в числа
//                    int chislo2 = Integer.parseInt(bukveniCifri[1]);
//
//
//                    if (1 <= chislo1 && chislo1 <= 10 && 1 <= chislo2 && chislo2 <= 10) {
//                        int result;
//                        String[] bukveniCifriVh = vhodviraghenie.replaceAll("\\s+", "").split("\\+|\\*|/|-");
//                        String vichisleniieSlov;
//
//                        if (plus > 0) {
//                            result = chislo1 + chislo2;
//
//                            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                                System.out.println("Ответ равен: " + Rim);
//                            } else {
//                                System.out.println("Ответ равен: " + result);
//                            }
//
//                        } else if (minus > 0) {
//                            result = chislo1 - chislo2;
//                            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                                System.out.println("Ответ равен: " + Rim);
//                            } else {
//                                System.out.println("Ответ равен: " + result);
//                            }
//                        } else if (umnogh > 0) {
//                            result = chislo1 * chislo2;
//                            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                                System.out.println("Ответ равен: " + Rim);
//                            } else {
//                                System.out.println("Ответ равен: " + result);
//                            }
//                        } else if (delenie > 0) {
//                            result = chislo1 / chislo2;
//                            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
//                                vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
//                                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
//                                System.out.println("Ответ равен: " + Rim);
//                            } else {
//                                System.out.println("Ответ равен: " + result);
//                            }
//                        }
//                    } else {
//                        System.out.println("throws Exception //заданные числа не входят в диапазан от 1 до 10");
//                    }

       // }


