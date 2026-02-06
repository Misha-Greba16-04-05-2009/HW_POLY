package taxes;

public class USNIncomeMinusExpenses extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int taxBase = debit - credit;
        if (taxBase > 0) {
            return (int) Math.round(taxBase * 0.15);
        }
        return 0;
    }
}