//Wrapper
const compressStr = () => {
	const compress = (str) => {
		
		let counter = 0;
		let result = '';
		let strArr = str.split('');
		let currChar = strArr[0];
		strArr.forEach(c => {
			if(c === currChar){
				counter++;
			}else{
				//write to result the char and num occurences
				result = result.concat(currChar).concat(counter);
				//change the currChar
				currChar = c;
				//reset count
				counter = 1;
			}
		});
		//write the last char sequence
		result = result.concat(currChar).concat(counter);

		if(result.length > str.length){
			return str;
		}else{
			return result;
		}
	};

	const test_1 = 'aabcccccaaa';
	console.log('test_1 : ' + test_1 + ' => ' + compress(test_1));

	const test_2 = 'abc';
	console.log('test_2 : ' + test_2 + ' => ' + compress(test_2));

	const test_3 = '';
	console.log('test_3 : ' + test_3 + ' => ' + compress(test_3));
};

compressStr();