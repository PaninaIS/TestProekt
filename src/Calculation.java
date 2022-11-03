import java.io.IOException;

class Calculation {

    public static boolean getRimVScanner(String[] scanner, String[] rimskieCifri) {
        for (int i = 0; i < scanner.length; i++) {

            for (int j = 0; j < rimskieCifri.length; j++) {
                if (scanner[i].equals(rimskieCifri[j])) {
                    return true;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public static String getCalculation(String[] valuesRimskieCifri,String input, int chislo1,int chislo2) {
        int result;
        String otvet;
        String[] bukveniCifriVh = input.replaceAll("\\s+", "").split("\\+|\\*|/|-");
        String vichisleniieSlov;
        int plus = input.indexOf("+");//ищем плюс
        int minus = input.indexOf("-");
        int umnogh = input.indexOf("*");
        int delenie = input.indexOf("/");

        if (plus > 0) {
            result = chislo1 + chislo2;
            vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
                return otvet =Rim.name();
            } else {
                return otvet =vichisleniieSlov;
            }
        return otvet;
        } else if (minus > 0) {
            result = chislo1 - chislo2;
            vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку

            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri) && result > 0) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
                try {
                    RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
                    return otvet =Rim.name();
                    throw new IOException();

                } catch (IOException e) {
                    System.out.println("//т.к. в римской системе нет отрицательных чисел");
                }

            } else {
                return otvet =vichisleniieSlov;
            }


        } else if (umnogh > 0) {
            result = chislo1 * chislo2;
            vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
                return otvet =Rim.name();
            } else {
                return otvet =vichisleniieSlov;
            }
            return otvet;
        } else if (delenie > 0) {
            result = chislo1 / chislo2;
            vichisleniieSlov = Integer.toString(result);//переделываем полученый цифровой результат в строку
            if (Calculation.getRimVScanner(bukveniCifriVh, valuesRimskieCifri)) {//проверяем во входящем выраении есть ли римские цифры и если да, то считаем римский ответ
                RimskieCifri Rim = RimskieCifri.getRimByArab(vichisleniieSlov);// получаем согласно арабскому результату значение соответ enum
                return otvet = Rim.name();
            } else {
                return otvet = vichisleniieSlov;
            }
            return otvet;
        }
    }
}
