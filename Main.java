// Name: Cesar de Paula

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        // The initial amount of marbles is determined by the program, which is randomized.
        int count = (int)(Math.random()*(100 - 10 + 1) + 10);

        System.out.println("Let's play a game of Nim.\n");

        while (true)
        {
            System.out.println("There are " + count + " marbles.");
            int halfCount = count / 2;
            System.out.println("You must take at least 1 marble, but you can only take up to " + halfCount + " marble(s).");
            System.out.print("How many would you like to take? ");
            int entry;
            while (true)
            {
                entry = kbd.nextInt();
                System.out.println();

                // These if-else statements ensures that the user's input is within range.
                if (entry > halfCount)
                {
                    System.out.print("That's too many, try again: ");
                }
                else if (entry < 1)
                {
                    System.out.print("You need to take at least 1 marble, try again: ");
                }
                else
                {
                    count -= entry;
                    halfCount = count / 2;
                    break;
                }
            }

            // This checks if one marble remains after the user takes their turn. At which point, the program must take
            // the last marble, thus making the player win the game.
            if (count == 1)
            {
                System.out.println("Oh no! There's only 1 marble left for me to take. You win!");
                break;
            }

            // This switch statement is the program's winning strategy.
            // Having 3 marbles is an unsafe amount, and so the central idea of the strategy is to reduce the amount
            // of marbles to 3 if it is the program's turn.
            switch (count)
            {
                case 4:
                    count -= 1;
                    System.out.println("I have taken 1 marble(s).");
                    break;
                case 5:
                    count -= 2;
                    System.out.println("I have taken 2 marble(s).");
                    break;
                case 6:
                    count -= 3;
                    System.out.println("I have taken 3 marble(s).");
                    break;
                // Since any amount of marbles greater than 6 cannot be reduced to 3 when it is the program's turn,
                // the program will take a random number of marbles.
                default:
                    int programEntry = (int)(Math.random()*(halfCount - 1 + 1) + 1);
                    count -= programEntry;
                    System.out.println("I have taken " + programEntry + " marble(s).\n");
            }

            // This checks if one marble remains after the program takes its turn. At which point, the player must
            // take the marble and lose the game.
            if (count == 1)
            {
                System.out.println("There is only 1 marble left. Since you must take it, you lose!");
                break;
            }
        }
    }
}
