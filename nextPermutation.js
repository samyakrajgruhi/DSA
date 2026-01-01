/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    let pivot= -1;
    let swapElem = -1;
    for(let i=nums.length-2;i>=0;i--){
        if(nums[i] < nums[i+1]){ pivot = i; break; }
    }
    if(pivot=== -1){ nums.reverse(); return }

    for(let i=nums.length-1;i>=0;i--){
        if(nums[i]>nums[pivot]){swapElem= i; break;}
    }

    [nums[pivot],nums[swapElem]] = [nums[swapElem],nums[pivot]];
    let left = pivot + 1;
    let right = nums.length - 1;
    while (left < right) {
        [nums[left], nums[right]] = [nums[right], nums[left]];
        left++;
        right--;
    }
    
    return;
};

let nums= [1,3,2];
nextPermutation(nums)
console.log(nums);