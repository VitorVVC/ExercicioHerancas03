package Application;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the number of tax payers: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        List<TaxPayer> list = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Tax payer #" + (i + 1) + " data: ");
            System.out.print("Individual or company (i/c)? ");
            Character resposta = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String nome = sc.nextLine();
            System.out.print("Anual Income: ");
            Double anIncome = sc.nextDouble();
            try {
                if (resposta == 'i' || resposta == 'I') {
                    System.out.print("Health expenditures: ");
                    Double healthExpenditures = sc.nextDouble();
                    TaxPayer payerIndivudual = new Individual(nome, anIncome, healthExpenditures);
                    list.add(payerIndivudual);
                } else if (resposta == 'c' || resposta == 'C') {
                    System.out.print("Number of employees: ");
                    Integer numberEmp = sc.nextInt();
                    TaxPayer payerComp = new Company(nome, anIncome, numberEmp);
                    list.add(payerComp);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro no reconhecimento de caracter: " + e.getMessage());
            }
        }
        System.out.println("TAXES PAID: ");
        double sum = 0;
        for (TaxPayer printPaids : list) {
            System.out.printf("%s: $ %.2f%n",printPaids.getName(),printPaids.tax());
            sum += printPaids.tax();
        }
        System.out.printf("\nTOTAL TAXES: $ %.2f%n",sum);
    }
}