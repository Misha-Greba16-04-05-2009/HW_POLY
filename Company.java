import taxes.TaxSystem;

public class Company {
    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        System.out.println("\nПрименение сделок для компании: " + title);

        for (Deal deal : deals) {
            System.out.println(deal.getComment());
            shiftMoney(deal.getDebitChange());
            shiftMoney(-deal.getCreditChange());
        }

        int profitBeforeTax = debit - credit;
        payTaxes();
        return profitBeforeTax;
    }

    // Геттеры для тестирования (необязательно, но полезно)
    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public String getTitle() {
        return title;
    }
}