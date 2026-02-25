void main() {
    HighToLow.game_prep();
}



class HighToLow {
    static void game_prep() {
        Scanner skan = new Scanner(System.in);
        int first_number = 0;
        int second_number = 0;
        IO.println("Game of Too High Too Low will start, here are quick rules about the game: \n");
        IO.println("""
                You need to Guess the number, every guess you will receive info if you guessed correct, too high or too low.
                But first you need to give the machine range of numbers you're interested in, the numbers needs to be positive and length of range needs to be bigger than 3
                After guessing the number, you will receive the grade based on number of guesses you've made.
                If you need to escape the game, type "EXIT" in guessing part of the game.
                
                
                """);

        boolean notReady = true;

        while (notReady) {
            IO.println("First Give me a range of number you want to guess from? Numbers needs to be positive and range length bigger than 3, negative numbers will be changed to positive");
            IO.println("First number?: ");
            first_number = Math.abs(skan.nextInt());
            IO.println("Second number?: ");
            second_number = Math.abs(skan.nextInt());


            if (first_number > second_number) {
                int temp = second_number;
                second_number = first_number;
                first_number = temp;
            }
            if ((second_number - first_number) + 1 < 3) {
                IO.println("length is too low, please provide with bigger range of numbers");
                continue;
            }


            IO.println("The range is picked!");
            notReady = false;


        }

        IO.println("Do you want to start? Type Yes or No");
        skan.nextLine();

        String dec = skan.nextLine();

        if (dec.equals("Yes")) {
            game_start(first_number,second_number);
        } else {
            IO.println("Game ended");
        }

        IO.println(dec);
    }

    static void game_start(int low, int high) {
        Scanner skan = new Scanner(System.in);
        IO.println("Game starts here");
        IO.println("The range is from: " + low + " to: " + high);

        IO.println("The game starts now");
        boolean notGuessed = true;
        int guesses = 0;
        int num_picked_machine = number_gen(low,high);

        while (notGuessed) {
            IO.println("What's your guess?: ");
            int guess = skan.nextInt();
            IO.println(guess);
            if (guess > high || guess < low) {
                IO.println("Your guess is outside of the range, please pick the number in range");
                guesses++;
                continue;
            } else if( guess == num_picked_machine) {
                guesses++;
                IO.println("You guessed the number!!!");
                notGuessed = false;
            } else if(guess > num_picked_machine) {
                IO.println("Too high");
                guesses++;
                continue;
            } else if(guess < num_picked_machine) {
                IO.println("Too low");
                guesses++;
                continue;
            }
        }
        IO.println(guesses);




    }

    static int number_gen(int low, int high) {
        return (int) ((Math.random() * ((high + 1) - low)) + low);    
    }
}
