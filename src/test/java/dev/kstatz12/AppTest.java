/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.kstatz12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
    @Test public void testPuzzleOneP2() {
        OneP2 puzzle = new OneP2(new MockInputOne());
        assertEquals(241861950, (long)puzzle.run());
    }

    @Test public void testPuzzleOne() {
        One puzzle = new One(new MockInputOne());
        assertEquals(puzzle, puzzle);
    }

    @Test public void testPuzzleTwo() {
        Two two = new Two(new MockInputTwo());


        Integer result = two.run();
        Integer expected = 2;

        assertEquals(expected, result);
    }

    @Test public void testPuzzleTwoP2() {
        TwoP2 puzzle = new TwoP2(new MockInputTwo());

        Integer result = puzzle.run();

        Integer expected = 1;

        assertEquals(expected, result);
    }
}
