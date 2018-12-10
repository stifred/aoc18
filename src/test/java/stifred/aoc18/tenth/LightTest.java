package stifred.aoc18.tenth;

import org.junit.Test;

import static org.junit.Assert.*;

public class LightTest {
  @Test
  public void testFrom() {
    String input = "position=< 1,  4> velocity=< 2,  1>";
    Light light = Light.from(input);

    assertEquals(1, light.positionAt(0).getX());
    assertEquals(4, light.positionAt(0).getY());
    assertEquals(3, light.positionAt(1).getX());
    assertEquals(5, light.positionAt(1).getY());
    assertEquals(5, light.positionAt(2).getX());
    assertEquals(6, light.positionAt(2).getY());
  }
}