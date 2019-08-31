package com.rzit.microservice.airports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarCollision {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer numberOfCars = Integer.valueOf(in.nextLine());
		List<String> cars = new ArrayList<>();
		Map<Double, Integer> timeMap = new HashMap<>();

		for (int i = 0; i < numberOfCars; i++) {
			String[] temp = in.nextLine().split("\\s+");
			Integer x = Integer.valueOf(temp[0]);
			Integer y = Integer.valueOf(temp[1]);
			Integer speed = Integer.valueOf(temp[2]);

			double distance = Math.sqrt(x * x + y * y);
			double time = distance / speed;

			if (timeMap.get(time) == null) {
				timeMap.put(time, 0);
			}
			timeMap.put(time, timeMap.get(time) + 1);
			System.out.println(x+ "\t"+ y +"\t" + speed + "\t time:" + time);
		}
		int total = 0;
		for (Integer n : timeMap.values()) {
			int ncr = (factorial(n) / (factorial(n - 2) * factorial(2)));
			System.out.println(n + "combination" + ncr);
			total = total + ncr;
		}
		System.out.println("total" + total);

	}

	public static int factorial(int n) {
		// 1
		int fact = 1;
		// 2
		for (int i = 1; i <= n; i++) {
			// 3
			fact = fact * i;
		}
		// 4
		return fact;
	}
}
