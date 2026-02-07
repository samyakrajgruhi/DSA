class Solution {
    numberOfInversions(nums) {
        return this.mergeSort(nums, 0, nums.length - 1);
    }
    
    mergeSort(array, left, right) {
        if(left >= right){
            return 0;
        }
        let count = 0;
        const mid = Math.floor(left + (right - left) / 2);
        // add count from all merges to one
        count += this.mergeSort(array, left, mid);
        count += this.mergeSort(array, mid + 1, right);
        count += this.merge(array, left, mid, right);
        
        return count;
    }
    
    merge(arr, left, mid, right) {
        let count = 0;
        let numOfElem1 = mid - left + 1;
        let numOfElem2 = right - mid;
        
        let L = new Array(numOfElem1);
        let R = new Array(numOfElem2);

        // Creating temp array for left half
        
        for(let i = 0; i < numOfElem1; i++){
            L[i] = arr[left + i];
        }

         // Creating temp array for right half
        for(let j = 0; j < numOfElem2; j++){
            R[j] = arr[mid + 1 + j];
        }
        
        // Sorting and Merging both half 

        let i = 0, j = 0, k = left;
        while(i < numOfElem1 && j < numOfElem2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];

                // Inversion = number of elements left in the Left Half (i.e. numOfElem - i) because array[j] < array[i] for i < j // 

                count += (numOfElem1 - i);
                j++;
            }
            k++;
        }

        // Adding remaing elements of left temp array to the main array
        
        while(i < numOfElem1){
            arr[k] = L[i];
            i++;
            k++;
        }

        // Adding remaing elements of right temp array to the main array
        
        while(j < numOfElem2){
            arr[k] = R[j];
            j++;
            k++;
        }
        
        return count;
    }
}

let nums = [2, 3, 7, 1, 3, 5];
let solution = new Solution();
console.log(solution.numberOfInversions(nums));