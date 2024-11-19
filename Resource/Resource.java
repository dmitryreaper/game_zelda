package Resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	public static final String PATH = "res/";

	public static BufferedImage loadImage(String filename) {
		
		BufferedImage image = null;

		try{

			image = ImageIO.read(new File(PATH + filename));

		}catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}
