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

package benchmarks;

import interfaces.Problem;
import utils.random.RandUtils;

public class ISBSuite extends Problem 
{
	public ISBSuite(int dimension, double[][] bounds) {super(dimension, bounds); setFID("f0");}
	
	public ISBSuite(String name, int dimension) {super(dimension); setBounds(getBoundaries(name,dimension));}
	
	
	public void setProblemFID(String string) {setFID(string);}

	public double f(double[] x){return RandUtils.random();}
	
	private double[][] getBoundaries(String name, int dimension)
	{
		switch (name) 
		{
		case "f0":
			setFID("f0");
			return initBoundaries(0, 1, dimension); 
		case "g0":
			setFID("g0");
			return initBoundaries(0, 100, dimension); 
		case "h0":
			setFID("h0");
			return initBoundaries(-0.6, 0.4, dimension); 
		case "i0":
			setFID("i0");
			return initBoundaries(-0.2, 0.1, dimension); 
		default:
			System.out.println("This fucntion is not define din the ISB test suite");
			return null; 
		}
	}
	
	private double[][] initBoundaries(double lowerBound, double upperBound, int dimension) 
	{
		double[][] boundaries = new double[dimension][2];
		
		for(int i=0; i<dimension; i++)
		{
			boundaries[i][0] = lowerBound;
			boundaries[i][1] = upperBound;
		}	
		return boundaries;
	}
}
