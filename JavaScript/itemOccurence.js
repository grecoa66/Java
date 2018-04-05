function countOccurence(arr, item){
	let count = 0;

	for(let x in arr){
		if(Array.isArray(arr[x])){
			count += countOccurence(arr[x], item);
		}else{
			if(arr[x] === item){
				count++;
			}
		}
	}

	return count;
}

let item = 'apple';
// let arr = ['apple', 'banana', 'pear', ['apple'], 'pear', 'apple', ['apple', 'pear', 'apple']];
//let arr = ['apple', 'apple', 5, 'apple'];
let arr = [['apple'], 'banana', 'pear', ['pear', 'pear', 'apple'], 'pear', 'apple', ['apple', 'pear', 'apple']];

console.log(countOccurence(arr, item));