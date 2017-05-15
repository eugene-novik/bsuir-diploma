function createError(message) {
    var div = $('<div>', {
        class: 'alert alert-block alert-error fade in',
        id: 'myError'
    });
    var close = $('<button class="close" data-dismiss="alert">×</button>');
    var header = $('<h4>', {
        class: 'alert-heading',
        text: 'Error!'
    });
    var message = $('<p>', {
        text: message
    });
    div.append(close);
    div.append(header);
    div.append(message);
    $('#error').append(div);
}

function createReview(nickname, message) {
    var row = $('<div>', {
        class: 'row-fluid well'
    });
    var one = $('<div>', {
        class: 'span3'
    });
    var nickname = $('<a>', {
        text: nickname, href:"#"
    });
    var two = $('<div>', {
    });
    var message = $('<p>', {
        text: message
    });
    one.append(nickname);
    row.append(one);
    two.append(message);
    row.append(two);
    nickname.click(function () {
        var nick = nickname.text();
        $.post("Show", {"nickname": nick}, function(data){
            window.location.href="show.jsp";
        });
    });
    $('#review').append(row);
}
