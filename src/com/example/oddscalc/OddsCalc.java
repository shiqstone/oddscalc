package com.example.oddscalc;

import java.math.BigDecimal;

public class OddsCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal res = new BigDecimal(12.345);
		res.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(res.toString());
	}
	

}
