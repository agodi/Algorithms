public class PercolationStats {

	private double[] sitesRecord;
	private double mean; 
	private double stddev;

	public PercolationStats(int N, int T) {
		// perform T independent experiments on an N-by-N grid
		this.sitesRecord = new double[T];
		int numSites = N * N;
		if (N <= 0 || T <= 0) throw new IllegalArgumentException();
		for (int i = 0; i < T; i++) {
			Percolation percolation = new Percolation(N);
			int sitesOpen = 0;
			while (true) {
				int row = StdRandom.uniform(N) + 1;
				int col = StdRandom.uniform(N) + 1;
				if (percolation.isOpen(row, col)) continue;
				percolation.open(row, col);
				sitesOpen++;
				if (percolation.percolates()) break;
			}
			this.sitesRecord[i] = (double) sitesOpen / numSites;
		}
		this.mean();
		this.stddev();
	}

	public double mean() {
		// sample mean of percolation threshold
	  this.mean = StdStats.mean(sitesRecord);
		return this.mean;
	}

	public double stddev() {
		// sample standard deviation of percolation threshold
		if (this.sitesRecord.length == 1) return Double.NaN;
		this.stddev = StdStats.stddev(sitesRecord);
		return this.stddev; 
	}

	public double confidenceLo() {
		// low endpoint of 95% confidence interval
		return this.mean - (1.96*this.stddev) / Math.sqrt(this.sitesRecord.length);
	}

	public double confidenceHi() {
		// high endpoint of 95% confidence interval
		return this.mean + (1.96*this.stddev) / Math.sqrt(this.sitesRecord.length);
	}

	public static void main(String[] args) {
		// test client (described below)
		PercolationStats stats = new PercolationStats(200, 100);
		System.out.println("mean " + stats.mean);
		System.out.println("stddev " + stats.stddev);
		System.out.println("confidence " + stats.confidenceLo() + ", " + stats.confidenceHi());
	}
}