import java.util.Scanner;

public class Main {
    public static void task1(Scanner scanner, double precision) {
        System.out.println("Завдання №1");

        double x, fl, addition, fr = 0;

        do{
            System.out.print("Введіть значення х: ");
            x = scanner.nextDouble();
        }while (x >= 1 || x <= -1);

        fl = Math.log((1 + x) / (1 - x));

        int k = 0;

        do {
            addition = Math.pow(x, 2 * k + 1)/(2 * k + 1);
            fr += addition;

            k++;
        } while (addition >= precision);

        fr *= 2;

        System.out.println("Кількість додатнів: " + k);
        System.out.println("Різниця лівої частини до правої: " + (fl - fr));
    }

    public static void task2(Scanner scanner){
        System.out.println("Завдання №2");

        double a, b, c, d, f;

        do{
            System.out.print("Введіть значення a: ");
            a = scanner.nextDouble();

            System.out.print("Введіть значення b: ");
            b = scanner.nextDouble();
        }while (a >= b);

        do{
            System.out.print("Введіть значення c: ");
            c = scanner.nextDouble();

            System.out.print("Введіть значення d: ");
            d = scanner.nextDouble();
        }while (c >= d);

        double[] xAxis = new double[8], yAxis = new double[8];

        double xStep = (b - a) / (9);
        double yStep = (d - c) / (9);

        for (int i = 0; i < 8; i++) {
            xAxis[i] = a + (i+1) * xStep;
            yAxis[i] = c + (i+1) * yStep;
        }

        double[][] result = new double[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                result[i][j] = 5 * Math.log10(xAxis[j] + yAxis[7-i]);
            }
        }

        double[][] table = new double[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0 && i == 8) table[i][j] = 0;
                else if(j == 0) table[i][j] = yAxis[7-i];
                else if(i == 8) table[i][j] = xAxis[j-1];
                else table[i][j] = result[i][j-1];
            }
        }

        String formattedNumber;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                formattedNumber = String.format("%.2f", table[i][j]);
                System.out.printf(formattedNumber + " ");
                if(j==0) System.out.print("| ");
            }
            System.out.println();
            if(i==7)System.out.println("-----+----------------------------------------");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precision = 1E-5;

        task1(scanner, precision);

        task2(scanner);
    }
}