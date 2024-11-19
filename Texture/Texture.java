package Texture;

import java.awt.image.BufferedImage;
import Resource.Resource;

public class Texture {

	BufferedImage image;

	public Texture(String imageName) {
		
		image = Resource.loadImage(imageName);
		
	}

	public BufferedImage cut(int x, int y, int w, int h) {
		
		return image.getSubimage(x,y,w,h);
	}
}
