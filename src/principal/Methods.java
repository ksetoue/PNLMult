package principal;

import exceptions.LexerException;
import exceptions.ParserException;
import parser.JParser;

public class Methods {
	public double result;
	public double a_lim;
	public double b_lim;
	public double l;
	public double epso;
	public double delta;
	public int    k;
	public String func;
	JParser jp = JParser.getInstance();
	

	double buscaUniforme() throws LexerException, ParserException{
		double fx, fxk, a, b;
		double x, xk, xant;
		double delta_local = delta;
		a = a_lim;
		b = b_lim;
		/**
		 * @comment 
		 * xant corresponde ao x anterior, usado no refinamento
		 * x é o valor de x usado para calcular xk
		 * xk é o x da iteração atual
		 */
		
		xant = a;
		x = a;
		xk = a+delta_local;
		jp.setVariable(x);
		jp.compileExpression(func);
		fx = jp.evaluate();
		jp.setVariable(xk);
		jp.compileExpression(func);
		fxk = jp.evaluate();
		//System.out.println("x = " + x + " delta = "+delta + "fx = " + fx + " xk = " + xk +" fxk = " + fxk);
		
		while((fx > fxk) && (x<=b)){
			
			x = xk;
			xk = xk + delta_local;
			/**calcular fx e fxk**/
			jp.setVariable(x);
			jp.compileExpression(func);
			fx = jp.evaluate();
			jp.setVariable(xk);
			jp.compileExpression(func);
			fxk = jp.evaluate();
			//System.out.println("x = " + x + " delta = "+delta + "fx = " + fx + " xk = " + xk +" fxk = " + fxk);
			
		}
		xant = x-delta_local;
		//System.out.println("Depois while \nxant = "+xant+"x = " + x + " delta = "+delta + "fx = " + fx + " xk = " + xk +" fxk = " + fxk);
		/**
		 * Refinamento
		 * **/
		//b = xk + delta;
		x = xant;
		delta_local = (delta_local/((double)10));
		xk = x+delta_local; 	
		
		
		jp.setVariable(x);
		jp.compileExpression(func);
		fx = jp.evaluate();
		jp.setVariable(xk);
		jp.compileExpression(func);
		fxk = jp.evaluate();
		//System.out.println("x = " + x + " delta = "+delta + "fx = " + fx + " xk = " + xk +" fxk = " + fxk);
		
		while((fx > fxk) && (x <= b)){
			x = xk;
			xk = xk + delta_local;
			/**calcular fx e fxk**/
			/**calcular fx e fxk**/
			jp.setVariable(x);
			jp.compileExpression(func);
			fx = jp.evaluate();
			jp.setVariable(xk);
			jp.compileExpression(func);
			fxk = jp.evaluate();
			//System.out.println("x = " + x + " delta = "+delta + " fx = " + fx + " xk = " + xk +" fxk = " + fxk);
		}
		//System.out.println("Depois while \nxant = "+xant+"x = " + x + " delta = "+delta + " fx = " + fx + " xk = " + xk +" fxk = " + fxk);
		return x; 
	}
	
	double buscaDicotomica() throws LexerException, ParserException{
		double x, z, xotimo, a, b;
		double fx, fz;
		a = a_lim;
		b = b_lim;
		//System.out.println("antes a = "+a+" b = "+b);
		while((b - a)> l && k > 0){
			x = ((a+b)/2) - epso;
			
			z = ((a+b)/2) + epso;
			
			jp.setVariable(x);
			jp.compileExpression(func);
			fx = jp.evaluate();
			jp.setVariable(z);
			jp.compileExpression(func);
			fz = jp.evaluate();
			//System.out.println("x = "+x+" fx = "+fx+" z = "+z+" fz = "+fz);
			if(fx > fz){
				a = x; 
			} 
			else {
				b = z;
			}
			//System.out.println("a = "+a+" b = "+b);
			k = k -1;
		}
		
		xotimo = (a+b)/2; 
		
		return xotimo;		
	}
	
	double secaoAurea() throws LexerException, ParserException{
		double xotimo, mi, lambda, fmi, flambda, a, b;
		double alpha = (-1+Math.sqrt(5))/2, beta = 1-alpha;
		a = a_lim;
		b = b_lim;
		mi = a + beta*(b-a);
		lambda = a+alpha*(b-a);
		
		jp.setVariable(mi);
		jp.compileExpression(func);
		fmi = jp.evaluate();
		jp.setVariable(lambda);
		jp.compileExpression(func);
		flambda = jp.evaluate();
		//System.out.println("mi = "+mi+" fmi = "+fmi+" lambda = "+lambda+" flambda = "+flambda);
		
		while ((b-a) > l && k>0){
			if(fmi > flambda){
				a = mi;
				mi = lambda;
				lambda =a+alpha*(b-a);
			}
			else{
				b = lambda;
				lambda = mi;
				mi = a + beta*(b-a);				
			}
			//System.out.println("a = "+a+" b = "+b);
			jp.setVariable(mi);
			jp.compileExpression(func);
			fmi = jp.evaluate();
			jp.setVariable(lambda);
			jp.compileExpression(func);
			flambda = jp.evaluate();
			//System.out.println("mi = "+mi+" fmi = "+fmi+" lambda = "+lambda+" flambda = "+flambda);
			k = k - 1;
		}
		xotimo = (a+b)/2;
		return xotimo;
	}
	
	double fibonacci() throws LexerException, ParserException{
		double xotimo, mi, lambda, fmi, flambda;
		double a, b; 
		a = a_lim;
		b = b_lim;
		int FN = (int) ((b-a)/l); 
		int N;
		boolean sair = false; 
		//System.out.println("FN = "+FN);
		double[] Fibo = new double[250]; 
		
		Fibo[0] = 1;
		Fibo[1] = 1;
		N = 1;
		
		while(!sair){
			if(Fibo[N] > FN )
				sair = true; 
			N = N+1;
			Fibo[N] = Fibo[N-1] + Fibo[N-2];
		}
		N = N-1;
		/*for(i = 0; i < N; i++){
			System.out.println("Fibo["+i+"] = " +Fibo[i]);
		}*/
		//System.out.println("FORA! N = "+N+"div = "+(Fibo[N-2])/(Fibo[N]) + "Fibo[N-2] = "+Fibo[N-2]+"Fibo[N] = "+Fibo[N] );
		mi = a +  ((Fibo[N-2])/(Fibo[N]))*(double)(b-a);
		lambda = a+ ((Fibo[N-1])/(Fibo[N]))*(double)(b-a);
		/*
		jp.setVariable(mi);
		jp.compileExpression(func);
		fmi = jp.evaluate();
		jp.setVariable(lambda);
		jp.compileExpression(func);
		flambda = jp.evaluate();
		System.out.println("mi = "+mi+" fmi = "+fmi+" lambda = "+lambda+" flambda = "+flambda);
		*/
		for(int k = 1; k <= N-2; k++){
			//System.out.println("a = "+a+" b = "+b);
			
			jp.setVariable(mi);
			jp.compileExpression(func);
			fmi = jp.evaluate();
			jp.setVariable(lambda);
			jp.compileExpression(func);
			flambda = jp.evaluate();
			//System.out.println("mi = "+mi+" fmi = "+fmi+" lambda = "+lambda+" flambda = "+flambda);
			
			if(fmi > flambda){
				a = mi;
				mi = lambda;
				lambda = a+((Fibo[N-k-1])/(Fibo[N-k]))*(double)(b-a);
				//System.out.println("fmi > flambda\nN = "+N+" div = "+(Fibo[N-k-1])/(Fibo[N-k]) + " Fibo[N-k-1] = "+Fibo[N-k-1]+" Fibo[N-k] = "+Fibo[N-k] );
			}
			else{
				b = lambda;
				lambda = mi;
				mi = a+((Fibo[N-k-2])/(Fibo[N-k]))*(double)(b-a);
				//System.out.println("fmi < flambda\nN-k = "+(N-k)+" div = "+(Fibo[N-k-2])/(Fibo[N-k]) + " Fibo[N-k-2] = "+Fibo[N-k-2]+" Fibo[N-k] = "+Fibo[N-k] );
			}
			
		}
		
		xotimo = (a+b)/2;
		return xotimo;
	
	}
	

double derivadaprim(double x) throws LexerException, ParserException{
	double h, d1, d2 = 1000;
	double f1, f2;
	int i;
	h = 1;
	jp.setVariable(x+h);
	jp.compileExpression(func);
	f1 = jp.evaluate();
	jp.setVariable(x-h);
	jp.compileExpression(func);
	f2 = jp.evaluate();
	d1 = (f1-f2)/(2*h);
	h = h/2;
	for (i = 0; i < 10; i++){
	   jp.setVariable(x+h);
	   jp.compileExpression(func);
 	   f1 = jp.evaluate();
   	   jp.setVariable(x-h);
	   jp.compileExpression(func);
	   f2 = jp.evaluate();
	   d2 = (f1-f2)/(2*h);
	   if (Math.abs(d2-d1)< 0.000001){
		     return d2;
	   }
	   else {
	      d1 = d2;
	      h = h/2;
	   }
	}
	return d2;
}


double derivadasec(double x) throws LexerException, ParserException{
	double h, d1, d2 = 1000;
	double f1, f2, f3;
	int i;
	h = 1;
	jp.setVariable(x+(2*h));
	jp.compileExpression(func);
	f1 = jp.evaluate();
	jp.setVariable(x-(2*h));
	jp.compileExpression(func);
	f2 = jp.evaluate();
	jp.setVariable(x);
	jp.compileExpression(func);
	f3 = jp.evaluate();
	d1 = (f1 - 2*f3 + f2)/(4*h*h);
	h = h/2;
	for (i = 0; i < 10; i++){	
 	    jp.setVariable(x+(2*h));
	    jp.compileExpression(func);
	    f1 = jp.evaluate();
	    jp.setVariable(x-(2*h));
	    jp.compileExpression(func);
	    f2 = jp.evaluate();
   	    jp.setVariable(x);
	    jp.compileExpression(func);
	    f3 = jp.evaluate();
   	    d2 = (f1 - 2*f3 + f2)/(4*h*h);
		if (Math.abs(d2-d1)< 0.000001){
			return d2;
		}
		else {
		  d1 = d2;
		  h = h/2;
		}
	}
	return d2;
}


double bissecao() throws LexerException, ParserException{
		double xk, xotimo, a, b, n;
		double flin;
		int nint;
		a = a_lim;
		b = b_lim;
		n = Math.log10((l/(b-a)))/Math.log10(0.5);
		nint = (int) Math.round(n); // *****arredondar para cima;
		if((n - (double)nint) >= 0.1)
			nint = nint+1;
		//System.out.println("Bissecao = antes n = "+n+" nint = "+nint);
		//System.out.println("Bissecao = l/b-a = "+l/(b-a)+" log = "+Math.log10((l/(b-a)))+" log(.5) = "+Math.log10(0.5));
		while (nint != 0) {
			xk = (a+b)/2;
			flin = derivadaprim(xk);
			if (flin < 0){
			   a = xk;	
			}
			else{
			  if (flin > 0){
			     b = xk;
			  }
			  else{
				  return xk;
			  }
			}
			n = n - 1;
		}
		xotimo = (a+b)/2;
		return xotimo;
}


double newton() throws LexerException, ParserException{
		double x, xk, xotimo, cp, a;
		double flin, fdlin;
		a = a_lim;
		x = a;
		flin = derivadaprim(x);
		do {
		   fdlin = derivadasec(x);
		   xk = x - flin/fdlin;
		   cp = Math.abs(xk-x)/Math.max(x,1);
		   x = xk; 
		   flin = derivadaprim(x);
		} while (Math.abs(flin) > epso || cp > epso);
		xotimo = xk;
		return 	xotimo;
}
}
