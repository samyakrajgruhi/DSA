/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let m = matrix.length;
    let n = matrix[0].length;

    for(let i = 0; i<m;i++){
        if( target <= matrix[i][n-1] && target >= matrix[i][0]){
            let left = 0, right = n-1;

            while(left <= right){
                
                let middle = Math.floor((left + right)/2)
                if(matrix[i][middle] === target){
                    return true;
                }else if(target > matrix[i][middle]){
                    left = middle+1;
                }else{
                    right = middle -1;
                }
            }
        }
    }

    return false;
};

let matrix = [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12] ]
let target = 8

console.log(searchMatrix(matrix,target));