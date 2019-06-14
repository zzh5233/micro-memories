$(function () {
    /* 添加记忆的一些事件*/
    $(".addMemory").mouseenter(function () {
        $(".addMemory").css("background","url(images/addMemory2.png) no-repeat -9px -9px");
    });
    $(".addMemory").mouseleave(function () {
        $(".addMemory").css("background","url(images/addMemory.png) no-repeat -11px -10px");
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

    /* 事件委托，不晓得为什么没反应*/
    // $(".memoryBox").delegate(".memoryBox span","click",function () {
    //     $(".memoryDetail").css("display","block");
    // });

    /* 记忆详情的一些事件*/
    $(".exit").mouseenter(function () {
        $(".exit").css("width","66px").css("height","47px");
        $(".exit").css("background","url(images/exit2.png) no-repeat -9px -2px");
    });
    $(".exit").mouseleave(function () {
        $(".exit").css("width","60px").css("height","44px");
        $(".exit").css("background","url(images/exit1.png) no-repeat -7px -5px");
    });
    $(".exit").click(function () { //关闭
        $(".memoryDetail").css("display","none");
    });

});

/*点击显示记忆详情*/
function memoryDetail() {
    $(".memoryBox span").click(function () {
        $(".memoryDetail").css("display","block");
    });
}