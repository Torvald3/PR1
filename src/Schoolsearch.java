import java.io.*;
import java.util.Scanner;

public class Schoolsearch {
    public static void main(String[] args) {
        int choice, exit=1;
        File students_file = new File("students.txt");
        if(students_file.exists()){
            System.out.println("File "+students_file.getPath()+" opened successfully");
        } else{
            System.out.println("File not found!");
            exit=0;
        }
        Scanner scanner = new Scanner(System.in);
        while(exit!=0){
            System.out.println("""
                    Choose option by what to find info:
                    1)Student
                    2)Teacher
                    3)Classroom
                    4)Bus
                    0)Exit
                    """);
            choice = scanner.nextInt();
            scanner.nextLine(); // додатковий виклик для споживання зайвого символу \n
            switch (choice){
                case 1://Пошук по прізвищу
                    System.out.println("Enter student`s last name:");
                    String lastname = scanner.nextLine();
                    searchByLastname(lastname);
                    break;
                case 2://Пошук за викладачем
                    System.out.println("Enter teacher`s last name:");
                    String teacher = scanner.nextLine();
                    searchByTeacher(teacher);
                    break;
                case 3://Пошук по прізвищу
                    System.out.println("Enter classroom`s number:");
                    String classroom = scanner.nextLine();
                    searchByClassroom(classroom);
                    break;
                case 4://Пошук за викладачем
                    System.out.println("Enter bus`s number:");
                    String bus = scanner.nextLine();
                    searchByBus(bus);
                    break;
                case 0:
                    exit=0;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }
    // 0 StLastName, 1StFirstName, 2Grade, 3Classroom, 4Bus, 5TLastName, 6TFirstName
    private static void searchByLastname(String lastname){
        String line;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose variant(student info = 1 / student bus = 2)");
        int option = scanner.nextInt();
        scanner.nextLine();// додатковий виклик для споживання зайвого символу \n
        if(option==1){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                //Прохід по всьому файлу
                while ((line = reader.readLine()) != null){ //поки не досягнемо кінця файлу
                    //розділ рядків на слова
                    String[] parts = line.split(",");
                    //Пошук співпадінь прізвищ
                    if(parts[0].equalsIgnoreCase(lastname)){//ігноруючи капіталізацію
                        System.out.println("Student: "+parts[0]+" "+parts[1]+"  Class: "+
                                parts[2]+"  Teacher: "+parts[5]+" "+parts[6]);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            try {
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                //Прохід по всьому файлу
                while ((line = reader.readLine()) != null){ //поки не досягнемо кінця файлу
                    //розділ рядків на слова
                    String[] parts = line.split(",");
                    //Пошук співпадінь прізвищ
                    if(parts[0].equalsIgnoreCase(lastname)){//ігноруючи капіталізацію
                        System.out.println("Student: "+parts[0]+" "+parts[1]+"  Bus: "+
                                parts[4]);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void searchByTeacher(String teacher){
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            //Прохід по всьому файлу
            System.out.println(teacher + "`s students:");
            while ((line = reader.readLine()) != null){ //поки не досягнемо кінця файлу
                //розділ рядків на слова
                String[] parts = line.split(",");
                //Пошук співпадінь прізвищ
                if(parts[5].equalsIgnoreCase(teacher)){//ігноруючи капіталізацію
                    System.out.println(parts[0]+" "+parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void searchByClassroom(String classroom){
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            //Прохід по всьому файлу
            System.out.println(classroom + "`s students:");
            while ((line = reader.readLine()) != null){ //поки не досягнемо кінця файлу
                //розділ рядків на слова
                String[] parts = line.split(",");
                //Пошук співпадінь прізвищ
                if(parts[3].equalsIgnoreCase(classroom)){//ігноруючи капіталізацію
                    System.out.println(parts[0]+" "+parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void searchByBus(String bus){
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            //Прохід по всьому файлу
            System.out.println(bus + "`s students:");
            while ((line = reader.readLine()) != null){ //поки не досягнемо кінця файлу
                //розділ рядків на слова
                String[] parts = line.split(",");
                //Пошук співпадінь прізвищ
                if(parts[4].equalsIgnoreCase(bus)){//ігноруючи капіталізацію
                    System.out.println(parts[0]+" "+parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}