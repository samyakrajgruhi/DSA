/**
 * @param {number[]} nums
 * @return {number}
 */
var merge = function(nums,left,mid,right){
  let temp = [];
  let low = left;
  let high = mid+1;
  
}
var mergeSort = function(nums,left,right){
  if(left > right){
    return;

  }

  let mid = Math.floor(left + (right-left) / 2);
  console.log(mid);
}

var reversePairs = function (nums) {
  mergeSort(nums,0,nums.length-1);
};

let nums = [1,3,2,3,1]
reversePairs(nums);