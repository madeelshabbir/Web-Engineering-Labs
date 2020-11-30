public class Matrix{
	int row;
	int col;
	double[][] arr;
	public Matrix(){
		this(0, 0);
	}
	public Matrix(int r, int c){
		this.row = r;
		this.col = c;
		this.arr = new double[r][c];
		for(int i = 0; i<this.row; i++)
			for(int j = 0; j<this.col; j++)
				this.arr[i][j] = 0;
	}
	public Matrix(Matrix m){
		this.row = m.row;
		this.col = m.col;
		this.arr = new double[m.row][m.col];
		for(int i = 0; i<this.row; i++)
			for(int j = 0; j<this.col; j++)
				this.arr[i][j] = m.arr[i][j];
	}
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
	public void setRow(int n){
		this.row = n;
	}
	public void setCol(int n){
		this.col = n;
	}
	public void setElement(int i, int j, double val){
		this.arr[i][j] = val;
	}
	public void add(Matrix obj1, Matrix obj2){
		if(obj1.col != obj2.col || obj1.row != obj2.row){
			System.out.println("Can't Add");
			return;
		}
		this.row = obj1.row;
		this.col = obj1.col;
		this.arr = new double[obj1.row][obj1.col];
		for(int i = 0; i<this.row; i++)
			for(int j = 0; j<this.col; j++)
				this.arr[i][j] = obj1.arr[i][j] + obj2.arr[i][j];
	}
	public void multiply(Matrix obj1, Matrix obj2){
		if(obj1.col != obj2.row){
			System.out.println("Can't Multiply");
			return;
		}
		this.row = obj1.row;
		this.col = obj2.col;
		this.arr = new double[obj1.row][obj2.col];
		for(int i = 0; i<obj1.row; i++){
			for(int j = 0; j<obj2.col; j++){
				this.arr[i][j] = 0;
				for(int k = 0; k<obj2.row; k++){
					this.arr[i][j]+= obj1.arr[i][k]*obj2.arr[k][j];
				}
			}
		}	
	}
	public void showMatrix(){
		for(int i = 0; i<this.row; i++){
			for(int j = 0; j<this.col; j++)
				System.out.print(this.arr[i][j]+" ");
			System.out.println();
		}

	}
}