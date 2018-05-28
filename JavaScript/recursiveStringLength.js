const findLengthWrapper = () => {
	const findLength = (currString) => {
		if(currString === ''){
			return 0;
		}else{
			return 1 + findLength(currString.substring(1));
		}
	}

	let newString = 'alexander';
	console.log('[Recursive str length] : length of ' + newString +':', findLength(newString));
};

findLengthWrapper();