package design;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class fontInit {

    public void initialize() {
        try {
            // Load the custom font from a resource file
            InputStream fontInputStream = getClass().getResourceAsStream("/font/Montserrat-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontInputStream).deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Register the font
            ge.registerFont(customFont);

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
