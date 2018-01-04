/*
	Given a String of length N reverse the words in it. Words are separated by dots.

	https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
*/

/*
	This function is going to reverse the string param. But the reversal will 
	happen on every occurence of the reverseChar.
*/
function reverseString(revString, revChar){

	// Build this string to be the final result
	var outputString = ''; 
	var currSection = '';

	for(var x = 0; x <= revString.length; x++){
		// Put not revChar chars into string
		if(revString.charAt(x) !== revChar && x !== revString.length){
			currSection += (revString.charAt(x));
		}else{
			for(var y = currSection.length - 1; y >= 0; y--){
				outputString += (currSection.charAt(y));
			}
			if(x !== revString.length){
				outputString += ('.');
			}
			currSection = new String();
		}
	}

	return outputString;

}




var revString = 'this.is.another.test';

var revChar = '.';

console.log('Starting with: ', revString);

console.log('Reversed: ', reverseString(revString, revChar));
