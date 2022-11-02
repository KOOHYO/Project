function nullCheck(data, dest, kind){
    // 비어있는거 체크
    if(data==null || data==""){
        $(dest).html(kind+" 필수입니다")
        return false;
    }else{
        $(dest).html("")
        return true;
    }
}