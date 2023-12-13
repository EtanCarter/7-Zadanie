package org.discbase;

import java.util.Scanner;

public class AddDisc {
    public void DiscCreate(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип диска: " + "\n" + "1. DVD" + "\n" + "2. CD-R" + "\n" + "3. mini-disc");
        int typenum = scanner.nextInt();
        String DiscType = null;

        switch (typenum) {
            case 1:
                DiscType = "DVD";
                break;
            case 2:
                DiscType = "CD-R";
                break;
            case 3:
                DiscType = "mini-disc";
                break;
        }


        System.out.println("Выберите категорию: " + "\n" + "1. Фильмы" + "\n" + "2. Музыка" + "\n" + "3. ПО");
        int catnum = scanner.nextInt();
        String DiscCategory = null;

        switch (catnum) {
            case 1:
                DiscCategory = "Фильмы";
                break;
            case 2:
                DiscCategory = "Музыка";
                break;
            case 3:
                DiscCategory = "ПО";
                break;
            default:
                break;
        }

        System.out.println("Введите название диска: ");
        String DiscName = scanner.next();
        System.out.println("Введите описание для диска: ");
        String Description = scanner.nextLine();

        Disc disc = new Disc(DiscType, DiscCategory, DiscName, Description);

        databaseHandler.AddDiscForDb(disc);

    }
}
