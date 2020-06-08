/**
 * Created by Administrator on 2019/12/9.
 */
$(document).ready(function(){
	$('input[type="text"]').attr('disabled','disabled');
	
    var checkAll = $(".choseAll");
    $(".simple_price").each(function() {
		var num = $(this).parent().parent().children().children().children('#flowerChose').val();
		var simplePrice = $(this).parent().parent().children(".sumPrice").children(".sumPrice").get(0).innerHTML;
		$(this).html((parseInt(num)*parseFloat(simplePrice)).toFixed(2))
	})
    $("input[class='ChooseAll']").click(function(){
        if(this.checked === true){
            $("input[class='ChooseAll']").prop("checked", true)
            $("input[type='checkbox']").prop("checked", true);
        }else{
            $("input[type='checkbox']").prop("checked",false);
            $("input[class='ChooseAll']").prop("checked", false)
        }
    });

    $("input").click(function(){
         var sum = 0;
         $("tbody input:checkbox:checked").each(function () {
             //var result = $(this).parent().parent().get(0).innerHTML;
             var result = $(this).parent().parent().children('.red').children().get(1).innerHTML;
             sum += parseInt(result);   
         });
      
         $("#AllSumPrice").html(sum);
    });
   $("input[name='flowerChose']").blur(function(){

       var simple_price = parseInt($(this).val());
        var num = $(this).parent().parent().parent().children(".sumPrice").children().get(0).innerHTML;
       var $sum_price = $(this).parent().parent().parent().children('.red').children().get(1);
       $sum_price.innerHTML = (parseFloat(num)*parseInt(simple_price)).toFixed(2)

    });
    $(".deleter").click(function(){
        /*�����*/
        var $inputNode = $(this).next();
        var $inputNum = parseInt($inputNode.val());
        /*����*/
        var $simple_price = $(this).parent().parent().parent().children('.red').children().get(1);
        var $price = parseFloat($simple_price.innerHTML).toFixed(2);
        if($inputNum>1){
            $simple_price.innerHTML = ($price/$inputNum)*($inputNum-1)+"";
            /*($price/$inputNum)*($inputNum-1)+""*/
            $inputNode.val($inputNum-1+"");
            updataSumPrice()
        }else{
            alert("no deleter")
        }
        //if(this)
    });
    $(".adder").click(function(){
        /*�����*/
        var $inputNode = $(this).prev();
        var $inputNum = parseInt($inputNode.val());
        /*����*/
        var $simple_price = $(this).parent().parent().parent().children('.red').children().get(1);
        var $price = parseFloat($simple_price.innerHTML).toFixed(2);
        if($inputNum<100){
            $simple_price.innerHTML = ($price/$inputNum)*($inputNum+1)+"";
            /*($price/$inputNum)*($inputNum-1)+""*/
            $inputNode.val($inputNum+1+"");
            updataSumPrice()
        }else{
            alert("no adder")
        }
        //if(this)
    });
    $("#returnTop").click(function(){
        $("body").animate({scrollTop:'0'},1000);
    });
    $("#return").click(function(){
        window.location.href = "personalPage";
    });
    $("#deleteSelect").click(function(){
    	if (confirm("您确定要删除这一些购物车吗？")) {
	        $("#myForm").prop('action','shopCarDeleteSelect');
	        $("#myForm").submit();
    	}else{
    		
    	}
    })
    $("#forPrice").click(function(){
    	if (confirm("您确定要付款吗？不考虑一下吗")) {
    		 $("tbody input:checkbox:checked").each(function () {
                 //var result = $(this).parent().parent().get(0).innerHTML;
                 $(this).parent().parent().children().children().children('#flowerChose').removeAttr("disabled");
             });
    		$("#myForm").prop('action','shopCarForPrice');
        	$("#myForm").submit();
    	}
    })

});
function updataSumPrice(){
    var sum = 0;
    $("tbody input:checkbox:checked").each(function () {
        //var result = $(this).parent().parent().get(0).innerHTML;
        var result = $(this).parent().parent().children('.red').children().get(1).innerHTML;
        sum += parseInt(result);
    });
    $("#AllSumPrice").html(sum);
}
/*
function chooseAll(){
    var flag = $(this).is(":checked");
    alert(this.checked === false)
    if(flag){
        $("input[type='checkbox']").attr("checked",false);
    }else{
        $("input[type='checkbox']").attr("checked", true);
    }

    /!*$('input[type="checkbox"]').attr("checked",this.checked);*!/
}*/
