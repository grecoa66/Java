/*
	The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 

	Input:
	First line contains number of test cases T. Each test case contain the integer value 'N' denoting days followed by an array of stock prices in N days.
	Output:
	The maximum profit is displayed as shown below. And if there is no profit then print "No Profit".


	Constraints:
	1 <=T<= 100
	2 <=N<= 100
	1 <=arr[i]<= 10000


	Example

	Input:
	2
	7
	100 180 260 310 40 535 695
	10
	23 13 25 29 33 19 34 45 65 67


	https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0#ExpectOP
*/
const stockAnalyzerWrapper = () => {
	const stockAnalyzer = (days, prices) => {
		
		let result = [];
		let low, high;

		for(let x = 0; x < prices.length - 1; x++){
			if(prices[x] <= prices[x + 1]){
				result.push(x);
				for(let y = x + 1; y < prices.length; y++){
					if(prices[y] >= prices[x]){
						if(y === prices.length - 1){
							result.push(y);
						}else{
							x++;
						}
					}else{
						result.push(y - 1);
						break;
					}
				}
			}
		}
		printResult(result);
	};

	const printResult = (result) => {
		let outputString = '[Stock trading] : ';
		for(let x = 0; x < result.length; x += 2){
			outputString += '(' + result[x] + ' ' + result[x + 1] + ')';
		}

		console.log(outputString);
	}

	const stockDriver = (testCases, days, prices) => {

		for(let x = 0; x < testCases; x++){
			stockAnalyzer(days[x], prices[x]);
		}

	}

	// Data
	let testCases = 2;

	let days = {
		0 : 7,
		1 : 10
	};

	let prices = {
		0 : [100, 180, 260, 310, 40, 535, 20, 10],
		1 : [23, 13, 25, 29, 33, 19, 34, 45, 65, 67]
	};

	stockDriver(testCases, days, prices);

};

stockAnalyzerWrapper();