function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();

    if (!content) {
        alert("亲，回复内容不能为空呦(●ˇ∀ˇ●)");
        return;
    }

    $.ajax({
        type: "post",
        url:"/comment",
        contentType: "application/json",
        data:JSON.stringify({
            parentId:questionId,
            content:content,
            type:1
        }),
        success:function (response) {
            if (response.code == 200) {
                // $("#comment_section").hide();
                window.location.reload();
            } else {

                if (response.code == 2003) {
                    var isAccept = confirm(response.message);
                    if (isAccept) {
                        window.open("https://github.com/login/oauth/authorize?client_id=b0fe5750fd9767a3c728&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "true");
                    }
                } else {
                    alert(response.message);
                }
            }
           
            console.log(response);
        },
        dataType:"json"
    });
}