
/*
	A child is running up a staircase with n steps and can 
	hop either 1 step, 2 steps, or 3 steps at a time. Implement a method 
	to count how many possible ways the child can run up the stairs.

	https://www.geeksforgeeks.org/?p=169066
*/
const stairCounterWrapper = () => {
	const stairCounter = (n) => {
		
		if(n === 0 || n === 1){
			return 1;
		}else if(n === 2){
			return 2;
		}else{
			return stairCounter(n - 3) +
					stairCounter(n - 2) +
					stairCounter(n - 1);
		}

	};

	// run the function
	console.log('[Stair Counter] : Number of ways for 5: ', stairCounter(5));
	console.log('[Stair Counter] : Number of ways for 8: ', stairCounter(8));
	console.log('[Stair Counter] : Number of ways for 15: ', stairCounter(15));
};

stairCounterWrapper();
