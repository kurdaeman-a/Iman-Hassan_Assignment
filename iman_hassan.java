import java.util.Scanner;

public class iman_hassan {
    // Declearing choice to select an operation,and visitcount to represeant the
    // valid size
    static int choice, visitcount = 0;
    static Scanner input = new Scanner(System.in);
    static String[] historical = { "Erbil Citadel", "Amedi", "Halabja Monument", "Slemani Old Town" };
    static String[] museums = { "Erbil Museum", "Slemani Museum", "Duhok Museum", "Halabja Museum" };
    static String[] archaeological = { "Shanidar Cave", "Qalat", "Darbandikhan", "Gali Ali Beg" };
    static String[] category = new String[100];
    static String[] site = new String[100];
    static String[] visitorName = new String[100];
    static int[] visitorID = new int[100];
    static String[] visitDate = new String[100];

    public static void main(String[] args) {
        String givinCategory, givinSite;
        int givinID;

        do {
            menu();
            switch (choice) {
                case 1:
                    selectHeritage();

                    break;
                case 2:

                    break;
                case 3:

                    // we ask the user visitor ID, category, and site to avoid removing the wrong
                    // booking
                    System.out.println("please specify the category of the schedule you want to cancel: ");
                    givinCategory = input.nextLine();
                    System.out.println("please specify the site of the schedule you want to cancel: ");
                    givinSite = input.nextLine();
                    System.out.println("please specify the visitor ID of the schedule you want to cancel: ");
                    givinID = input.nextInt();
                    int result=searchByIndex(givinCategory, givinSite, givinID);
                    if(result==-1){
                        System.out.println("The schedule you want to cancel was not found, please try againg");
                    }
                    else
                        cancelSchedule(result);

                    break;
                case 4:

                    break;
                case 5:

                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
    }

    public static void menu() {
        System.out.println("------------------------------");
        System.out.println("1. select heritage");
        System.out.println("2. schedule your visit");
        System.out.println("3. Display items of stack");
        System.out.println("4. Peek at the top");
        System.out.println("5 exit");
        System.out.println("------------------------------");
        System.out.println("Enter a choice: ");
        choice = input.nextInt();
    }

    public static void selectHeritage() {

        System.out.println("1- Historical Sites: ");
        for (int inner = 0; inner < historical.length; inner++) {
            System.out.println("- " + historical[inner]);

        }
        System.out.println("2- Museums: ");
        for (int inner = 0; inner < historical.length; inner++) {
            System.out.println("- " + museums[inner]);

        }
        System.out.println("3- Archaeological Sites: ");
        for (int inner = 0; inner < historical.length; inner++) {
            System.out.println("- " + archaeological[inner]);

        }

    }

    public static void scheduleVisit() {

    }

    public static void cancelSchedule(int position) {

        for(int count=position;count<visitcount-1;count++){

            category[count]=category[count+1];
            site[count]=site[count+1];
            visitorID[count]=visitorID[count+1];
            visitorName[count]=visitorName[count+1];
            visitDate[count]=visitDate[count+1];



        }
        visitcount--;
    }

    public static int searchByIndex(String givinCategory, String givinSite, int givinID) {

        for (int index = 0; index < visitcount; index++) {

            if (category[index].equals(givinCategory) && site[index].equals(givinSite)
                    && visitorID[index] == givinID) {
                return index;
            }
        }
        return -1;
    }
}
