package utils.algorithms.operators.aos;

public class ProbMatching extends OperatorSelection {

	protected double p_min;
	private double alpha;
	protected double[] quality;
	protected double[] prob;
	private int[] op_times;
	private double best_quality;
	
	public ProbMatching(int _n_operators, double _p_min, double _alpha, long _seed) {
		super(_n_operators, _seed);
		p_min = _p_min;
		alpha = _alpha;
		quality = new double[_n_operators];
		prob = new double[_n_operators];
		op_times = new int[_n_operators];
		best_quality = 0;
		
		for(int i=0; i<_n_operators; i++){
			prob[i] = 1.0/(double)_n_operators;
			quality[i] = 1.0;
			op_times[i] = 0;
		}
	}
	
	public double ApplyReward(int op){
		double reward = GetReward(op);
		UpdateQualityVector(op, reward);
		UpdateProbabilityVector();
		UpdateBestOp(op);
		op_times[op]++;
		times++;
		return reward;
	}
	
	public void UpdateBestOp(int op){
		double exploit_op = quality[op];
		//if the one that was the best has a lower \hat p, check between all; or if the previous best changed
		if((best_op==op && exploit_op < best_quality)||(best_op>=0 && quality[best_op] != best_quality)){
			best_quality = -1; best_op = 0;
			double exploit_aux = -1;
			for(int i=0; i<n_operators; i++){
				exploit_aux = quality[i];
				if(exploit_aux > best_quality){
					best_quality = exploit_aux;
					best_op = i;
				}
			}
		}
		else if (exploit_op >= best_quality){ //else if it is best than the previous best
			best_op = op;
			best_quality = exploit_op;
			
		}
	}
	
	protected int OptionNotTried(){
		
		//check how to handle random numbers here
		int i = rng.nextInt(n_operators);
		for (int j=0; j < n_operators; j++) {
			int k = (i + j) % n_operators;			
			if (op_times[k] == 0){
				//System.out.println("Returned Op. "+k);
				return k;
			}
		}
		System.out.println(" We are in big trouble \n");
		System.exit(1);
		return 0;
	}

	public int SelectOperator(){
		if(times < n_operators)
			return OptionNotTried();
		else{
			int op;
			double sorted = rng.nextDouble();
			double sum = 0;
			for(op = 0; op < n_operators-1; op++){
				sum += prob[op];
				if(sum > sorted){
					//System.out.println("Selected Op. "+op+" from "+n_operators+" operators");
					return op;
				}
			}
			//System.out.println("Selected Op. "+op+" from "+n_operators+" operators");
			return op;
		}
	}
	
	protected void UpdateQualityVector(int op, double reward){
		if(credit[0].getType()<3)
			quality[op] = quality[op] + (alpha * (reward - quality[op]) );
		else
			quality[op] = reward;
	}

	protected void UpdateProbabilityVector(){
		double sum = 0.0;
		for(int i=0; i<n_operators; i++)	
			sum += quality[i];
		for(int i=0; i<n_operators; i++)
			prob[i] = p_min + ((1.0 - ((double)n_operators) * p_min) * (quality[i]/sum));
	}
	
	@Override
	public double getProbability(int op) {
		if (op >=0 && op < n_operators)
			return prob[op];
		else return -1.0;
	}
}