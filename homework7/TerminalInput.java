import java.util.Scanner;
/**
 * User Interface via terminal
 */
public class TerminalInput
{
    /**
     * Determines if the user wants to "hit"
     * @return true if the user chooses to hit, falase otherwise
     */
    public static boolean hitOrStand()
    {
        Scanner s = new Scanner(System.in);
        boolean hit = false;
        boolean invalidInput = true;
        do
        {
            System.out.println("(h)it or (s)tand?");
            String userInput = s.nextLine();
            if (userInput.startsWith("h") || userInput.startsWith("H"))
            {
                hit = true;
                invalidInput = false;
            }
            else if (userInput.startsWith("s") || userInput.startsWith("S"))
            {
                hit = false;
                invalidInput = false;
            }
        }while(invalidInput);
        return hit;
    }

}
