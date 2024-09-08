// TALISIC, JHON ROSELL B.
import java.util.Scanner;
public class ISBN {
    Scanner scan = new Scanner(System.in);
    private String[] isbnArr = new String[5];
    private String isbnStr;


    public void setIsbn() {

        try {
            while (true) {
                System.out.print("\n|  Enter the first four numbers: ");
                String firstFourNum = scan.nextLine();
                if (firstFourNum.length() != 4 || firstFourNum.contains("-") || Integer.parseInt(firstFourNum) < 0) {
                    System.out.println("   INVALID INPUT!");
                } else {
                    isbnArr[0] = firstFourNum;
                    break;
                }
            }

            while (true) {
                System.out.print("|  Enter the next one number: ");
                String oneNum = scan.nextLine();
                if ((oneNum.length() != 1) || oneNum.contains("-") || Integer.parseInt(oneNum) < 0) {
                    System.out.println("   INVALID INPUT!");
                } else {
                    isbnArr[1] = oneNum;
                    break;
                }
            }

            while (true) {
                System.out.print("|  Enter the next two numbers: ");
                String nextTwoNum = scan.nextLine();
                if (nextTwoNum.length() != 2 || nextTwoNum.contains("-") || Integer.parseInt(nextTwoNum) < 0) {
                    System.out.println("   INVALID INPUT!");
                } else {
                    isbnArr[2] = nextTwoNum;
                    break;
                }
            }

            while (true) {
                System.out.print("|  Enter the next six numbers: ");
                String nextSixNum = scan.nextLine();
                if (nextSixNum.length() != 6 || nextSixNum.contains("-") || Integer.parseInt(nextSixNum) < 0) {
                    System.out.println("   INVALID INPUT!");
                }
                else {
                    isbnArr[3] = nextSixNum;
                    break;
                }
            }

            while (true) {
                System.out.print("|  Enter the last one number: ");
                String lastNum = scan.nextLine();
                if (lastNum.length() != 1 || lastNum.contains("-") || Integer.parseInt(lastNum) < 0) {
                    System.out.println("   INVALID INPUT!");
                }
                else {
                    isbnArr[4] = lastNum;
                    break;
                }
            }

            isbnStr = String.join("-", isbnArr);
            System.out.println("|  ISBN: " + isbnStr);
        }
        catch (NumberFormatException e) {
            System.out.println("   INVALID INPUT!");

        }

    }

    public String getIsbnStr() {
        return isbnStr;
    }
}
