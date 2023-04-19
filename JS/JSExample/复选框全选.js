/* <script>
    //全选按钮
   var j_cbAll = document.querySelector('#j_cbAll');
    //下面所有的复选框
   var j_tbs = document.querySelector('#j_tb').querySelector('input');
   //注册事件
   j_cbAll.onclick = function(){
      //this.checked; 返回选中状态
     for(var i = 0;i< j_tbs.length; i++){
       j_tbs[i].checked = this.checked;
     }
   }
   //2.所有复选框选中，则全选框选中
   //所有复选框绑定事件
   for(var i = 0;i< j_tbs.length; i++){
       j_tbs[i].onclick = function(){
         //取boolean类型flag判断对象的状态
         var flag = true;
         //每次点击复选框则检测其他复选框的状态，如果未选中则将全选框的选中状态切换为false
           for(var i = 0;i< j_tbs.length; i++){
               if(! j_tbs[i].checked){
                flag = false;
               }
           }
           j_cbAll.checked = flag;
       }
   }
   
</script> */