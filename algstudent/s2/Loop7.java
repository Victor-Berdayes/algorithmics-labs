package algstudents.s12;

public class Loop7 {
	
	public static long loop5(int n) {
		long cont = 0;
		for (int i = 1; i <= n; i++) //n
			for (int j = 1; j <= n; j++) //n 
				for (int k = 1; k <= n; k*=3) // log(n)
					for(int l = 1; l <=n; l*=2) // log(n)
						cont++;
		//n^2 log(n)^2
		return cont;

	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;

		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (int n = 100; n <= 819200; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop5(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main
}
