/**
 * Created by cheng on 2016/1/7 0007.
 */
$(function(){
    page(1);
})



function page(no){
    var pageSize=10;
    if(no==0) {
        no = $("#page").val();
    }
    if(no==null||no=="undefined"){
        no=1;
    }
    url=basepath+"/user/resources_list.do?no="+no+"&pageSize="+pageSize+"&r="+Math.random();
    $("#resourceList").load(encodeURI(url),function(){

    });
}

function  downLoad(fileName){
    $.ajax({
        url:'downLoadFile.html?',
        type:"POST",
        dataType:"JSON",
        data:{
            "fileName":fileName,
        },
        success: function (data) {
            alert(data.result);
            console(data.result);
        }
    });

}