function checkLogin() {
    $.ajax({
        type: 'get',
        url: 'login',
        success: function (body) {
            // 登录成功, 不必做任何处理. 
        },
        error: function () {
            // 403 就会触发 error
            // 强行跳转到登录页面. 
            location.assign('login.html');
        }
    });
}
