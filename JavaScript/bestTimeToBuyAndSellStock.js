/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let totalProfit = 0;
    if (prices.length == 1) return totalProfit;

    
    let left = 0, right = 1;

    while(right < prices.length){
        if(prices[left]<prices[right]){
            let currentProfit = prices[right] - prices[left];
            if(currentProfit > totalProfit){
                totalProfit = currentProfit;
            }
        }else{
            left = right
        }

        right++;
    }

    return totalProfit;
};

let prices = [[7,1,5,3,6,4],[7,6,4,3,1]];

prices.forEach((array) => {
    console.log(maxProfit(array));
})