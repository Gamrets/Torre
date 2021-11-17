package org.iesalandalus.programacion.torreajedrez;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class ColorTest {
	
	private static final String ERROR_COLOR_NO_VALIDO = "ERROR: El color no es válido.";

	@Test
	public void nombresValidosColoresCreanColoresValidos() {
		
		Color color;
		
		color = Color.BLANCO;
		assertThat(ERROR_COLOR_NO_VALIDO, color,  equalTo(Color.BLANCO));
		
		color = Color.NEGRO;		
		assertThat(ERROR_COLOR_NO_VALIDO, color, equalTo(Color.NEGRO));
		
	}

}
