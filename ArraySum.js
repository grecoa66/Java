function arraySum(array){
	let currSum = 0;
	for(let x in array){
		if(typeof array[x] === 'number'){
			currSum += array[x];
		}else{
			currSum += arraySum(array[x]);
		}
	}

	return currSum;
}

//Should sum to 100
var newArr = [10, 10, [10, 10, [10, [10]], 10, 10], 10, [10]];

console.log('Sum of the array: ', arraySum(newArr));