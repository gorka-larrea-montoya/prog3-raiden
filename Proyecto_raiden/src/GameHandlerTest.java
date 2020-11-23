import static org.junit.Assert.*;
import org.junit.Test;

public class GameHandlerTest {	
	GameHandler h = new GameHandler();
	@Test
	public void testTick() {
		h.addObject(new EnemyBullet(800, 800, h));
		h.tick();
		assertEquals(0,h.objectList.size());
		h.addObject(new EnemyBullet(800, 300, h));
		assertEquals(1, h.objectList.size());
			
	}

	@Test
	public void testRemoveobject() {
		Block a = new Block(50, 50, 0, 0, ID.Block);
		h.addObject(a);
		h.removeobject(a);
		assertEquals(0, h.objectList.size());
	}
	
	@Test
	public void testGetters() {
		h.up = false;
		h.down = true;
		h.left = false;
		h.right = true;
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
		assertEquals(true, h.up);
		assertEquals(false, h.down);
		assertEquals(true, h.left);
		assertEquals(false, h.right);
		
	}

}
