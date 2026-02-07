var Swap = function(array,i,j){
    let temp = array[i];
    array[i] = array[j];
    array[j]= temp;
}

var BubbleSort = function (array,end){
    if(end<=0){
        return;
    }
    for(let i=0;i<end;i++){
        if(array[i] > array[i+1]){
            Swap(array,i,i+1);
           
        }
    }
    BubbleSort(array,end-1);
}


let array = [5,2,3,1,7,8];
BubbleSort(array,array.length);

console.log(array);