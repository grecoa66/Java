/*
	Given an array of n integers(duplicates allowed). 
	Print “Yes” if the collection has a set of contiguous integers,
	else print “No”.
	
	https://www.geeksforgeeks.org/?p=168817
*/
const isContiguousWrapper = () => {
	const isContiguous = (arr) => {

		// Find smallest number
		let lowest = arr[0];
		// Also make a set 
		let contSet = new Set();
		for(let x = 0; x < arr.length; x++){
			if(arr[x] < lowest){
				lowest = arr[x];
			}
			contSet.add(arr[x]);
		}

		// Make sure the set is contiguous
		for(let x = 0; x < contSet.size; x++){
			if(!contSet.has(lowest)){
				return false
			}else{
				lowest++;
			}
		}

		return true;
	};

	let testArr_1 = [7, 2, 4, 3, 4, 2, 5, 2, 6, 5, 5, 5, 5, 8, 1];
	let testArr_2 = [3, 2, 1, 4];

	console.log('[Contiguous Array 1] : Is this contiguous? ', isContiguous(testArr_1));
	console.log('[Contiguous Array 2] : Is this contiguous? ', isContiguous(testArr_2));
};

isContiguousWrapper();