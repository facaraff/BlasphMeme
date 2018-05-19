package benchmarks;


import benchmarks.problemsImplementation.CEC2014.CEC2014TestFunc;
import interfaces.Problem;


public class CEC2014 extends Problem
{
	private CEC2014TestFunc testFunc;
	
	public CEC2014(int dimension, int problemNum) throws Exception
	{
		 super(dimension, new double[] {-100, 100});  
		 setFID(".f"+problemNum);
		 
		 testFunc = new CEC2014TestFunc(dimension,problemNum);
	}
	
	public double f(double[] x)
	{
		return testFunc.f(x);
	}
}