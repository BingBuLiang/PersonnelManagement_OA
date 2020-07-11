'use strict';
$(document).ready(function () {

    $("span.pie").peity("pie");

    $(".line").peity("line");

    $(".bar").peity("bar");

    $('.peity [data-title]').mousemove(function (e) {
        $('#peity-tooltip').html($(this).data('title')).css({left: e.pageX + 8, top: e.pageY + 8});
    }).hover(
        function() {
            $('#peity-tooltip').addClass('show');
        }, function() {
            $('#peity-tooltip').removeClass('show');
        }
    );

});