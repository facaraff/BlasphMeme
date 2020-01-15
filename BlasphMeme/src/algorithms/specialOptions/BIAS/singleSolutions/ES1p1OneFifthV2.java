/**
Copyright (c) 2020, Fabio Caraffini (fabio.caraffini@gmail.com, fabio.caraffini@dmu.ac.uk)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met: 

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer. 
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution. 

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

The views and conclusions contained in the software and documentation are those
of the authors and should not be interpreted as representing official policies, 
either expressed or implied, of the FreeBSD Project.
*/
package algorithms.specialOptions.BIAS.singleSolutions;

import static utils.algorithms.Misc.generateRandomSolution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static utils.algorithms.Misc.fillAWithB;
import static utils.MatLab.multiply;
import static utils.MatLab.sum;
import static utils.MatLab.randUncorrelatedGauusian;

import interfaces.AlgorithmBias;
import interfaces.Problem;
import utils.random.RandUtils;

import static utils.RunAndStore.FTrend;

public class ES1p1OneFifthV2 extends AlgorithmBias
{
	@Override
	public FTrend execute(Problem problem, int maxEvaluations) throws Exception
	{
		double sigma = this.getParameter("p0").intValue(); //2??

		
		FTrend FT = new FTrend();
		int problemDimension = problem.getDimension(); 
		double[][] bounds = problem.getBounds();

		double[] best = new double[problemDimension];
		double[] newPt = new double[problemDimension];
		double fBest, newFit = Double.NaN;

		
		String fileName = "ES11V2"+this.correction; 
		
		fileName+="D"+problem.getDimension()+"f0-"+(run+1);
		File file = new File(Dir+fileName+".txt");
		if (!file.exists()) 
			file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		int prevID = -1;
		int newID = 0;
		long seed = System.currentTimeMillis();
		RandUtils.setSeed(seed);	
		String line = "# function 0 dim "+problemDimension+" sigma "+sigma+" max_evals "+maxEvaluations+" SEED  "+seed+"\n";
		bw.write(line);
		line = null;
		line = new String();
		//prevID = newID;
		
		
		int i = 0;
		if (initialSolution != null)
		{
			best = initialSolution;
			fBest = initialFitness;
		}
		else
		{
			best = generateRandomSolution(bounds, problemDimension);		
			fBest = problem.f(best);
			i++; newID++;
			
			line =""+newID+" "+formatter(fBest)+" "+i+" "+prevID;
			for(int k = 0; k < problemDimension; k++)
				line+=" "+formatter(best[k]);
			line+="\n";
			bw.write(line);
			line = null;
			line = new String();
			prevID = newID;
		}

		
		while (i < maxEvaluations)
		{
			newPt = sum(best,multiply(sigma,randUncorrelatedGauusian(problemDimension)));
			newPt = correct(newPt,best,bounds);
			newFit = problem.f(newPt);
			i++;
			
			if(newFit < fBest)
			{
				fBest = newFit;
				fillAWithB(best,newPt);
				FT.add(i, newFit);
				sigma = 1.5*sigma;
				
				line =""+newID+" "+formatter(fBest)+" "+i+" "+prevID;
				for(int k = 0; k < problemDimension; k++)
					line+=" "+formatter(best[k]);
				line+="\n";
				bw.write(line);
				line = null;
				line = new String();
				prevID = newID;
				
			}
			else if (newFit > fBest)
				sigma = Math.pow(1.5, -0.25)*sigma;

				
		}
		
		finalBest = best;
		FT.add(i, fBest);
		wrtiteCorrectionsPercentage(fileName, (double) this.numberOfCorrections/maxEvaluations,"correctionsSingleSol");
		bw.close();
		return FT;
	}
}
