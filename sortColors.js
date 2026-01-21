/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let zeros = 0;
    let ones = 0;
    let twos = 0;

    for(let i=0;i < nums.length;i++){
        if(nums[i] == 0){
            zeros++;
        }else if(nums[i] == 1){
            ones++;
        }else{
            twos++;
        }
    }

    for(let i =0;i<nums.length;i++){
        if(zeros!=0){
            nums[i] = 0;
            zeros--;
        }else if(ones!=0){
            nums[i] = 1;
            ones--;
        }else if(twos!=0){
            nums[i] = 2;
            twos--;
        }
    }
}


let nums = [[2,0,2,1,1,0],[2,0,1],[0,2,1],[1,2,0],[1,0,1]];

nums.forEach((array)=> {
    sortColors(array);
    console.log(array);
})