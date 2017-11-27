import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Frame[] user = new Frame[11];
		int x;
		int y;
		Scanner input;
		int strikeCounter = 0;
		for (int i = 1; i < user.length; i++) {

			System.out.println("Frame " + (i) + " Enter round 1:");
			input = new Scanner(System.in);
			x = input.nextInt();
			if (x < 10) {
				System.out.println("Frame " + (i) + " Enter round 2:");
				input = new Scanner(System.in);
				y = input.nextInt();
			} else
				y = 0;

			user[i] = new Frame(x, y);//Initilazie a Frame object

			// IF THERE IS A STRIKE
			while (user[i].isStrike() && i<=user.length-2) {
				i++;
				System.out.println("Frame " + (i) + " Enter round 1:");
				input = new Scanner(System.in);
				x = input.nextInt();
				if (x < 10) {
					System.out.println("Frame " + (i) + " Enter round 2:");
					input = new Scanner(System.in);
					y = input.nextInt();
				} else
					y = 0;

				user[i] = new Frame(x, y);
				
				// if the current frame isn't a strike, it will update the previous frame total
				if (user[i].isStrike() && strikeCounter == 1) {
					user[i - (1+strikeCounter)].updateTheTotals(user[i].getRoundOnePoints() + user[i].getRoundTwoPoints()); // UPDATE THE PREVIOUS FRAMETOTAL
					
					// printing previous frame results
					System.out.println();
					System.out.println("frame " + (i - 1) + " Total: " + user[i - 1].getFrameTotal());// PRINTS THE TOTAL POINTS OF A FRAME
					System.out.println("totalCount: " + user[i].getTotalCount());// PRINTS THE OVERALL TOTAL POINTS
					System.out.println();

					// printing current frame results
					System.out.println();
					System.out.println("frame " + i + " Total: " + user[i].getFrameTotal());// PRINTS THE TOTAL OF A FRAME
					System.out.println("totalCount: " + user[i].getTotalCount());// PRINTS THE OVERALL TOTAL POINTS
					System.out.println();
					strikeCounter = 0;
				} else 
					strikeCounter++;
			}//end of strike while loop

			
			// IF THERE IS A SPARE
			while (user[i].isSpare() && i<=user.length-2) {
				i++;// MOVE ON TO THE NEXT FRAME
				
				System.out.println("Frame " + (i) + " Enter round 1:");
				input = new Scanner(System.in);
				x = input.nextInt();
				if (x < 10) {
					System.out.println("Frame " + (i) + " Enter round 2:");
					input = new Scanner(System.in);
					y = input.nextInt();
				} else
					y = 0;
				
				user[i] = new Frame(x, y);
				user[i - 1].updateTheTotals(user[i].getRoundOnePoints());// UPDATE PREVIOUS FRAME
				
				// printing previous frame results
				System.out.println();
				System.out.println("frame " + (i - 1) + " Total: " + user[i - 1].getFrameTotal());// PRINTS THE TOTAL POINTS OF A FRAME
				System.out.println("totalCount: " + user[i].getTotalCount());// PRINTS THE OVERALL TOTAL POINTS
				System.out.println();

				// printing current frame results
				System.out.println();
				System.out.println("frame " + i + " Total: " + user[i].getFrameTotal());// PRINTS THE TOTAL OF A FRAME
				System.out.println("totalCount: " + user[i].getTotalCount());// PRINTS THE OVERALL TOTAL POINTS
				System.out.println();
			}//end of spare while loop
			
			//if there is no spare and no strike
			if (!(user[i].isSpare()) && !(user[i].isStrike())) {
				System.out.println();
				System.out.println("frame " + i + " Total: " + user[i].getFrameTotal());// PRINTS THE TOTAL OF A FRAME
				System.out.println("totalCount: " + user[i].getTotalCount());// PRINTS THE OVERALL TOTAL POINTS
				System.out.println();
			}

		} // end of main for loop

	}// end of main
}
