package org.discbase;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Scanner start = new Scanner(System.in);

        System.out.println("Выберите операцию: " + "\n" + "1: Добавить диск: " +
                "\n" + "2: Удалить диск" + "\n" + "3: Изменить диск" + "\n" + "4: Просмотр базы дисков");
        int Operation = start.nextInt();

        switch (Operation) {
            case 1:
                AddDisc addDisc = new AddDisc();
                addDisc.DiscCreate();
                break;
            case 2:
                DeleteDisc deleteDisc = new DeleteDisc();
                deleteDisc.DiscDelete();
                break;
            case 3:
                UpdateDisc updateDisc = new UpdateDisc();
                updateDisc.DiscUpdate();
                break;
            case 4:
                CheckDisc checkDisc = new CheckDisc();
                checkDisc.ViewDisc();
                break;
            default:
                break;
        }
    }
}