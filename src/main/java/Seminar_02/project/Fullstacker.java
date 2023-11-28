package Seminar_02.project;

public class Fullstacker extends Developer implements FrontendAction,BackendAction{
    @Override
    public void back() {
        System.out.println("Фуллстэк программист что-то делает для back....");
    }

    @Override
    public void front() {System.out.println("Фуллстэк программист что-то делает для front....");

    }
}
