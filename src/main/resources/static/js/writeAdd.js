console.log("자바스크립트");

let results = [false, false];

$("#ipTitle").on({
    blur:function(){
        console.log("블러");
        let result = nullCheck($("#ipTitle").val(), $("#titleResult"), "제목은");
        results[0]=result;
    },
    change:function(){
        console.log("체인지");
    }
});

$("#ipWriter").on({
    blur:function(){
        console.log("블러");
        let result = nullCheck($("#ipWriter").val(), $("#writerResult"), "작성자는");
        results[1]=result;
    },
    change:function(){
        console.log("체인지");
    }
});

// $("#ipContents").on({
//     blur:function(){
//         console.log("블러");
//         let result = nullCheck($("#ipContents").val(), $("#contentsResult"), "내용은");
//         results[2]=result;
//     },
//     change:function(){
//         console.log("체인지");
//     }
// });

$("#writeBtn").click(function(){

    // 최근에 나온 함수
    if(results.includes(false)){
        alert("필수를 입력해주세요");
    }else{
        alert("글작성을 완료했습니다");
        $("#writeForm").submit();
    }
});