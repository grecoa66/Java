function findLength(currString){
	if(currString === ''){
		return 0;
	}else{
		return 1 + findLength(currString.substring(1));
	}
}

let newString = 'alexander';
console.log('length of ' + newString +':', findLength(newString));