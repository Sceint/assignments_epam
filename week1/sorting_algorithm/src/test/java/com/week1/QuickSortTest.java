package com.week1;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		QuickSort t = new QuickSort();
		String result = t.sortbyQuicksort("45 3 23 12 54");
		assertEquals("3 12 23 45 54", result);
		
		result = t.sortbyQuicksort("54 32 12 564 12 34 54 65 1");
		assertEquals("1 12 12 32 34 54 54 65 564", result);
		
		result = t.sortbyQuicksort("76 32 90 12 4252 -12 0 23");
		assertEquals("-12 0 12 23 32 76 90 4252", result);
	}

}
