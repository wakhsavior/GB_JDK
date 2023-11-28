package Seminar_02.project;

public class Backender extends Developer implements BackendAction{
    @Override
    public void back() {
        System.out.println("BackEnd working");
    }
}
