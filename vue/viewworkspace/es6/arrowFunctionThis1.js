function Person(name, yearCount) {
    this.name = name;
    this.age = 0;
    //var outerThis=this;
    var incrAge = function() {
        this.age++;
        //outerThis.age++;
    }
    for (var i=1; i <= yearCount; i++) {
        incrAge();
        // incrAge.apply(this);
    }
}
var p1 = new Person("홍길동",20);
//--this.age는 0이 출력됨.
console.log(p1.name + "님의 나이 : " + p1.age);
alert(p1.name + "님의 나이 : " + p1.age);
