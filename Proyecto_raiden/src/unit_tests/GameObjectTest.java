package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logica_interna.Enemy;
import logica_interna.GameHandler;
import logica_interna.ID;

public class GameObjectTest {
	
	GameHandler h = new GameHandler();
	Enemy en = new Enemy(50, 50, -2, 2, ID.Enemy, h);
	@Test
	public void testID() {
		en.setId(ID.Block);
		assertEquals(ID.Block, en.getId());
	}
	@Test
	public void testMove() {
		en.move();
		assertEquals(48, en.getX());
		assertEquals(52, en.getY());
	}
	@Test
	public void testSetters() {
		en.setVelX(-3);
		en.setVelY(3);
		en.tick();
		assertEquals(47, en.getX());
		assertEquals(53, en.getY());
	}

}
