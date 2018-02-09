package Test;

import org.junit.*;
import static org.junit.Assert.*;
import oxo.*;

public class Tests {

  @Test
  public void test1() {
      Board b = new Board();
      b.move(new Position(0,0));
      b.move(new Position(2,2));
      b.move(new Position(0,1));
      b.move(new Position(1,1));
      b.move(new Position(0,2));
      assertEquals("XXX\n.O.\n..O\n",b.toString());
      assertEquals(Player.X, b.winner());
      assertEquals(b.blanks().length, 4);
  }

  @Test
  public void test2() {
    Board b = new Board();
      b.move(new Position(2,2));
      b.move(new Position(0,2));
      b.move(new Position(2,1));
      b.move(new Position(1,1));
      b.move(new Position(1,2));
      b.move(new Position(2,0));
      assertEquals("..O\n.OX\nOXX\n",b.toString());
      assertEquals(Player.O, b.winner());
      assertEquals(b.blanks().length, 3);
  }

  @Test
  public void test3() {
    Board b = new Board();
      b.move(new Position(2,2));
      b.move(new Position(0,2));
      b.move(new Position(2,1));
      b.move(new Position(1,1));
      b.move(new Position(1,2));
      b.move(new Position(2,0));
      b.move(new Position(1,0));
      b.move(new Position(0,0));
      b.move(new Position(0,1));
      assertEquals("OXO\nXOX\nOXX\n",b.toString());
      assertEquals(Player.O, b.winner());
      assertArrayEquals(b.blanks(), null);
  }

}
