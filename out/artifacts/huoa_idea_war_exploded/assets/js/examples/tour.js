'use strict';
$(document).ready(function () {

    $(document).on('click', 'a.tour', function(){
        Tour.run([
            {
                element: $('nav.navbar'),
                content: 'This is the menu bar.',
                position: 'bottom'
            },
            {
                element: $('.side-menu'),
                content: 'This is the side menu.',
                position: 'right'
            },
            {
                element: $('aside'),
                content: 'This is the side menu bar.'
            },
            {
                element: $('.page-header'),
                content: 'This is the main title of the page.',
                position: 'bottom'
            },
            {
                element: $('.tour-card'),
                content: 'This is the area that covers the content.',
                position: 'top'
            },
            {
                element: $('.jumbotron'),
                content: 'but it can be on top',
                position: 'top'
            },
            {
                element: $('.jumbotron a.btn'),
                content: 'but it can be on top',
                position: 'right'
            }
        ]);
    });

});