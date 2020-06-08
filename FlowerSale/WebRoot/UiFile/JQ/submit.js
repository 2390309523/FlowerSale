var commitStatus = false;
function dosubmit(){
    if(commitStatus==false){
     //提交表单后，讲提交状态改为true
       commitStatus = true;
       return true;
    }else{
       return false;
    }
}