import java.util.Scanner;
import java.util.Random;

public class MohammadAldawaghrehMexicoDiceGame
{
    static Scanner sc;

    public static int randomNumber ()
    {
        Random ran = new Random ();

        int roll = ran.nextInt (6) + 1;//generates random number from 1 to 6

        return roll;
    }

    public static int valueCheck(int roll1, int roll2)
    {
        int total = 0;
        if (roll1 == roll2)
        {
            // checks if the player roll is a double and adds 100 to rank it above other normal rolls
            total = 100 + (roll1*10 + roll2);
        }
        else if (roll1 > roll2)
        {
            //sorts so the higher roll is in the tens place
            total = roll1*10 + roll2;
        }
        else
        {
            //sorts so the higher roll is in the tens place
            total = roll2*10 + roll1;
        }
        if( total == 21)
        {
            // adds 1000 to a roll of 21 so it can be unreachable by any other value in order to rank the players properly
            total += 1000;
        }
        return total;
    }

    public static void winner (int player1Total, int player2Total, int player3Total)
    {
       //calculates and shows who the winner of the round is
        if ((player1Total > player2Total) && (player1Total > player3Total))
        {
            System.out.println ("The winner of this round is Player 1\n");
        }
        else if ((player2Total > player1Total) && (player2Total > player3Total))
        {
            System.out.println ("The winner of this round is Player 2\n");
        }
        else if ((player3Total > player1Total) && (player3Total > player2Total))
        {
            System.out.println ("The winner of this round is Player 3\n");
        }
    }
    
    public static void introduction ()
    {
        String rules, begin;
        //nice presentation of introduction...
        for(int i = 0 ; i < 100; i++) 
        {
			if(i > 0 && i < 100)
		    System.out.print("*");
			
		}
		
		for(int i = 0; i < 5; i++)
		{
		    if(i > 0 && i < 5)
			System.out.println("");
		}
		
		for(int i = 0; i < 100; i++)
		{
		    if(i > 0 && i < 35)
		    System.out.print(" ");
		    else if (i == 35)		     
		    System.out.println("WELCOME TO MEXICO DICE GAME!");
		}
		
		for(int i = 0; i < 5; i++)
		{
		    if(i > 0 && i < 5)
			System.out.println("");
		}
		
		for(int i = 0 ; i < 100; i++) 
        {
			if(i > 0 && i < 100)
		    System.out.print("-");
			
		}
		
		System.out.println("");
		System.out.print("Press enter to display rules");
        rules = sc.nextLine ();
        if (rules.equals (""))
        System.out.print ('\u000c');
        
        System.out.println("Rules:");
        System.out.println("1. You roll two dice and take the the higher roll and place it in the tens value and the lower role in the ones.");
        System.out.println("2. The number of rolls player 2 and 3 roll depend on how many times player 1 rolls.");
        System.out.println("3. Each player starts with 3 lives and the loser of each round loses a life.");
        System.out.println("4. If two players tie for last place, they both lose a life.");
        System.out.println("5. If a player rolls a double, example: 44, it is valued higher than any other normal roll. Example: 44 > 51.");
        System.out.println("6. A 21 roll is the highest possible roll.");
        System.out.println("7. The game ends when a player loses all of their lives.");
        System.out.println("8. And lastly, have FUN! Lets MEXICO!");
        
        System.out.println("\nPress enter to begin game:");
        begin = sc.nextLine ();
        if (begin.equals (""))
        System.out.print ('\u000c');
    }
   
    
    public static void main (String[] args)
    {
        sc = new Scanner (System.in);
        
        boolean endGame = false;//initialized at false to allow players to play again if they want
        
        //keeps looping if the players wanna play again
        while (!endGame)
        {
        //initializes all variables in loop so the game can reset properly
        int p1Life=3, p2Life=3, p3Life=3;//player lives
        int roll1, roll2; //dice rolls
        int playerTotal = 0, player1Total = 0, player2Total = 0, player3Total = 0; //player values of rolls
        int nRolls = 0;//number of rolls player 1 rolls and is forced upon the remaining players

        String terminate, nextTurn;
        boolean p1Turn = false;//boolean for player 1 turn
        boolean p23Turn = false;//boolean for player 2 and 3 turn
        
        introduction();//calls upon introduction method to display rules

        //keeps looping rounds until a player loses
        while (p1Life > 0 && p2Life > 0 && p3Life > 0)
        {
            p1Turn = false;//
            p23Turn = false;//reinitializes all 3 variables each round in order for the loops and number of rolls to work properly
            nRolls = 0;//

            //loops for player 1 turn, put in seperate loop so the number of rolls can be forced upon remaining players
            while (!p1Turn)
            {
                System.out.println ("Player 1's Turn:");
                roll1 = randomNumber ();//rolls one dice
                roll2 = randomNumber ();//rolls one dice
                playerTotal = valueCheck (roll1, roll2);//checks the value of the roll and assigns the proper value
 
                int numberOfRoles = 1;//initializes number of rolls so far as 1

                System.out.println("");
                System.out.println("You have rolled " + roll1 + " and " + roll2);//displays rolls
                System.out.println("");

                //a bunch of if statements so the values can be displayed properly and not as a larger number so players dont get confused
                if (playerTotal == 1021)
                {
                    System.out.println ("Your roll is 21");
                }
                else if (playerTotal == 111)
                {
                    System.out.println("Your roll is 11");
                }
                else if (playerTotal == 122)
                {
                    System.out.println("Your roll is 22");
                }
                else if (playerTotal == 133)
                {
                    System.out.println("Your roll is 33");
                }
                else if (playerTotal == 144)
                {
                    System.out.println("Your roll is 44");
                }
                else if (playerTotal == 155)
                {
                    System.out.println("Your roll is 55");
                }
                else if (playerTotal == 166)
                {
                    System.out.println("Your roll is 66");
                }
                else
                {
                    System.out.println ("Your roll is " + playerTotal);
                }
                nRolls++;//counter to keep track of number of rolls for player 1

                System.out.println("");

                while (numberOfRoles < 3)// while loop to loop again for player one if they wanna roll again
                {
                    String rollAgain;
                    System.out.print ("Would you like to roll again? (Yes/No): ");
                    rollAgain = sc.nextLine ();

                    if (rollAgain.equalsIgnoreCase ("yes"))
                    {
                        // generates new random numbers, finds their total and increases the number of roles
                        roll1 = randomNumber ();
                        roll2 = randomNumber ();
                        playerTotal = valueCheck (roll1, roll2);
                        numberOfRoles++;
                        System.out.println("");
                        System.out.println("You have rolled " + roll1 + " and " + roll2);
                        System.out.println("");

                        if (playerTotal == 1021)
                        {
                            System.out.println ("Your roll is 21");
                        }
                        else if (playerTotal == 111)
                        {
                            System.out.println("Your roll is 11");
                        }
                        else if (playerTotal == 122)
                        {
                            System.out.println("Your roll is 22");
                        }
                        else if (playerTotal == 133)
                        {
                            System.out.println("Your roll is 33");
                        }
                        else if (playerTotal == 144)
                        {
                            System.out.println("Your roll is 44");
                        }
                        else if (playerTotal == 155)
                        {
                            System.out.println("Your roll is 55");
                        }
                        else if (playerTotal == 166)
                        {
                            System.out.println("Your roll is 66");
                        }
                        else
                        {
                            System.out.println ("Your roll is " + playerTotal);
                        }
                        nRolls++;

                        System.out.println("");
                    }
                    else if (rollAgain.equalsIgnoreCase ("no"))
                    {
                        // ends player's turn
                        numberOfRoles = 3;//if player 1 doesnt wanna roll again, it exits and moves on

                    }
                    else
                    {
                        System.out.println ("INVALID RESPONSE. That roll is now your value");
                        numberOfRoles = 3;//exits out of loop
                    }

                }

                player1Total = playerTotal;//assigns player 1's total 
                System.out.println ("Press enter to continue");
                nextTurn = sc.nextLine ();

                if (nextTurn.equals (""))
                System.out.print ('\u000c');
                p1Turn = true;//exits out of player 1's turn
            }


            while (!p23Turn)//loops for player 2 and 3
            {
                // loops for each player (up to 2 players)
                for (int player = 2 ; player <= 3 ; player++)
                {
                    // initializes number of rolls for each player
                    String rollAgain;
                    int numberOfRoles = 1;
                    System.out.println("Player " + player + "'s Turn : ");
   
                    roll1 = randomNumber ();
                    roll2 = randomNumber ();
                    playerTotal = valueCheck (roll1, roll2);

                    System.out.println("");
                    System.out.println("You have rolled " + roll1 + " and " + roll2);
                    System.out.println("");

                    if (playerTotal == 1021)
                    {
                        System.out.println ("Your roll is 21");
                    }
                    else if (playerTotal == 111)
                    {
                        System.out.println("Your roll is 11");
                    }
                    else if (playerTotal == 122)
                    {
                        System.out.println("Your roll is 22");
                    }
                    else if (playerTotal == 133)
                    {
                        System.out.println("Your roll is 33");
                    }
                    else if (playerTotal == 144)
                    {
                        System.out.println("Your roll is 44");
                    }
                    else if (playerTotal == 155)
                    {
                        System.out.println("Your roll is 55");
                    }
                    else if (playerTotal == 166)
                    {
                        System.out.println("Your roll is 66");
                    }
                    else
                    {
                        System.out.println ("Your roll is " + playerTotal);
                    }

                    System.out.println("");

                    // until the number of rolls that player 1 has rolled or until they do not want to roll again
                    while (numberOfRoles < nRolls)
                    {
                        System.out.print ("would you like to roll again?(yes/no) ");
                        rollAgain = sc.nextLine ();

                        if (rollAgain.equalsIgnoreCase ("yes"))
                        { 
                            roll1 = randomNumber ();
                            roll2 = randomNumber ();
                            playerTotal = valueCheck (roll1, roll2);
                            numberOfRoles++;//counter to keep track of number of rolls
                            
                            System.out.println("");
                            System.out.println("You have rolled " + roll1 + " and " + roll2);
                            System.out.println("");
                            if (playerTotal == 1021)
                            {
                                System.out.println ("Your roll is 21");
                            }
                            else if (playerTotal == 111)
                            {
                                System.out.println("Your roll is 11");
                            }
                            else if (playerTotal == 122)
                            {
                                System.out.println("Your roll is 22");
                            }
                            else if (playerTotal == 133)
                            {
                                System.out.println("Your roll is 33");
                            }
                            else if (playerTotal == 144)
                            {
                                System.out.println("Your roll is 44");
                            }
                            else if (playerTotal == 155)
                            {
                                System.out.println("Your roll is 55");
                            }
                            else if (playerTotal == 166)
                            {
                                System.out.println("Your roll is 66");
                            }
                            else
                            {
                                System.out.println ("Your roll is " + playerTotal);
                            }

                            System.out.println("");
                        }
                        else if (rollAgain.equalsIgnoreCase ("no"))
                        {
                            // ends player's turn
                            numberOfRoles = 3;
                        }
                        else
                        {
                            System.out.println ("INVALID RESPONSE. That roll is now your value");
                            numberOfRoles = 3;
                        }
                    }

                    if (player == 2)
                    {
                        // assigns the total based on whos turn it is
                        player2Total = playerTotal;
                    }
                    else if (player == 3)
                    {
                        // assigns the total based on whos turn it is
                        player3Total = playerTotal;
                    }

                    //buffer...press enter
                    System.out.println ("Press enter to continue");
                    nextTurn = sc.nextLine ();

                    if (nextTurn.equals (""))
                    System.out.print ('\u000c');
                }
                p23Turn = true;//exits out of player 2's and 3's turns
            }
      
            //calculates who lost and deducts a life based on the loser
            if (player1Total < player2Total && player1Total < player3Total)
            {
                System.out.println("Player 1 loses a life");
                p1Life --;
            }
            else if (player2Total < player1Total && player2Total < player3Total)
            {
                System.out.println("Player 2 loses a life");
                p2Life --;
            }
            else if (player3Total < player1Total && player3Total < player2Total)
            {
                System.out.println("Player 3 loses a life");
                p3Life --;
            }
            else if( player1Total == player2Total && player1Total < player3Total)//deducts a life for the people who tie for last...
            {
                System.out.println("Player 1 and 2 lose a life");
                p1Life --;
                p2Life --;
            }
            else if( player1Total == player3Total && player1Total < player2Total)//deducts a life for the people who tie for last...
            {
                System.out.println("Player 1 and 3 lose a life");
                p1Life --;
                p3Life --;
            }
            else if( player2Total == player3Total && player2Total < player1Total)//deducts a life for the people who tie for last...
            {
                System.out.println("Player 2 and 3 lose a life");
                p1Life --;
                p3Life --;
            }

            System.out.println("");

            winner(player1Total, player2Total, player3Total);//displays the winner of the round

            System.out.println("");
            
            //displays lives left for each player
            System.out.println("Player 1 has " + p1Life + " lives left!");
            System.out.println("Player 2 has " + p2Life + " lives left!");
            System.out.println("Player 3 has " + p3Life + " lives left!");

            //displays who lost the game
            if (p1Life == 0)
                System.out.println("\nPlayer 1 Loses");
            else if (p2Life == 0)
                System.out.println("\nPlayer 2 Loses");
            else if (p3Life == 0)
                System.out.println("\nPlayer 3 Loses");

            System.out.println("");
            System.out.println("");
            
            System.out.println ("Press enter to continue");
            nextTurn = sc.nextLine ();

            if (nextTurn.equals (""))
            System.out.print ('\u000c');
            
            
            //offers the chance for the players to play again
            if(p1Life == 0 || p2Life == 0 || p3Life == 0)
            {
            System.out.print ("Would you like to play again? (Yes/No) ");
            terminate = sc.nextLine();
            if(terminate.equalsIgnoreCase("no"))
            {
            endGame = true;//exits game...
            }
            }
    }
        System.out.print ('\u000c');
    }
    }
}
