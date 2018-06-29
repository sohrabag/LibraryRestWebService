

function Matrix(rows, cols){
	this.rows = rows;
	this.cols = cols;
	
	this.matrix = [];
	
	for(var i = 0; i < this.rows; i++ ){
		this.matrix[i] = [];
		for (var j=0; j < this.cols; j++){
			this.matrix[i][j] = 0;
		}
	}
}

Matrix.prototype.add = function(n){
	if( n instanceof Matrix){
		for(var i = 0; i < this.rows; i++){
			for(var j=0; j < this.cols; j++){
				this.matrix[i][j] = n.matrix[i][j];
			}
		}
	}
	else{
		for(var i=0; i < this.rows; i++){
			for(var j=0; j < this.cols; j++){
				this.matrix[i][j] += n;
			}
		}
	}
}

Matrix.prototype.multiply = function(n){
	if(n instanceof Matrix){
		//Matrix product
		if(this.cols !== n.rows){
			console.log('columns of A must match rows of B.');
			return undefined;
		}

		let a = this;
		let b = n;
		let result = new Matrix(a.rows, b.cols);

		for(let i=0; i < result.rows; i++){
			for(let j=0; j < result.cols; j++){
				let sum = 0;
				for(let k=0; k < a.cols; k++){
					sum += a.matrix[i][k] * b.matrix[k][j];
				}
				result.matrix[i][j] = sum;
			}
		}
		console.log(result);
		return result;
	}else{
		//scalar product
		for(var i=0; i < this.rows; i++){
			for(var j=0; j < this.cols; j++){
				this.matrix[i][j] *= n;
			}
		}
	}
}

Matrix.prototype.transpose = function(){
	let result = new Matrix(this.cols, this.rows);
	for(let i=0; i < this.rows; i++){
		for(let j=0; j < this.cols; j++){
			result.matrix[j][i] = this.matrix[i][j];
		}
	}
	return result;
}

function setup(){
	let a = new Matrix(2,3);
	a.randomize();
	let b = a.transpose();
	console.table(a.matrix);
	console.table(b.matrix);
//	let b = new Matrix(3,2);
//	a.randomize();
//	b.randomize();
//	console.table(a.matrix);
//	console.table(b.matrix);
//	
//	let c = a.multiply(b);
//	console.table(c.matrix);
}
Matrix.prototype.randomize = function(n){
	for(var i = 0; i < this.rows; i++){
		for(var j=0; j < this.cols; j++)
			{
					this.matrix[i][j] = Math.floor(Math.random() * 10);
			}
	}
}

clas NeuralNetwork {
	constructor(input_nodes, hidden_nodes, output_nodes){
		this.input_nodes = input_nodes;
		this.hidden_nodes = hidden_nodes;
		this.output_noses = output_nodes;
	}
}

feeforward(input){
	
	//LOTS OF MATRIX MATH!!
	return gurss;
}