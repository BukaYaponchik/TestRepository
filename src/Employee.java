import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Employee {

    private String nameEmployee;
    private int nameDepartment;
    private int salary;
    private int id;
    private static int idCount = 1;

    public Employee( String nameEmployee, int nameDepartment, int salary) {
        this.nameEmployee = nameEmployee;
        this.nameDepartment = nameDepartment;
        this.salary = salary;
        this.id = idCount;
        idCount++;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(int nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    static List<Employee> listEmployee = new ArrayList<Employee>();

    public static void addEmployee( String addNameEmployee, int addNameDepartment, int addSalary){
        listEmployee.add(new Employee(addNameEmployee, addNameDepartment, addSalary));
    }

    public static void outputOfAllElements(){
        listEmployee.forEach(e -> System.out.println(e.toString()));
    }

    public static int withdrawThePOInAMonth(){
        return listEmployee.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public static Employee outputTheMinimumPO(){
        return listEmployee.stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .get();
    }

    public static Employee outputTheMaximumPO(){
        return listEmployee.stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .get();
    }

    public static int outputTheAveragePO(){
        return (withdrawThePOInAMonth() / listEmployee.size());
    }

    public static void outputOfAllNameEmployee(){
        listEmployee.forEach(e -> System.out.println(e.getNameEmployee()));
    }

    public static void indexTheSalary(int indexationPercentage){
        listEmployee.forEach(e -> e.setSalary(e.getSalary() *  ((indexationPercentage / 100) + 1)));
    }

    public static void outputOfAllEmployeeLessValues(int doorstep){
        listEmployee.stream().filter(e -> e.getSalary() < doorstep).forEach(e -> System.out.println(e.toString()));
    }

    public static void outputOfAllEmployeeMoreValues(int doorstep){
        listEmployee.stream().filter(e -> e.getSalary() > doorstep).forEach(e -> System.out.println(e.toString()));
    }

    public static Employee outputTheMinimumPOAtDepartment(int nameDepartment){
        return listEmployee.stream().filter(e -> e.getNameDepartment() == nameDepartment)
                .min(Comparator.comparingInt(Employee::getSalary))
                .get();
    }

    public static Employee outputTheMaximumPOAtDepartment(int nameDepartment){
        return listEmployee.stream().filter(e -> e.getNameDepartment() == nameDepartment)
                .max(Comparator.comparingInt(Employee::getSalary))
                .get();
    }

    public static int withdrawThePOInAMonthAtDepartment(int nameDepartment){
        return listEmployee.stream()
                .filter(e -> e.getNameDepartment() == nameDepartment)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public static int outputTheAveragePOAtDepartment(int nameDepartment){
        return (withdrawThePOInAMonthAtDepartment(nameDepartment) / listEmployee.stream().filter(e -> e.getNameDepartment() == nameDepartment).toList().size());
    }

    public static void indexTheSalaryAtDepartment(int nameDepartment, int indexationPercentage){
        listEmployee.stream().filter(e -> e.getNameDepartment() == nameDepartment).forEach(e -> e.setSalary(e.getSalary() *  ((indexationPercentage / 100) + 1)));
    }

    public static void outputOfAllElementsAtDepartment(int nameDepartment){
        listEmployee.stream().filter(e -> e.getNameDepartment() == nameDepartment).forEach(e -> System.out.println("ID сотрудника " + e.id + "   /ФИО сотрудника: " + e.nameEmployee + "  Зарплата: " + e.salary));

    }

    @Override
    public String toString() {
        return "ID сотрудника " + this.id + "   /ФИО сотрудника: " + this.nameEmployee + "  /Номер отдела: " + this.nameDepartment + "  Зарплата: " + this.salary;
    }

}
