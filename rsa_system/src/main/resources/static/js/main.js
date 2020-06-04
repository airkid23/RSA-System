function visible(){
    document.getElementById("n").style.visibility="visible";
    document.getElementById("d").style.visibility="visible";
}

function encrypt() {
    var text = document.getElementById("content").value;
    console.log(text)
    var url = '/encrypt/'+text.toString()
    $.ajax({
        url: url,
        success: function (data) {
            document.getElementById("content1").value = data;
        }
    })
}
function decrypt() {
    if (document.getElementById("n").style.visibility == "hidden") {
        visible()
    } else {
        var message = document.getElementById("content").value;
        var d = document.getElementById("d").value;
        var n = document.getElementById("n").value;
        if (message == "" || d == "" || n == "") {
            alert("不能输入空值！")
        }
        var text = document.getElementById("content").value;
        var url = '/decrypt/' + text.toString() + '/' + n + '/' + d ;
        $.ajax({
            url: url,
            success: function (data) {
                document.getElementById("content1").value = data;
            }
        })
    }


}