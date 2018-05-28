const poisonBottleWrapper = () => {
    "use strict";
    /**
     * Object used to represent the bottles
     * @param number
     * @param poisoned
     * @returns {{num: *, poisoned: *}}
     */
    let bottle = (number, poisoned) => {
       return {
           num : number,
           poisoned : poisoned
       }
    };

    /**
     * You have 10 test strips.
     * @param bottles
     */
    const findPoisonBottle = (bottles) => {
        let timeSoFar = 0;
        let testStrips = 10;
        // Split in 5 until you are down to 2
        while(bottles.length > 2){
            testStrips -= 1;
            timeSoFar += 7;
            if(testStrips > 5) {
                bottles = checkFifth(bottles);
            }else{
                console.log('[Poison Bottles] : FAILED');
                return false;
            }
        }

        timeSoFar += 7;
        if(bottles[0].poisoned){
            return {
                timeSoFar : timeSoFar,
                bottleNum : bottles[0].num
            }
        }else{
            return {
                timeSoFar : timeSoFar,
                bottleNum : bottles[1].num
            }
        }


    };

    const checkFifth = (bottles) =>{
        const partitions = getPartitions(bottles);
        let poisonedPart = null;
        partitions.forEach( partition => {
            if( checkPartition(partition) ){
                poisonedPart = partition;
            }
        });

        return poisonedPart;
    };

    const getPartitions = (bottles) => {
        const numToSplit = bottles.length / 5;
        let partitionStr = 0;
        const partitions = [];
        for(let x = 0; x < 5; x++){
            let partition = bottles.slice(partitionStr, partitionStr + numToSplit);
            partitions.push(partition);
            partitionStr += numToSplit;
        }
        return partitions;
    };

    const checkPartition = (partition) => {
        let found = false;
        partition.map( bottle => {
            if(bottle.poisoned){
                found = true;
            }
        });
        return found;
    };

    /**
     * Build a list of bottle and poison a random one
     * @param numBottles
     * @returns {{poisonNum: number, bottles: Array}}
     */
    const buildBottleList = (numBottles) => {
        const bottleList = [];
        for(let x = 0; x < numBottles; x++){
            bottleList.push(bottle(x, false));
        }
        //Pick random number and poison it
        let randomNum = Math.floor(Math.random() * (numBottles));
        bottleList[randomNum ].poisoned = true;

        return {
            poisonNum : randomNum,
            bottles : bottleList
        }
    };

    const bottles = buildBottleList(1000);
    console.log('[Posion Bottles] original poisoned bottle number : ', bottles.poisonNum);
    const result = findPoisonBottle(bottles.bottles);
    console.log('[Posion Bottles] time to find poison bottle : ', result.timeSoFar);
    console.log('[Posion Bottles] poisoned bottle number : ', result.bottleNum);
};

poisonBottleWrapper();