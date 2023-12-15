package Seminar_04_HW;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDirectory {
    private int employeeCount = 0;
    private final Map<Integer, Employee> employees = new HashMap<>();
    private static Scanner scn = new Scanner(System.in);

    public void createEmployee() {
        System.out.print("Введите имя сотрудника: ");
        String name = scn.nextLine();
        System.out.print("Введите телефон сотрудника: ");
        String phone = scn.nextLine();
        System.out.print("Введите стаж сотрудника: ");
        int experience = scn.nextInt();
        scn.nextLine();
        createEmployee(phone, name, experience);
    }

    public void createEmployee(String phone, String name, int experience) {
        Employee employee = new Employee(phone, name, experience);
        employees.put(employee.getId(), employee);
        this.employeeCount++;
    }

    public ArrayList<String> searchPhone(String name) {
        if (employees.isEmpty()) {
            return null;
        }
       return employees.values().stream().
                filter(x -> x.getName().equals(name)).
                map(x->x.getPhoneNumber()).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Employee> searchEmployeeByExperience(int experience) {
        if (employees.isEmpty()) {
            return null;
        }
        return employees.values().stream().
                filter(x->x.getExperienceMonth()==experience).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Employee> searchEmployee(int id) {
        if (employees.isEmpty()) {
            return null;
        }
        ArrayList<Employee> curEmployees = new ArrayList<>();

        return employees.keySet().stream().filter(x -> x == id).
                map(x->employees.get(x)).
                collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Employee> searchEmployee(String name) {

        if (employees.isEmpty()) {
            return null;
        }
        return employees.values().stream().
                filter(x -> x.getName().equals(name)).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<Integer, Employee> getAllEmployees() {
        return this.employees;
    }

    public void removeEmployee(int id) {
        employees.remove(id);
        this.employeeCount--;
    }

    public void removeEmployee(Employee employee) {
        removeEmployee(employee.getId());
    }

}
