$(function () {
    /* 添加记忆的一些事件*/
    $(".addMemory").mouseenter(function () {
        $(".addMemory").css("background","url(../images/addMemory2.png) no-repeat -9px -9px");
    });
    $(".addMemory").mouseleave(function () {
        $(".addMemory").css("background","url(../images/addMemory.png) no-repeat -11px -10px");
    });
    $(".addMemory").click(function () {
        //发送请求到controller处理。
        $.get("/memory/addMemoryUI",function (result) {
            //设置记忆的产生时间
            $(".addMemoryForm #moment").val(result);
            //显示记忆添加表单
            $(".addMemoryForm").css("display","block");

        });
    });
    $(".addMemoryForm form .exit").click(function () {
        //关闭记忆添加表单
        $(".addMemoryForm").css("display","none");
    });

    /* 事件委托，不晓得为什么没反应*/
    // $(".memoryBox").delegate(".memoryBox span","click",function () {
    //     $(".memoryDetail").css("display","block");
    // });

    /* 记忆详情的一些事件*/
    // $(".exit").mouseenter(function () {
    //     $(".exit").css("width","66px").css("height","47px");
    //     $(".exit").css("background","url([[@{/images/exit2.png}]]) no-repeat -9px -2px");
    // });
    // $(".exit").mouseleave(function () {
    //     $(".exit").css("width","60px").css("height","44px");
    //     $(".exit").css("background","url([[@{/images/exit1.png}]]) no-repeat -7px -5px");
    // });
    $(".memoryDetail .RInformation .exit").click(function () { //关闭
        $(".memoryDetail").css("display","none");
    });
});
/*点击显示记忆详情*/
function memoryDetail() {
    $(".memoryDetail").css("display","block");
}
/*鼠标移入，改变外形*/
function changeStyle(id) {
    $("#"+id).stop(false,true); //立即停止当前动画和后续的所有动画
    // $("#"+id).css("transition","none"); //不行，没效果
    $("#"+id).animate({
        width:"+=50",
        height:"+=50",
        left: "-=25",
        top: "-=25"
    },500);
    $.get("/memory/get/"+id,function (result) {
        // console.log($("#" + id));
        $("#"+id).css("background","url(/pic/"+result.picture+") no-repeat center center");
        $(".memoryDetail .LImage img").attr("src","/pic/"+result.picture);
        $(".memoryDetail .RInformation .container textarea").val("That day, I Remember,"+result.description);
    });
}
/*鼠标移出，还原外形*/
function returnStyle(id){
    $("#"+id).stop(false,true);//立即停止当前的动画
    // $("#"+id).css("transition","300s linear");
    $("#"+id).animate({
        width:"-=50",
        height:"-=50",
        left: "+=25",
        top: "+=25"
    },500);
    $("#"+id).css("background","#f5d76e");
}