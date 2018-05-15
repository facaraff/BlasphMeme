package benchmarks.problemsImplementation.cec2005;


public class F14 extends TestFunction {

	// Fixed (class) parameters
	static final public String FUNCTION_NAME = "Shifted Rotated Expanded Scaffer's F6 Function";
	static final public String DEFAULT_FILE_DATA = "supportData/E_ScafferF6_func_data.txt";
	static final public String DEFAULT_FILE_MX_PREFIX = "supportData/E_ScafferF6_M_D";
	static final public String DEFAULT_FILE_MX_SUFFIX = ".txt";

	// Shifted global optimum
	private final double[] m_o;
	private final double[][] m_matrix;

	// In order to avoid excessive memory allocation,
	// a fixed memory buffer is allocated for each function object.
	private double[] m_z;
	private double[] m_zM;

	// Constructors
	public F14 (int dimension, double bias) {
		this(dimension, bias, DEFAULT_FILE_DATA, DEFAULT_FILE_MX_PREFIX + dimension + DEFAULT_FILE_MX_SUFFIX);
	}
	public F14 (int dimension, double bias, String file_data, String file_m) {
		super(dimension, bias, FUNCTION_NAME);

		// Note: dimension starts from 0
		m_o = new double[m_dimension];
		m_matrix = new double[m_dimension][m_dimension];

		m_z = new double[m_dimension];
		m_zM = new double[m_dimension];

		// Load the shifted global optimum
		Benchmark.loadRowVectorFromFile(file_data, m_dimension, m_o);
		// Load the matrix
		Benchmark.loadMatrixFromFile(file_m, m_dimension, m_dimension, m_matrix);
	}

	// Function body
	public double f(double[] x) {

		double result = 0.0;

		Benchmark.shift(m_z, x, m_o);
		Benchmark.rotate(m_zM, m_z, m_matrix);

		result = Benchmark.EScafferF6(m_zM);

		// XXX (gio) fixes -inf bug
		if (Double.isInfinite(result))
			result = Double.POSITIVE_INFINITY;
		
		result += m_bias;

		return (result);
	}
}
