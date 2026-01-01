/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    if(numRows == 1) return [[1]];
    if(numRows == 2) return [[1],[1,1]];

    let answer = [[1],[1,1]];

    for(let answerIndex=1;answerIndex<numRows-1;answerIndex++){
    
        let pushArray = [], pushArrayIndex = 0;
        let i=0, j=1;
        while(pushArrayIndex<=answer[answerIndex].length){
            
            if(pushArrayIndex == 0 || pushArrayIndex == answer[answerIndex].length){
                pushArray.push(1);
                pushArrayIndex++;
            }else {
                let item = answer[answerIndex][i] + answer[answerIndex][j];
                console.log(item,i,j);
                i++;j++;
                pushArray.push(item);
                pushArrayIndex++
            }
        }
        answer.push(pushArray);
    }

    return answer;

};

generate(5);