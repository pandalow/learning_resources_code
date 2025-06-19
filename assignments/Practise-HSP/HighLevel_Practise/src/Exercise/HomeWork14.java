package Exercise;

import java.util.Scanner;

public class HomeWork14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======= Let's Play a Funny Game ========");
        Tom tom = new Tom();
        boolean key = true;
        while (key) {
            System.out.println("======= Input Your VALUE =======");
            System.out.println("======= Input '5' exit games =======");
            System.out.print("Enter:");
            int guess = scanner.nextInt();
            if (guess == 5) {
                key = false;
            } else if (guess > 2) {
                System.out.println("Wrong input input again");
            } else {
                tom.compareGame(guess, tom.guessGame());
            }
        }
        System.out.println("Game End~~~~~~~`");
    }
}

class Tom {
    private static int count;
    private static int dual;
    private static int win;

    public int guessGame() {
        return (int) (Math.random() * 3);
    }

    public void compareGame(int input, int comGuess) {
        if (input == comGuess) {
            System.out.println("dual");
            count++;
            dual++;
        }
        if (input - comGuess == 1 || input - comGuess == -2) {
            System.out.println("You lose the game");
            count++;
            win++;
        }
        if (input - comGuess == 2 || input - comGuess == -1) {
            System.out.println("You win the game");
            count++;
        }
        System.out.println("Your guess: " + input + "Tom guess is: " + comGuess);
        System.out.println("Tom win: " + win + " , Lose: " + dual + " , all Game are: " + count);
    }
}
