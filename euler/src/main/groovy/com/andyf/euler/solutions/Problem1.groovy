package com.andyf.euler.solutions

/**
 * A script to solve Project Euler problem 1:
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.  Find the sum of
 * all the multiples of 3 or 5 below 1000.
 * 
 * @author Andy Fedus
 */

def numbers = []
// Iterate over all numbers below 1000
( 1 ..<1000 ).each { num ->
	 // If a number ends in 5 or 0, it's divisible by 5
	 def s = num as String
	 if (s.endsWith("5") || s.endsWith("0")) {
	 	numbers << num
	 } else {
	     // If the digits in a number sum to a number divisible
	     // by 3, then that number is divisible by 3 too
		 def sum = s.getChars().inject(0) { acc, d ->
			 acc += d as int
		 }
		 if (sum % 3 == 0) {
			 numbers << num
		 }
	 }
}

println numbers.sum()
println "${numbers.size} numbers, from ${numbers.first()} to ${numbers.last()}"