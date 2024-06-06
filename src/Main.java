import java.nio.file.FileSystemLoopException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inObject = new Scanner(System.in);

        Employee.addEmployee("Буковцов Максим Владимирович", 1, 30000);
        Employee.addEmployee("Багнюков Артем Сергеевич", 3, 123400);
        Employee.addEmployee("Мелконян Эдгар Геворгиевич", 2, 312340);
        Employee.addEmployee("Медведев Артем Андреевич", 5, 302340);
        Employee.addEmployee("Ватутин Петр Сергеевич", 2, 32340);
        Employee.addEmployee("Филипова Анастасия Сергеевна", 1, 234500);
        Employee.addEmployee("Каткова Николь Владимировна", 4, 45600);
        Employee.addEmployee("Зубенко Михаил Петрович", 3, 45700);
        Employee.addEmployee("Гречина Диана Николаевна", 3, 254620);
        Employee.addEmployee("Долотова Анна Викторовна", 3, 235700);

        System.out.println("Выберите действие:");
        System.out.println("    1 - Вывести список сотрудников со всеми данными");
        System.out.println("    2 - Посчитать ЗП за месяц");
        System.out.println("    3 - Найти сотрудника с минимальной ЗП");
        System.out.println("    4 - Найти сотрудника с максимальной ЗП");
        System.out.println("    5 - Найти среднюю ЗП сотрудников");
        System.out.println("    6 - Вывести ФИО всех сотрудников");
        System.out.println("    7 - Проиндексировать зарплату на ?% всех сотрудников");
        System.out.println("    8 - Вывести сотрудников с ЗП меньше указанного значения:");
        System.out.println("    9 - Вывести сотрудников с ЗП больше указанного значения:");
        System.out.println("    10 - Работать отдельно с выбранным отделом:");
        System.out.println("        11 - Найти сотрудника с минимальной ЗП в отделе");
        System.out.println("        12 - Найти сотрудника с максимальной ЗП в отделе");
        System.out.println("        13 - Посчитать ЗП за месяц для отдела");
        System.out.println("        14 - Найти среднюю ЗП сотрудников отдела");
        System.out.println("        15 - Проиндексировать зарплату на ?% всех сотрудников отдела");
        System.out.println("        16 - Вывести ФИО всех сотрудников отдела");

        int number = 100;

        while (number != 0) {

            System.out.println("Введите номер действия:");
            number = inObject.nextInt();

            if (number == 1) Employee.outputOfAllElements();
            if (number == 2) System.out.println(Employee.withdrawThePOInAMonth());
            if (number == 3) System.out.println(Employee.outputTheMinimumPO().toString());
            if (number == 4) System.out.println(Employee.outputTheMaximumPO().toString());
            if (number == 5) System.out.println(Employee.outputTheAveragePO());
            if (number == 6) Employee.outputOfAllNameEmployee();
            if (number == 7) {
                System.out.println("Введите % индексации:");
                int indexationPercentage = inObject.nextInt();
                Employee.indexTheSalary(indexationPercentage);
            }
            if (number == 8){
                System.out.println("Введите порог:");
                int doorstep = inObject.nextInt();
                Employee.outputOfAllEmployeeLessValues(doorstep);
            }
            if (number == 9){
                System.out.println("Введите порог:");
                int doorstep = inObject.nextInt();
                Employee.outputOfAllEmployeeMoreValues(doorstep);
            }
            if (number == 10){
                int nameDepartment = 100;

                while (nameDepartment != 0) {
                    System.out.println("Введите подходящий отдел:");
                    nameDepartment = inObject.nextInt();
                    System.out.println("Введите номер действия:");
                    number = inObject.nextInt();

                    if (number == 11) System.out.println(Employee.outputTheMinimumPOAtDepartment(nameDepartment).toString());
                    if (number == 12) System.out.println(Employee.outputTheMaximumPOAtDepartment(nameDepartment).toString());
                    if (number == 13) System.out.println(Employee.withdrawThePOInAMonthAtDepartment(nameDepartment));
                    if (number == 14) System.out.println(Employee.outputTheAveragePOAtDepartment(nameDepartment));
                    if (number == 15) {
                        System.out.println("Введите % индексации:");
                        int indexationPercentage = inObject.nextInt();
                        Employee.indexTheSalaryAtDepartment(nameDepartment, indexationPercentage);
                    }
                    if (number == 16) Employee.outputOfAllElementsAtDepartment(nameDepartment);
                }
            }

        }
    }
}