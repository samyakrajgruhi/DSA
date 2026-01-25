/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a,b) => a[0] -b[0]);
    const answer = [intervals[0]];

    for(let i = 1;i<intervals.length;i++){
        
        if(intervals[i][0] <= answer[answer.length - 1][1]){
            answer[answer.length - 1][1] = Math.max(answer[answer.length - 1][1],intervals[i][1]);
        
        }else{
            answer.push(intervals[i]);
        }
    }
    return answer;
};
// [[1,4],[0,0]]

// [[1,4]]
let intervals = [[1,3],[2,6],[8,10],[15,18]]
console.log(merge(intervals));
