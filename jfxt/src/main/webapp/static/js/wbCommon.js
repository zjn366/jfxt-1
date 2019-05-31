
//点击图片弹出放大预览图片方法
function openImgWindow(obj){
    var qq_or_img = "";
    switch(obj.id)
    {
        case 'contact_img':
        qq_or_img = "light_img";
        break;
        

    }
    document.getElementById(qq_or_img).style.display='block';
    document.getElementById('fade').style.display='block';
}
//关闭图片遮罩
function closeImgWindow(){
    document.getElementById('light_img').style.display='none';
    document.getElementById('fade').style.display='none';
}

