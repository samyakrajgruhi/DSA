var setColumnZero = function(matrix,colVal){
    matrix.forEach((row, i) => {
        row.forEach((col,j) => {
            if(j == colVal){
                matrix[i][j] = 0;
            }
        })
    });
}

var setRowZero = function(matrix,rowVal){
    matrix.forEach((row, i) => {
        row.forEach((col,j) => {
            if(i == rowVal){
                matrix[i][j] = 0;
            }
        })
    });
}

var setZeroes = function(matrix) {
    let zeroIndex = [];
    matrix.forEach((row, i) => {
        row.forEach((col,j) => {
            if(col === 0){
                zeroIndex.push([i,j]);
            }
        })
    });

    zeroIndex.forEach((zero) => {
        setColumnZero(matrix,zero[1]);
        setRowZero(matrix,zero[0]);
    })
};

matrix =[   [0,1,2,0],
            [3,4,5,2],
            [1,3,1,5]];

setZeroes(matrix);
console.log(matrix)