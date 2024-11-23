package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import Texture.Texture;

import IO.Input;
import Texture.Sprite;
import Texture.SpriteSheet;

public class Player extends Entity {

	public static final int SPRITE_SCALE = 130;
	public static final int SPRITE_PER_HEADING = 1;
	
	private enum Heading {
		
		NORTH(0 * SPRITE_SCALE, 6 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
		EAST(0 * SPRITE_SCALE, 7 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
		SOUTH(0 * SPRITE_SCALE, 4 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
		WEST(0 * SPRITE_SCALE, 5 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE);

		private int x, y, h, w;

		Heading(int x, int y, int h, int w) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;
		}

		protected BufferedImage texture(Texture atlas) {
			return atlas.cut(x, y, w, h);
		}
	}

	private Heading heading;
	private Map<Heading, Sprite> spriteMap;
	private float scale;
	private float speed;

	public  Player(float x, float y, float scale, float speed,Texture atlas) {
		super(EntityType.Player, x, y);
		heading = Heading.NORTH;
		spriteMap = new HashMap<Heading, Sprite>();
		this.scale = scale;
		this.speed = speed;

		for (Heading h : Heading.values()) {
			SpriteSheet sheet = new SpriteSheet(h.texture(atlas), SPRITE_PER_HEADING, SPRITE_SCALE);
			Sprite sprite = new Sprite(sheet, scale);
			spriteMap.put(h, sprite);
			
		}
	}

	public void update(Input input){

		float newX = x;
		float newY = y;

		if(input.getKey(KeyEvent.VK_W)) {
			newY -= speed;
			heading = Heading.NORTH;
		}else if(input.getKey(KeyEvent.VK_D)) {
			newX += speed;
			heading = Heading.EAST;
		}else if(input.getKey(KeyEvent.VK_S)) {
			newY += speed;
			heading = Heading.SOUTH;
		}else if(input.getKey(KeyEvent.VK_A)) {
			newX -= speed;
			heading = Heading.WEST;
		}

		if(newX < 0) {
			newX = 0;
		}else if(newX >= Game.WIDTH - SPRITE_SCALE * scale) {
			newX = Game.WIDTH - SPRITE_SCALE * scale;
		}

		if(newY < 0) {
			newY = 0;
		}else if(newY >= Game.HEIGHT - SPRITE_SCALE * scale) {
			newY = Game.HEIGHT - SPRITE_SCALE * scale;
		}

		x = newX;
		y = newY;

	}
	
	public void render(Graphics2D g) {
		
		spriteMap.get(heading).render(g, x, y);
	}

}
