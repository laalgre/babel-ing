package com.laura;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ArrayLeaders {

	/*
	 * Returns a sorted array with all the integers that can become a leader after
	 * increasing by 1 every element of a segment of length K. Leader: value of an
	 * array that occurs more than half of the size of the array Segment: sequence
	 * of K consecutive elements of the array
	 * 
	 * @param K length of each segment, K<100000, K<=A.length
	 * 
	 * @param M max value of each integer in the array A, M<100000
	 * 
	 * @param A array of integers
	 */
	public int[] solution(int K, int M, int[] A) throws IllegalArgumentException {

		int length = A.length;

		// Verify conditions
		if (length == 0 || K > 100000 || M > 100000 || K > length || !Arrays.stream(A).allMatch(p -> p <= M)) {
			throw new IllegalArgumentException();
		}
		
		HashSet<Integer> leaders = new HashSet<Integer>();

		IntStream.range(0, A.length - K + 1).mapToObj(i -> (List<Integer>) obtainLeaders(i, K, A))
											.forEach(p -> leaders.addAll(p));
		
		return leaders.stream().mapToInt(p -> p).toArray();
	}

	
	
	/*
	 * Calculates the leaders of the array associated to one segment increase
	 *
	 **/
	public List<Integer> obtainLeaders(int start, int segment, int[] A) {
		
		Integer[] combination = Arrays.stream(A).boxed().toArray(Integer[]::new);
		
		//Get new array increasing by 1 the elements of segment that starts in ´start´
		for (int i = start; i < start + segment; i++) {
			combination[i]++;
		}
		
		//Return leaders of new array
		return Arrays.stream(combination).distinct()
				.filter(p -> Collections.frequency(Arrays.asList(combination), p) > combination.length / 2)
				.collect(Collectors.toList());
	}
}
