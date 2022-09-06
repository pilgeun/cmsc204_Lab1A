import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	GradeBook g1, g2;
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		for (int score = 10; score <= 50; score += 10) {
			g1.addScore(score);
		}
		
		g2.addScore(45);
		g2.addScore(30);
		g2.addScore(90);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("10.0 20.0 30.0 40.0 50.0 "));
		assertTrue(g2.toString().equals("45.0 30.0 90.0 "));
	}
	@Test
	void testSum() {
		assertEquals(150, g1.sum(), .0001);
		assertEquals(165, g2.sum(), .0001);
	}
	@Test
	void testMinimum() {
		assertEquals(10, g1.minimum(), .001);
		assertEquals(30, g2.minimum(), .001);
	}
	@Test
	void testFinalScore() {
		assertEquals(140, g1.finalScore(), .001);
		assertEquals(135, g2.finalScore(), .001);
	}

}
