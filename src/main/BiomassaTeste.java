package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class BiomassaTeste {

	public static void main(String[] args) {
		//Carrega arquivo fcl
		FIS fis = FIS.load("src/resource/biomassa.fcl", true);
		
		if (fis == null) {
			System.err.println("Can't load file");
			System.exit(1);
		}

		
		// Mostra todas as varivais linguisticas em grafico
        JFuzzyChart.get().chart(fis.getFunctionBlock("biomassa"));
		
	    //Seta as entradas para cada variavel linguistica
        fis.setVariable("experiencia", 2); 
	    fis.setVariable("responsabilidade", 0.65);
	    fis.setVariable("digestibilidadeRacao", 0.7);
	    fis.setVariable("qualidadeAgua", 0.7);
	    
	    //Avalia as regras
	    fis.evaluate();

	    //Mostra saída em grafico
        Variable biomassa = fis.getFunctionBlock("biomassa").getVariable("produtividade");
        JFuzzyChart.get().chart(biomassa, biomassa.getDefuzzifier(), true);
        System.out.println(biomassa.getValue());
	}

}
