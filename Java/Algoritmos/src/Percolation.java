
public class Percolation {
	
	private WeightedQuickUnionUF uf;
	private boolean[] sites;
	private int width;
	private int totalSites;
	private int index;
	private int lastSite;

	public Percolation(int N) {
		// create N-by-N grid, with all sites blocked
		if (N <= 0) throw new IllegalArgumentException();
		this.width = N;
		this.totalSites = (int) Math.pow(this.width, 2);
		this.uf = new WeightedQuickUnionUF(totalSites + 2);
		this.sites = new boolean[totalSites + 2];
		this.lastSite = this.totalSites + 1;
	}

	public void open(int i, int j) {
		// open site (row i, column j) if it is not open already
		if (i<1 || j<1 || i>this.width || j>this.width) throw new IndexOutOfBoundsException ();
		this.index = (i - 1) * this.width + j;
		this.sites[index] = true;
		connectSites(i, j);
	}

	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
		if (i<1 || j<1 || i>this.width || j>this.width) throw new IndexOutOfBoundsException ();
		return this.sites[(i-1) * this.width + j];
	}

	public boolean isFull(int i, int j) {
		// is site (row i, column j) full?
		if (i<1 || j<1 || i>this.width || j>this.width) throw new IndexOutOfBoundsException ();
		return uf.connected(0, (i-1) * this.width + j);
	}

	public boolean percolates() {
		// does the system percolate?
		return uf.connected(0, this.lastSite);
	}
	
	private void connectSites(int i, int j) {
	  if (this.width == 1) {
	    connectWithTopSite(i, j);
	    connectWithBottomSite(i, j);
	  } else if (this.index % this.width == 1) {
			connectWithTopSite(i, j);
			connectWithRightSite(i, j);
			connectWithBottomSite(i, j);
		} else if (this.index % this.width == 0) {
			connectWithTopSite(i, j);
			connectWithLeftSite(i, j);
			connectWithBottomSite(i, j);
		} else {
			connectWithTopSite(i, j);
			connectWithLeftSite(i, j);
			connectWithRightSite(i, j);
			connectWithBottomSite(i, j);
		}
	}
	
	private void connectWithTopSite(int i, int j) {
		if (i == 1) {
			uf.union(0, index);
		} else if (isOpen(i - 1, j)) {
			uf.union(index, index - this.width);
		}
	}

	private void connectWithLeftSite(int i, int j) {
		if (isOpen(i, j - 1)) {
			uf.union(index, index - 1);
		}
	}

	private void connectWithRightSite(int i, int j) {
		if (isOpen(i, j + 1)) {
			uf.union(index, index + 1);
		}
	}

	private void connectWithBottomSite(int i, int j) {
		if (i == this.width) {
			uf.union(index, this.lastSite);
		} else if (isOpen(i + 1, j)) {
			uf.union(index, index + this.width);
		}
	}

	public static void main(String[] args) {
		// test client (optional)
		Percolation p = new Percolation(1);
		p.open(1, 1);System.out.println(p.isFull(1, 1));
		System.out.println(p.isFull(1, 1));
		System.out.println("Percolates -> " + p.percolates());
	}
}