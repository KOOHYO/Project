console.log("자바스크립트");

let results = [false, false, false, false, false];

$("#ipTitle").on({
    blur : function(){
        let result = nullCheck($("#ipTitle").val(), $("#titleResult"), "제목은");
        results[1]=result;
    }
});

$("#ipWriter").on({
    blur : function(){
        let result = nullCheck($("#ipWriter").val(), $("#writerResult"), "작성자는");
        results[1]=result;
    }
});