package unit_tests;
import static org.junit.Assert.*;

import org.junit.Test;

import logica_interna.*;
public class GameHandlerTest {	
	GameHandler h = new GameHandler();
	@Test
	public void testTick() {
		h.addObject(new EnemyBullet(800, 800, h));
		h.tick();
		assertEquals(0,h.getObjectList().size());
		h.addObject(new EnemyBullet(800, 300, h));
		assertEquals(1, h.getObjectList().size());
			
	}

	@Test
	public void testRemoveobject() {
		Block a = new Block(50, 50, 0, 0, ID.Block);
		h.addObject(a);
		h.removeobject(a);
		assertEquals(0, h.getObjectList().size());
	}
	
	@Test
	public void testGetters() {
		h.setUp(false);
		h.setDown(true);
		h.setLeft(false);
		h.setRight(true);
		assertEquals(false, h.isUp());
		assertEquals(true, h.isDown());
		assertEquals(false, h.isLeft());
		assertEquals(true, h.isRight());	
	}
	
	@Test
	public void testSetters() {
		h.setUp(true);
		h.setDown(false);
		h.setLeft(true);
		h.setRight(false);
		assertEquals(true, h.isUp());
		assertEquals(false, h.isDown());
		assertEquals(true, h.isLeft());
		assertEquals(false, h.isRight());
		
	}

}
