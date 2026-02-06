import taxes.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование Задания 1 ===");

        // Создаем компании с разными системами налогообложения
        Company company1 = new Company("Рога и копыта", new USNIncome());
        Company company2 = new Company("ООО Василек", new USNIncomeMinusExpenses());

        // Тестируем shiftMoney
        company1.shiftMoney(100000);
        company1.shiftMoney(-50000);
        company1.shiftMoney(20000);

        company2.shiftMoney(150000);
        company2.shiftMoney(-80000);
        company2.shiftMoney(30000);

        // Выплачиваем налоги
        company1.payTaxes();
        company2.payTaxes();

        // Тестируем смену системы налогообложения
        System.out.println("\nСмена системы налогообложения для компании 1:");
        company1.setTaxSystem(new USNIncomeMinusExpenses());
        company1.shiftMoney(100000);
        company1.shiftMoney(-30000);
        company1.payTaxes();

        System.out.println("\n=== Тестирование Задания 2 ===");

        // Создаем новую компанию для тестирования сделок
        Company company3 = new Company("ИП Сидоров", new USNIncomeMinusExpenses());

        // Создаем массив сделок
        Deal[] deals = {
                new Sale("Ноутбук", 50000),
                new Expenditure("Офисное кресло", 15000),
                new Sale("Монитор", 20000),
                new Expenditure("Канцелярия", 5000),
                new Sale("Мышь", 3000)
        };

        // Применяем сделки
        int profit = company3.applyDeals(deals);
        System.out.println("Прибыль до уплаты налогов: " + profit + " руб.");

        // Тест с УСН доходы
        System.out.println("\nТест с УСН доходы:");
        Company company4 = new Company("ИП Петров", new USNIncome());
        Deal[] deals2 = {
                new Sale("Товар А", 100000),
                new Expenditure("Расходы", 40000),
                new Sale("Товар Б", 50000)
        };

        int profit2 = company4.applyDeals(deals2);
        System.out.println("Прибыль до уплаты налогов: " + profit2 + " руб.");
    }
}