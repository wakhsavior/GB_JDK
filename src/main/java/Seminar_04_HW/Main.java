package Seminar_04_HW;

/*
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class Main {
    public static void main(String[] args) {
        EmployeeDirectory dir = new EmployeeDirectory();
        dir.createEmployee("9101011010","Vasiliy",120);
        dir.createEmployee("9202345110","Ilya",90);
        dir.createEmployee("9207430924","Semen",100);
        dir.createEmployee("9024710904","Igor",240);
        dir.createEmployee("9168800193","Evgenia",160);
        dir.createEmployee("9116894129","Vitaliy",60);
        dir.createEmployee("9542344534","Ilya",180);
        dir.createEmployee("9059094102","Alexey",80);
        dir.createEmployee("9154355345","Evgenia",120);
        dir.createEmployee("9543544223","Ilya",200);
        dir.createEmployee("9424234234","Vitaliy",120);


        for (Employee employee: dir.getAllEmployees().values()
             ) {
            System.out.println("ID: " + employee.getId() + " HashCode: " + employee.hashCode());

        }
        System.out.println(dir.searchEmployee(5));
        System.out.println(dir.searchEmployee("Evgenia"));
        System.out.println(dir.searchEmployee("Ilya"));
        System.out.println(dir.searchPhone("Ilya"));
        System.out.println(dir.searchPhone("Evgenia"));
        System.out.println(dir.searchEmployeeByExperience(120));
    }

}
