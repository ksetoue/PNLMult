package principal;
import javax.swing.JFrame;

import exceptions.LexerException;
import exceptions.ParserException;
import principal.Screen;

@SuppressWarnings("serial")
public class MainClass extends JFrame{
	
	static double a;
	static double b;
	static double l;
	static double epso;
	static double delta;
	static int k;
	static boolean[] option;
	public static String fc; 
	static String text;

	static double result;
	static double[] resultArray = new double[6]; 
	
	MainClass(){	
	}
	
	public static double[] result() throws LexerException, ParserException{
		Methods calcular = new Methods();
		
		option = Screen.sendOption(); 
		
		calcular.func = fc; 
		calcular.a_lim = a;
		calcular.b_lim = b;
		calcular.l = l;
		calcular.epso = epso;
		calcular.delta = delta;
		calcular.k = k;
		/*send the result to Screen*/
		if(	option[0] == true){
			resultArray[0] = calcular.buscaUniforme();
		}
		if(	option[1] == true){
			resultArray[1] = calcular.buscaDicotomica();
		}
		if(	option[2] == true){
			resultArray[2] = calcular.secaoAurea();
		}
		if(	option[3] == true){
			resultArray[3] = calcular.fibonacci();
		}
		if(	option[4] == true){
			resultArray[4] = calcular.bissecao();
		}
		if(	option[5] == true){
			resultArray[5] = calcular.newton();
		}
		return (resultArray);
		
	}
	
	
}
