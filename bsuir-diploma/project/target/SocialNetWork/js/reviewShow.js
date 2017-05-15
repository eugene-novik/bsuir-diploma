$(document).ready(function () {
    $.post("ReviewShow", function (data) {
        if (data != "ERROR") {
            var reviews = JSON.parse(data);
            for(var i=0;i<reviews.length;i++){
                createReview(reviews[i].commentator,reviews[i].comment);
            }
        }
    });

});