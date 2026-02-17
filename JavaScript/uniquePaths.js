/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
 var factorial = function(num){
    if(num<= 1) return 1;
    return num*factorial(num-1);
 }
var uniquePaths = function(m, n) {
    let answer = factorial(m+n-2) / ((factorial(m-1))*(factorial(n-1)));
    return Math.round(answer);
};

console.log(uniquePaths(19,13))