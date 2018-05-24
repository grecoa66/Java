/**
* 	Using native JavaScript write a function that checks if a 
*	string is composed of all unique characters
*/
const unqiueStrWrapper = () => {
	const uniqueString = (str) => {
		// I wouldn't consider the empty string unique...maybe?
		if(str.length < 1){
			return false;
		}
		let strSet = new Set();
		for(let x = 0; x < str.length; x++){
			if(strSet.has(str.charAt(x))){
				return false;
			}else{
				strSet.add(str.charAt(x));
			}
		}
		return true;
	};

	let testArr = ['abcdefghijk', 'abcdeffghijjk', 'x', '', 'llllllldfg'];

	for(let word in testArr){
		console.log('Is this String unique: ' + testArr[word] + ' : ' +uniqueString(testArr[word]));
	}

};

unqiueStrWrapper();