package org.dexpi.pid.imaging.compare;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Analyzes the pixels of two images and compares them.
 * 
 * @author El Pulpo
 *
 */
public class Compare {

	/**
	 * @param args console input arguments
	 */
	public static void main(String[] args) {
		// boolean equal = compareImages(
		// "files/junit_tests_files/testfile01_new.png",
		// "files/junit_tests_files/testfile01_Epq_SC_ref.png");

	}

	@SuppressWarnings("static-method")
	public boolean compareImages(String file1, String file2) {
		BufferedImage img1;
		BufferedImage img2;
		try {
			img1 = ImageIO.read(new File(file1));
			img2 = ImageIO.read(new File(file2));

			if (img1.getWidth() == img2.getWidth()
					&& img1.getHeight() == img2.getHeight()) {

				for (int x = 0; x < img1.getWidth(); x++) {

					for (int y = 0; y < img1.getHeight(); y++) {

						if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
							return false;
						}
					}
				}
			} else {
				return false;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
}
