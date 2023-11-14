package Entities;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company(String name, Double anualIcome, Integer numberOfEmployees) {
        super(name, anualIcome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        try {
            if (numberOfEmployees > 10) {
                return anualIcome * 0.14;
            } else {
                return anualIcome * 0.16;
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro no método TAX Company: "+exception.getMessage());
        }

    }
}
