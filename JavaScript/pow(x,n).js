/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */

var power = function(x, n){
    if(n === 0) return 1;
    if(n === 1) return x;

    if(x%2 === 0){
        return power(x*x,Math.floor(n/2));
    }

    return x*(power(x,n-1));
}

var myPow = function(x,n){
    
    if(n<0){
        return 1.0/power(x,-n);
    }

    return power(x,n);

    
}

console.log(myPow(10,13))






// NOOB ANSWER, TAKES TOO MUCH TIME

// var myPow = function(x, n) {
//     let answer = 1;
//     if(n == 0) return answer;

//     if(n < 0){
//         x = 1/x;
//         n = -n;
//     }

//     for(let i=0;i<n;i++){
//         answer *= x;
//     }

//     return answer
// };
