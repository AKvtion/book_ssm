$(document).ready(function () {
    // 绑定发送邮件按钮的点击事件
    $("#regEmailSubmit").click(function () {
        sendEmail();
    });

    function sendEmail() {
        var email = $("#email").val(); // 获取用户输入的邮箱地址
        console.log(email);

        var data = {
            email: email
        };

        $.ajax({
            type: "GET", // 使用POST方法发送请求
            url: "reMail", // 发送邮件的后端接口地址
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (response) {
                // 请求成功的回调函数
                if (response.success) {
                    alert("邮件发送成功，请查收你的邮箱！"); // 发送成功提示信息
                } else {
                    alert("邮件发送失败，请重试或联系管理员！"); // 发送失败提示信息
                }
            },
            error: function () {
                // 请求失败的回调函数
                alert("发送请求失败，请检查网络连接！"); // 错误提示信息
            }
        });
    }




});