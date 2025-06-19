function iterative(){
    let myArray = [] ;
    myArray.push({make: "Ford", model: "Focus", age: 2}, {make: "Toyota", model: "Yaris", age: 5});
    for(let i = 0 ; i < myArray.length; i++){
        if(i % 2 === 1){
            myArray.splice(i);
            i--;
        }
    }
}

function iterative2(){
    let myArray = [] ;
    myArray.push({make: "Ford", model: "Focus", age: 2}, {make: "Toyota", model: "Yaris", age: 5});
    for (let i = 0; i < myArray.length; i++) {
        if (i % 2 === 1) {
            myArray.splice(i, 1);
            i--; // 由于删除了元素，需要调整索引
        }
    }
}

function sum(array1, array2){
    let sum1 = 0;
    let sum2 = 0;
    for(let i = array1.length -1; i>=0; i--){
        sum1 += array1[i];
        sum2 += array2[i];
    }
    return sum1 > sum2 ;
}