/**
*	Take in # of items, large boxes, which hold 5 items, and small boxes, which hold 1 item.
*	Return number of boxes needed to pack all items. A box must be completely ful to be a part
*	of the solution.
*/
const shippingBoxesWrapper = () => {
	const shippingBoxes = (items, numLrg, numSm) => {
		let boxesUsed = 0;

		let totalCapacity = (numLrg * 5) + numSm;

		if(totalCapacity < items){
			return -1;
		}else{
			// Try to fill lrg boxes
			while(items > 4 && numLrg > 0){
				boxesUsed++;
				numLrg--;
				items = items - 5;
			}
			// Fill small boxes
			while(items > 0){
				boxesUsed++;
				numSm--;
				items--;
			} 
		}
		return boxesUsed;
	};

	console.log('[Shipping Boxes] : # of boxes needed:' + shippingBoxes(16, 4, 10));
};

shippingBoxesWrapper();