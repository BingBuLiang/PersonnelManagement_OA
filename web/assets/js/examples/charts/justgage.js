'use strict';
$(document).ready(function () {

    new JustGage({
        id: "justgage_one",
        value: 90,
        min: 0,
        max: 100,
        counter: true,
        donut: true,
        gaugeWidthScale: 0.3,
        label: "Users",
    });

    new JustGage({
        id: "justgage_two",
        value: 46,
        min: 0,
        max: 100,
        counter: true,
        donut: true,
        gaugeWidthScale: 0.3,
        label: "Customers",
    });

    new JustGage({
        id: "justgage_three",
        value: 10,
        min: 0,
        max: 100,
        counter: true,
        donut: true,
        gaugeWidthScale: 0.3,
        label: "Visitor",
    });

    new JustGage({
        id: 'justgage_four',
        value: 155,
        min: 0,
        max: 250,
        symbol: 'mph',
        pointer: true,
        gaugeWidthScale: 0.3,
        counter: true,
        relativeGaugeSize: true,
        donut: true
    });

    new JustGage({
        id: 'justgage_five',
        value: 25,
        min: 0,
        max: 100,
        symbol: '%',
        pointer: true,
        pointerOptions: {
            toplength: -15,
            bottomlength: 10,
            bottomwidth: 12,
            color: '#8e8e93',
            stroke: '#ffffff',
            stroke_width: 3,
            stroke_linecap: 'round'
        },
        gaugeWidthScale: 0.3,
        counter: true,
        relativeGaugeSize: true,
        donut: true,
    });

    new JustGage({
        id: 'justgage_six',
        value: 86,
        min: 0,
        max: 100,
        symbol: 'kWh',
        pointer: true,
        gaugeWidthScale: 0.3,
        pointerOptions: {
            toplength: 10,
            bottomlength: 10,
            bottomwidth: 8,
            color: '#000'
        },
        counter: true,
        relativeGaugeSize: true,
        donut: true
    });

    var justgage_seven = new JustGage({
        id: "justgage_seven",
        value: 275,
        min: 0,
        max: 500,
        label: "Visitors On Site"
    });

    var justgage_eight = new JustGage({
        id: "justgage_eight",
        value: 120,
        min: 0,
        max: 500,
        label: "Memory Usage",
        pointer:true,
        pointerOptions: {
            toplength: -15,
            bottomlength: 10,
            bottomwidth: 12,
            color: '#8e8e93',
            stroke: '#ffffff',
            stroke_width: 3,
            stroke_linecap: 'round'
        },
    });

    var justgage_nine = new JustGage({
        id: 'justgage_nine',
        value: 25,
        min: 0,
        max: 100,
        symbol: '%',
        pointer: true,
        pointerOptions: {
            toplength: -15,
            bottomlength: 10,
            bottomwidth: 12,
            color: '#8e8e93',
            stroke: '#ffffff',
            stroke_width: 3,
            stroke_linecap: 'round'
        },
        gaugeWidthScale: 0.3,
        counter: true,
        relativeGaugeSize: true
    });

    var justgage_ten = new JustGage({
        id: 'justgage_ten',
        value: 70,
        min: 0,
        max: 100,
        symbol: 'Kg',
        pointerOptions: {
            toplength: 8,
            bottomlength: -20,
            bottomwidth: 6,
            color: '#8e8e93'
        },
        gaugeWidthScale: 0.1,
        counter: true,
        relativeGaugeSize: true
    });

    setInterval(function() {
        justgage_seven.refresh(getRandomInt(0, 500));
        justgage_eight.refresh(getRandomInt(0, 500));
        justgage_nine.refresh(getRandomInt(0, 100));
        justgage_ten.refresh(getRandomInt(0, 100));
    }, 2000);

});