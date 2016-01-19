# Problem-Set1
Dice Simulation

public class DiceSim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;
		
		int SIDES = 6;
		double[] prob = new double[2 * SIDES + 1];
		double[] freq = new double[2 * SIDES + 1];
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i + j] += 1.0;
		System.out.println("Theoretical\n");
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
			System.out.println("Result: " + k + " has " + dist[k]);
		}

		System.out.println();
		System.out.println("Experimental\n");

		while (compare(dist, prob)){
			int total = getTotal();
			freq[total] += 1.0;
			count++;
			
			for (int i = 2; i < prob.length; i++) {
				prob[i] = freq[i]/count;
			} 
		}
		
		for (int i = 2; i < prob.length; i++) {
			System.out.println("Result: " + i + " has " + prob[i]);
		}
		System.out.println("\n" + "It took " + count + " times to get the experimental probability closes to theoretical one." );
	}

	public static int getTotal() {
		int die1 = (int) (Math.random() * 6) + 1;
		int die2 = (int) (Math.random() * 6) + 1;
		
		return die1 + die2;
	}

	public static boolean compare(double[] a, double[] b) {
		int round = 0;
		for (int i = 2; i < a.length; i++){
			if (Math.abs(a[i] - b[i]) < 0.001 )
				round++;
		}
			if (round == 11)
			return false;
		
		return true;
	}
}

