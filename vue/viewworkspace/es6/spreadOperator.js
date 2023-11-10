let obj1 = { name:"이바벨", age:29 };
let obj2 = { ...obj1 };
let obj3 = { ...obj1, email:"babel@gmail.com" };

console.log(obj2);
alert(obj2);
console.log(obj3);  
alert(obj3);
console.log(obj1 == obj2);      //false
alert(obj1 == obj2);

let arr1 = [ 100, 200, 300 ];
let arr2 = [ "es2015", ...arr1, "es6"];
console.log(arr2);
alert(arr2);