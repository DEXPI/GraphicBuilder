package org.dexpi.pid.test.testCases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * This class gets two images and compares them whether 
 * they are equal - these two images have to be of the 
 * same size, as it will be compared whether the pixels are identical.
 * 
 *  If they are not identical there are two different 
 *  output-images that can be written: 
 *  
 *  - Overlay, wheras the original image is written as a grayed out image 
 *  and the difference is written in red into the grayed out original.
 *  
 *  - Harddiff, where only the difference is written in neon-green on a black
 *  canvas that has the size of the original image, so one can easily spot the
 *  divergences
 *  
 *  @MaHe08
 */

public abstract class ImageComparer {
	public enum diffImageStyle {
		NONE, OVERLAY, HARDDIFF, ALL
	}

	/**
	 * This function gets two images, whereas imageOne is handled as the
	 * source-image. Returns true iff both images are identical, false else.
	 * 
	 * @param imageOne
	 *            image to be compared with
	 * @param imageTwo
	 *            image to compare
	 * @param path
	 *            path to file, needed for diffImage
	 * @return true iff images are equal
	 * @throws IOException
	 */
	public static boolean compareImages(BufferedImage imageOne,
			BufferedImage imageTwo, String path, diffImageStyle diffStyle)
			throws IOException {
		if (imageOne == null || imageTwo == null)
			throw new IOException("At least one Image is null!");

		int diffPixel = 0;

		// As neither image can be null anymore we can now safely work on them:
		int width = imageOne.getWidth();
		int height = imageOne.getHeight();

		// Compare size of images
		if (width == imageTwo.getWidth() && height == imageTwo.getHeight()) {

			// check every pixel regarding inequality
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					// return false if unequal
					if (imageOne.getRGB(x, y) != imageTwo.getRGB(x, y)) {
						++diffPixel;
					}
				}
			}
		} else {
			System.out.println("Size differs!");
			return false;
		}

		// return true iff images are equal, false else
		// additionally writes percentage and amount of different pixel to
		// console
		if (diffPixel > 0) {
			double percentage = ((double) diffPixel) / (width * height);
			System.out.println(diffPixel + " pixel differ!");
			System.out.println("This means " + percentage + "%!");

			// Paint difference-image(s) and store it in the given folder as
			// diffImage_<TYPE>.png
			paintDiffImage(imageOne, imageTwo, path, diffStyle);
			// return false if unequal
			return false;
		}

		System.out.println("Images equal!");
		return true;
	}

	/**
	 * 
	 * @param sampleImage
	 *            blueprint image to be compared with
	 * @param Path
	 *            path to file, e.g. "resources/"
	 * @param File
	 *            filename, e.g. "file.png"
	 * @return
	 */
	public static boolean compareImageWithImageFile(BufferedImage sampleImage,
			String Path, String File, diffImageStyle diffStyle) {
		try { //
			String PathWithFile = Path + File;
			BufferedImage createdImage = ImageIO.read(new File(PathWithFile));
			return ImageComparer.compareImages(sampleImage, createdImage, Path,
					diffStyle);
		} catch (IOException e) {
			System.out.println("Something went terribly wrong!");
			System.out.println("Probably check FilePath and FileName.");
			if (TestRunnerFiles.EXIT_ON_EXCEPTION)
				System.exit(1);
		}
		return false; // should never be reached
	}

	/**
	 * Handler to choose the kind of diff-image written
	 * 
	 * @param imageOne
	 *            image to compare with
	 * @param imageTwo
	 *            image to compare
	 * @param path
	 *            path to write diffImage to
	 */
	private static void paintDiffImage(BufferedImage imageOne,
			BufferedImage imageTwo, String path, diffImageStyle diffStyle) {

		switch (diffStyle) {
		case NONE:
			System.out.println("Chosen not to create diff-images!");
			return;
		case OVERLAY:
			System.out.println("Overlay chosen");
			paintDiffImageOVERLAY(imageOne, imageTwo, path);
			break;
		case HARDDIFF:
			System.out.println("Harddiff chosen");
			paintDiffImageHARD(imageOne, imageTwo, path);
			break;
		case ALL:
		default:
			System.out.println("All chosen");
			paintDiffImageOVERLAY(imageOne, imageTwo, path);
			paintDiffImageHARD(imageOne, imageTwo, path);
		}
	}

	/**
	 * writes a diffImage hard black/green-style to given path
	 * 
	 * @param imageOne
	 *            image to compare with
	 * @param imageTwo
	 *            image to compare
	 * @param path
	 *            path to write diffImage to
	 */
	private static void paintDiffImageHARD(BufferedImage imageOne,
			BufferedImage imageTwo, String path) {
		try {
			int width = imageOne.getWidth();
			int height = imageOne.getHeight();
			System.out.println("Write hard diff-image.");
			BufferedImage diffImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {

					if (imageOne.getRGB(x, y) != imageTwo.getRGB(x, y)) {
						diffImage.setRGB(x, y, Color.GREEN.getRGB());
					} else {
						diffImage.setRGB(x, y, Color.BLACK.getRGB());
					}
				}
			}

			File diffImageFile = new File(path + "diffImage_hard.png");
			ImageIO.write(diffImage, "png", diffImageFile);

			System.out.println("Diff-image written.");
		} catch (Exception ioe) {
			System.out.println("Exception: Couldn't write hard DiffImage");
			if (TestRunnerFiles.EXIT_ON_EXCEPTION)
				System.exit(1);
		}
	}

	/**
	 * writes a diffImage with an overly in gray/red-style to given path
	 * 
	 * @param imageOne
	 *            image to compare with
	 * @param imageTwo
	 *            image to compare
	 * @param path
	 *            path to write diffImage to
	 */
	private static void paintDiffImageOVERLAY(BufferedImage imageOne,
			BufferedImage imageTwo, String path) {
		try {
			int width = imageOne.getWidth();
			int height = imageOne.getHeight();
			System.out.println("Write overlay diff-image.");

			// first convert imageOne to grayscale-image

			BufferedImage grayImage = new BufferedImage(width, height,
					BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = grayImage.getGraphics();
			g.drawImage(imageOne, 0, 0, null);
			g.dispose();

			BufferedImage diffImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {

					if (imageOne.getRGB(x, y) != imageTwo.getRGB(x, y)) {
						diffImage.setRGB(x, y, Color.RED.getRGB());
					} else {
						diffImage.setRGB(x, y, grayImage.getRGB(x, y));
					}
				}
			}

			File diffImageFile = new File(path + "diffImage_overlay.png");
			ImageIO.write(diffImage, "png", diffImageFile);

			System.out.println("Diff-image written.");
		} catch (Exception ioe) {
			System.out.println("Exception: Couldn't write overlay-DiffImage");
			if (TestRunnerFiles.EXIT_ON_EXCEPTION)
				System.exit(1);
		}
	}
}