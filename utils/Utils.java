package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		newImage.getGraphics().drawImage(image, 0, 0, width, height, null);

		return newImage;
	}

	public static int[][] levelParser(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
