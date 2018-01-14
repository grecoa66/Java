(function(){
/*
	Given two given arrays of equal length, 
	the task is to find if given arrays are equal or not. 
	Two arrays are said to be equal if both of them contain same set of elements, 
	arrangements (or permutation) of elements may be different though.

	https://www.geeksforgeeks.org/check-if-two-arrays-are-equal-or-not/
*/

function checkEqual(arr1, arr2){

	var map1 = new Dictionary();
	var map2 = new Dictionary();

	// Build the dictionaries
	for(var val in arr1){
		map1.addEntry(arr1[val]);
	}

	for(var val in arr2){
		map2.addEntry(arr2[val]);
	}

	console.log(map1.map.entries());
	console.log(map2.map.entries());

	var isFalse = false;

	// Iterate and check if every [key, value] exist in both dicts
	map1.map.forEach(function(value, key){
		if(map2.map.has(key)){
			if(map2.map.get(key) !== value ){
				isFalse = true;
			}
		}else{
			isFalse = true;
		}
	});


	return !isFalse;
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
			this.map.set(entry, ++entryCount);
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
			return -1;
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
				this.map.set(entry, --entryCount);
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


// var dict = new Dictionary();

// dict.addEntry(3);
// dict.addEntry(3);
// dict.addEntry(1);
// dict.addEntry(5);
// dict.addEntry(5);
// dict.addEntry(3);
// dict.addEntry(5);
// dict.addEntry(22);

// console.log(dict.map.entries());

var arr1 = [1, 2, 3, 4, 1, 1, 1, 6];
var arr2 = [1, 2, 3, 4, 1, 1, 1, 6];

console.log(checkEqual(arr1, arr2));

})();
