package com.epam.bowling.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game bowling = new Game();

    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, bowling.score());
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, bowling.score());
    }

    @Test
    public void testOnSpare() {
        rollSpare();//Spare
        bowling.roll(3);
        rollMany(17, 0);
        assertEquals(16, bowling.score());
    }

    @Test
    public void testOnStrike() {
        rollStrike();//Strike
        bowling.roll(3);
        bowling.roll(4);
        rollMany(16, 0);
        assertEquals(24, bowling.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12,10);
        assertEquals(300, bowling.score());
    }

    private void rollMany(int tries, int pins) {
        for (int i = 0; i < tries; i++)
            bowling.roll(pins);
    }

    private void rollStrike() {
        bowling.roll(10);
    }

    private void rollSpare() {
        bowling.roll(5);
        bowling.roll(5);
    }

}
