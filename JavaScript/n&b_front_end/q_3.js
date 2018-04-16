let iife = (function(){
	//define function that is public until exposed
	let add = function(x, y){
		if(validateTypes(x, y)){
			return 'Invalid Input';
		}else {
			return x + y;
		}
	};

	//define function that will remain private
	let validateTypes = function(x, y){
		return(typeof x !== 'number' || typeof y !== 'number')
	};

	return {
		//expose the 'add' function
		add: add
	}
})();

console.log('2 + 3 = ' + iife.add(2, 3)); // 5
console.log('2 + "apple" = ' + iife.add(2, 'apple')); // Invalid Input