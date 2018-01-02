/*
	Given an array of n integers(duplicates allowed). 
	Print “Yes” if the collection has a set of contiguous integers,
	else print “No”.
*/
function isContiguous(arr){

	// Find smallest number
	var lowest = arr[0];
	// Also make a set 
	var contSet = new Set();
	for(var x = 0; x < arr.length; x++){
		if(arr[x] < lowest){
			lowest = arr[x];
		}
		contSet.add(arr[x]);
	}

	// Make sure the set is contiguous
	for(var x = 0; x < contSet.size; x++){
		if(!contSet.has(lowest)){
			return false
		}else{
			lowest++;
		}
	}

	return true;
}

var testArr = [7, 2, 4, 3, 4, 2, 5, 2, 6, 5, 5, 5, 5, 8, 1];
//var testArr = [3, 2, 1, 4];

console.log('Is this contiguous? ', isContiguous(testArr));