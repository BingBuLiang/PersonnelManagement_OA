'use strict';
$(document).ready(function () {

    if ($('.swiper-demo1').length > 0) {
        new Swiper('.swiper-demo1', {
            autoplay: {
                delay: 2000
            },
            pagination: {
                el: '.swiper-demo1-pagination'
            },
            loop: true
        });
    }

    if ($('.swiper-demo2').length > 0) {
        new Swiper('.swiper-demo2', {
            autoplay: {
                delay: 2000
            },
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            loop: true
        });
    }

    if ($('.swiper-demo3').length > 0) {
        new Swiper('.swiper-demo3', {
            autoplay: {
                delay: 2000
            },
            scrollbar: {
                el: '.swiper-scrollbar',
                hide: true,
            }
        });
    }

    if ($('.swiper-demo4').length > 0) {
        new Swiper('.swiper-demo4', {
            autoplay: {
                delay: 2000
            },
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            slidesPerView: 3,
            spaceBetween: 30,
            loop: true
        });
    }

});