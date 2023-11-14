package Entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(String name, Double anualIcome, Double healthExpenditures) {
        super(name, anualIcome);
        this.healthExpenditures = healthExpenditures;
    }
    @Override
    public Double tax() {
        Double taxaTemp = null;
        Double taxaFinal = null;

        try {
            if (anualIcome < 20000) {
                taxaTemp = anualIcome * 0.15;
            } else if (anualIcome >= 20000) {
                taxaTemp = anualIcome * 0.25;
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro no método TAX Individual: "+exception.getMessage());
        }
        if (healthExpenditures != null) {
            taxaFinal = taxaTemp - (healthExpenditures * 0.50);
        }
        return taxaFinal;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }
}
