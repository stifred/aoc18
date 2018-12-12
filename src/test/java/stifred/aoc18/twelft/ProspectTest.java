package stifred.aoc18.twelft;

import org.junit.Test;

import java.io.PipedOutputStream;

import static org.junit.Assert.*;

public class ProspectTest {
  @Test
  public void testDoesApplyTo() {
    Pot pot1 = new Pot(1, false, null, null);
    Pot pot2 = new Pot(2, true, null, null);
    Pot pot3 = new Pot(3, false, null, null);
    Pot pot4 = new Pot(4, true, null, null);
    Pot pot5 = new Pot(5, false, null, null);

    pot1.addRight(pot2);
    pot2.addRight(pot3);
    pot3.addRight(pot4);
    pot4.addRight(pot5);

    Prospect prospect1 = Prospect.from(".#.#. => #");
    Prospect prospect2 = Prospect.from("#.#.. => .");

    assertTrue(prospect1.doesApplyTo(pot3));
    assertFalse(prospect2.doesApplyTo(pot3));
  }
}
