/**
 * @param {number[]} nums
 * @return {number}
 */
var findMissingAndDuplicate = function(nums) {
    let countMap = new Map();

    for( let i = 1; i <= nums.length; i++){
        countMap.set(i,0);
    }

    for(let  i=0;i<nums.length;i++){
        countMap.set(nums[i],countMap.get(nums[i])+1);
    }

    
    let A,B;

    countMap.forEach((value,key) => {
        if(value > 1){
            A = key;
        }
        if(value == 0){
            B = key;
        }
    })

    return [A,B];
};

let nums = [1, 2, 3, 6, 7, 5, 7];

console.log(findMissingAndDuplicate(nums));
