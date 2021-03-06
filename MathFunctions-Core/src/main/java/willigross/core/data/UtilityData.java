/**
 *
 */
package willigross.core.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class UtilityData {

	private static final Logger logger = LoggerFactory.getLogger(UtilityData.class);

	/**
	 * A utility method that converts a string expression into a double value
	 *
	 * @param input the string input
	 * @return the calculated double value
	 * @throws IllegalArgumentException if input can't be converted to a number
	 */
	public static double readDoubleFromStringInput(String input) throws IllegalArgumentException {
		
		final DoubleEvaluator evaluator = new DoubleEvaluator();
		
		final double result = evaluator.evaluate(input);

		logger.info("Read {} from \"{}\"", result, input); //$NON-NLS-1$

		return result;
	}

	/**
	 * Convert a string into html format by replacing escape sequences like \n with <br< and color codes with the
	 * minecraft color code system
	 *
	 * @param string the string to convert
	 * @return the updated string
	 */
	public static String convertToHTML(String string) {
		String s = string;
		
		if (s.contains("\n")) //$NON-NLS-1$
			s = "<div align=\"center\">" + s; //$NON-NLS-1$
			
		s = s.replaceAll("\n", "<br><div align=\"center\">"); //$NON-NLS-1$ //$NON-NLS-2$		//new line
		
		s = s.replaceAll("�l", "<b>"); //$NON-NLS-1$ //$NON-NLS-2$		//bold
		s = s.replaceAll("�m", "<del>"); //$NON-NLS-1$ //$NON-NLS-2$		//strikethrough
		s = s.replaceAll("�n", "<ins>"); //$NON-NLS-1$ //$NON-NLS-2$		//unerline
		s = s.replaceAll("�o", "<i>"); //$NON-NLS-1$ //$NON-NLS-2$		//italic
		s = s.replaceAll("�r", "</b></del></ins></i>"); //$NON-NLS-1$ //$NON-NLS-2$		//reset

		s = s.replaceAll("�0", "<font color=\"rgb(  0,   0,   0)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//black
		s = s.replaceAll("�1", "<font color=\"rgb(  0,   0, 170)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//dark blue
		s = s.replaceAll("�2", "<font color=\"rgb(  0, 170,   0)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//dark green
		s = s.replaceAll("�3", "<font color=\"rgb(  0, 170, 170)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//dark aqua
		s = s.replaceAll("�4", "<font color=\"rgb(170,   0,   0)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//dark red
		s = s.replaceAll("�5", "<font color=\"rgb(170,   0, 170)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//dark purple
		s = s.replaceAll("�6", "<font color=\"rgb(255, 170,   0)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//gold
		s = s.replaceAll("�7", "<font color=\"rgb(170, 170, 170)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//gray
		s = s.replaceAll("�8", "<font color=\"rgb( 85,  85,  85)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//dark gray
		s = s.replaceAll("�9", "<font color=\"rgb( 85,  85, 255)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//blue
		s = s.replaceAll("�a", "<font color=\"rgb( 85, 255,  85)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//green
		s = s.replaceAll("�b", "<font color=\"rgb( 85, 255, 255)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//aqua
		s = s.replaceAll("�c", "<font color=\"rgb(255,  85,  85)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//red
		s = s.replaceAll("�d", "<font color=\"rgb(255,  85, 255)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//light purple
		s = s.replaceAll("�e", "<font color=\"rgb(255, 255,  85)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//yellow
		s = s.replaceAll("�f", "<font color=\"rgb(255, 255, 255)\">"); //$NON-NLS-1$ //$NON-NLS-2$		//white
		
		return "<html>" + s + "</html>"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
}
