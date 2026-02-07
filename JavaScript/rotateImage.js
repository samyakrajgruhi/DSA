/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    for(let i=0;i<matrix.length;i++){
        for(let j=0;j<matrix.length;j++){
            if(j>i){
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
            }
            
        }
    }
    for(let i=0;i<matrix.length;i++){
        let left = 0;
        let right = matrix.length-1;

        while(left<right){
            let temp = matrix[i][right];
            matrix[i][right] = matrix[i][left];
            matrix[i][left] = temp;
            left++;right--;
        }
    }
};

let matrix = [[1,2,3],[4,5,6],[7,8,9]];
rotate(matrix);

console.log(matrix);