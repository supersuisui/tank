package test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageTest {

	@Test
	public void test() {

		try {
			// BufferedImage image = ImageIO.read(new
			// File("‪C:/Users/Administrator/Desktop/BadTank1.png"));
			// assertNotNull(image);

			BufferedImage image2 = ImageIO
					.read(ImageTest.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			assertNotNull(image2);
		} catch (IOException e) {

			e.printStackTrace();
		}
		// fail("Not yet implemented");
		// assertNotNull(new Object());
	}

}
