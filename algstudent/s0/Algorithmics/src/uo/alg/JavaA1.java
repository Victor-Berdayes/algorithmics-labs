package uo.alg;

import java.util.ArrayList;

public class JavaA1 {
	
	public JavaA1() {
		int num = 10000;
		for(int i=0; i<7; i++) {
			long t1 = System.currentTimeMillis();
			ArrayList primes = primeList(num);
			long t2 = System.currentTimeMillis();
			int total = (int) (t2-t1);
			System.out.println("n =" + num + "***" + "time =" + total + " milliseconds");
			num *= 2;
		}
	}
	
	
	private ArrayList primeList(int n) {
		ArrayList primes = new ArrayList();
		for(int i =2; i<n+1;i++) {
			if(isPrime(i))
				primes.add(i);
		}
		return primes;
	}
	
	
	private boolean isPrime(int num) {
		for(int i = 2; i<num; i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
}
