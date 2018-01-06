/*
	Given two given arrays of equal length, 
	the task is to find if given arrays are equal or not. 
	Two arrays are said to be equal if both of them contain same set of elements, 
	arrangements (or permutation) of elements may be different though.

	https://www.geeksforgeeks.org/check-if-two-arrays-are-equal-or-not/
*/

function checkEqual(arr1, arr2){

	var map1 = new Map();
	var map2 = new Map();


}

function Dictionary() {
	this.map = new Map();
}

/*
	Function to keep track of how many times a key has been entered.
*/
Dictionary.prototype.addEntry = function(entry){
	if(typeof entry === 'undefined'){
		console.log('Cannot add undefined entry');
	}else{
		if(this.map.has(entry)){
			var entryCount = this.map.get(entry);
			this.map.set(entry, entryCount++);
		}else{
			this.map.set(entry, 1);
		}
	}
}

/*
	Function to get the value associated with a key
*/
Dictionary.prototype.getValue = function(key){
	if(typeof key === 'undefined'){
		console.log('Cannot remove undefined key');
	}else{
		if(this.map.has(key)){
			console.log(this.map.get(key));
			return this.map.get(key);
		}else{
			console.log('There is no key that matches your input');
		}
	}
}

/*
	Function to remove an occurance of a key. Also remove the key
	if you removed the last occurance of it.
*/
Dictionary.prototype.removeEntry = function(entry){
	if(typeof entry === 'undefined'){
		console.log('Cannot remove undefined entry');
	}else{
		if(this.map.has(entry)){
			var entryCount = this.map.get(entry);
			if(entryCount === 1){
				return this.map.delete(entry);
			}else{
				this.map.set(entry, entryCount--);
			}
		}else{
			console.log('This key does not exist, so it can not be removed');
		}
	}
}

/*
	Function to remove a key and its value from the dictionary
*/
Dictionary.prototype.removeKey = function(key){
	if(typeof key === 'undefined'){
		console.log('Cannot remove undefined key');
	}else{
		if(this.map.has(key)){
			return this.map.delete(entry);
		}else{
			console.log('This key does not exist, so it can not be removed');
		}
	}
}

