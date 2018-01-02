/*
	Given an array of integers of length n. 
	Our task is to return the index of the max element if 
	it is at least twice as much as every other number in the array. 
	If the max element does not satisfy the condition return -1.

	https://www.geeksforgeeks.org/?p=169051
*/

// Brute force way
function maxDouble (arr){
	var currMax = 0;
	var maxInd = 0;
	// find largest and index
	for(var x = 0; x < arr.length; x++){
		if(arr[x] > currMax){
			currMax = arr[x];
			maxInd = x;
		}
	}

	var doubleExists = true;
	for(var y = 0; y < arr.length; y++){
		if(y !== maxInd){
			if( (arr[y] * 2) > currMax ){
				doubleExists = false;
			}
		}
	}

	return doubleExists;
}

var testArr = [3, 6, 2, 1];
console.log('Testing this array: ', testArr);
console.log('Result: ', maxDouble(testArr));