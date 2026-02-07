/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    let i = m-1;
    let j = n-1;
    let k = nums1.length-1;
    while(k >= 0) {
        if(nums2[j] > nums1[i] || i == -1){
            nums1[k] = nums2[j];
            k--;j--;
        }else if(nums1[i] > nums2[j] || j==-1){
            nums1[k] = nums1[i];
            k--;i--;
        }else{
            nums1[k] = nums2[j];
            j--;k--;
        }
    }
};

let nums1 = [2,0]
let m = 1
let nums2 = [1];
let n=1;

merge(nums1,m,nums2,n);

console.log(nums1);
 