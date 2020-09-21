package com.laura;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;


class LeadersArrayApplicationTests {

	@Test
	public void testObtainLeader() {
		ArrayLeaders al = new ArrayLeaders();
		assertArrayEquals(new int[] {2}, al.solution(1, 4, new int[] { 1 }));
		assertArrayEquals(new int[] {}, al.solution(2, 4, new int[] { 1, 3 }));
		assertArrayEquals(new int[] {}, al.solution(3, 8, new int[] { 6, 6, 6, 6, 6, 6 }));
		assertArrayEquals(new int[] { 2, 3 }, al.solution(4, 2, new int[] { 1, 2, 2, 1, 2 }));
		
		//Provided array must have at least an element
		Throwable thrown = catchThrowable(() -> al.solution(4, 4, new int[] {}));
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
		//Length segment <= Array.length
		Throwable thrown1 = catchThrowable(() -> al.solution(4, 4, new int[] {1,3}));
		assertThat(thrown1).isInstanceOf(IllegalArgumentException.class);
		//Length segment <100000
		Throwable thrown2 = catchThrowable(() -> al.solution(400000, 4, new int[] {1,3}));
		assertThat(thrown2).isInstanceOf(IllegalArgumentException.class);
		//M must be <100000
		Throwable thrown3 = catchThrowable(() -> al.solution(2, 400000, new int[] {1,3}));
		assertThat(thrown3).isInstanceOf(IllegalArgumentException.class);
		//All integers must be <= M
		Throwable thrown4 = catchThrowable(() -> al.solution(2, 2, new int[] {1,3}));
		assertThat(thrown4).isInstanceOf(IllegalArgumentException.class);
	}

}
