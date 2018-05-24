/*
	Given an array of integers of length n. 
	Our task is to return the index of the max element if 
	it is at least twice as much as every other number in the array. 
	If the max element does not satisfy the condition return -1.

	https://www.geeksforgeeks.org/?p=169051
*/
const maxDoubleWrapper = () => {
	// Brute force way
	const maxDouble = (arr) => {
		let currMax = 0;
		let maxInd = 0;
		// find largest and index
		for(let x = 0; x < arr.length; x++){
			if(arr[x] > currMax){
				currMax = arr[x];
				maxInd = x;
			}
		}

		let doubleExists = true;
		for(let y = 0; y < arr.length; y++){
			if(y !== maxInd){
				if( (arr[y] * 2) > currMax ){
					doubleExists = false;
				}
			}
		}

		return doubleExists ? currMax : -1;
	}

	let testArr = [3, 6, 2, 1];
	console.log('[Max Double] : Testing this array: ', testArr);
	console.log('[Max Double] : Result: ', maxDouble(testArr));
	let testArr_2 = [3, 5, 2, 1];
	console.log('[Max Double] : Testing this array: ', testArr_2);
	console.log('[Max Double] : Result: ', maxDouble(testArr_2));
};

maxDoubleWrapper();