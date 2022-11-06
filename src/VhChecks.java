import java.io.IOException;

class VhChecks {
    public static void getChecks(String[] bukveniCifri) {
        if (bukveniCifri.length > 2) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(1);
            }
        }
        if (bukveniCifri.length == 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }
    }
        public static boolean getOtrizatelnoe (int otvet){
            if (otvet <0) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.err.println("//т.к. в римской системе нет отрицательных чисел");
                    System.exit(4);
                }
            }
            return false;
        }

    }